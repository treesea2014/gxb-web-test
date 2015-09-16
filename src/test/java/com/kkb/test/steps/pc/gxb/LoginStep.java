/**
 * 
 */
package com.kkb.test.steps.pc.gxb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.kkb.test.actions.pc.gxb.IndexAct;
import com.kkb.test.constants.Constant;
import com.kkb.test.steps.AbstractStep;

/**
 * @author dengshuhai
 * @description wap登录
 * @date 2015-05-05
 */
public class LoginStep extends AbstractStep {
	/**
	 * 首页动作
	 */
	protected IndexAct loginAct;
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(LoginStep.class);
	
	@BeforeSuite
	public void beforeSuite() {
		super.beforeSuite(Constant.GXB);
		userLogin();
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
	 * 
	 */
	@BeforeMethod
	public void beforeMethod() {
		
	}

	/**
	 * 
	 */
	@AfterMethod
	public void afterMethod() {
	
	}
	/**
	 * gxb 用户登录
	 */
	public void userLogin(){
		try {
			IndexAct l = new IndexAct(driver);
			int i = 0;
			while(i<5&&!l.checkLogin()){
				logger.info("状态为：未登录");
				l.clickToLogin();
				l.inputUserName(loginName);
				l.inputPassword(password);
				l.clickLogin();
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("登录失败！");
			e.printStackTrace();
		}

	}

		
}
