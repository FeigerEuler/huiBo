package com.mhh.huibo.database.service;


import com.mhh.huibo.database.dto.PostDto;
import com.mhh.huibo.dbservice.dto.HuiBoUserInfoDto;
import com.mhh.huibo.entity.HuiBoUserInfo;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class HuiboUserInfoService {

    @Resource
    public HuiBoUserInfoDto huiBoUserInfoDto;



    public void insertAPost(String openId, String postContent){


    }
    public String getUserNameByOpenId(String openId){
        HuiBoUserInfo huiBoUserInfo = huiBoUserInfoDto.selectByOpenid(openId);
        return huiBoUserInfo.getUserName();

    }


}
