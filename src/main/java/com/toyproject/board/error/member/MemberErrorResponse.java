package com.toyproject.board.error.member;


import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Builder
@Getter
public class MemberErrorResponse {
    private LocalDateTime timestamp;
    private String errorCode;
    private String error;
    private int status;
    private String message;

    public static ResponseEntity<MemberErrorResponse> errorMessageResponse(MemberErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getStatus())
                .body(
                        MemberErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .errorCode(errorCode.name())
                                .error(errorCode.getStatus().name())
                                .status(errorCode.getStatus().value())
                                .message(errorCode.getMessage())
                                .build()

                );
    }
}
