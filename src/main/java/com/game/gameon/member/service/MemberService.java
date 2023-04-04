package com.game.gameon.member.service;

import com.game.gameon.member.dto.JoinRequestBody;
import com.game.gameon.member.entity.MemberEntity;
import com.game.gameon.member.exception.AlreadyExistsEmailException;
import com.game.gameon.member.exception.AlreadyExistsNicknameException;
import com.game.gameon.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(JoinRequestBody joinRequestBody){

        boolean existsByEmail = memberRepository.existsByEmail(joinRequestBody.getEmail());
        boolean existsByNickname = memberRepository.existsByNickname(joinRequestBody.getNickname());

        if (existsByEmail){
            throw new AlreadyExistsEmailException();
        }

        if (existsByNickname){
            throw new AlreadyExistsNicknameException();
        }

        MemberEntity memberEntity = MemberEntity.builder()
                .email(joinRequestBody.getEmail())
                .password(joinRequestBody.getPassword())
                .nickname(joinRequestBody.getNickname())
                .build();

        memberRepository.save(memberEntity);
    }
}
