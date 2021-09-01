package com.xxt.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author xk
 * @since 2021.08.09 15:33
 */
public class Testaa {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //String sq = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,16}$";
        String PW_PATTERN = "^(?![A-Za-z]+$)(?![A-Z\\d]+$)(?![A-Z\\W]+$)(?![a-z\\d]+$)(?![a-z\\W]+$)(?![\\d\\W]+$)\\S{8,}$";
        String s = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}";
        String password = "#Adssfsdf1ddga";
        if(password.matches(pattern)){
            System.out.println("-----y---");
        } else{
            System.out.println("-------n----");
        }
        byte[] encode = Base64.getEncoder().encode("123456".getBytes(StandardCharsets.UTF_8));
        String encodedPassword = new String(encode);//"MTIzNDU2\\n";//
        byte[] decodeBytes = null;
        /*try{
            decodeBytes = Base64.getDecoder().decode(encodedPassword);
        }catch (Exception e){
            //log.error("第一次解密失败..");
            System.out.println("第一次解密失败..");
            try{
                decodeBytes = Base64.getDecoder().decode(encodedPassword.replace("\\n",""));
            }catch (Exception e1){
                //log.error("第二次解密失败..");
                System.out.println("第二次解密失败..");
            }
        }*/

        try{
            decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodedPassword);
        }catch (Exception e){
            //log.error("第一次解密失败..");
            System.out.println("第一次解密失败..");
            try{
                decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodedPassword.replace("\\n",""));
            }catch (Exception e1){
                //log.error("第二次解密失败..");
                System.out.println("第二次解密失败..");
            }
        }

        String originalPassword = new String(decodeBytes,"utf-8");
        System.out.println(originalPassword);

        JSONObject jsonObject = JSON.parseObject("{}");
        System.out.println(jsonObject.size());
    }
}
