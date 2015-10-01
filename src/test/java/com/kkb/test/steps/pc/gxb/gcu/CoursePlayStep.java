package com.kkb.test.steps.pc.gxb.gcu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kkb.test.actions.pc.gxb.CommonCourseDetailsAct;
import com.kkb.test.actions.pc.gxb.gcu.CourseDetailsAct;
import com.kkb.test.constants.Constant;

/**
 * 
 * @author sh.deng 
 * <p>华南理工学院|广州学院
 * @date 2015-09-14
 * @version 1.0
 */
public class CoursePlayStep extends LoginStep {
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(CoursePlayStep.class);
	//个人中心页面动作
	private CourseDetailsAct courseDetailsAct;
	
	@BeforeClass
	public void beforeSuite(){
		beforeSuite(Constant.GCU);
	}

	/**
	 * 高校帮-个人中心-个人信息设置
	 * 
	 * @throws Exception
	 */
	@Test(description = "华南理工大学|广州学院-查看视频播放 " , priority = 1)
	public void testVideoPaly() throws Exception {
		try {
			courseDetailsAct = new CourseDetailsAct(driver);
			courseDetailsAct.snapshot();
			//点击课程
			courseDetailsAct.clickCourseBar();
			courseDetailsAct.snapshot();
			//点击第一门课程
			courseDetailsAct.clickFirstCourse();
			//显示所有章节
			courseDetailsAct.dispalyAllChapter();
			courseDetailsAct.snapshot();
			//点击预览
			courseDetailsAct.clickPreview();
			courseDetailsAct.snapshot();
			//等待30s
			courseDetailsAct.pause(30);
			courseDetailsAct.snapshot();
			//点击暂停
			courseDetailsAct.clickPaly();
			courseDetailsAct.snapshot();
			//获取播放时间
			courseDetailsAct.getCurrentTime();
			//获取总时长
			courseDetailsAct.getDurationTime();
			//获取播放进度
			courseDetailsAct.palyProgress();

			logger.info("华南理工大学|广州学院-查看视频播放-测试用例执行结束！");
		
		} catch (Exception e) {
			logger.error("华南理工大学|广州学院-查看视频播放", e);
			throw new Exception("华南理工大学|广州学院-查看视频播放  >> "
					+ e.getMessage(), e);
		}

	}


}
