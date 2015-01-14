package com.xunlei.wifi.test.modules.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private static String fileName = "../config/environment.properties";

	public final static Properties loadProperties() {
		Properties p = new Properties();
		try {
			InputStream in = Configuration.class.getResourceAsStream(fileName);
			p.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("配置文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("配置文件读取错误");
		}
		return p;
	}
}
