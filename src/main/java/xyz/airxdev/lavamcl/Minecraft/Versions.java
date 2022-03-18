package xyz.airxdev.lavamcl.Minecraft;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import xyz.airxdev.lavamcl.Downloader.GetPost;
import xyz.airxdev.lavamcl.Main;
import xyz.airxdev.lavamcl.Tools.B64T;

import java.util.ArrayList;
import java.util.List;

public class Versions {
    //public static String
    public static String Type_Release = "release";
    public static String Type_Snapshot = "snapshot";
    public static String Type_Old_Alpha = "old_alpha";
    public static String Type_Old_Beta = "old_beta";
    public static String GetVersionList(String Type){
        String AD = GetPost.Get(Main.DownloadServer[0]);
        JSONObject JS = new JSONObject();
        List lt = new ArrayList<>();
        try{
            JS = JSONObject.parseObject(AD);
            JSONArray version = (JSONArray) JS.get("versions");
            String ReString = "";
            ReString = ReString + "#FINISH\n";
            for (int i = 0; i < version.size(); i++) {
                JSONObject tjb = version.getJSONObject(i);
                String id = tjb.getString("id");
                String type = tjb.getString("type");
                String url = tjb.getString("url");
                String time = tjb.getString("time");
                String releaseTime = tjb.getString("releaseTime");
                if(type.equals(Type)){
                    String tempadd = id + "$" +
                            type + "$" + B64T.Encode(url) + "$" +
                            time + "$" + releaseTime;
                    ReString = ReString + tempadd + "\n";
                }

            }
            ReString = ReString + "#END";

            return ReString;
        }catch (Exception ex){
            ex.printStackTrace();
            return "#ERROR\n" + B64T.Encode(ex.toString()) +
                    "\n" + "#END";

        }
    }
}
