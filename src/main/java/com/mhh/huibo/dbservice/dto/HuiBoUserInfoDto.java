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


    public List<HuiBoUserInfo> selectAll() {
        return huiBoUserInfoMapper.selectList(null);
    }

    public HuiBoUserInfo selectByOpenid(String openId) {
        QueryWrapper<HuiBoUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        List<HuiBoUserInfo> huiBoUserInfos = huiBoUserInfoMapper.selectList(queryWrapper);

        return huiBoUserInfos.stream().findAny().orElseThrow(RuntimeException::new);
    }

    public HuiBoUserInfo insertOneForOpenIdAndAvatar(String openId, String avatarUrl) {
        HuiBoUserInfo huiBoUserInfo = new HuiBoUserInfo();
        huiBoUserInfo.setOpenId(openId);
        huiBoUserInfo.setAvatarSrc(avatarUrl);

        huiBoUserInfoMapper.insert(huiBoUserInfo);
        return huiBoUserInfo;
    }

    public HuiBoUserInfo updateAvatarById(HuiBoUserInfo huiBoUserInfo, String avatar) {
        huiBoUserInfo.setAvatarSrc(avatar);
        int res = huiBoUserInfoMapper.updateById(huiBoUserInfo);
        if (res < 1) {
            throw new RuntimeException();
        }
        return huiBoUserInfo;
    }
}
