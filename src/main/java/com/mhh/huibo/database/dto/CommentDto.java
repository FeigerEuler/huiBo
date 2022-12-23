package com.mhh.huibo.database.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mhh.huibo.database.mapper.CommentMapper;
import com.mhh.huibo.vo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDto {

    @Autowired
    private CommentMapper commentMapper;


    public List<Comment> queryAllComments(){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();

      //  wrapper.eq("status","1");

        wrapper.orderByDesc("update_time");
        return commentMapper.selectList(wrapper);
    }

}
