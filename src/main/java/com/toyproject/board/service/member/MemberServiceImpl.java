package com.toyproject.board.service.member;

import com.toyproject.board.dto.member.request.MemberRequest;
import com.toyproject.board.entity.member.Member;
import com.toyproject.board.error.member.MemberCustomException;
import com.toyproject.board.error.member.MemberErrorCode;
import com.toyproject.board.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    @Override
    public Long save(MemberRequest memberRequest) {
        if (memberRepository.existsByLoginId(memberRequest.getLoginId())) {
            throw new MemberCustomException(MemberErrorCode.DUPLICATE_ID);
        }
        if (!memberRequest.getPassword().equals(memberRequest.getConfirmPassword())) {
            throw new MemberCustomException(MemberErrorCode.DISMISMATCH_PASSWORD);
        }

        if (memberRepository.existsByNickName(memberRequest.getNickName())) {
            throw new MemberCustomException(MemberErrorCode.DUPLICATE_NICKNAME);
        }

        Member member = memberRepository.save(memberRequest.toEntity());
        return member.getId();
    }

    @Override
    public String isDuplicateLoginId(String login_id) {
        if (memberRepository.existsByLoginId(login_id)) {
            throw new MemberCustomException(MemberErrorCode.DUPLICATE_ID);
        }
        return "사용 가능한 아이디입니다.";
    }

    @Override
    public String isDuplicateNickName(String nickName) {
        if (memberRepository.existsByNickName(nickName)) {
            throw new MemberCustomException(MemberErrorCode.DUPLICATE_NICKNAME);
        }
        return "사용 가능한 닉네임입니다.";
    }
}
