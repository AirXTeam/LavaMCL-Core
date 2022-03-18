package xyz.airxdev.lavamcl.Web;

import com.sun.net.httpserver.HttpServer;
import xyz.airxdev.lavamcl.Main;
import xyz.airxdev.lavamcl.Web.Heads.W_Versions;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HTTPServer {
    public HttpServer HS;
    public boolean InitWebServer(){
        try{
            HS = HttpServer.create(new InetSocketAddress(Main.Web_Host,Main.Web_Port), 0);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean BuildWebServer(){
        try{
            //HS = HttpServer.create(new InetSocketAddress(Main.Web_Host,Main.Web_Port), 0);
            HS.createContext("/Versions",new W_Versions());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean StartWebServer(){
        try{
            //HS = HttpServer.create(new InetSocketAddress(Main.Web_Host,Main.Web_Port), 0);
            //HS.createContext("/Versions",new W_Versions());
            HS.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
