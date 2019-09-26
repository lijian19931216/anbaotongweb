package com.anbaotong.util;

import java.util.UUID;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-26
 **/
public class UuidUtil {
    public static String createID(){
        UUID uuid = UUID.randomUUID();
        String id=uuid.toString();
        return id.replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(createID());
    }
}
