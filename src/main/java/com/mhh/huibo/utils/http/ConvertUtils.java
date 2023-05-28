package com.mhh.huibo.utils.http;


import com.mhh.huibo.database.service.HuiboUserInfoService;
import com.mhh.huibo.entity.Post;
import com.mhh.huibo.vo.entity.PostVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConvertUtils {

    @Resource()
    public HuiboUserInfoService huiboUserInfoService;

   public List<PostVo> toPostVos(List<Post> posts){
       List<PostVo> postVos = new ArrayList<>();
        if(null==huiboUserInfoService){
            System.out.println("null11111111");
        }
       for(Post post : posts){
           PostVo postVo = new PostVo();
           BeanUtils.copyProperties(post,postVo);
           postVo.setUserName(
                   huiboUserInfoService.getUserNameByOpenId(
                           post.getOpenId()));
           postVos.add(postVo);
       }
       return postVos;
   }
}
