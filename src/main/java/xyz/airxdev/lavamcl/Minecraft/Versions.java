package xyz.airxdev.lavamcl.Minecraft;


import com.alibaba.fastjson.JSONObject;
import xyz.airxdev.lavamcl.Downloader.GetPost;
import xyz.airxdev.lavamcl.Main;
import xyz.airxdev.lavamcl.Tools.B64T;

public class Versions {
    //public static String
    public static String Type_Release = "release";
    public static String Type_Snapshot = "snapshot";
    public static String Type_Old_Alpha = "old_alpha";
    public static String Type_Old_Beta = "old_beta";
    public static String GetVersionList(String Type){
        String AD = GetPost.Get(Main.DownloadServer[0]);
        JSONObject JS = new JSONObject();
        try{
            return "";
        }catch (Exception ex){
            return "ERROR\n" + B64T.Encode(ex.toString());
        }
    }
}
