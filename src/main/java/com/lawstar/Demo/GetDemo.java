package com.lawstar.Demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.lawstar.Pojo.SearchPojo;
import com.lawstar.Utiles.Base64Utiles;

//注意，因为后台记录session，所以请求是必须保持cookie一致，否则会导致正文查询不出来

public class GetDemo {
	
	public static List<Cookie> cookies;
	
	//法规查询
	 public void GetSearch(){
		 BasicCookieStore cookieStore = new BasicCookieStore();
	     CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCookieStore(cookieStore)
	                .build();
	        try {
	        	HttpGet get = new HttpGet("http://202.85.223.137:9098/SearchLaw?param=search");          //这里用上本机的某个工程做测试
	           
	            
	        	get.addHeader("Accept", "*/*");
	        	get.addHeader("Accept-Encoding", "gzip,deflate");
	        	get.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
	        	get.addHeader("Connection", "keep-alive");
	        	get.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	        	get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.72 Safari/537.36");
	        	
	        	get.addHeader("X-Appid", "c8v9b0n6");
	            
	            
	        	SearchPojo searchPojo = new SearchPojo();
	       		searchPojo.setTitle("刑法");
	       	//	searchPojo.setContent("刑法");
	       		searchPojo.setCp(1);
	       		searchPojo.setPagesize(20);
	       		searchPojo.setSsort("imp");
	       		String jsonString = JSON.toJSONString(searchPojo);
	       		//参数加密
	       		String encode = Base64Utiles.encode(jsonString.getBytes());
	    		//参数加密
	    		System.out.println(encode);
	    		//encode="eyJyaWQiOiJjaGwwMDNzMTE0LnR4dCJ9";
	    		
	    		
//	    		get.addHeader("X-CurTime", "");
	    		get.addHeader("X-Param", encode);
	            System.out.println(jsonString);
	            System.out.println("POST 请求...." + get.getURI());
	            //执行请求
	            CloseableHttpResponse httpResponse = httpclient.execute(get);
	            
	            
	            try{
	            	
	            	    cookies = cookieStore.getCookies();
	                   if (cookies.isEmpty()) {
	                       System.out.println("None");
	                   } else {
	                       for (int i = 0; i < cookies.size(); i++) {
	                           System.out.println("- " + cookies.get(i).toString());
	                       }
	                   }
	            	 int statusCode = httpResponse.getStatusLine().getStatusCode();
	                 System.out.println("======================statusCode------------------------:" + statusCode);
	            	Header[] allHeaders = httpResponse.getAllHeaders();
	            	for (int i = 0; i < allHeaders.length; i++) {
						System.out.println(allHeaders[i]);
					}
	            	
	                HttpEntity entity = httpResponse.getEntity();
	                if (null != entity){
	                    System.out.println("----------------1---------------------------------------");
	                     System.out.println("响应内容:" + EntityUtils.toString(entity, "UTF-8"));
	            
	                }else{
	                	
	                	System.out.println("请求失败，请稍后重试");
	                }
	            } finally{
	                httpResponse.close();
	            }
	             
	        } catch( UnsupportedEncodingException e){
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally{
	            try{
	                closeHttpClient(httpclient);                
	            } catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	         
	    }
	 
	 //查看正文
	 public void GetLaw(){
		 BasicCookieStore cookieStore = new BasicCookieStore();
	     CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCookieStore(cookieStore)
	                .build();
	        try {
	        	HttpGet get = new HttpGet("http://202.85.223.137:9098/SearchLaw?param=showLaw");          //这里用上本机的某个工程做测试
	           
	            
	        	get.addHeader("Accept", "*/*");
	        	get.addHeader("Accept-Encoding", "gzip,deflate");
	        	get.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
	        	get.addHeader("Connection", "keep-alive");
	        	get.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	        	get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.72 Safari/537.36");
	        	get.addHeader("Set-Cookie", "JSESSIONID=F9197245C66C200D5274D2C2534AFBD8.tomcat6");
	        	
	        	get.addHeader("X-Appid", "c8v9b0n6");
	            
	           System.out.println("123=="+cookies);
	           
	           
	           for (Cookie cookie : cookies) {
				cookieStore.addCookie(cookie);
			}
	           
	            //base64加密参数
	    		String jsonString = "{\"rid\":\"chl523s587.txt\",\"keyword\":\"刑法\"}";
	    		//参数加密
	    		String encode = Base64Utiles.encode(jsonString.getBytes());
	    		System.out.println(encode);
	    		//encode="eyJyaWQiOiJjaGwwMDNzMTE0LnR4dCJ9";
	    		
	    		
//	    		get.addHeader("X-CurTime", "");
	    		get.addHeader("X-Param", encode);
	            System.out.println(jsonString);
	            System.out.println("POST 请求...." + get.getURI());
	            //执行请求
	            CloseableHttpResponse httpResponse = httpclient.execute(get);
	            
	            
	            try{
	            	 int statusCode = httpResponse.getStatusLine().getStatusCode();
	                 System.out.println("======================statusCode------------------------:" + statusCode);
	            	Header[] allHeaders = httpResponse.getAllHeaders();
	            	for (int i = 0; i < allHeaders.length; i++) {
						System.out.println(allHeaders[i]);
					}
	            	
	                HttpEntity entity = httpResponse.getEntity();
	                if (null != entity){
	                    System.out.println("----------------1---------------------------------------");
	                     System.out.println("响应内容:" + EntityUtils.toString(entity, "UTF-8"));
	            
	                }else{
	                	
	                	System.out.println("请求失败，请稍后重试");
	                }
	            } finally{
	                httpResponse.close();
	            }
	             
	        } catch( UnsupportedEncodingException e){
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally{
	            try{
	                closeHttpClient(httpclient);                
	            } catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	         
	    }
	 
	  private void closeHttpClient(CloseableHttpClient client) throws IOException{
	        if (client != null){
	            client.close();
	        }
	    }
	  
	  public static void main(String[] args) {
		GetDemo getDemo = new GetDemo();
		getDemo.GetSearch();
		getDemo.GetLaw();
	}
}
