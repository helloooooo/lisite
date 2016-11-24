package com.bruce.http_learning.httpclient_demo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuteng1 on 2016/9/27.
 */
public class HttpRequestClient {
    private CloseableHttpClient httpClient;
    private PoolingHttpClientConnectionManager cm;

    public HttpRequestClient() {
        cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultMaxPerRoute(50);
        cm.setMaxTotal(500);

        RequestConfig config = RequestConfig.custom().setConnectTimeout(100).setSocketTimeout(800).setConnectionRequestTimeout(500).build();
        httpClient = HttpClientBuilder.create().setConnectionManager(cm).setDefaultRequestConfig(config).build();


    }

    public static void main(String[] args) {

    }

    public void doHttpRequest(){
        String url = "";
        Student student = new Student("bruce", "boy");
        Gson gson = new Gson();
        String json = gson.toJson(student);

        HttpPost post = new HttpPost(url);
        StringEntity body = new StringEntity(json, ContentType.APPLICATION_JSON);
        post.setEntity(body);

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity resultEntity = response.getEntity();

            String r = "";
            if(resultEntity != null){
                r = EntityUtils.toString(resultEntity);
            }
            if(statusCode == HttpStatus.SC_OK){
                System.out.println("json returned: " + r);
            }
            else{
                System.out.println("return wrong result.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response != null){
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testParse(){
        String s = "{\"status\":1,\"msg\":\"success!\",\"data\":{\"778938\":{\"id\":\"778938\",\"commodityId\":\"0\",\"title\":\"\\u624b\\u673a\\u901a\\u8baf\",\"picUrl\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3280\\/226\\/3076622579\\/42409\\/a50d00ff\\/57eb9210Na06bf6a0.jpg\",\"picUrl80\":\"\\/\\/img14.360buyimg.com\\/cms\\/jfs\\/t3106\\/213\\/3042993627\\/42409\\/a50d00ff\\/57eb9211N002eb851.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141210\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"724784\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/FbrGCxElUv.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"1\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"724784\\\",\\\"title\\\":\\\"\\\\u624b\\\\u673a\\\\u901a\\\\u8baf\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/FbrGCxElUv.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3280\\\\\\/226\\\\\\/3076622579\\\\\\/42409\\\\\\/a50d00ff\\\\\\/57eb9210Na06bf6a0.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3106\\\\\\/213\\\\\\/3042993627\\\\\\/42409\\\\\\/a50d00ff\\\\\\/57eb9211N002eb851.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"724784\\\",\\\"title\\\":\\\"\\\\u624b\\\\u673a\\\\u901a\\\\u8baf\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/FbrGCxElUv.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3280\\\\\\/226\\\\\\/3076622579\\\\\\/42409\\\\\\/a50d00ff\\\\\\/57eb9210Na06bf6a0.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3106\\\\\\/213\\\\\\/3042993627\\\\\\/42409\\\\\\/a50d00ff\\\\\\/57eb9211N002eb851.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"1\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778939\":{\"id\":\"778939\",\"commodityId\":\"0\",\"title\":\"\\u7535\\u8111\",\"picUrl\":\"\\/\\/img13.360buyimg.com\\/cms\\/jfs\\/t3088\\/244\\/3095761737\\/17777\\/82be02f4\\/57eb9212Nc9231caa.jpg\",\"picUrl80\":\"\\/\\/img14.360buyimg.com\\/cms\\/jfs\\/t3118\\/186\\/3072833141\\/17777\\/82be02f4\\/57eb9212Nca32ee49.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141213\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"711324\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/RA0XqLIBeUf3b.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"1\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"711324\\\",\\\"title\\\":\\\"\\\\u7535\\\\u8111\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/RA0XqLIBeUf3b.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3088\\\\\\/244\\\\\\/3095761737\\\\\\/17777\\\\\\/82be02f4\\\\\\/57eb9212Nc9231caa.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3118\\\\\\/186\\\\\\/3072833141\\\\\\/17777\\\\\\/82be02f4\\\\\\/57eb9212Nca32ee49.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"711324\\\",\\\"title\\\":\\\"\\\\u7535\\\\u8111\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/RA0XqLIBeUf3b.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3088\\\\\\/244\\\\\\/3095761737\\\\\\/17777\\\\\\/82be02f4\\\\\\/57eb9212Nc9231caa.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3118\\\\\\/186\\\\\\/3072833141\\\\\\/17777\\\\\\/82be02f4\\\\\\/57eb9212Nca32ee49.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"2\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778940\":{\"id\":\"778940\",\"commodityId\":\"0\",\"title\":\"\\u6570\\u7801\",\"picUrl\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3118\\/180\\/3058364600\\/18734\\/b742b569\\/57eb9213N5124abf9.jpg\",\"picUrl80\":\"\\/\\/img14.360buyimg.com\\/cms\\/jfs\\/t3088\\/232\\/3114489953\\/17777\\/82be02f4\\/57eb9214Nf891ec7e.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141218\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"746099\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/jnwbQOKIaoW.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"1\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"746099\\\",\\\"title\\\":\\\"\\\\u6570\\\\u7801\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/jnwbQOKIaoW.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3118\\\\\\/180\\\\\\/3058364600\\\\\\/18734\\\\\\/b742b569\\\\\\/57eb9213N5124abf9.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3088\\\\\\/232\\\\\\/3114489953\\\\\\/17777\\\\\\/82be02f4\\\\\\/57eb9214Nf891ec7e.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"746099\\\",\\\"title\\\":\\\"\\\\u6570\\\\u7801\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/jnwbQOKIaoW.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3118\\\\\\/180\\\\\\/3058364600\\\\\\/18734\\\\\\/b742b569\\\\\\/57eb9213N5124abf9.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3088\\\\\\/232\\\\\\/3114489953\\\\\\/17777\\\\\\/82be02f4\\\\\\/57eb9214Nf891ec7e.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"3\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778941\":{\"id\":\"778941\",\"commodityId\":\"0\",\"title\":\"\\u56fe\\u4e66\",\"picUrl\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3115\\/274\\/3132463236\\/17859\\/e929c676\\/57eb9214N0eb9c895.jpg\",\"picUrl80\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3271\\/111\\/3092610957\\/17859\\/e929c676\\/57eb9214Nff0ffe1b.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141220\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"338806\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/Zn28vOXewkF5N.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"1\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"338806\\\",\\\"title\\\":\\\"\\\\u56fe\\\\u4e66\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/Zn28vOXewkF5N.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3115\\\\\\/274\\\\\\/3132463236\\\\\\/17859\\\\\\/e929c676\\\\\\/57eb9214N0eb9c895.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3271\\\\\\/111\\\\\\/3092610957\\\\\\/17859\\\\\\/e929c676\\\\\\/57eb9214Nff0ffe1b.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"338806\\\",\\\"title\\\":\\\"\\\\u56fe\\\\u4e66\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/Zn28vOXewkF5N.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3115\\\\\\/274\\\\\\/3132463236\\\\\\/17859\\\\\\/e929c676\\\\\\/57eb9214N0eb9c895.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3271\\\\\\/111\\\\\\/3092610957\\\\\\/17859\\\\\\/e929c676\\\\\\/57eb9214Nff0ffe1b.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"4\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778942\":{\"id\":\"778942\",\"commodityId\":\"0\",\"title\":\"\\u751f\\u9c9c\",\"picUrl\":\"\\/\\/img11.360buyimg.com\\/cms\\/jfs\\/t3277\\/191\\/3073323410\\/39975\\/a1b1593\\/57eb9216N2cad3621.jpg\",\"picUrl80\":\"\\/\\/img13.360buyimg.com\\/cms\\/jfs\\/t3301\\/199\\/3126433246\\/39975\\/a1b1593\\/57eb9216Nd7b7c443.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141222\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"718842\",\"url\":\"https:\\/\\/sale.jd.com\\/act\\/jAIlUHXyCg.html?cpdad=1DLSUE\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"1\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"718842\\\",\\\"title\\\":\\\"\\\\u751f\\\\u9c9c\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/jAIlUHXyCg.html?cpdad=1DLSUE\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3277\\\\\\/191\\\\\\/3073323410\\\\\\/39975\\\\\\/a1b1593\\\\\\/57eb9216N2cad3621.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3301\\\\\\/199\\\\\\/3126433246\\\\\\/39975\\\\\\/a1b1593\\\\\\/57eb9216Nd7b7c443.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"718842\\\",\\\"title\\\":\\\"\\\\u751f\\\\u9c9c\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/jAIlUHXyCg.html?cpdad=1DLSUE\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3277\\\\\\/191\\\\\\/3073323410\\\\\\/39975\\\\\\/a1b1593\\\\\\/57eb9216N2cad3621.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3301\\\\\\/199\\\\\\/3126433246\\\\\\/39975\\\\\\/a1b1593\\\\\\/57eb9216Nd7b7c443.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"5\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778943\":{\"id\":\"778943\",\"commodityId\":\"0\",\"title\":\"\\u9c9c\\u8089\",\"picUrl\":\"\\/\\/img14.360buyimg.com\\/cms\\/jfs\\/t3202\\/82\\/3064576095\\/18008\\/899498bb\\/57eb9216Ncba35041.jpg\",\"picUrl80\":\"\\/\\/img14.360buyimg.com\\/cms\\/jfs\\/t3097\\/98\\/3029882013\\/18008\\/899498bb\\/57eb9217N96e6f382.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141224\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"740215\",\"url\":\"https:\\/\\/sale.jd.com\\/act\\/JC3PLlMmVh8poDf5.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"1\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"740215\\\",\\\"title\\\":\\\"\\\\u9c9c\\\\u8089\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/JC3PLlMmVh8poDf5.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3202\\\\\\/82\\\\\\/3064576095\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9216Ncba35041.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3097\\\\\\/98\\\\\\/3029882013\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9217N96e6f382.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"740215\\\",\\\"title\\\":\\\"\\\\u9c9c\\\\u8089\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/JC3PLlMmVh8poDf5.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3202\\\\\\/82\\\\\\/3064576095\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9216Ncba35041.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3097\\\\\\/98\\\\\\/3029882013\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9217N96e6f382.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"6\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778944\":{\"id\":\"778944\",\"commodityId\":\"0\",\"title\":\"\\u6d77\\u9c9c\",\"picUrl\":\"\\/\\/img11.360buyimg.com\\/cms\\/jfs\\/t3079\\/345\\/3073722020\\/18008\\/899498bb\\/57eb9d2dN0cb76b48.jpg\",\"picUrl80\":\"\\/\\/img11.360buyimg.com\\/cms\\/jfs\\/t3190\\/126\\/3087212898\\/18008\\/899498bb\\/57eb9d2dNae4ccb97.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141227\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"641127\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/IFR3oBPSWut.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"745\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"641127\\\",\\\"title\\\":\\\"\\\\u6d77\\\\u9c9c\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/IFR3oBPSWut.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3079\\\\\\/345\\\\\\/3073722020\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9d2dN0cb76b48.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3190\\\\\\/126\\\\\\/3087212898\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9d2dNae4ccb97.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"641127\\\",\\\"title\\\":\\\"\\\\u6d77\\\\u9c9c\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/IFR3oBPSWut.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3079\\\\\\/345\\\\\\/3073722020\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9d2dN0cb76b48.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3190\\\\\\/126\\\\\\/3087212898\\\\\\/18008\\\\\\/899498bb\\\\\\/57eb9d2dNae4ccb97.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"7\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778945\":{\"id\":\"778945\",\"commodityId\":\"0\",\"title\":\"\\u7f8e\\u98df\",\"picUrl\":\"\\/\\/img13.360buyimg.com\\/cms\\/jfs\\/t3046\\/193\\/3020257639\\/22588\\/6ea9b25e\\/57eb9d6dN626d42bd.jpg\",\"picUrl80\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3193\\/27\\/3106848273\\/22588\\/6ea9b25e\\/57eb9d6eN8461464e.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141229\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"740747\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/L72jGfCQ01JMHd.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"745\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"740747\\\",\\\"title\\\":\\\"\\\\u7f8e\\\\u98df\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/L72jGfCQ01JMHd.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3046\\\\\\/193\\\\\\/3020257639\\\\\\/22588\\\\\\/6ea9b25e\\\\\\/57eb9d6dN626d42bd.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3193\\\\\\/27\\\\\\/3106848273\\\\\\/22588\\\\\\/6ea9b25e\\\\\\/57eb9d6eN8461464e.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"740747\\\",\\\"title\\\":\\\"\\\\u7f8e\\\\u98df\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/L72jGfCQ01JMHd.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3046\\\\\\/193\\\\\\/3020257639\\\\\\/22588\\\\\\/6ea9b25e\\\\\\/57eb9d6dN626d42bd.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3193\\\\\\/27\\\\\\/3106848273\\\\\\/22588\\\\\\/6ea9b25e\\\\\\/57eb9d6eN8461464e.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"8\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778946\":{\"id\":\"778946\",\"commodityId\":\"0\",\"title\":\"\\u5bb6\\u7535\",\"picUrl\":\"\\/\\/img10.360buyimg.com\\/cms\\/jfs\\/t3139\\/254\\/3089231091\\/52529\\/9c4cb321\\/57eb9de4Na8441b9d.jpg\",\"picUrl80\":\"\\/\\/img13.360buyimg.com\\/cms\\/jfs\\/t3079\\/262\\/3076165408\\/52529\\/9c4cb321\\/57eb9de8N2f845968.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141231\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"746960\",\"url\":\"https:\\/\\/sale.jd.com\\/act\\/wcxvWQmqotR.html?cpdad=1DLSUE\\u00a0\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"745\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"746960\\\",\\\"title\\\":\\\"\\\\u5bb6\\\\u7535\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/wcxvWQmqotR.html?cpdad=1DLSUE\\\\u00a0\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3139\\\\\\/254\\\\\\/3089231091\\\\\\/52529\\\\\\/9c4cb321\\\\\\/57eb9de4Na8441b9d.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3079\\\\\\/262\\\\\\/3076165408\\\\\\/52529\\\\\\/9c4cb321\\\\\\/57eb9de8N2f845968.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"746960\\\",\\\"title\\\":\\\"\\\\u5bb6\\\\u7535\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/wcxvWQmqotR.html?cpdad=1DLSUE\\\\u00a0\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3139\\\\\\/254\\\\\\/3089231091\\\\\\/52529\\\\\\/9c4cb321\\\\\\/57eb9de4Na8441b9d.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3079\\\\\\/262\\\\\\/3076165408\\\\\\/52529\\\\\\/9c4cb321\\\\\\/57eb9de8N2f845968.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"9\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778947\":{\"id\":\"778947\",\"commodityId\":\"0\",\"title\":\"\\u5c0f\\u5bb6\\u7535\",\"picUrl\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3250\\/334\\/3129010225\\/20905\\/20405a89\\/57eb9de4Nc69bd616.jpg\",\"picUrl80\":\"\\/\\/img14.360buyimg.com\\/cms\\/jfs\\/t3223\\/136\\/3089306852\\/20905\\/20405a89\\/57eb9de8Ne2dc24ee.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141233\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"362401\",\"url\":\"https:\\/\\/sale.jd.com\\/act\\/nAZWFv0qeSgJX.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"745\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"362401\\\",\\\"title\\\":\\\"\\\\u5c0f\\\\u5bb6\\\\u7535\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/nAZWFv0qeSgJX.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3250\\\\\\/334\\\\\\/3129010225\\\\\\/20905\\\\\\/20405a89\\\\\\/57eb9de4Nc69bd616.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3223\\\\\\/136\\\\\\/3089306852\\\\\\/20905\\\\\\/20405a89\\\\\\/57eb9de8Ne2dc24ee.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"362401\\\",\\\"title\\\":\\\"\\\\u5c0f\\\\u5bb6\\\\u7535\\\",\\\"url\\\":\\\"https:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/nAZWFv0qeSgJX.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3250\\\\\\/334\\\\\\/3129010225\\\\\\/20905\\\\\\/20405a89\\\\\\/57eb9de4Nc69bd616.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3223\\\\\\/136\\\\\\/3089306852\\\\\\/20905\\\\\\/20405a89\\\\\\/57eb9de8Ne2dc24ee.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"10\",\"seq\":\"0\",\"commodity_type\":\"3\"},\"778948\":{\"id\":\"778948\",\"commodityId\":\"0\",\"title\":\"\\u51b0\\u6d17\",\"picUrl\":\"\\/\\/img12.360buyimg.com\\/cms\\/jfs\\/t3082\\/200\\/3030384124\\/19521\\/251270be\\/57eb9de4Nce625416.jpg\",\"picUrl80\":\"\\/\\/img10.360buyimg.com\\/cms\\/jfs\\/t3094\\/160\\/3067519597\\/19521\\/251270be\\/57eb9de6Ndfa6fc8a.jpg\",\"picSize\":\"2\",\"soldNum\":\"0\",\"channel\":\"0\",\"classId\":\"0\",\"categoryName\":\"0\",\"onMarketDate\":\"0\",\"isFrenzy\":\"0\",\"price\":\"0\",\"lastUpdate\":\"1475141236\",\"lastUpdateUser\":\"zhangxiaoyao\",\"pool\":\"11227\",\"sortNumber\":\"1\",\"defaultDisplay\":\"1\",\"primaryGoods\":\"\",\"term\":\"571115\",\"url\":\"http:\\/\\/sale.jd.com\\/act\\/tE7zZdl0CsM4Wkxf.html\",\"marketPrice\":\"0\",\"className\":\"\",\"promoteText\":\"\\u6ee1199\\u51cf100\",\"shortPromoteText\":\"\",\"inventory\":\"745\",\"partnerId\":\"\",\"skuId\":\"1\",\"spuId\":\"0\",\"tag\":\"\\u6ee1199\\u51cf100\",\"starttime\":\"1474992000\",\"endtime\":\"1485619200\",\"groupid\":\"\",\"token\":null,\"customData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"571115\\\",\\\"title\\\":\\\"\\\\u51b0\\\\u6d17\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/tE7zZdl0CsM4Wkxf.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3082\\\\\\/200\\\\\\/3030384124\\\\\\/19521\\\\\\/251270be\\\\\\/57eb9de4Nce625416.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3094\\\\\\/160\\\\\\/3067519597\\\\\\/19521\\\\\\/251270be\\\\\\/57eb9de6Ndfa6fc8a.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"areaStockInfo\":\"{\\\"lastUpdate_ut\\\":11,\\\"0\\\":{\\\"price\\\":\\\"1\\\",\\\"snap_price\\\":\\\"1\\\",\\\"sale_count\\\":0,\\\"inventory\\\":\\\"1\\\",\\\"state\\\":1,\\\"multiInfo\\\":{}}}\",\"state\":\"1\",\"saleAttr\":\"\",\"extData\":\"{\\\"starttime\\\":1474992000,\\\"endtime\\\":1485619200,\\\"tag\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"promoteText\\\":\\\"\\\\u6ee1199\\\\u51cf100\\\",\\\"term\\\":\\\"571115\\\",\\\"title\\\":\\\"\\\\u51b0\\\\u6d17\\\",\\\"url\\\":\\\"http:\\\\\\/\\\\\\/sale.jd.com\\\\\\/act\\\\\\/tE7zZdl0CsM4Wkxf.html\\\",\\\"picUrl\\\":\\\"jfs\\\\\\/t3082\\\\\\/200\\\\\\/3030384124\\\\\\/19521\\\\\\/251270be\\\\\\/57eb9de4Nce625416.jpg\\\",\\\"picUrl80\\\":\\\"jfs\\\\\\/t3094\\\\\\/160\\\\\\/3067519597\\\\\\/19521\\\\\\/251270be\\\\\\/57eb9de6Ndfa6fc8a.jpg\\\",\\\"areaId\\\":\\\"0\\\"}\",\"needStockUpdate\":\"0\",\"score\":\"0\",\"areaId\":\"0\",\"subAreaId\":\"0\",\"promoId\":\"0\",\"applyId\":\"0\",\"position\":\"11\",\"seq\":\"0\",\"commodity_type\":\"3\"}}}";
        parse(s);
    }
    public void parse(String content){
        List<TabItem> list = new ArrayList<TabItem>();
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(content).getAsJsonObject();
        JsonObject data = object.getAsJsonObject("data");
        for(Map.Entry<String, JsonElement> entry: data.entrySet()){
            try {
                JsonObject entryObject = entry.getValue().getAsJsonObject();
                if(entryObject != null){

                    String tabId = entryObject.getAsJsonPrimitive("id").getAsString();
                    String tag = entryObject.getAsJsonPrimitive("tag").getAsString();
                    List<Long> l1 = new ArrayList<Long>();
                    List<Long> l2 = new ArrayList<Long>();
                    List<Long> l3 = new ArrayList<Long>();
                    TabItem t = new TabItem(Long.parseLong(tabId));
                    //to test if category_info is null or empty
                    if (StringUtils.isNotBlank(tag)) {
                        String sharpSplit[] = tag.split("#");
                        for(int i = 0; i < sharpSplit.length; i++){
                            //1,,2   1,2,3   1,,
                            String[] commaSplit = sharpSplit[i].split(",");
                            if(commaSplit.length == 1 && !commaSplit[0].equals("null") && !StringUtils.isBlank(commaSplit[0])){
                                l1.add(Long.parseLong(commaSplit[0]));
                            }
                            else if(commaSplit.length == 2 && !commaSplit[1].equals("null") && !StringUtils.isBlank(commaSplit[1])){
                                l2.add(Long.parseLong(commaSplit[1]));
                            }
                            else if(commaSplit.length == 3 && !commaSplit[2].equals("null") && !StringUtils.isBlank(commaSplit[2])){
                                l3.add(Long.parseLong(commaSplit[2]));
                            }
                        }
                    }

                    if(l1.size() > 0){
                        t.setCid1List(l1);
                    }
                    if(l2.size() > 0){
                        t.setCid2List(l2);
                    }
                    if(l3.size() > 0){
                        t.setCid3List(l3);
                    }

                    String starttime = entryObject.getAsJsonPrimitive("starttime").getAsString();
                    String endtime = entryObject.getAsJsonPrimitive("endtime").getAsString();
                    Date startDate = new Date(Long.parseLong(starttime) * 1000);
                    Date endDate = new Date(Long.parseLong(endtime) * 1000);
                    t.setStartTime(startDate);
                    t.setEndTime(endDate);
                    System.out.println("tabItem is " + t);
                    list.add(t);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    class IdleConnectionMonitorManager extends Thread{
        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown = false;

        IdleConnectionMonitorManager(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }


        @Override
        public void run() {
            while(!shutdown){
                synchronized (this){
                    try {
                        wait(60*1000);
                        connMgr.closeExpiredConnections();
                        connMgr.closeIdleConnections(300, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        public void shutdown(){
            shutdown = true;
            synchronized (this){
                notifyAll();
            }
        }
    }
}
