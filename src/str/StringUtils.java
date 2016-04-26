package str;

/**
 * Created by qinbingbing on 4/19/16.
 */
public class StringUtils {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static final String bytesToHexStr(byte[] bytes){
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes)
            sb.append(hexChars[b >>> 4 & 0xf]).append(hexChars[b & 0xf]);
        return sb.toString();
    }

    public static final byte[] hexStrToBytes(String s)  {
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++)
            bytes[i] = (byte) Integer.parseInt(s.substring(2*i, 2*(i+1)), 16);
        return bytes;
    }

    public static String str2Hex(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char ch : chars)
            sb.append(Integer.toHexString(ch));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(str2Hex(ALPHABET));
    }
}
