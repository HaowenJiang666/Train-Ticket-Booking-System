package com.hjiang.train.member.controller;

import com.hjiang.train.common.resp.CommonResp;
import com.hjiang.train.member.req.MemberRegisterReq;
import com.hjiang.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> hello() {
        int count = memberService.count();
        CommonResp<Integer> commResp = new CommonResp<>();
        commResp.setContent(count);
        return commResp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(MemberRegisterReq req) {
        long register = memberService.register(req);
//        CommonResp<Long> commResp = new CommonResp<>();
//        commResp.setContent(register);
//        return commResp;
        return new CommonResp<>(register);
    }
}
