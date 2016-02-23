package com.kkb.test.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import net.sf.json.JSONObject;

public class HttpRequest {
	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            路径
	 * @return
	 */
	public static String sendHttpGet(String url) {
		// get请求返回结果
		StringBuilder  responseResult = new StringBuilder();
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
				responseResult.append(String.valueOf(404));
			} else {
				/** 读取服务器返回过来的json字符串数据 **/
				responseResult.append(response.getStatusLine().getStatusCode());
				responseResult.append("&");
				responseResult.append(EntityUtils.toString(response.getEntity(), "UTF-8"));
			}
		} catch (IOException e) {
			System.out.println("get请求提交失败:" + url + "   " + e);
		}
		return responseResult.toString();
	}
	
	/**
	 * 发送delete请求
	 * 
	 * @param url
	 *            路径
	 * @return
	 */
	public static String sendHttpDelete(String url) {
		// get请求返回结果
		StringBuilder  responseResult = new StringBuilder();
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			// 发送get请求
			HttpDelete deleteRequest = new HttpDelete(url);
			HttpResponse response = client.execute(deleteRequest);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
				responseResult.append(String.valueOf(HttpStatus.SC_NOT_FOUND));
			} else {
				/** 读取服务器返回过来的json字符串数据 **/
				responseResult.append(response.getStatusLine().getStatusCode());
				responseResult.append("&");
				responseResult.append(EntityUtils.toString(response.getEntity(), "UTF-8"));
			}
		} catch (IOException e) {
			System.out.println("delete请求提交失败:" + url + "   " + e);
		}
		return responseResult.toString();
	}
	

	/**
	 * post请求
	 * 
	 * @param url
	 *            url地址
	 * @param jsonParam
	 *            参数
	 * @param noNeedResponse
	 *            不需要返回结果
	 * @return
	 */
	public static String sendHttpPost(String url,  Object jsonParam) {
		// post请求返回结果
		DefaultHttpClient httpClient = new DefaultHttpClient();
		StringBuilder  responseResult = new StringBuilder();
		HttpPost method = new HttpPost(url);
		try {
			if (jsonParam != null) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			HttpResponse result = httpClient.execute(method);

			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
				responseResult.append(HttpStatus.SC_NOT_FOUND);
			}
			else
			{
				try {
					/** 读取服务器返回过来的json字符串数据 **/
//					responseResult = EntityUtils.toString(result.getEntity(),"utf-8");		
					responseResult.append(result.getStatusLine().getStatusCode());
					responseResult.append("&");
					responseResult.append(EntityUtils.toString(result.getEntity(),"utf-8"));
				} catch (Exception e) {
					System.out.println("post请求提交失败:" + url + "  " + e);
				}
			}
			
		} catch (IOException e) {
			System.out.println("post请求提交失败:" + url + "  " + e);
		}
		return responseResult.toString();
	}

	/**
	 * put请求
	 * 
	 * @param url
	 *            url地址
	 * @param jsonParam
	 *            参数
	 * @param noNeedResponse
	 *            不需要返回结果
	 * @return
	 */
	public static String sendHttpPut(String url, Object jsonParam) {
		// post请求返回结果
		DefaultHttpClient httpClient = new DefaultHttpClient();
		StringBuilder  responseResult = new StringBuilder();
		HttpPut httpPut = new HttpPut(url);

		try {
			if (jsonParam != null) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPut.setEntity(entity);
			}
			HttpResponse result = httpClient.execute(httpPut);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
				responseResult.append(HttpStatus.SC_NOT_FOUND);
			}
			else
			{
				try {
					/** 读取服务器返回过来的json字符串数据 **/
//					responseResult = EntityUtils.toString(result.getEntity(),"utf-8");		
					responseResult.append(result.getStatusLine().getStatusCode());
					responseResult.append("&");
					responseResult.append(EntityUtils.toString(result.getEntity(),"utf-8"));
				} catch (Exception e) {
					System.out.println("put请求提交失败:" + url + "  " + e);
				}
			}
		} catch (IOException e) {
			System.out.println("post请求提交失败:" + url + "  " + e);
		}
		return responseResult.toString();
	}

	public static String getCode(String surl) {
		String code = "Http状态码";
		try {
			// url="http://www.baidu.com";
			URL url = new URL(surl);
			URLConnection rulConnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setConnectTimeout(300000);
			httpUrlConnection.setReadTimeout(300000);
			httpUrlConnection.connect();
			code = new Integer(httpUrlConnection.getResponseCode()).toString();
			// String message = httpUrlConnection.getResponseMessage();
			// System.out.println("getResponseCode code ="+ code);
			// System.out.println("getResponseMessage message ="+ message);
			if (!code.startsWith("2")) {
				throw new Exception("ResponseCode is not begin with 2,code=" + code);
			}
		} catch (Exception ex) {
			// System.out.println(ex.getMessage());
		}
		return code;
	}
}