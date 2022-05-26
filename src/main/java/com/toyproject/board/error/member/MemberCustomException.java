package com.toyproject.board.error.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberCustomException extends RuntimeException {
    private final MemberErrorCode memberErrorCode;
}
