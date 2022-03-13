package xyz.airxdev.lavamcl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import xyz.airxdev.lavamcl.DSApi.BMCLAPI;
import xyz.airxdev.lavamcl.DSApi.MCBBS;
import xyz.airxdev.lavamcl.DSApi.MoJang;

import java.io.*;

public class StartLoader {
    public static File CF = new File(Main.ConfigFile);
    public static OutputStream CFw;
    public static InputStream CFr;
    public static JSONObject JB = new JSONObject();
    public static void Start(){
        try {
            if(!CF.exists()){
                if(CF.isDirectory()){
                    CF.delete();
                }
                CF.createNewFile();
            }
            CFw = new FileOutputStream(CF);
            CFr = new FileInputStream(CF);
            JB = JSON.parseObject(CFr.readAllBytes().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String C_DS = JB.getString("DownloadServer");
        if(C_DS.equals("Mojang")){
            Main.DownloadServer = MoJang.Config;
        }else if(C_DS.equals("MCBBS")){
            Main.DownloadServer = MCBBS.Config;
        }else if(C_DS.equals("BMCLAPI")){
            Main.DownloadServer = BMCLAPI.Config;
        }else{
            Main.DownloadServer = MoJang.Config;
        }


    }

    public static boolean Save(){
        try {
            CFw.write(JSON.toJSONString(JB).getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
