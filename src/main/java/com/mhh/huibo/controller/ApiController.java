package com.mhh.huibo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mhh.huibo.dbservice.dto.HuiBoUserInfoDto;
import com.mhh.huibo.entity.HuiBoUserInfo;
import com.mhh.huibo.utils.http.HttpUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@RestController()
@RequestMapping("api")
public class ApiController {


    @Resource
    public HuiBoUserInfoDto huiBoUserInfoDto;

    @PostMapping("/login")
    @ResponseBody
    public String  login(@RequestBody String body) throws IOException {
        System.out.println("login info" + body);
        JSONObject jsonObject = JSON.parseObject(body);
        String code = jsonObject.getString("code");
        System.out.println(code);

        String getOpenidUrlTemplate = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc35a9f8127ecea87&secret=f19e1d610a4e7291fc47129de6e8d02f&js_code=CODE&grant_type=authorization_code";
        String getOpenidUrl= getOpenidUrlTemplate.replace("CODE", code);
        String rsp = HttpUtils.get(getOpenidUrl);
        JSONObject resp= JSON.parseObject(rsp);
        String openId = jsonObject.getString("openid");
        HuiBoUserInfo huiBoUserInfo = null;
        try{
            huiBoUserInfo = huiBoUserInfoDto.selectByOpenid(openId);
        } catch (Exception e){
             huiBoUserInfo = huiBoUserInfoDto.insertOneForOpenId(openId);
        }
        System.out.println(JSON.toJSONString(huiBoUserInfo));
        return JSON.toJSONString(huiBoUserInfo);

    }
}