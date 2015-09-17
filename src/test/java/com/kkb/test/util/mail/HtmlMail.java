/**
 * 
 */
package com.kkb.test.util.mail;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

import com.kkb.test.steps.BaseStep;

/**
 * @author treesea888@qq.com
 * 
 */
public class HtmlMail {
	/**
	 * slf4j logback
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(HtmlMail.class);

	public static String hostName = "smtp.qq.cn";
	public static String from = "shdeng@gaoxiaobang.cn";
	public static String pwd = "pwd";


	private static ResourceBundle bundle = null;

	static {
		try {
			bundle = ResourceBundle.getBundle("mail");
			if (bundle.getString("mail.smtp") != null
					&& !bundle.getString("mail.smtp").trim().equals("")) {
				hostName = bundle.getString("mail.smtp");
			}
			if (bundle.getString("mail.from") != null
					&& !bundle.getString("mail.from").trim().equals("")) {
				from = bundle.getString("mail.from");
			}

			if (bundle.getString("mail.pwd") != null
					&& !bundle.getString("mail.pwd").trim().equals("")) {
				pwd = bundle.getString("mail.pwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 */
	public static void send(String to, String subject, String content) {
		String[] tos = { to };
		send(tos, subject, content, null, null);
	}

	/**
	 * 群发邮件
	 * 
	 * @param to
	 * @param subject
	 * @param content
	 */
	public static void send(String[] to, String subject, String content) {
		send(to, subject, content, null, null);
	}

	/**
	 * 群发邮件
	 * 
	 * @param to
	 *            收件人邮箱集合
	 * @param subject
	 *            主题
	 * @param content
	 *            内容
	 * @param cc
	 *            抄送人
	 * @param bcc
	 *            秘密抄送人
	 */
	public static void send(final String[] to, final String subject,
			final String content, final List<String> cc, final List<String> bcc) {
		HtmlEmail email = new HtmlEmail();
		email.setCharset("UTF-8");
		try {

			// 设置邮件服务器
			email.setHostName(hostName);
			// 设置登录邮件服务器用户名和密码
			email.setAuthentication(from, pwd);
			// 设置发件人
			email.setFrom(from, "UI自动化测试【GXB】");
			if (null != to && to.length > 0) {
				for (int i = 0; i < to.length; i++) {
					email.addTo(to[i]); // 接收方
				}
			}
			if (null != cc && cc.size() > 0) {
				for (int i = 0; i < cc.size(); i++) {
					email.addCc(cc.get(i)); // 抄送方
				}
			}
			if (null != bcc && bcc.size() > 0) {
				for (int i = 0; i < bcc.size(); i++) {
					email.addBcc(bcc.get(i)); // 秘密抄送方
				}
			}
			// 设置邮件标题
			email.setSubject(subject);
			// 设置邮件正文内容
			email.setHtmlMsg(content);
			email.send();
			logger.info("邮件发送完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
		 * 以行为单位读取文件，常用于读面向行的格式化文件
		 */
		public static void generateMailHtml(List<ISuite> suites, Date reportTime) {
			String to = bundle.getString("toMail");
			if (to == null) {
				return;
			}
			String[] toMail = bundle.getString("toMail").split(";");
			String env = BaseStep.p.getProperty("env");
			String server = bundle.getString("server");
			String port = bundle.getString("port");
			String htmlPath = bundle.getString("htmlPath") ;
			String	subject = bundle.getString("subject");
			
			String url = "http://"  
					+ server + ":"
					+ port
					+ htmlPath
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(reportTime)+File.separator
					 + "index.html";

			int passed = 0;
			int fail = 0;
			int skip = 0;

			StringBuilder html = new StringBuilder("<html>");
			StringBuilder sb = new StringBuilder("");
			sb.append("<h4>" + "详细结果：" + url + "</h4><br>");
			int lineCount = 0;
			for (ISuite suite : suites) {
				if (suite.getAllMethods() == null
						|| suite.getAllMethods().size() == 0) {
					continue;
				}
				if (lineCount == 0) {
					sb.append("<h2 style='margin-left:40px;'>");
				} else {
					sb.append("<h2>");
				}
				sb.append("suite 模块：" + suite.getName()).append("<h2>");
				Map<String, ISuiteResult> results = suite.getResults();
				Iterator<String> it = suite.getResults().keySet().iterator();
				while (it.hasNext()) {
					ISuiteResult result = results.get(it.next());
					ITestContext testContext = result.getTestContext();
					passed = passed + testContext.getPassedTests().size();
					fail = fail + testContext.getFailedTests().size();
					skip = skip + testContext.getSkippedTests().size();

					int total = testContext.getFailedTests().size()
							+ testContext.getPassedTests().size()
							+ testContext.getSkippedTests().size();

					 sb.append("<h3 style='margin-left:80px;'>" + "test 模块："
					 + testContext.getName() + "\t总计：" + total + " \t通过："
					 + testContext.getPassedTests().size() + " \t失败："
					 + testContext.getFailedTests().size() + " \t跳过："
					 + testContext.getSkippedTests().size() + " \t通过率："
					 + (testContext.getPassedTests().size() * 100 / total)
					 + " %" + "</h3>");
					/*sb.append("<h3 style='margin-left:80px;'>" + "test 模块："
							+ testContext.getName() + "</h3>");*/
				}
				lineCount++;
			}
			String per = "<div style=\"height:20px;width:400px;\">" +
				"<div style=\"height:20px;width:"+(passed * 100 / (passed + fail + skip))+"%;background-color:green;float:left\"></div>"+
				"<div style=\"height:20px;width:"+(skip * 100 / (passed + fail + skip))+"%;background-color:yellow;float:left\"></div>"+
				"<div style=\"height:20px;width:"+(fail * 100 / (passed + fail + skip))+"%;background-color:red;float:left\"></div>"+
				"</div>";
			html.append(
					"<h4 style='color:red;'>" + env + "环境     结果统计："
							+ (passed + fail + skip) + "\t通过:" + passed
							+ "&nbsp;&nbsp;失败:" + fail + "&nbsp;&nbsp;跳过:" + skip
							+ "&nbsp;&nbsp;通过率:"
							+ (passed * 100 / (passed + fail + skip)) + " %</h4>").append(per)
					.append(sb.toString()).append("</html>");

			String Subject = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒")
					.format(reportTime)
					+ "  "
					+ env
					+ "环境      "
					+ subject;
			
			HtmlMail.send(toMail, Subject, html.toString());
		}
}
