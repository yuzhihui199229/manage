package com.huayun.cms.utils;

import java.util.Base64;
import java.util.Base64.Decoder;

public class DecodeBasePwd {
    /**
     * @param base64 密文
     * @return 明文
     */
    public static  String getDecode(String cipherData) {
        String re_base64 = new String();
        try {
            /* BASE64加密
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] data = encoder.encode(cipherData.getBytes());
            System.out.println("BASE64加密：" + new String(data));
            // 或者采用以下方法，但是不赞成使用该方法，源码也做了@deprecation标记
            System.out.println("BASE64加密：" + encoder.encodeToString(DATA.getBytes()));
            */
            // BASE64解密
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(cipherData.getBytes());
            re_base64 = bytes.toString();
        } catch (Exception e) {
            System.out.println("BASE64加解密异常");
            e.printStackTrace();
        }
        return re_base64;
    }
}