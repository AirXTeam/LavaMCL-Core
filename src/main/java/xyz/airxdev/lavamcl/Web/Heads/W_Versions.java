package xyz.airxdev.lavamcl.Web.Heads;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import xyz.airxdev.lavamcl.Minecraft.Versions;
import xyz.airxdev.lavamcl.Web.Errors;

import java.io.IOException;
import java.io.OutputStream;

public class W_Versions implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String ReStr = "";
        String response = exchange.getRequestURI().getPath();
        if(response.equals("/Versions/" + Versions.Type_Release)){
            ReStr = Versions.GetVersionList(Versions.Type_Release);
        }else if(response.equals("/Versions/" + Versions.Type_Snapshot)){
            ReStr = Versions.GetVersionList(Versions.Type_Snapshot);
        }else if(response.equals("/Versions/" + Versions.Type_Old_Alpha)){
            ReStr = Versions.GetVersionList(Versions.Type_Old_Alpha);
        }else if(response.equals("/Versions/" + Versions.Type_Old_Beta)){
            ReStr = Versions.GetVersionList(Versions.Type_Old_Beta);
        }else if(response.equals("/Versions/" + "all")){
            ReStr = Versions.GetVersionList_All();
        }else {
            ReStr = Errors.NotFoundError();
        }
            exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        os.write(ReStr.getBytes("UTF-8"));
        os.close();
    }
}
