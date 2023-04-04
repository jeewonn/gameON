package com.game.gameon.member.controller;

import com.game.gameon.common.GameonResponse;
import com.game.gameon.member.dto.JoinRequestBody;
import com.game.gameon.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<GameonResponse<Void>> join(@RequestBody JoinRequestBody joinRequestBody){
        memberService.join(joinRequestBody);
        return ResponseEntity.ok(GameonResponse.success());
    }
}
