package Interface.com.service;

import Interface.com.contrl.MyHttpDelete;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SentRequest {
    /*
    * 做get请求
    * */
    public static String doGet(String url) throws Exception{
        String respContent = null;
        HttpGet httpGet = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() == 200){
            HttpEntity he = httpResponse.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        System.out.println(respContent);
        return String.valueOf(httpResponse.getStatusLine().getStatusCode());
    }


    /*
    * 做post请求
    * */
    public static String doPost(String url, String jsonParam) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = "返回结果空";

        StringEntity entity = new StringEntity(jsonParam,"UTF-8");
//      解决乱码问题
//        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        HttpResponse resp = client.execute(httpPost);

        if (resp.getStatusLine().getStatusCode() == 200){
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }else {
            System.out.println(url);
            System.out.println(jsonParam);
        }

        System.out.println(respContent);
        return String.valueOf(resp.getStatusLine().getStatusCode());
    }

    /*
     * 做delete请求
     * */
    public static String doDelete(String url,String api,String param, String jsonParam) throws Exception {

        String respContent = "";
        url = url + api + param;
        HttpDelete httpDelete = new HttpDelete(url);

        httpDelete.setHeader("Content-Type","application/json");

        HttpResponse httpResponse = new DefaultHttpClient().execute(httpDelete);
        if (jsonParam == ""){

            if (httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity he = httpResponse.getEntity();
                respContent = EntityUtils.toString(he,"UTF-8");
            }

        }else {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            MyHttpDelete delete = new MyHttpDelete(url);
            StringEntity entity = new StringEntity(jsonParam,"utf-8");

//            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            delete.setEntity(entity);
            HttpResponse response = httpClient.execute(delete);


            if (response.getStatusLine().getStatusCode() == 200){
                HttpEntity he = response.getEntity();
                respContent = EntityUtils.toString(he,"UTF-8");
            }

        }


        System.out.println(respContent);
        return String.valueOf(httpResponse.getStatusLine().getStatusCode());

    }



     /*
     * 做path请求
     * */
    public static String doPatch(String url, String jsonParam) throws IOException {
        HttpPatch httpPatch = new HttpPatch(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        StringEntity entity = new StringEntity(jsonParam,"utf-8");
//      解决乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPatch.setEntity(entity);

        HttpResponse resp = client.execute(httpPatch);
        if (resp.getStatusLine().getStatusCode() == 200){
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        System.out.println(respContent);
        return String.valueOf(resp.getStatusLine().getStatusCode());

    }
}
