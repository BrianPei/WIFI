package com.xunlei.wifi.test.modules.driver;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 加载指定工作簿，读取用例信息
 * 
 * @author peiyu
 * 
 */
public class CaseReader {
	public XSSFSheet sheet;

	public CaseReader(XSSFWorkbook wb, int index) {
		this.sheet = wb.getSheetAt(index);
	}

	/**
	 * 获取接口名
	 * 
	 * @return
	 */
	public String getApiName() {
		XSSFRow row = this.sheet.getRow(0);
		XSSFCell cell = row.getCell(1);
		return cell.getStringCellValue();
	}

	/**
	 * 获取参数数量
	 * 
	 * @return
	 */
	public int getArgCount() {
		XSSFRow row = this.sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		return Integer.valueOf(cell.getStringCellValue());
	}

	/**
	 * 获取用例数量
	 * 
	 * @return
	 */
	public int getCaseCount() {
		int rowNum = this.sheet.getLastRowNum();
		return (rowNum - 2) / 4;
	}

	/**
	 * 获取某条用例对应行,从0开始
	 * 
	 * @param index
	 * @return
	 */
	public XSSFRow getCaseTopRow(int caseNum) {
		return this.sheet.getRow(caseNum * 4 + 3);
	}

	/**
	 * 获取用例ID
	 * 
	 * @param row
	 * @return
	 */
	public int getCaseID(XSSFRow row) {
		XSSFCell cell = row.getCell((short) 0);
		return Integer.valueOf(cell.getStringCellValue());
	}

	/**
	 * 获取用例描述
	 * 
	 * @param row
	 * @return
	 */
	public String getCaseDesc(XSSFRow row) {
		XSSFCell cell = row.getCell((short) 1);
		return cell.getStringCellValue();
	}

	/**
	 * 获取用例运行状态
	 * 
	 * @param row
	 * @return
	 */
	public String getRunStatus(XSSFRow row) {
		XSSFCell cell = row.getCell((short) 2);
		return cell.getStringCellValue();
	}

	/**
	 * 获取测试结果单元格
	 * 
	 * @param row
	 * @return
	 */
	public XSSFCell getResultCell(XSSFRow row) {
		return row.getCell((short) 3);
	}

	/**
	 * 获取记录log单元格
	 * 
	 * @param row
	 * @return
	 */
	public XSSFCell getResponseCell(XSSFRow row) {
		return row.getCell((short) 4);
	}

	/**
	 * 获取记录异常单元格
	 * 
	 * @param row
	 * @return
	 */
	public XSSFCell getExceptionCell(XSSFRow row) {
		return row.getCell((short) 5);
	}

	/**
	 * 获取参数map
	 * 
	 * @param row
	 * @return
	 */
	public HashMap<String, String> getParamsMap(XSSFRow row) {
		HashMap<String, String> map = new HashMap<>();
		// 计算下一行
		XSSFRow valueRow = this.sheet.getRow(row.getRowNum() + 1);
		for (int i = 7; i < 18; i++) {
			// 判断参数行末尾
			if (row.getCell(i).getCellType() == 3) {
				break;
			}
			String key = row.getCell(i).getStringCellValue();
			String value = valueRow.getCell(i).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}

	/**
	 * 获取结果Map
	 * 
	 * @param row
	 * @return
	 */
	public LinkedHashMap<String, String> getResultsMap(XSSFRow row) {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		// 计算行数
		XSSFRow keyRow = this.sheet.getRow(row.getRowNum() + 2);
		XSSFRow valueRow = this.sheet.getRow(row.getRowNum() + 3);
		for (int i = 7; i < 18; i++) {
			// 判断末尾
			if (keyRow.getCell(i).getCellType() == 3) {
				break;
			}
			String key = keyRow.getCell(i).getStringCellValue();
			String value = valueRow.getCell(i).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
