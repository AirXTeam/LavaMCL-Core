package xyz.airxdev.lavamcl;

import org.json.JSONObject;
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
    public static OutputStream CFw;
    public static InputStream CFr;
    //public static JSONObject JB = new JSONObject();
    public static Properties Pro = new Properties();
    public static void Start(){

        try {
            CFw = new FileOutputStream(CF);
            CFr = new FileInputStream(CF);
            if(!CF.exists()){
                if(CF.isDirectory()){
                    CF.delete();
                }
                CF.createNewFile();
            }
            Pro.load(CFr);
            String C_DS = Pro.getProperty("Download.Server");
            if(C_DS == null){
                Pro.setProperty("Download.Server","Mojang");
                C_DS = Pro.getProperty("Download.Server");
            }
            if(C_DS.equals("Mojang")){
                Main.DownloadServer = MoJang.Config;
            }else if(C_DS.equals("MCBBS")){
                Main.DownloadServer = MCBBS.Config;
            }else if(C_DS.equals("BMCLAPI")){
                Main.DownloadServer = BMCLAPI.Config;
            }else{
                Main.DownloadServer = MoJang.Config;
            }

            System.out.println(Versions.GetVersionList(""));
        } catch (IOException e) {
            e.printStackTrace();
            exit(1);
        }
    }

    public static boolean Save(){
        try {
            Pro.store(CFw,"Data");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
