package sec;

import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.Base64;

/**
 * Created by qinbingbing on 4/19/16.
 */
public class Base64Utils {
    public static String encode(String src) {
        byte[] bytes = Base64.getEncoder().encode(src.getBytes());
        return new String(bytes);
    }

    public static String decode(String encrypted) {
        byte[] bytes = Base64.getDecoder().decode(encrypted.getBytes());
        return new String(bytes);
    }

    public static byte[] decodeBytes(String encrypted) {
        return Base64.getDecoder().decode(encrypted.getBytes());
    }

    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        str = encode(str);
        System.out.println("encode:" + str);
        str = decode(str);
        System.out.println("decode:" + str);
    }
}