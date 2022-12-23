package com.mhh.huibo.vo.entity;

import lombok.Data;

@Data
public class Comment {

    long id;

    long userId;

    String content;

    String createTime;

    String updateTime;


}
