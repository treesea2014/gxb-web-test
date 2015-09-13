/**
 * 
 */
package com.kkb.test.steps.pc.gxb;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kkb.test.actions.gxb.LoginAct;
import com.kkb.test.constants.Constant;
import com.kkb.test.steps.AbstractStep;
import com.kkb.test.steps.BaseStep;

/**
 * @author dengshuhai
 * @description wap登录
 * @date 2015-05-05
 */
public class LoginStep extends AbstractStep {
	/**
	 * wap首页
	 */
	protected LoginAct loginAct;

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
	@Test
	public void test(){}
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
	 * wap 用户登录
	 */
	public void userLogin(){
		LoginAct l = new LoginAct(driver);
		l.clickToLogin();
		l.inputUserName(loginName);
		l.inputPassword(password);
		l.clickLogin();

	}

	@Override
	public void addNeedParam() {
		// TODO Auto-generated method stub
		
	}
	
}
