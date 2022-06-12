package com.toyproject.board.service.member;

import com.toyproject.board.dto.member.request.MemberRequest;

public interface MemberService {
    Long save(MemberRequest memberRequest);

    String isDuplicateEmail(String email);

    String isDuplicateNickName(String nickName);
}
