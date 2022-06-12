package com.toyproject.board.repository.member;

import com.toyproject.board.entity.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    Member memberSave() {
        Member member = memberRepository.save(
                new Member("test@naver.com", "asd12", "hoestory",
                        "아으닉네임", "01011111111"));
        return member;
    }

    @Test
    @Transactional
    void 회원가입() throws Exception {
        // given
        Member member = new Member("test@naver.com", "asd12", "hoestory",
                "아으닉네임", "01011111111");
        // when
        Member saveMember = memberRepository.save(member);

        // then
        List<Member> members = memberRepository.findAll();
        Assertions.assertThat(members.size()).isEqualTo(1);
        Assertions.assertThat(saveMember.getEmail()).isEqualTo(members.get(0).getEmail());
        Assertions.assertThat(saveMember.getNickName()).isEqualTo(members.get(0).getNickName());

    }


}