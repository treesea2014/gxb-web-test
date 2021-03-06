package com.kkb.test.pages.pc.gxb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.kkb.test.pages.Page;

/**
 * @author sh.deng
 * @description 高校帮 课程学习page
 * @date 2015.10.12
 */
public class CourseLearnPage extends Page {

	public CourseLearnPage(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * 开始学习
	 */
	@FindBy(xpath = "//*[@id='menus_list']/li[2]/a/span[2]")
	public WebElement startLearn;
	
	/**
	 * 所有章节名称
	 */
	@FindBy(xpath = "//*[@id='units_list']/div/div/h4/span[2]")
	public List<WebElement> chapterList;
	
	/**
	 * 所有章节下课程
	 */
	@FindBy(xpath = "//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression']")
	@CacheLookup
	public List<WebElement> courseList;
	/**
	 * 视频播放返回
	 */
	@FindBy(xpath = "//*[@href='#/units/index'][@class='back-btn']")
	public WebElement videoBack;

	/**
	 * 视频-播放按钮
	 */
	@FindBy(xpath = "//*[@id='home_video']/div[5]")
	public WebElement videoPlayBtn;
	/**
	 * 视频-暂停按钮
	 */
	@FindBy(id = "home_video_html5_api")
	public WebElement videoPauseBtn;
	
	
	/**
	 * 视频-本次观看时间%
	 */
	@FindBy(xpath = "//*[@id='vlog-box']/table/tbody/tr[@class='current']/td[2]")
	public WebElement currentPlayTime;
	
	/**
	 * 视频-历史观看时间%
	 */
	@FindBy(xpath = "//*[@id='vlog-box']/table/tbody/tr[@class='history']/td[2]")
	public WebElement historyPlayTime;
	
	/**
	 * 视频-播放出错
	 */
	@FindBy(xpath = "//div[@class='vjs-error-display']/*")
	public WebElement playError;
}
