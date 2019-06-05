package com.lawstar.Utiles;  
  
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;  
  
  
  
public class Base64Utiles {  
      
	//加密
	
    public static String encode(byte[] binaryData) throws UnsupportedEncodingException {  
        return new String(Base64.encodeBase64(binaryData), "UTF-8");  
    }  
      
    //解密
    public static byte[] decode(String base64String) throws UnsupportedEncodingException {  
        return Base64.decodeBase64(base64String.getBytes("UTF-8"));  
    }  
      
      
    public static void main(String[] args) throws UnsupportedEncodingException {  
        String param = "{\"title\":\"刑法\",\"cp\":1,\"pagesize\":20,\"ssort\":\"imp\"}";  
        String data ="eyJyaWQiOiJjaGw1MjNzNTg3LnR4dCIsImtleXdvcmQiOiLliJHms5UifQ==";     
        System.out.println("加密后："+Base64Utiles.encode(param.getBytes()));       
               
        byte[] byteArray = Base64Utiles.decode(data);  
        System.out.println("解密后："+new String(byteArray));    
    }  
  
  
}  