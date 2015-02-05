package com.xunlei.wifi.test.modules.driver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.xunlei.wifi.test.modules.model.User;

/**
 * 解析与运行Case
 * 
 * @author peiyu
 * 
 */
public class CaseDriver {
	public String fileName;
	public int apiNum;
	public int caseNum;
	public String apiName;

	public XSSFWorkbook wb;
	public ExcelReader excel;
	public CaseReader caseReader;

	public CaseDriver(String fileName) {
		this.fileName = fileName;

		this.excel = new ExcelReader(fileName);
		this.wb = excel.wb;
		this.apiNum = excel.getSheetNum();
	}

	/**
	 * 切换sheet
	 * 
	 * @param index
	 */
	public void switchCaseSheet(int index) {
		this.caseReader = new CaseReader(wb, index);
		this.apiName = caseReader.getApiName();
		this.caseNum = caseReader.getCaseCount();
	}

	/**
	 * 获取用例集合
	 * 
	 * @return
	 */
	public List<XSSFRow> getRowList() {
		List<XSSFRow> rowList = new ArrayList<>();
		for (int i = 0; i < caseNum; i++) {
			rowList.add(caseReader.getCaseTopRow(i));
		}
		return rowList;
	}

	/**
	 * 循环执行用例集
	 * 
	 * @param user
	 * @param rowList
	 */
	public void runCases(User user, List<XSSFRow> rowList) {
		// 获取接口名
		String apiName = caseReader.getApiName();
		// 执行loop
		for (int i = 0; i < rowList.size(); i++) {
			XSSFRow row = rowList.get(i);
			// 初始化之前记录的结果
			XSSFCell resultCell = caseReader.getResultCell(row);
			resultCell.setCellType(3);
			XSSFCell responseCell = caseReader.getResponseCell(row);
			responseCell.setCellType(3);
			XSSFCell exceptionCell = caseReader.getExceptionCell(row);
			exceptionCell.setCellType(3);

			// 检查用例状态，运行or跳过
			String caseFlag = caseReader.getRunStatus(row);
			if (caseFlag.equals("Y")) {
				// 从excel获取参数集合
				HashMap<String, String> paramMap = caseReader.getParamsMap(row);
				// 调用接口，获取返回值
				JSONObject resultObject = excute(user, paramMap, apiName);
				// 保存返回值
				responseCell.setCellValue(resultObject.toString());
				// 从excel获取预期结果集合
				LinkedHashMap<String, String> resultMap = caseReader
						.getResultsMap(row);
				System.out.println(resultMap);
				// 验证结果，在excel中记录用例运行结果
				int result = verifyResult(resultObject, resultMap, row,
						exceptionCell);
				if (result == 0) {
					resultCell.setCellValue("PASS");
				} else {
					resultCell.setCellValue("FAIL");
				}
			} else {
				resultCell.setCellValue("NT");
			}
		}
		excel.saveResult();
	}

	/**
	 * 执行单条用例
	 * 
	 * @param user
	 * @param map
	 * @param interfaceName
	 * @return
	 */
	public JSONObject excute(User user, Map<String, String> map, String apiName) {
		user.http_param.putAll(map);
		JSONObject result = user.postJsonResp(apiName);
		return result;
	}

	/**
	 * 验证测试结果
	 * 
	 * @param resultObject
	 * @param resultMap
	 * @param row
	 * @return
	 */
	public int verifyResult(JSONObject resultObject,
			Map<String, String> resultMap, XSSFRow row, XSSFCell cell) {
		int resultFlag = 0;
		JSONArray resultList = null;
		try {
			for (String key : resultMap.keySet()) {
				String value = resultMap.get(key);
				if (resultList != null) {
					// 循环获取List中的json进行验证
					for (int i = 0; i < resultList.size(); i++) {
						resultObject = resultList.getJSONObject(i);
						// 分类检查结果
						switch (value.toLowerCase()) {
						case ">0":
							assertTrue(key + "验证失败",
									resultObject.getInt(key) > 0);
							break;
						case "<0":
							assertTrue(key + "验证失败",
									resultObject.getInt(key) < 0);
							break;
						case "!=0":
							assertTrue(key + "验证失败",
									resultObject.getInt(key) != 0);
							break;
						case "contain":
							assertTrue(key + "验证失败",
									resultObject.containsKey(key));
							break;
						case "notnull":
							assertNotNull(key + "验证失败", resultObject.get(key));
							break;
						case "null":
							assertNull(key + "验证失败", resultObject.get(key));
							break;
						default:
							assertEquals(key + "验证失败", value,
									resultObject.getString(key));
							break;
						}
					}
				} else {
					switch (value.toLowerCase()) {
					// 判断后续结果是否包含在JSON中
					case "jsonobject":
						resultObject = resultObject.getJSONObject(key);
						break;
					// 判断后续结果是否包含在List中
					case "jsonarray":
						resultList = resultObject.getJSONArray(key);
						break;
					case ">0":
						assertTrue(key + "验证失败", resultObject.getInt(key) > 0);
						break;
					case "<0":
						assertTrue(key + "验证失败", resultObject.getInt(key) < 0);
						break;
					case "!=0":
						assertTrue(key + "验证失败", resultObject.getInt(key) != 0);
						break;
					case "contain":
						assertTrue(key + "验证失败", resultObject.containsKey(key));
						break;
					case "notnull":
						assertNotNull(key + "验证失败", resultObject.get(key));
						break;
					case "null":
						assertNull(key + "验证失败", resultObject.get(key));
						break;
					default:
						assertEquals(key + "验证失败", value,
								resultObject.getString(key));
						break;
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			// 记录异常信息
			cell.setCellValue(e.getMessage());
			resultFlag = 1;
		}
		return resultFlag;
	}
}
