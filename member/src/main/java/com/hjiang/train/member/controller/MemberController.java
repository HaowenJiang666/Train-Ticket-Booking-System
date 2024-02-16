package com.hjiang.train.member.controller;

import com.hjiang.train.common.resp.CommonResp;
import com.hjiang.train.member.req.MemberLoginReq;
import com.hjiang.train.member.req.MemberRegisterReq;
import com.hjiang.train.member.req.MemberSendCodeReq;
import com.hjiang.train.member.resp.MemberLoginResp;
import com.hjiang.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
//        CommonResp<Long> commResp = new CommonResp<>();
//        commResp.setContent(register);
//        return commResp;
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }
}
