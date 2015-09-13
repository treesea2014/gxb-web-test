package com.kkb.test.actions.gxb;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNGException;
import org.xml.sax.Attributes;

import com.kkb.test.actions.Action;
import com.kkb.test.pages.pc.gxb.LoginPage;



/**
 * @author dengshuhai
 * 登陆页面动作
 */
public class LoginAct  extends Action{
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(LoginAct.class);
	/**
	 *高校帮登陆页面
	 */
	private LoginPage loginPage;
	
	/**
	 * 
	 * @param driver
	 */
	public LoginAct(WebDriver driver) {
		super(driver);
		loginPage=new LoginPage(driver);
	}
	
	/**
	 *点击去登陆/注册按钮
	 */
	public  void clickToLogin() {
		logger.info("点击去登陆按钮：");
		this.click(loginPage.tologinBtn);
	}
	
	/**
	 *输入用户
	 */
	public  void inputUserName(String text) {
		logger.info("输入收货人姓名：{}",text );
		this.type(loginPage.username,text);
	}
	
	/**
	 *输入密码
	 */
	public  void inputPassword(String text) {
		logger.info("输入密码：{}",text );
		this.type(loginPage.password,text);
	}
	
	
	/**
	 *点击登陆按钮
	 */
	public  void clickLogin() {
		logger.info("点击登陆按钮：");
		this.click(loginPage.loginBtn);
	}
	
	
}
