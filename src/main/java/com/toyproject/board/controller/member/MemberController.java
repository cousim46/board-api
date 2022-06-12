package com.toyproject.board.controller.member;

import com.toyproject.board.dto.member.request.MemberRequest;
import com.toyproject.board.dto.member.response.MemberResponse;
import com.toyproject.board.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/email")
    public ResponseEntity<String> duplicateLoginId(@RequestParam String email) {
        return new ResponseEntity<>(memberService.isDuplicateLoginId(email), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("nickname")
    public ResponseEntity<String> duplicateNickName(@RequestParam String nickName) {
        return new ResponseEntity<>(memberService.isDuplicateNickName(nickName), HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<MemberResponse> memberSave(@Valid @RequestBody MemberRequest memberRequest) {
        return new ResponseEntity<>(new MemberResponse(memberService.save(memberRequest), "회원가입 성공"), HttpStatus.CREATED);
    }

}
