/**
 * 
 */
package com.kkb.test.steps;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * @author sh.deng
 * 
 */
public abstract class AbstractStep extends BaseStep {

	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(AbstractStep.class);


	public void beforeSuite(String sys) {
		init(sys);
		printCaseInfo();
		// 打开首页
		driver.get(baseUrl);

	}
	
	@AfterClass
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
		//System.out.println("关闭");
		//driver.quit();
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
		//System.out.println("关闭");
		//driver.quit();
	}

	/**
	 * @throws  
	 * 
	 */
	public void beforeMethod()  {
	}

	/**
	 * 
	 */
	@AfterMethod
	public void afterMethod() {

	}

}
