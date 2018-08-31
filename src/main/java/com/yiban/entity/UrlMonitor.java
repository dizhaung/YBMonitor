package com.yiban.entity;

public class UrlMonitor {
    private Integer urlId;

    private String url;

    private String sensitiveWork;

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getSensitiveWork() {
        return sensitiveWork;
    }

    public void setSensitiveWork(String sensitiveWork) {
        this.sensitiveWork = sensitiveWork == null ? null : sensitiveWork.trim();
    }
}