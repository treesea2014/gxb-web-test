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

    /**
     * 用户信息 用于判断是否登录
     */
    @FindBy(xpath = "//div[@id='userInfo']/a")
    public WebElement loginInfo;

    @FindBy(xpath = "//div[@class='wrapper']/div[2]/div[@class='mainRight']/ul/li[contains(text(), '学号登录')]")
    public WebElement studentId;


    @FindBy(xpath = "(//*[@id='username'])[1]")
    public WebElement username;

    @FindBy(xpath = "(//*[@id='password'])[1]")
    public WebElement password;

    /**
     * 登陆按钮
     */
    @FindBy(xpath = "(//input[@name='submit'])[1]")
    public WebElement loginBtn;


}
