package com.mhh.huibo.database.service;


import com.mhh.huibo.database.dto.PostDto;
import com.mhh.huibo.entity.Post;
import com.mhh.huibo.utils.http.ConvertUtils;
import com.mhh.huibo.vo.entity.PostVo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class PostService {

    @Resource
    public PostDto postDto;

@Resource
private ConvertUtils convertUtils;

    public void insertAPost(String openId, String postContent){
        Post post = new Post();
        post.setContent(postContent);
        post.setOpenId(openId);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());
        post.setCreateTime(now);
        post.setUpdateTime(now);
        postDto.insertPost(post);

    }
    public List<PostVo> getAllPostVos(){
        List<Post> posts = postDto.queryAllPosts();

        return convertUtils.toPostVos(posts);
    }


}
