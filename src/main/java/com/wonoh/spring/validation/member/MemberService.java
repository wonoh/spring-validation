package com.wonoh.spring.validation.member;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Transactional
    public Long save(MemberRequestDto dto){
        return memberRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll(){

        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());

    }


}
