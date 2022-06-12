package com.toyproject.board.dto.member.request;

import com.toyproject.board.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@AllArgsConstructor
public class MemberRequest {
    @NotNull(message = "이메일을 필수로 입력하셔야 됩니다.")
    @Email
    private String email;
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

    public Member toEntity() {
        return new Member(email, password, userName, nickName, phoneNumber);
    }


}
