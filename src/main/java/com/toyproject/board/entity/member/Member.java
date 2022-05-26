package com.toyproject.board.entity.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    private int boardCount;

    public static class Builder {
        private String loginId;
        private String password;
        private String userName;
        private String nickName;
        private String phoneNumber;
        private String email;

        private int boardCount;

        public Builder loginId(String loginId) {
            this.loginId = loginId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder boardCount(int boardCount) {
            this.boardCount = boardCount;
            return this;
        }
        public Member build() {
            return new Member(this);
        }

    }
    private Member(Builder builder) {
        loginId = builder.loginId;
        password = builder.password;
        userName = builder.userName;
        nickName = builder.nickName;
        phoneNumber = builder.phoneNumber;
        email = builder.email;
    }
    public static Builder builder() {
        return new Builder();
    }

}
