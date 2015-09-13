/**
 * 
 */
package com.kkb.test.steps;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNGException;
import org.testng.annotations.Test;

import com.kkb.test.util.PropertiesBundle;
import com.kkb.test.util.WebdriverFactory;

/**
 * @author jianping
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



	protected Properties p;

	/**
	 * WebDriver
	 */
	protected WebDriver driver;

	/**
	 * WebDriver
	 */
	protected List<String> params;

	/**
	 * 初始化自动化测试系统
	 */
/*	public void init(String sys) {
		// 获取本次case驱动
		if("true".equals(getMemVal(REMOTE).trim())){
			if(remoteIp.contains("localhost")){
				logger.info("本地主机启动...");
				driver = new WebdriverFactory().newInstanceOf(getMemVal(BROWSER));
			}else{
				logger.info("远程主机启动...");
				driver = new RemoteWebdriver().newInstanceOf(getMemVal(BROWSER), remoteIp , platform);
			}
		}else{
			driver = new WebdriverFactory().newInstanceOf(getMemVal(BROWSER));
		}
		// 获取执行方式
		if ("true".equals(getMemVal(SWITCH).trim())) {
			// 获取首页的url
			baseUrl = getMemVal(sys + ".baseurl");
			// 登录名
			loginName = getMemVal(sys + ".loginname");
			// 登录密码
			password = getMemVal(sys + ".password");
		}

	}*/

	/**
	 * 加载配置文件 的信息【selenium.pro 以及相关测试环境的信息base.jdbc】
	 * @throws InterruptedException 
	 */
	
	public void init(String sys)  {

		p = PropertiesBundle.loadProperties(PropertiesBundle.ALL);
		// 获取首页的url
		baseUrl = p.getProperty(sys + ".baseurl");
		// 登录名
		loginName = p.getProperty(sys + ".loginname");
		// 登录密码
		password = p.getProperty(sys + ".password");
		
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
	 * 退出浏览器
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
