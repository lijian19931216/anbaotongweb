package com.anbaotong.bean;

import lombok.Data;

import java.util.Date;

@Data
public class QuesAns extends BaseBean {
    /**
     * id
     */
    private String id;


    private String question;


    private String answer;
    private String type ;

    private Date date;


}