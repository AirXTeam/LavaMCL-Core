package xyz.airxdev.lavamcl;

import com.alibaba.fastjson.JSONObject;
import org.yaml.snakeyaml.Yaml;
import xyz.airxdev.lavamcl.DSApi.BMCLAPI;
import xyz.airxdev.lavamcl.DSApi.MCBBS;
import xyz.airxdev.lavamcl.DSApi.MoJang;
import xyz.airxdev.lavamcl.Minecraft.Versions;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import static java.lang.System.exit;

public class StartLoader {
    public static File CF = new File(Main.ConfigFile);
    public static RandomAccessFile CFw;
    public static FileInputStream CFr;
    public static JSONObject JB = new JSONObject();
    //public static Properties Pro = new Properties();
    public static void Start(){
        try {
            String C_DS = "";
            if(!CF.exists()){
                if(CF.isDirectory()){
                    CF.delete();
                }
                CF.createNewFile();
            }
            /*CFw = new FileOutputStream(CF);*/
            CFr = new FileInputStream(CF);
            //CFw = new FileOutputStream(CF);
            CFw = new RandomAccessFile(CF, "rw");
            byte[] readtemp = {};
            //System.out.println(CF.getPath());
            readtemp = CFr.readAllBytes();
            /*System.out.println();
            System.out.println(readtemp.length);*/
            JB = JSONObject.parseObject(new String(readtemp));
            System.out.println(JSONObject.toJSONString(JB));
            if(JB != null){
                JB.put("DownloadServer","Mojang");
                Save();
                C_DS = JB.getString("DownloadServer");
            }else{
                C_DS = "Mojang";
            }

            /*
            Pro.load(CFr);
            String C_DS = Pro.getProperty("Download.Server");
            if(C_DS == null){
                Pro.setProperty("Download.Server","Mojang");
                C_DS = Pro.getProperty("Download.Server");
            }*/
            if(C_DS.equals("Mojang")){
                Main.DownloadServer = MoJang.Config;
            }else if(C_DS.equals("MCBBS")){
                Main.DownloadServer = MCBBS.Config;
            }else if(C_DS.equals("BMCLAPI")){
                Main.DownloadServer = BMCLAPI.Config;
            }else{
                Main.DownloadServer = MoJang.Config;
            }

            //String DT = Versions.GetVersionList(Versions.Type_Release);
            System.out.println("DT");

        } catch (IOException e) {
            e.printStackTrace();
            exit(1);
        }
    }

    public static boolean Save(){
        try {
            CFw.write(JSONObject.toJSONString(JB).getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
