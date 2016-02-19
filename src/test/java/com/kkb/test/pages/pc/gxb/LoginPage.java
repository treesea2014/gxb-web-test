package com.kkb.test.pages.pc.gxb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kkb.test.pages.Page;

/**
 * @author sh.deng
 * @description 高校帮 常用登录 page
 * @date 2015.09.22
 */
public class LoginPage extends Page {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(linkText = "登录/注册")
	public WebElement tologinBtn;
	//学号登录
	@FindBy(id = "studentId")
	public WebElement studentId;

	
	@FindBy(xpath = "(//*[@id='username'])[2]")
	public WebElement username;

	@FindBy(xpath = "(//*[@id='password'])[2]")
	public WebElement password;

	/**
	 * 登陆按钮
	 */
	@FindBy(xpath = "(//input[@name='submit'])[2]")
	public WebElement loginBtn;
	
	/**
	 * 用户信息 用于判断是否登录
	 */
	@FindBy(xpath = "//div[@id='userInfo']/a")
	public WebElement loginInfo;
}
