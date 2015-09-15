package com.kkb.test.pages.pc.gxb.personcenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.kkb.test.pages.Page;

/**
 * 高校帮 首页 page
 */
public class PersonCenterPage extends Page {

	public PersonCenterPage(WebDriver webDriver) {
		super(webDriver);
	}
	/**
	 * 认证学分课
	 */
	@FindBy(xpath = "//a[@href='#/home']")
	public WebElement scoreCourse;
	/**
	 * 兴趣学习课
	 */
	@FindBy(xpath = "//a[@href='#/home/interestCourse']")
	public WebElement interestCourse;
	/**
	 * 收藏
	 */
	@FindBy(xpath = "//a[@href='#/home/collection']")
	public WebElement collection;
	/**
	 * 个人设置
	 */
	@FindBy(xpath = "//*[@id='context-container']/div/div[2]/div[1]/ul/li[4]/a")
	public WebElement 	userInfoEdit;
	/**
	 * 个人中心页的frame
	 */
	@FindBy(name = "google_conversion_frame']")
	public WebElement 	iframe;
	
	
	//**************************个人设置页面*****************************//
	/**
	 * 个人信息
	 */
	@FindBy(linkText = "个人信息")
	public WebElement 	userInfo;
	
	/**
	 * 头像
	 */
	@FindBy(linkText = "头像")
	public WebElement 	avatars;
	/**
	 * 安全设置
	 */
	@FindBy(linkText = "安全设置")
	public WebElement 	security;
}
