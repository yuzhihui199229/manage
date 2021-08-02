package com.huayun.cms.utils;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Base64.Encoder;

public class EncodeBasePwd {
    /**
     * @param base64 明文
     * @return 密文
     */
    public static  String getEecode(String obviousData) {
        String re_base64 = new String();
        try {
            //BASE64加密
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] data = encoder.encode(obviousData.getBytes());
            System.out.println("BASE64加密：" + new String(data));
            re_base64 =  new String(data);
        } catch (Exception e) {
            System.out.println("BASE64加解密异常");
            e.printStackTrace();
        }
        return re_base64;
    }
}