package com.mhh.huibo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_post")
@Data
public class Post {
    @TableId(value = "id")
    long id;

    String  openId;

    String content;

    String createTime;

    String updateTime;


}
