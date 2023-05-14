package com.mhh.huibo.dbservice.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mhh.huibo.dbservice.mappers.HuiBoUserInfoMapper;
import com.mhh.huibo.entity.HuiBoUserInfo;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
public class HuiBoUserInfoDto {

    @Resource
    private HuiBoUserInfoMapper huiBoUserInfoMapper;



    public List<HuiBoUserInfo>  selectAll(){
        return huiBoUserInfoMapper.selectList(null);
    }

    public HuiBoUserInfo selectByOpenid(String openId)  {
        QueryWrapper<HuiBoUserInfo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("open_id",openId);
        List<HuiBoUserInfo> huiBoUserInfos = huiBoUserInfoMapper.selectList(queryWrapper);

        return huiBoUserInfos.stream().findAny().orElseThrow(RuntimeException::new);
    }
    public HuiBoUserInfo insertOneForOpenId(String openId){
        HuiBoUserInfo huiBoUserInfo = new HuiBoUserInfo();
        huiBoUserInfo.setOpenId(openId);

        huiBoUserInfoMapper.insert(huiBoUserInfo);
        return huiBoUserInfo;
    }
}
