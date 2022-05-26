package com.toyproject.board.dto.member.request;

import com.toyproject.board.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;


@Getter
@AllArgsConstructor
public class MemberRequest {
    @NotNull(message = "아이디를 필수로 입력하셔야 됩니다.")
    private String loginId;

    @NotNull(message = "비밀번호를 필수로 입력하셔야 됩니다.")
    private String password;

    @NotNull(message = "비밀번호 재확인을 필수로 입력하셔야 됩니다.")
    private String confirmPassword;
    @NotNull(message = "이름을 필수로 입력하셔야 됩니다.")
    private String userName;
    @NotNull(message = "닉네임을 필수로 입력하셔야 됩니다.")
    private String nickName;
    @NotNull(message = "핸드폰 번호를 필수로 입력하셔야 됩니다.")
    private String phoneNumber;

    @NotNull(message = "이메일을 필수로 입력하셔야 됩니다.")
    private String email;

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .userName(userName)
                .nickName(nickName)
                .phoneNumber(phoneNumber)
                .email(email).build();
    }


}
