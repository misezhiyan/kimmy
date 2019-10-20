package com.treasure.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpUtil {

	public static void main(String[] args) throws IOException {
		String url = "http://cms.pokermanager.club/cms/";
		String cookie = getCookiesByGet(url);
		String html = sendGetWithCookie(url, cookie);
		System.out.println(html);
		String regex = "ng-init=\"([^\"]*)\'\"";
		List<String> resultList = StringUtil.match(html, regex);
	}

	// 获取cookies, 每使用一次与目标网站建立一次连接, 创建一个新的SESSIONID, 慎用
	public static String getCookiesByGet(String url) {
		// 准备返回的参数
		String cookie = "";

		HttpClient httpClient = new HttpClient();

		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		GetMethod postMethod = new GetMethod(url);

		try {
			// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			int statusCode = httpClient.executeMethod(postMethod);
			// 获得登陆后的 Cookie
			Cookie[] cookies = httpClient.getState().getCookies();
			for (Cookie c : cookies) {
				cookie += c.toString() + ";";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cookie;
	}

	//获取html页面
	public static String sendGetWithCookie(String url, String cookie){

		String html = null;
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		getMethod.setRequestHeader("cookie", cookie);
		getMethod.setRequestHeader("Referer", url);
		getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");

		try {
			httpClient.executeMethod(getMethod);
			html = getMethod.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return html;
	}
	
	public static void sendPost() throws IOException {
		String urlStr = "http://cms.pokermanager.club/cms/";
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true); // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
		connection.setDoInput(true); // 设置连接输入流为true
		connection.setRequestMethod("POST"); // 设置请求方式为post
		connection.setUseCaches(false); // post请求缓存设为false
		connection.setInstanceFollowRedirects(true); //// 设置该HttpURLConnection实例是否自动执行重定向
		// 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
		// application/x-javascript text/xml->xml数据 application/x-javascript->json对象
		// application/x-www-form-urlencoded->表单数据
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		connection.connect();

		// // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
		// DataOutputStream dataout = new
		// DataOutputStream(connection.getOutputStream());
		// //TODO
		// String parm = "storeId=" + URLEncoder.encode("32", "utf-8");
		// //URLEncoder.encode()方法 为字符串进行编码
		// dataout.writeBytes(parm);
		// dataout.flush();
		// dataout.close();

		// 处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
		BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuilder sb = new StringBuilder(); // 用来存储响应数据
		// 循环读取流,若不到结尾处
		while ((line = bf.readLine()) != null) {
			sb.append(bf.readLine());
		}
		bf.close(); // 重要且易忽略步骤 (关闭流,切记!)
		connection.disconnect(); // 销毁连接
		System.out.println(sb.toString());

		//
		// HttpPost methodPost = new HttpPost(url.toString());
		//
		// try{
		// //设置参数
		// if(null != paramList && paramList.size() > 0){
		// methodPost.setEntity(new UrlEncodedFormEntity(paramList));
		// }
		// //设置请求头
		// client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/5.0
		// (X11; U; Linux i686; zh-CN; rv:1.9.1.2) Gecko/20090803 Fedora/3.5.2-2.fc11
		// Firefox/3.5.2");
		// HttpResponse response = client.execute(methodPost);
		// HttpEntity entity = response.getEntity();
		// in = entity.getContent();
		// byte[] read = new byte[1024];
		// byte[] all = new byte[0];
		// int num;
		// while ((num = in.read(read)) > 0) {
		// byte[] temp = new byte[all.length + num];
		// System.arraycopy(all, 0, temp, 0, all.length);
		// System.arraycopy(read, 0, temp, all.length, num);
		// all = temp;
		// }
		//
		// resultData = new String(all, "UTF-8");
		// }
	}
}
