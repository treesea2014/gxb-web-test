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
	
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	/**
	 * 登陆按钮
	 */
	@FindBy(name = "submit")
	public WebElement loginBtn;
	
	/**
	 * 用户信息 用于判断是否登录
	 */
	@FindBy(xpath = "//div[@id='userInfo']/a")
	public WebElement loginInfo;
}
