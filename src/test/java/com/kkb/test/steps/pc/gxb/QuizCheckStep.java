package com.kkb.test.steps.pc.gxb;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kkb.test.actions.pc.gxb.CommonCourseQuizAct;
import com.kkb.test.actions.pc.gxb.LoginAct;
import com.kkb.test.steps.AbstractStep;
import com.kkb.test.util.PropertiesBundle;
import com.kkb.test.util.WebdriverFactory;

/**
 * 
 * @author sh.deng 
 * <p>测验检查 共通
 * @date 2015-12-07
 * @version 1.0
 */
public class QuizCheckStep extends AbstractStep {
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(QuizCheckStep.class);
	//课程检查动作。页面动作
	private CommonCourseQuizAct commonCourseQuizAct;
	


	/**
	 * 高校帮-个人中心-个人信息设置
	 * 
	 * @throws Exception
	 */
	@Parameters({"baseUrl","loginName","password","courseName" })
	@Test(description = "查看测验检查遍历 " , priority = 1)
	public void testVideoPaly(String baseUrl,String loginName,String password,String courseName) throws Exception {
		try {		
			//StringBuilder  errorQuiz = new StringBuilder("");

			userLogin(baseUrl,loginName, password);
			
			commonCourseQuizAct = new CommonCourseQuizAct(driver);
			//点击课程bar
			commonCourseQuizAct.clickCourseBar();
			//搜索课程
			commonCourseQuizAct.inputSearchContent(courseName);
			commonCourseQuizAct.snapshot();
			//点击开始/继续学习clickStartStudy
			commonCourseQuizAct.clickStartStudy();
			commonCourseQuizAct.pause(5);
			//点击测验
			commonCourseQuizAct.clickQuiz();
			//开始遍历检查
			commonCourseQuizAct.quizCheck(courseName);
			
			logger.info("查看测验检查遍历-测试用例执行结束！");
		
		} catch (Exception e) {
			logger.error("查看测验检查遍历-"+courseName, e);
			throw new Exception("查看测验检查遍历-"+courseName+"  >> "
					+ e.getMessage(), e);
		}

	}
	/**
	 * gxb 用户登录
	 */
	public void userLogin(String baseUrl ,String loginName,String password ){
		try {
			p = PropertiesBundle.loadProperties(PropertiesBundle.ALL);

			driver = new WebdriverFactory().newInstanceOf(p.getProperty(BROWSER), p);
			driver.get(baseUrl);
			LoginAct l = new LoginAct(driver);
			int i = 0;
			while(i<5&&!l.checkLogin()){
				logger.info("状态为：未登录");
				l.clickToLogin();
				l.inputUserName(loginName);
				l.inputPassword(password);
				l.clickLogin();
				l.pause(3);
				if(driver.getPageSource().contains("跳过")){
				driver.findElement(By.linkText("跳过")).click();}
				if(driver.getPageSource().contains("跳过")){
					driver.findElement(By.linkText("跳过")).click();}
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("登录失败！");
			e.printStackTrace();
		}

	}

}
