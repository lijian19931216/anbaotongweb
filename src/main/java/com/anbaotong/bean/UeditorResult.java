package com.anbaotong.bean;

import lombok.Data;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-29
 **/
@Data
public class UeditorResult {
    private long size;
    private String state;
    private String url;
    private String original;
    private String type;

    public UeditorResult() {
    }

    public UeditorResult(long size, String state, String url, String original, String type) {
        this.size = size;
        this.state = state;
        this.url = url;
        this.original = original;
        this.type = type;
    }
}
