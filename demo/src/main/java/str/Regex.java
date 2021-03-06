package str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 5/17/16.
 */
public class Regex {
    private static final String TOKEN = "([^ \"=]*)";
    private static final String QUOTED_STRING = "\"([^\"]*)\"";
    private static final Pattern PARAMETER
            = Pattern.compile(" +" + TOKEN + "=(:?" + QUOTED_STRING + "|" + TOKEN + ") *(:?,|$)");
    public static final Pattern IPV4 = Pattern.compile("[\\d.]+");

    public static void main(String[] args) {
        testIpv4();
    }

    private static void test() {
        String json = "{\"errno\":0,\"errmsg\":\"\",\"ttl\":600,\"sig\":\"PDW82eIV1T17pI8qW5Wwtohp3OAGcJ9I2U4E2ntivwOnT8myjs0RatRFu6XRz5SGtV3qPEMRlKu6h3FVIMlb9v3q1KSeveQO3jMKHTXoJKEvKGksveZ0lwwyhTtEIABFnhIYtwHSjJe1lQgEcmdb13BFcHZ1ZG0EvnpFMXPKNLw=\",\"httpdomains\":[{\"domain\":\"api.didialift.com\",\"host\":\"api.didialift.com\"},{\"domain\":\"api.diditaxi.com.cn\",\"host\":\"api.diditaxi.com.cn\"},{\"domain\":\"api.udache.com\",\"host\":\"api.udache.com\"},{\"domain\":\"api.weixin.qq.com\",\"host\":\"api.weixin.qq.com\"},{\"domain\":\"apis.map.qq.com\",\"host\":\"apis.map.qq.com\"},{\"domain\":\"common.diditaxi.com.cn\",\"host\":\"common.diditaxi.com.cn\"},{\"domain\":\"conf.diditaxi.com.cn\",\"host\":\"conf.diditaxi.com.cn\"},{\"domain\":\"daijia.kuaidadi.com\",\"host\":\"daijia.kuaidadi.com\"},{\"domain\":\"epassport.diditaxi.com.cn\",\"host\":\"epassport.diditaxi.com.cn\"},{\"domain\":\"httpdns.xiaojukeji.com\",\"host\":\"124.251.93.6|124.251.93.7\"},{\"domain\":\"notice.diditaxi.com.cn\",\"host\":\"notice.diditaxi.com.cn\"},{\"domain\":\"pay.diditaxi.com.cn\",\"host\":\"pay.diditaxi.com.cn\"},{\"domain\":\"smsgw.xiaojukeji.com\",\"host\":\"smsgw.xiaojukeji.com\"}],\"pushDomains\":[{\"domain\":\"gwp.diditaxi.qq.com\",\"type\":\"online\",\"host\":\"gwp.diditaxi.qq.com:25269\"},{\"domain\":\"gwp.diditaxi.qq.com\",\"type\":\"offline\",\"host\":\"gwp.diditaxi.qq.com:25269\"}]}";
        String httpPattern = "\"httpdomains\":(.*?])";
        Matcher matcher = Pattern.compile(httpPattern).matcher(json);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        String sigPattern = "\"sig\":\"(.*?)\"";
        matcher = Pattern.compile(sigPattern).matcher(json);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        String pushPattern = "\"pushDomains\":(.*?])";
        matcher = Pattern.compile(pushPattern).matcher(json);
        System.out.println(matcher.groupCount());
        if (matcher.find())
            System.out.println(matcher.group(1));
    }

    private static void test1() {
        String str = "http://168.0.0.1?psw=111&token=aaa&user=qbb";
//        String str = "http://168.0.0.1?token=aaa&user=qbb";
//        String str = "http://168.0.0.1?psw=111&a3_token=aaa&user=qbb";
        System.out.println(str);
        str = str.replaceAll("&(token=[^&]*)", "&token=123");
        str = str.replaceAll("\\?(token=[^&]*)", "?token=123");
        System.out.println(str);
    }

    private static void testQuotedString() {
        System.out.println("\"aaa\"".matches(QUOTED_STRING));
        System.out.println("\"\"".matches(QUOTED_STRING));
    }

    private static void testToken() {
        System.out.println("".matches(TOKEN));
        System.out.println("a".matches(TOKEN));
        System.out.println("=".matches(TOKEN));
        System.out.println("\"".matches(TOKEN));
        System.out.println(" ".matches(TOKEN));
    }

    private static void testIpv4() {
        System.out.println(IPV4.matcher("172.21.32.10").matches());
    }
}
