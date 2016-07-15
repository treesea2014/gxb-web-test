package com.kkb.test.pages.pc.gxb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kkb.test.pages.Page;

/**
 * @author sh.deng
 * @description 高校帮 课程详细page
 * @date 2015.09.14
 */
public class CourseDetailsPage extends Page {

	public CourseDetailsPage(WebDriver webDriver) {
		super(webDriver);
	}

	
	
	/**
	 * head播放按钮
	 */
	@FindBy(xpath = "//*[@id='preview-intro-video']/div[6]/div[1]")
	public WebElement headVideoPlayBtn;
	
	/**
	 * head 课程名称
	 * 
	 */
	@FindBy(xpath = "//*[@class='class-info-detail']/h3")
	public WebElement courseName;
	
	/**
	 * head 课程评分
	 * 
	 */
	@FindBy(xpath = "//span[@class='score']")
	public WebElement score;
	
	
	/**
	 * 学分
	 */
	@FindBy(xpath = "//div[@class='class-info-score']")
	public WebElement credit;
	
	/**
	 * 开始/继续学习
	 */
        @FindBy(xpath = "//div[@class='vedioRight']/div[@class='r_right']/div[@class='ng-scope']/p")
	public WebElement startStudy;

	/**
	 * 授权提示框
	 */
	@FindBy(xpath = "//div[@class='modal-content']")
	public WebElement promptBox;

	/**
	 * 授权确认按钮
	 */
	@FindBy(xpath = "//a[@class='cms-pop-btn']")
	public WebElement promptButton;

	/**
	 * 课程介绍
	 */
	@FindBy(linkText = "课程介绍")
	public WebElement courseInstru;
	/**
	 * 章节试学
	 */
	@FindBy(linkText = "章节试学")
	public WebElement chapter;
	/**
	 *教学安排
	 */
	@FindBy(linkText = "教学安排")
	public WebElement arrange;
	/**
	 * 精彩评价
	 */
	@FindBy(linkText = "精彩评价")
	public WebElement evaluation;
	/**
	 * 章节标题列表
	 */
	@FindBy(xpath = "//div[@class='content']/ul/li/ul")
	public List<WebElement> chapterList;
	
	/**
	 * 预览
	 */
	@FindBy(linkText = "预览")
	public WebElement preview;
	
	
	/**
	 * 视频播放(暂停)按钮 
	 */
	@FindBy(xpath = "(//div[@class='vjs-control-bar']/div[1]/div/span)[2]")
	public WebElement playBtn;
	
	/**
	 * 视频已播放的时间 
	 */
	@FindBy(xpath = "(//div[@class='vjs-current-time-display'])[2]")
	public WebElement currentTime;
	
	/**
	 * 视频时间总长
	 */
	@FindBy(xpath = "(//div[@class='vjs-duration-display'])[2]")
	public WebElement durationTime;
	
	/**
	 * 视频播放进度
	 */
	@FindBy(xpath = "(//div[@class='vjs-play-progress'])[2]")
	public WebElement palyProgress;
	

}
