package com.bruce.http_learning.httpclient_demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by wuteng1 on 2016/9/27.
 */
public class HttpRequestDemo {
    public static void main(String[] args) {
        testPing();
    }
    @Test
    public static void testPing(){
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //httpclient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        System.out.println(httpGet.getRequestLine());

        try {
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);

            HttpEntity entity = httpResponse.getEntity();
            //response code
            System.out.println("status: " + httpResponse.getStatusLine());
            if(entity != null){
                System.out.println("contentEncoding: " + entity.getContentEncoding());
                System.out.println("reponse content: " + EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
