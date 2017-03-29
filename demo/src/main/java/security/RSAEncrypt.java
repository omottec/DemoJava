package security;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import str.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by qinbingbing on 4/19/16.
 */
public class RSAEncrypt {
    private static final String PRIVATE_KEY =
            "";

    public static final String PUBLIC_KEY =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2yF1O45xFOJ9vAziLMC4VRcne\n" +
            "u4ht7vtI5sDffgEjXJE3pIjOkBdsYUothx9lrL3NF1iFmKeTCJ5UZETMF0Jmt4Uc\n" +
            "A1KSeejx9eE0cDcNt8lQSmu7eMICrtkp0VhWiRPaAkPR8g0TAx+hcsCssLW83t5y\n" +
            "AmCHXXfBaZ9SFKufdQIDAQAB";


    /**
     * 私钥
     */
    private RSAPrivateKey privateKey;

    /**
     * 公钥
     */
    private RSAPublicKey publicKey;

    /**
     * 字节数据转字符串专用集合
     */
    private static final char[] HEX_CHAR= {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    /**
     * 获取私钥
     * @return 当前的私钥对象
     */
    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * 获取公钥
     * @return 当前的公钥对象
     */
    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * 随机生成密钥对
     */
    public void genKeyPair(){
        KeyPairGenerator keyPairGen= null;
        try {
            keyPairGen= KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair= keyPairGen.generateKeyPair();
        this.privateKey= (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey= (RSAPublicKey) keyPair.getPublic();
    }

    /**
     * 从文件中输入流中加载公钥
     * @param in 公钥输入流
     * @throws Exception 加载公钥时产生的异常
     */
    public void loadPublicKey(InputStream in) {
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            String readLine= null;
            StringBuilder sb= new StringBuilder();
            while((readLine= br.readLine())!=null){
                if(readLine.charAt(0)=='-'){
                    continue;
                }else{
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPublicKey(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 从字符串中加载公钥
     * @param publicKeyStr 公钥数据字符串
     */
    public void loadPublicKey(String publicKeyStr) {
        try {
            BASE64Decoder base64Decoder= new BASE64Decoder();
            byte[] buffer= base64Decoder.decodeBuffer(publicKeyStr);
            KeyFactory keyFactory= KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);
            this.publicKey= (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中加载私钥
     * @return 是否成功
     * @throws Exception
     */
    public void loadPrivateKey(InputStream in) {
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            String readLine= null;
            StringBuilder sb= new StringBuilder();
            while((readLine= br.readLine())!=null){
                if(readLine.charAt(0)=='-'){
                    continue;
                }else{
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPrivateKey(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void loadPrivateKey(String privateKeyStr) {
        try {
//            BASE64Decoder base64Decoder= new BASE64Decoder();
//            byte[] buffer= base64Decoder.decodeBuffer(privateKeyStr);
//            PKCS8EncodedKeySpec keySpec= new PKCS8EncodedKeySpec(buffer);
//            KeyFactory keyFactory= KeyFactory.getInstance("RSA");
//            this.privateKey= (RSAPrivateKey) keyFactory.generatePrivate(keySpec);

            BASE64Decoder base64Decoder= new BASE64Decoder();
            byte[] buffer= base64Decoder.decodeBuffer(privateKeyStr);
            RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(buffer));
            RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());
            KeyFactory keyFactory= KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(rsaPrivKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密过程
     * @param publicKey 公钥
     * @param plainTextData 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public byte[] encryptWithPublicKey(RSAPublicKey publicKey, byte[] plainTextData) {
        if(publicKey == null){
            throw new IllegalArgumentException("public key can not be empty");
        }
        Cipher cipher= null;
        try {
            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output= cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] encryptWithPrivateKey(RSAPrivateKey privateKey, byte[] plainTextData) {
        if(privateKey == null){
            throw new IllegalArgumentException("private key can not be null");
        }
        Cipher cipher= null;
        try {
//            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher= Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            byte[] output= cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密过程
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public byte[] decryptWithPrivateKey(RSAPrivateKey privateKey, byte[] cipherData) {
        if (privateKey == null){
            throw new IllegalArgumentException("private key can not be null");
        }
        Cipher cipher= null;
        try {
//            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher= Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output= cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decrypt(RSAPublicKey publicKey, byte[] cipherData) {
        if (publicKey == null){
            throw new IllegalArgumentException("public key can not be null");
        }
        Cipher cipher= null;
        try {
//            cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher= Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] output= cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字节数据转十六进制字符串
     * @param data 输入数据
     * @return 十六进制内容
     */
    public static String byteArrayToString(byte[] data){
        StringBuilder stringBuilder= new StringBuilder();
        for (int i=0; i<data.length; i++)
            stringBuilder
                    .append(HEX_CHAR[(data[i] & 0xf0) >>> 4])
                    .append(HEX_CHAR[(data[i] & 0x0f)]);
        return stringBuilder.toString();
    }


    public static void main(String[] args){
        RSAEncrypt rsaEncrypt = new RSAEncrypt();
        //rsaEncrypt.genKeyPair();

        rsaEncrypt.loadPublicKey(RSAEncrypt.PUBLIC_KEY);
//        rsaEncrypt.loadPrivateKey(RSAEncrypt.PRIVATE_KEY);

        String httpDomain = "[{\"domain\":\"api.diditaxi.com\",\"host\":\"10.0.0.1|10.10.0.100\"},{\"domain\":\"dns.didichuxing.com\",\"host\":\"10.231.135.100|10.231.135.101\"},{\"domain\":\"gs.diditaxi.com\",\"host\":\"10.10.0.12|10.10.0.4|10.10.0.5|10.10.0.6\"},{\"domain\":\"pay.diditaxi.com\",\"host\":\"10.10.0.10|10.10.0.11|10.10.0.7|10.10.0.8|10.10.0.9\"}]";
        String dnsDomain = "[{\"domain\":\"push.didichuxing.com\",\"type\":\"online\",\"host\":\"10.9.0.1|10.9.0.2|10.9.1.1|10.9.1.10\"},{\"domain\":\"push.didichuxing.com\",\"type\":\"offline\",\"host\":\"10.9.0.3|10.9.0.4\"}]";
        String md5 = Md5Utils.getMd5(httpDomain + dnsDomain);
        System.out.println(md5);

        /*byte[] cipher = rsaEncrypt.encryptWithPrivateKey(rsaEncrypt.getPrivateKey(), md5.getBytes());
        String sig = new String(cipher);
        System.out.println("sig:" + sig);
        String base64 = Base64Utils.encode(sig);
        System.out.println("base64:" + base64);*/

        byte[] decrypt = rsaEncrypt.decrypt(rsaEncrypt.getPublicKey(), Base64Utils.decodeBytes("aqFttTN5j8JXiG+dV3EvIaEWBUOxvx0tHOLLSfp98Nk/9wDnqi/nIa/NXSWjV9YcdNn1Fa3GJUsxloW1uC4+WReFXu3K8oR9/CMmLmitFA7jB/94K5uLdsxU4TGig1n6J1TqY68M2zmbNHv4sSVJjvjk+K2JdvBwdkwTDtrpka4="));
        String md5Check = new String(decrypt);
        System.out.println(md5Check);
    }

}
