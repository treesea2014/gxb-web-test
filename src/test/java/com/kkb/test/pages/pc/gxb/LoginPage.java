package com.kkb.test.pages.pc.gxb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.kkb.test.pages.Page;

/**
 * 高校帮 首页 page
 */
public class LoginPage extends Page {

  @FindBy(linkText = "登录/注册")
  public WebElement tologinBtn;

  @FindBy(id = "username")
  public WebElement username;
  
  @FindBy(id = "password")
  public WebElement password;
  
  /**
   * 登陆按钮
   */
  @FindBy(id = "login-submit")
  public WebElement loginBtn;
  
  
  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

public WebElement getLoginBtn() {
	return loginBtn;
}

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}
  
}
