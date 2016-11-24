package com.bruce.http_learning.httpclient_demo;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by wuteng1 on 2016/4/27.
 */
public class TabItem {

    @SerializedName("id")
    Long tabId;

    @SerializedName("cid1")
    private List<Long> cid1List;

    @SerializedName("cid2")
    private List<Long> cid2List;

    @SerializedName("cid3")
    private List<Long> cid3List;

    @SerializedName("brand")
    private List<Long> brand;

    private Date startTime;

    private Date endTime;

    public TabItem(Long tabId) {
        this.tabId = tabId;
    }

    public Long getTabId() {
        return tabId;
    }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
    }

    public List<Long> getCid1List() {
        return cid1List;
    }

    public void setCid1List(List<Long> cid1List) {
        this.cid1List = cid1List;
    }

    public List<Long> getCid2List() {
        return cid2List;
    }

    public void setCid2List(List<Long> cid2List) {
        this.cid2List = cid2List;
    }

    public List<Long> getCid3List() {
        return cid3List;
    }

    public void setCid3List(List<Long> cid3List) {
        this.cid3List = cid3List;
    }

    public List<Long> getBrand() {
        return brand;
    }

    public void setBrand(List<Long> brand) {
        this.brand = brand;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "tabId " + tabId + ", cid1List " + cid1List + ", cid2List " + cid2List + ", cid3List "
                + cid3List + ", startTime " + startTime + ", endTime " + endTime + ", brand " + brand;
    }
}
