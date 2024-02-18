package com.hjiang.train.member.req;

import com.hjiang.train.common.req.PageReq;

public class PassengerQueryReq extends PageReq {

    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PassengerQuery{");
        sb.append("memberId=").append(memberId);
        sb.append('}');
        return sb.toString();
    }
}