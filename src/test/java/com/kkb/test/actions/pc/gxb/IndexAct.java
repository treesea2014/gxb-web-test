package com.kkb.test.actions.pc.gxb;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kkb.test.actions.Action;
import com.kkb.test.pages.pc.gxb.IndexPage;



/**
 * @author sh.deng
 * @description 首页页面动作
 * @date 2015.09.14
 */
public class IndexAct  extends Action{
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(IndexAct.class);
	/**
	 *高校帮登陆页面
	 */
	private IndexPage loginPage;
	
	/**
	 * 
	 * @param driver
	 */
	public IndexAct(WebDriver driver) {
		super(driver);
		loginPage=new IndexPage(driver);
	}
	
	/**
	 *点击首页
	 */
	public  void clickMainPageBar() {
		logger.info("点击首页");
		this.click(loginPage.mianPage);
	}
	
	/**
	 *点击课程
	 */
	public  void clickCourseBar() {
		logger.info("点击课程");
		this.click(loginPage.course);
	}
	
	/**
	 *点击个人中心
	 */
	public  void clickPersonCenter() {
		logger.info("点击个人中心");
		this.click(loginPage.personCenter);
	}
	
	/**
	 *点击管理员入口
	 */
	public  void clickAdminBar() {
		logger.info("点击管理员入口");
		this.click(loginPage.adminLogin);
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
		logger.info("输入用户名：{}",text );
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
	

	/**
	 *检查是否登陆
	 * @return 
	 */
	public  boolean checkLogin() {
		String loginInfo = loginPage.loginInfo.getText();
		logger.info("登陆信息：{}",loginInfo);
		if("登录/注册".equals(loginInfo)){
			return false;
		}
		return true;
	}
}
