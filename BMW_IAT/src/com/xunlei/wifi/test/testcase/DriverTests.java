package com.xunlei.wifi.test.testcase;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.driver.CaseDriver;

public class DriverTests extends BaseCase {
	@Test
	public void test_User() {
		// 加载用例驱动器，读取excel文件
		CaseDriver caseDriver = new CaseDriver("user");
		// 读取接口数
		int apiNum = caseDriver.apiNum;

		for (int i = 0; i < apiNum; i++) {
			// 切换每个接口对应的sheet
			caseDriver.switchCaseSheet(i);
			
			String apiName = caseDriver.apiName;
			System.out.println(apiName);
			
			int caseNum = caseDriver.caseNum;
			if (caseNum > 0) {
				// 获取该接口对应的用例集
				List<XSSFRow> rowList = caseDriver.getRowList();
				// 批量执行
				caseDriver.runCases(g_user, rowList);
			}
		}
	}
}
