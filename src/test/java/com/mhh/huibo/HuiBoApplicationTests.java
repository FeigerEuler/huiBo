package com.mhh.huibo;

import com.alibaba.fastjson.JSON;
import com.mhh.huibo.database.dto.PostDto;
import com.mhh.huibo.database.service.PostService;
import com.mhh.huibo.dbservice.dto.HuiBoUserInfoDto;
import com.mhh.huibo.entity.HuiBoUserInfo;
import com.mhh.huibo.entity.Post;
import com.mhh.huibo.utils.http.ConvertUtils;
import com.mhh.huibo.utils.http.HttpUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HuiBoApplication.class)
class HuiBoApplicationTests {

    @Resource
    public HuiBoUserInfoDto huiBoUserInfoDto;

    @Resource
   public  ConvertUtils convertUtils;

    @Resource
    public PostDto postDto;
    @Test
    void contextLoads() throws IOException {

        List<Post> posts = postDto.queryAllPosts();

        System.out.println(convertUtils.toPostVos(posts));

    }
    @Test
    void httpTest(){

                System.out.println("Hello World!");

        }


    @Test
    public void testGet() throws IOException {
        String rsp = HttpUtils.get("https://baidu.com");
        System.out.println(rsp);
    }

    @Test
    public void testPost() throws IOException {
    String params ="{'1':3}";
        String rsp = HttpUtils.post("http://localhost:8088/api/login", params);
        System.out.println(rsp);
    }



    @Test
    public void dtoTest(){
        List<HuiBoUserInfo> huiBoUserInfos1 = huiBoUserInfoDto.selectAll();


        System.out.println(JSON.toJSONString(huiBoUserInfos1));

    }

}
