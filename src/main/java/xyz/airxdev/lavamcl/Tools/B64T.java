package xyz.airxdev.lavamcl.Tools;

import java.util.Base64;

public class B64T {
    /**
     * Java8中的Base64编码
     * @param str
     * @return
     */
    public static String Encode(String str) {
        try {
            return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Java8中的Base64解码
     * @param str
     * @return
     */
    public static String Decode(String str) {
        byte[] result = Base64.getDecoder().decode(str.getBytes());
        return new String(result);
    }
}
