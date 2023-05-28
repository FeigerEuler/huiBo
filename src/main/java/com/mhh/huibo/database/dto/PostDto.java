package com.mhh.huibo.database.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mhh.huibo.dbservice.mappers.PostMapper;
import com.mhh.huibo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDto {

    @Autowired
    private PostMapper postMapper;


    public List<Post> queryAllPosts(){
        QueryWrapper<Post> wrapper = new QueryWrapper<>();

      //  wrapper.eq("status","1");

        wrapper.orderByDesc("update_time");
        return postMapper.selectList(wrapper);
    }
    public Post insertPost(Post post){
        int insert = postMapper.insert(post);
        if(insert == 1){
            return post;
        }
        throw new RuntimeException(" post insert failed");
    }

}
