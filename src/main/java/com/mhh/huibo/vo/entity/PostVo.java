package com.mhh.huibo.vo.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class PostVo implements Serializable {

    int id;
    String userName;
    String content;
    int likes=0;
    int comments=0;
    String createTime;
    String updateTime;



}
