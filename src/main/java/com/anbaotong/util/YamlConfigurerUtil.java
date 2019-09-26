package com.anbaotong.util;

import java.util.Properties;

/**
 * @description:
 * @author: lijian
 * @create: 2019-09-26
 **/
public class YamlConfigurerUtil {
    private static Properties ymlProperties = new Properties();

    public YamlConfigurerUtil(Properties properties){
        ymlProperties = properties;
    }

    public static String getStrYmlVal(String key){
        return ymlProperties.getProperty(key);
    }

    public static Integer getIntegerYmlVal(String key){
        return Integer.valueOf(ymlProperties.getProperty(key));
    }

    public static void main(String[] args) {
        System.out.println(YamlConfigurerUtil.getStrYmlVal("server.servlet.context-path"));
    }
}
