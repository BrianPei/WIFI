package com.xunlei.wifi.test.modules.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 读取excel文件
 * 
 * @author peiyu
 * 
 */
public class ExcelReader {
	public String filePath;
	public XSSFWorkbook wb;

	public ExcelReader(String fileName) {
		this.filePath = "resources/" + fileName.toLowerCase() + ".xlsx";
		try {
			InputStream fi = new FileInputStream(this.filePath);
			this.wb = new XSSFWorkbook(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("excel文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("excel文件读取错误");
		}
	}

	/**
	 * 获取sheet数量
	 * 
	 * @return
	 */
	public int getSheetNum() {
		return this.wb.getNumberOfSheets();
	}

	/**
	 * 保存测试结果
	 */
	public void saveResult() {
		try {
			FileOutputStream fo = new FileOutputStream(this.filePath);
			this.wb.write(fo);
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("excel文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("excel文件保存错误");
		}
	}
}
