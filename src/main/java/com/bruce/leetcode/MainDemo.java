package com.bruce.leetcode;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wuteng1 on 2016/5/19.
 */
public class MainDemo {
    public static void main(String[] args) {
        String a = "poolSkuOffline,poolSku,skuOrderOffline,brandResource,skuBrand,618Cid3Brand,mainBrand,brandOfflineFeature,brandOfflineFeaturePerfOpt,brandProfile,brandProfilePerfOpt,brandCtr,brandActCtr,skuAttributeInfo,skuDataInfo,skuPriceInfo";
        String b = "skuOffline,sky_towers,selections,delivery_infos,poolSku,skuOrderOffline,poolSkuOffline,wxsqCidCidMap,wxsqCidSkuMain,accompanyKey";
        Set<String> st = new HashSet<String>();
        for(String t: a.split(",")){
            st.add(t);
        }
        for(String t: b.split(",")){
            st.add(t);
        }
        System.out.println(StringUtils.join(st,","));
     }
}
