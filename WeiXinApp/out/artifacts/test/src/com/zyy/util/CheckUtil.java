package com.zyy.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class CheckUtil {

    public static final String token = "zyyzuishuai001";

    public static boolean checkSignature(String signature,String timestamp, String nonce){
        //定义数组存放token,timestamp,nonce
        String[] arr = {token, timestamp, nonce};
        //对数组进行排序
        Arrays.sort(arr);
        //生成字符串
        StringBuffer sb = new StringBuffer();
        for(String s :arr){
            sb.append(s);
        }
        //sha1加密
        String temp = getSha1(sb.toString());
        //将加密后的字符串与微信传来的字符串对比
        return temp.equals(signature);
    }

    public static String getSha1(String str){
        if(str == null || str.length() == 0){
            return null;
        }

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'a', 'b', 'c', 'd', 'e', 'f'};

        try{
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int i = md.length;
            char buf[] = new char[i * 2];
            int k = 0;
            for(int j = 0; j < i; j++){
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(buf);

        }catch (Exception ex){
            return null;
        }
    }
}
