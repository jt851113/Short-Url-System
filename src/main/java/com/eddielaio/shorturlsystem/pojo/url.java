package com.eddielaio.shorturlsystem.pojo;

public class url {
    private String url;

    public url() {
    }

    public url(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "url{url = " + url + "}";
    }
}
