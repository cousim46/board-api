package com.toyproject.board.repository.member;

import com.toyproject.board.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByNickName(String nickName);

}
