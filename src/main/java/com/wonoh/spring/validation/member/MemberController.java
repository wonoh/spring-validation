package com.wonoh.spring.validation.member;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping(value = "/member")
    public Long saveMember(@RequestBody @Valid MemberRequestDto dto){
        return memberService.save(dto);
    }

    @GetMapping(value = "/members")
    public List<MemberResponseDto> findAll(){
        return memberService.findAll();
    }


}
