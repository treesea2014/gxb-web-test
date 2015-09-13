/**
 * 
 */
package com.kkb.test.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author treesea888@icloud.com
 *
 */
public class PropertiesBundle {

	/**
	 * slf4j logback
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(PropertiesBundle.class);
	
	/*
	 * properties 文件的后缀
	 */
	private static String PROPERTIES = ".properties";
	private static String SELENIUM = "selenium";
	private static String BASE = "base";
	public static String MEMCACHED = "memcached";
	private static String JDBC = "jdbc";
	private static String ENV = "env";
	private static String FTP = "ftp";
	public static String ALL = "all";
	public static String PARAMETER = "parameter";

	/*
	 * 加载配置文件
	 */
	public static Properties loadProperties(String type) {
		Properties p = loadResource(null,SELENIUM, PROPERTIES);
		if (ALL.equals(type)) {
			// 加载memcached的配置文件
			storeProperties(MEMCACHED, p);
			// 加载所有被测试系统的基本url,默认的用户和名密码
			storeProperties(BASE, p);
			// 加载jdbc
			storeProperties(JDBC, p);
		} else if (BASE.equals(type)) {
			// 加载所有被测试系统的基本url,默认的用户和名密码
			storeProperties(BASE, p);
		} else if (MEMCACHED.equals(type)) {
			// 加载memcached的配置文件
			storeProperties(MEMCACHED, p);
		} else if (JDBC.equals(type)) {
			// 加载jdbc
			storeProperties(JDBC, p);
		} else if (SELENIUM.equals(type)) {

		} else if (FTP.equals(type)) {
			// 加载jdbc
			storeProperties(FTP, p);
		} else if (PARAMETER.equals(type)) {
			// 加载jdbc
			storeProperties(PARAMETER, p);
		}
		return p;
	}

	/*
	 * 加载配置文件
	 */
	public static Properties loadResource(String path, String fileName,
			String suffix) {
		Properties p = new Properties();
		try {
			if (null == path || "".equals(path) || fileName.equals(PARAMETER)) {
				p.load(ClassLoader.getSystemResourceAsStream(fileName + suffix));
			} else {
				p.load(ClassLoader.getSystemResourceAsStream(path
						+ File.separator + fileName + suffix));
			}

			logger.info("load ResourceFile　: {}", fileName + suffix);
		} catch (IOException e) {
			logger.info("loadProperties(\"{}\") error ： {}", fileName + suffix,
					e);
			try {
				p.load(ClassLoader.getSystemResourceAsStream(fileName + suffix));
				logger.info("reload ResourceFile　: {}", fileName + suffix);
			} catch (IOException e1) {
				logger.info("reloadProperties(\"{}\") error ： {}", fileName
						+ suffix, e);
			}
		}
		return p;
	}

	/*
	 * 组装配置文件
	 */
	public static void storeProperties(String fileName, Properties p) {
		String path = ENV + File.separator + p.getProperty(ENV);
		Properties temp = loadResource(path, fileName, PROPERTIES);
		Iterator<Object> it = temp.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			p.put(key, temp.get(key));
		}
	}
}
