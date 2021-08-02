package com.huayun.cms.utils;


import java.util.Base64;

public class DecodeBasePwd {
    /**
     * @param cipherData ??
     * @return ??
     */
    public static  String getDecodeBasePwd(String cipherData) {
        String re_base64 = new String();
        try {
            /* BASE64??
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] data = encoder.encode(cipherData.getBytes());
            System.out.println("BASE64???" + new String(data));
            // ?????????????????????????@deprecation??
            System.out.println("BASE64???" + encoder.encodeToString(DATA.getBytes()));
            */
            // BASE64??
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(cipherData.getBytes());
            re_base64 = new String(bytes);
        } catch (Exception e) {
            System.out.println("BASE64?????");
            e.printStackTrace();
        }
        return re_base64;
    }
}