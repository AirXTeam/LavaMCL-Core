package xyz.airxdev.lavamcl.Downloader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.IOException;

public class GetPost {
    public static String Get(String url) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet=new HttpGet(url);
            HttpResponse res = httpClient.execute(httpGet);
            String rtn = EntityUtils.toString(res.getEntity());
            return rtn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
