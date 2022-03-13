package xyz.airxdev.lavamcl;

import xyz.airxdev.lavamcl.Tools.B64T;
import xyz.airxdev.lavamcl.Tools.HashT;
import xyz.airxdev.lavamcl.Tools.UuidT;
import xyz.airxdev.lavamcl.DSApi.MoJang;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    public static Logger Log = Logger.getLogger("Main");
    public static boolean SafeMode = false;
    public static String ConfigFile = "LMCLConfig.json";
    //代理相关功能
    public static boolean UseHttpProxy = false;
    public static String Py_HttpHost = "127.0.0.1";
    public static String Py_HttpPort = "80";
    public static String Py_HttpUserName = "root";
    public static String Py_HttpPassWord = "root";

    public static boolean UseHttpsProxy = false;
    public static String Py_HttpsHost = "127.0.0.1";
    public static String Py_HttpsPort = "80";
    public static String Py_HttpsUserName = "root";
    public static String Py_HttpsPassWord = "root";

    public static boolean UseSocksProxy = false;
    public static String Py_SocksHost = "127.0.0.1";
    public static String Py_SocksPort = "80";
    public static String Py_SocksUserName = "root";
    public static String Py_SocksPassWord = "root";

    public static String[] DownloadServer = MoJang.Config;

    public static void main(String[] args) {
        for(String T_Str : args){
            if(T_Str.equals("--safe-mode")){
                SafeMode = true;
            }
            if(T_Str.equals("--config")){
                ConfigFile = B64T.Decode(args[Arrays.binarySearch(args,"--config") + 1]);
            }
            if(T_Str.equals("--use-proxy-http")){
                try {
                    UseHttpProxy = true;
                    String ProxyData = B64T.Decode(args[Arrays.binarySearch(args, "--use-proxy-http") + 1]);
                    String DeB64PD = B64T.Decode(ProxyData);
                    String[] PDx = DeB64PD.split("\n");
                    Py_HttpHost = PDx[0];
                    Py_HttpPort = PDx[1];
                    Py_HttpUserName = PDx[2];
                    Py_HttpPassWord = PDx[3];
                    System.setProperty("proxySet", "true");
                    System.setProperty("http.proxyHost", Py_HttpHost);
                    System.setProperty("http.proxyPort", Py_HttpPort);
                    System.setProperty("http.proxyUser", Py_HttpUserName);
                    System.setProperty("http.proxyPassword", Py_HttpPassWord);
                }catch (Exception ex){
                    UseHttpProxy = false;
                    ex.printStackTrace();
                }
            }
            if(T_Str.equals("--use-proxy-https")){
                try {
                    UseHttpsProxy = true;
                    String ProxyData = B64T.Decode(args[Arrays.binarySearch(args, "--use-proxy-https") + 1]);
                    String DeB64PD = B64T.Decode(ProxyData);
                    String[] PDx = DeB64PD.split("\n");
                    Py_HttpsHost = PDx[0];
                    Py_HttpsPort = PDx[1];
                    Py_HttpsUserName = PDx[2];
                    Py_HttpsPassWord = PDx[3];
                    System.setProperty("proxySet", "true");
                    System.setProperty("https.proxyHost", Py_HttpsHost);
                    System.setProperty("https.proxyPort", Py_HttpsPort);
                    System.setProperty("https.proxyUser", Py_HttpsUserName);
                    System.setProperty("https.proxyPassword", Py_HttpsPassWord);
                }catch (Exception ex){
                    UseHttpsProxy = false;
                    ex.printStackTrace();
                }
            }
            if(T_Str.equals("--use-proxy-socks")){
                try {
                    UseSocksProxy = true;
                    String ProxyData = B64T.Decode(args[Arrays.binarySearch(args, "--use-proxy-socks") + 1]);
                    String DeB64PD = B64T.Decode(ProxyData);
                    String[] PDx = DeB64PD.split("\n");
                    Py_SocksHost = PDx[0];
                    Py_SocksPort = PDx[1];
                    Py_SocksUserName = PDx[2];
                    Py_SocksPassWord = PDx[3];
                    System.setProperty("proxySet", "true");
                    System.setProperty("socksProxyHost", Py_SocksHost);
                    System.setProperty("socksProxyPort", Py_SocksPort);
                    System.setProperty("socksProxyUser", Py_SocksUserName);
                    System.setProperty("socksProxyPassword", Py_SocksPassWord);
                }catch (Exception ex){
                    UseHttpsProxy = false;
                    ex.printStackTrace();
                }
            }

            StartLoader.Start();





        }
        //System.out.println(SafeMode);
        //System.out.println(ConfigFile);
        //System.out.println(B64T.Encode("test")); //测试Base64是否正常
        //System.out.println(B64T.Decode("dGVzdA=="));
    }

}
