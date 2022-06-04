package com.toyproject.board.service.member;

import com.toyproject.board.dto.member.request.MemberRequest;

public interface MemberService {
    Long save(MemberRequest memberRequest);

    String isDuplicateLoginId(String login_id);

    String isDuplicateNickName(String nickName);
}
