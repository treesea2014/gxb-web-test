package com.kkb.test.steps.pc.gxb.personcenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kkb.test.actions.pc.gxb.personcenter.PersonCenterAct;
import com.kkb.test.steps.pc.gxb.LoginStep;

/**
 * 
 * @author sh.deng 
 * <p>高校帮-个人中心-个人信息设置
 * @date 2015-09-14
 * @version 1.0
 */
public class ModifyUserInfoStep extends LoginStep {
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(ModifyUserInfoStep.class);
	//个人中心页面动作
	private PersonCenterAct personCenterAct;

	/**
	 * 高校帮-个人中心-个人信息设置
	 * 
	 * @throws Exception
	 */
	@Test(description = "高校帮-个人中心-个人信息设置 " , priority = 1)
	public void testUserInfo() throws Exception {
		try {
			personCenterAct = new PersonCenterAct(driver);
			personCenterAct.clickPersonCenter();
			personCenterAct.clickUserInfoEdit();


			personCenterAct.switchToWindow(driver.getWindowHandle());
			personCenterAct.clickUserInfo();
			logger.info("高校帮-个人中心-个人信息设置-测试用例执行结束！");
		} catch (AssertionError e) {
			logger.error("testCurrencyAdd  failed ", e);
			personCenterAct.failScreenShot(getClass().getName());
			Assert.fail("testCurrencyAdd  failed  >> " + e.getMessage());
		} catch (Exception e) {
			personCenterAct.failScreenShot(getClass().getName());
			logger.error("testCurrencyAdd  failed ", e);
			throw new Exception("testCurrencyAdd  failed  >> "
					+ e.getMessage(), e);
		}

	}
	@Test(description = "高校帮-个人中心-个人信息设置1 " , priority = 2)
	public void testAvatars() throws Exception {
		try {
			personCenterAct = new PersonCenterAct(driver);
			//personCenterAct.clickAvatars();
			personCenterAct.snapshot();
			logger.info("高校帮-个人中心-个人信息设置-测试用例执行结束！");
		} catch (AssertionError e) {
			logger.error("testCurrencyAdd  failed ", e);
			personCenterAct.failScreenShot(getClass().getName());
			Assert.fail("testCurrencyAdd  failed  >> " + e.getMessage());
		} catch (Exception e) {
			personCenterAct.failScreenShot(getClass().getName());
			logger.error("testCurrencyAdd  failed ", e);
			throw new Exception("testCurrencyAdd  failed  >> "
					+ e.getMessage(), e);
		}

	}

}
