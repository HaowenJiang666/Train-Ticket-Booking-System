package com.hjiang.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.hjiang.train.common.exception.BusinessException;
import com.hjiang.train.common.exception.BusinessExceptionEnum;
import com.hjiang.train.member.domain.Member;
import com.hjiang.train.member.domain.MemberExample;
import com.hjiang.train.member.mapper.MemberMapper;
import com.hjiang.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        // 检查是否存在重复手机号
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(list)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
