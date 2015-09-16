/**
 * 
 */
package com.kkb.test.steps;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.kkb.test.util.PropertiesBundle;
import com.kkb.test.util.WebdriverFactory;

/**
 * @author sh.deng
 *
 */
public class BaseStep {
	
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(BaseStep.class);
	
	protected final String ENV = "env";

	protected final String BROWSER = "browser";
	protected static String baseUrl = "baseurl";
	protected static String loginName = "loginname";
	protected static String password = "password";



	public static Properties p;

	/**
	 * WebDriver
	 */
	public  static WebDriver driver;

	/**
	 * WebDriver
	 */
	protected List<String> params;

	/**
	 * 加载配置文件 的信息【selenium.pro 以及相关测试环境的信息base.jdbc】
	 * 初始化测试系统
	 */
	public void init(String sys)  {
		p = PropertiesBundle.loadProperties(PropertiesBundle.ALL);
		// 获取首页的url
		baseUrl = p.getProperty(sys + ".baseurl");
		// 登录名
		loginName = p.getProperty(sys + ".loginname");
		// 登录密码
		password = p.getProperty(sys + ".password");
		//根据浏览器类型 初始化driver
		driver = new WebdriverFactory().newInstanceOf(p.getProperty(BROWSER), p);
		logger.info(p.toString());
	}

/*
	 * 打印case的基本信息
	 */
	protected void printCaseInfo() {
		Method[] methods = this.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Test test = methods[i].getAnnotation(Test.class);
			if (test == null) {
				continue;
			}
			StringBuilder sb = new StringBuilder("");
			if (test.description() != null) {
				sb.append("\n\ndescription = ");
				sb.append(test.description());
				String[] dependsOnMethods = test.dependsOnMethods();
				if (dependsOnMethods == null || dependsOnMethods.length == 0) {

				} else {
					for (int j = 0; j < dependsOnMethods.length; j++) {
						sb.append("\t\t dependsOnMethods = "
								+ dependsOnMethods[i]);
					}
				}
			}
			sb.append("\n");
			logger.info(sb.toString());
		}
	}
	
	
	
	/**
	 * All退出浏览器
	 */
	protected void quitBrowser() {
		driver.quit();
	}

	/**
	 * 退出浏览器
	 */
	protected void closeBrowser() {
		driver.close();
	}



}
