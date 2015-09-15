package com.kkb.test.actions.pc.gxb.personcenter;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kkb.test.actions.pc.gxb.IndexAct;
import com.kkb.test.pages.pc.gxb.personcenter.PersonCenterPage;



/**
 * @author sh.deng
 * @description 个人中心页面动作
 * @date 2015.09.14
 */
public class PersonCenterAct  extends IndexAct{
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(PersonCenterAct.class);
	/**
	 *高校帮登陆页面
	 */
	private PersonCenterPage personCenterPage;
	
	/**
	 * 
	 * @param driver
	 */
	public PersonCenterAct(WebDriver driver) {
		super(driver);
		personCenterPage=new PersonCenterPage(driver);
	}
	
	/**
	 * 点击 认证学分课
	 */
	public  void clickScoreCourse() {
		logger.info("点击 认证学分课");
		this.click(personCenterPage.scoreCourse);
	}
	/**
	 * 点击 兴趣学习课
	 */
	public  void clickInterestCourse() {
		logger.info("点击 兴趣学习课");
		this.click(personCenterPage.interestCourse);
	}
	/**
	 * 点击 收藏
	 */
	public  void clickCollection() {
		logger.info("点击 认证学分课");
		this.click(personCenterPage.collection);
	}
	
	/**
	 * 点击 个人设置           
	 */
	public  void clickUserInfoEdit() {
		logger.info("点击  个人设置 ");
		this.click(personCenterPage.userInfoEdit);
	}
	
	/***********************个人设置页面动作*********************/
	
	/**
	 * 点击-个人设置页面-个人信息           
	 */
	public  void clickUserInfo() {
		logger.info("点击  个人信息");
		click(personCenterPage.userInfo);
	}
	/**
	 * 点击-个人设置页面-头像           
	 */
	public  void clickAvatars() {
		logger.info("点击  头像");
		click(personCenterPage.avatars);
	}
	/**
	 * 点击-个人设置页面-安全设置           
	 */
	public  void clickSecurity() {
		logger.info("点击   安全设置");
		click(personCenterPage.security);
	}
}
