/**
 * 
 */
package com.kkb.test.steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author jianping.gao
 * 
 */
public abstract class AbstractStep extends BaseStep {

	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(AbstractStep.class);

	/**
	 * test before
	 * 
	 * @param args
	 */

	
	public void beforeSuite(String sys) {
		init(sys);
		printCaseInfo();
		// 打开首页
		driver.get(baseUrl);

	}
	
	@AfterSuite
	public void afterSuite() {
		Set<String> handles = 	driver.getWindowHandles();
		for(String s :handles){
			driver.switchTo().window(s);
			logger.info("关闭浏览器：{}",s);
			driver.close();
		}

	}
	
	



	/**
	 * 
	 */
	@BeforeTest
	public void beforeTest() {

	}

	/**
	 * 
	 */
	@AfterTest(alwaysRun = true)
	public void afterTest() {

	}

	/**
	 * 
	 * @param sys
	 */
	@BeforeClass
	public void beforeClass() {

	}

	/**
	 * 
	 */
	@AfterClass(alwaysRun = true)
	public void afterClass() {

	}

	/**
	 * @throws  
	 * 
	 */

	public void beforeMethod(String sys)  {
	
	

	}

	/**
	 * 
	 */
	@AfterMethod
	public void afterMethod() {
		
	
	}

	/**
	 * 请写case之前，添加需要依赖的参数到这个方法中,具体在case实现此方法
	 * 
	 * params.add(ParameterConstant.PRODUCT_ID);
	 */
	public abstract void addNeedParam();
}
