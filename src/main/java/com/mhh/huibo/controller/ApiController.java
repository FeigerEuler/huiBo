package com.mhh.huibo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mhh.huibo.database.service.PostService;
import com.mhh.huibo.dbservice.dto.HuiBoUserInfoDto;
import com.mhh.huibo.entity.HuiBoUserInfo;
import com.mhh.huibo.entity.Post;
import com.mhh.huibo.utils.http.HttpUtils;
import com.mhh.huibo.vo.entity.PostVo;
import com.mhh.huibo.vo.entity.Resp;
import com.mysql.jdbc.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("api")
public class ApiController {


    @Resource
    public HuiBoUserInfoDto huiBoUserInfoDto;

    @Resource
    public PostService postService;

    @PostMapping("/login")
    @ResponseBody
    public Resp login(@RequestBody String body) throws IOException {
        System.out.println("login info" + body);
        JSONObject jsonObject = JSON.parseObject(body);
        String code = jsonObject.getString("code");
        String avatar = jsonObject.getString("avatarUrl");

        String getOpenidUrlTemplate = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc35a9f8127ecea87&secret=f19e1d610a4e7291fc47129de6e8d02f&js_code=CODE&grant_type=authorization_code";
        String getOpenidUrl = getOpenidUrlTemplate.replace("CODE", code);
        String rsp = HttpUtils.get(getOpenidUrl);
        JSONObject resp = JSON.parseObject(rsp);
        String openId = resp.getString("openid");
        System.out.println("openId=" + openId);
        HuiBoUserInfo huiBoUserInfo = null;
        try {
            huiBoUserInfo = huiBoUserInfoDto.selectByOpenid(openId);
            if(StringUtils.isNullOrEmpty(huiBoUserInfo.getAvatarSrc())){
                huiBoUserInfoDto.updateAvatarById(huiBoUserInfo,avatar);
            }
        } catch (Exception e) {
            huiBoUserInfo = huiBoUserInfoDto.insertOneForOpenIdAndAvatar(openId,avatar);
        }
        System.out.println("42"+JSON.toJSONString(huiBoUserInfo));
        Resp<HuiBoUserInfo> resp1 = new Resp<>();
        System.out.println(JSON.toJSONString(resp1.buildSuccess(huiBoUserInfo)));
        return null == huiBoUserInfo ? resp1.buildFail("unknown error") : resp1.buildSuccess(huiBoUserInfo);

    }

    @PostMapping("/newPost")
    @ResponseBody
    public Resp newPost(@RequestBody String body) throws IOException {
        System.out.println("login info" + body);
        JSONObject jsonObject = JSON.parseObject(body);
        String openId=jsonObject.getString("openId");
        String content= jsonObject.getString("inputValue");
        System.out.println(openId+" "+content);
        postService.insertAPost(openId,content);


        return null;

    }

    @PostMapping("/getAllPosts")
    @ResponseBody
    public Resp getAllPost(@RequestBody String body) throws IOException {
        List<PostVo> allPostVos = postService.getAllPostVos();
        Resp<List<PostVo>> resp = new Resp<>();
        resp.buildSuccess(allPostVos);
        System.out.println(JSON.toJSONString(resp));
        return resp.buildSuccess(allPostVos);

    }
}