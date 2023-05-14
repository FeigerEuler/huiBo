package com.mhh.huibo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_userInfo")
@Data
public class HuiBoUserInfo {

    @TableId(value = "id")
    Long id;

    String openId;

    String avatarSrc;

    String userName;

    String nickName;

    String userPwd;

    String createTime;

    String updateTime;
}

