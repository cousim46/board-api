package com.toyproject.board.service.member;

import com.toyproject.board.dto.member.request.MemberRequest;
import com.toyproject.board.error.member.MemberCustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    Long memberSave() {
        MemberRequest memberRequest = new MemberRequest("test12",
                "asd123","asd123","테스터","아으닉네임","01011111111"
                ,"asd@naver.com");
        return memberService.save(memberRequest);
    }



    @Test
    @DisplayName("아이디가 이미 존재하면 MemberCustomException 발생합니다.")
    @Transactional
    void 아이디중복여부() throws Exception {
        //given
         memberSave();
        MemberRequest member2 = new MemberRequest("test12",
                "asd123","asd123","아무개","닉네임2","01022222222"
                ,"asd@naver.com");
        //when
        MemberCustomException memberCustomException = assertThrows(MemberCustomException.class, () ->
                memberService.save(member2));
        //then
        assertThat(memberCustomException.getMemberErrorCode().getMessage()).isEqualTo("중복된 아이디 입니다");
        assertThat(memberCustomException.getMemberErrorCode().getStatus().name()).isEqualTo("CONFLICT");
        assertThat(memberCustomException.getMemberErrorCode().getStatus().value()).isEqualTo(409);
    }

    @Test
    @DisplayName("비밀번호와 비밀번호 재확인이 일치하지 않으면 MemberCustomException 발생합니다.")
    @Transactional
    void 비밀번호_비밀번호재학인_일치여부() throws Exception {
        //given
        MemberRequest member = new MemberRequest("test12",
                "asd123","asd1231","아무개","닉네임2","01022222222"
                ,"asd@naver.com");
        //when
        MemberCustomException memberCustomException = assertThrows(MemberCustomException.class, () ->
                memberService.save(member));
        //then
        assertThat(memberCustomException.getMemberErrorCode().getMessage()).isEqualTo("비밀번호가 일치하지 않습니다.");
        assertThat(memberCustomException.getMemberErrorCode().getStatus().name()).isEqualTo("BAD_REQUEST");
        assertThat(memberCustomException.getMemberErrorCode().getStatus().value()).isEqualTo(400);
    }

    @Test
    @DisplayName("존재하는 닉네임이면 MemberCustomException 발생합니다.")
    @Transactional
    void 닉네임_중복여부() throws Exception {
        //given
        memberSave();
        MemberRequest memberRequest = new MemberRequest("admin",
                "admin12", "admin12", "관리자", "아으닉네임", "01012341234"
                , "admin@naver.com");
        //when
        MemberCustomException memberCustomException = assertThrows(MemberCustomException.class, () ->
                memberService.save(memberRequest));

        //then
        assertThat(memberCustomException.getMemberErrorCode().getMessage()).isEqualTo("이미 존재하는 닉네임입니다.");
        assertThat(memberCustomException.getMemberErrorCode().getStatus().name()).isEqualTo("CONFLICT");
        assertThat(memberCustomException.getMemberErrorCode().getStatus().value()).isEqualTo(409);
    }



}