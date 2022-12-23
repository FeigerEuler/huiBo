package com.mhh.huibo.restful.controller;

import com.mhh.huibo.database.dto.CommentDto;
import com.mhh.huibo.vo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api")
public class HuiBoController {


    @Autowired
   private CommentDto commentDto;

    @GetMapping("/getAllComments")
    @ResponseBody
    public List<Comment> getAllComments(){
        List<Comment> comments = commentDto.queryAllComments();
        return comments;
    }
}
