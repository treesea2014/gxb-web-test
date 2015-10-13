package com.kkb.test.steps.pc.gxb.tsk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kkb.test.actions.pc.gxb.CommonCourseDetailsAct;
import com.kkb.test.actions.pc.gxb.CommonCourseLearnAct;
import com.kkb.test.actions.pc.gxb.gcu.CourseDetailsAct;
import com.kkb.test.constants.Constant;
import com.kkb.test.steps.pc.gxb.LoginStep;

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
	private CommonCourseLearnAct commonCourseLearnAct;
	
	@BeforeClass
	public void beforeSuite(){
		beforeSuite(Constant.TSK);
	}

	/**
	 * 高校帮-个人中心-个人信息设置
	 * 
	 * @throws Exception
	 */
	@Parameters("courseName" )
	@Test(description = "厦门海洋大学-查看视频播放 " , priority = 1)
	public void testVideoPaly(String courseName) throws Exception {
		try {
			commonCourseLearnAct = new CommonCourseLearnAct(driver);
			
			StringBuilder errorCourse = new StringBuilder("");

			commonCourseLearnAct.snapshot();
			//点击课程
			commonCourseLearnAct.clickCourseBar();
			//搜索课程
			commonCourseLearnAct.inputSearchContent(courseName);
			commonCourseLearnAct.snapshot();

			//点击第一门课程
			//String errorVideo = commonCourseLearnAct.clickCourse(courseName);
			
			//点击开始/继续学习
			commonCourseLearnAct.clickStartStudy();
			commonCourseLearnAct.pause(10);
			commonCourseLearnAct.snapshot();
			//等待30s
			//点击左侧学习
			commonCourseLearnAct.clickStartLearn();
			commonCourseLearnAct.snapshot();
			//获取所有章节
			commonCourseLearnAct.allChapters(courseName,errorCourse);
			logger.info("出错的视频有：");
			logger.info(errorCourse.toString());

			logger.info("厦门海洋大学-查看视频播放-测试用例执行结束！");
		
		} catch (Exception e) {
			logger.error("厦门海洋大学-查看视频播放-"+courseName, e);
			throw new Exception("厦门海洋大学-查看视频播放-"+courseName+"  >> "
					+ e.getMessage(), e);
		}

	}


}
