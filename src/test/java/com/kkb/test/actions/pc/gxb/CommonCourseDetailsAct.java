package com.kkb.test.actions.pc.gxb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kkb.test.pages.pc.gxb.CourseDetailsPage;
import com.kkb.test.pages.pc.gxb.CoursePage;


/**
 * @author sh.deng
 * @description 首页页面动作
 * @date 2015.09.14
 */
public class CommonCourseDetailsAct extends CourseAct {
    /**
     * slf4j
     */
    private final static Logger logger = LoggerFactory
            .getLogger(CommonCourseDetailsAct.class);

    private CourseDetailsPage courseDetialsPage;

    /**
     * @param driver
     */
    public CommonCourseDetailsAct(WebDriver driver) {
        super(driver);
        courseDetialsPage = new CourseDetailsPage(driver);
    }

    /**
     * 打印课程列表
     */
    public void dispalyAllChapter() {
        List<WebElement> chapterList = courseDetialsPage.chapterList;
        for (WebElement chapter : chapterList) {
            logger.info(getText(chapter));
        }
    }

    /**
     * 点击开始/继续学习
     */
    public void clickStartStudy() {
        logger.info("点击开始/继续学习");
        click(courseDetialsPage.startStudy);
    }

    /**
     * 点击授权提示按钮
     */
    public void clickPromptButton() {
        logger.info("授权提示框");
        if (this.isElementPresent(courseDetialsPage.promptBox)) {
            click(courseDetialsPage.promptButton);
            this.pause(1);
            clickStartStudy();
        }
    }

    /**
     * 点击预览
     */
    public void clickPreview() {
        logger.info("点击预览");
        click(courseDetialsPage.preview);
    }

    /**
     * 点击暂停
     */
    public void clickPaly() {
        logger.info("点击暂停");
        click(courseDetialsPage.playBtn);
    }

    /**
     * 获取播放时间
     */
    public void getCurrentTime() {
        String time = getText(courseDetialsPage.currentTime);
        logger.info("获取当前已播放时间为：{}", time);
    }

    /**
     * 获取视频时间总长
     */
    public void getDurationTime() {
        String time = getText(courseDetialsPage.durationTime);
        logger.info(" 获取视频时间总长：{}", time);
    }

    /**
     * 获取视频播放进度
     */
    public void palyProgress() {
        String time = courseDetialsPage.palyProgress.getAttribute("style").replace("width:", "");
        logger.info(" 获取视频播放进度：{}", time);
    }
}
