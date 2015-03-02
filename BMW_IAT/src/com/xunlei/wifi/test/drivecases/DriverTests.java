package com.xunlei.wifi.test.drivecases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.driver.CaseDriver;

public class DriverTests extends BaseCase {
	private DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Test
	public void test_User() {
		// 加载用例驱动器，读取excel文件
		CaseDriver caseDriver = new CaseDriver("user");

		// 读取接口数
		int apiNum = caseDriver.apiNum;

		for (int i = 0; i < apiNum; i++) {
			// 切换每个接口对应的sheet
			caseDriver.switchCaseSheet(i);
			// 记录进行接口测试的时间
			Date date = new Date();
			String time = df.format(date);
			caseDriver.saveTime(time);
			// 获取该接口下的用例数量
			int caseNum = caseDriver.caseNum;
			if (caseNum > 0) {
				// 获取该接口对应的用例集
				List<XSSFRow> rowList = caseDriver.getRowList();
				// 批量执行
				caseDriver.runCases(g_user, rowList);
			}
		}
	}

	@Test
	public void test_Reward() {
		// 加载用例驱动器，读取excel文件
		CaseDriver caseDriver = new CaseDriver("reward");
		// 读取接口数
		int apiNum = caseDriver.apiNum;

		for (int i = 0; i < apiNum; i++) {
			// 切换每个接口对应的sheet
			caseDriver.switchCaseSheet(i);
			// 记录进行接口测试的时间
			Date date = new Date();
			String time = df.format(date);
			caseDriver.saveTime(time);
			// 获取该接口下的用例数量
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
