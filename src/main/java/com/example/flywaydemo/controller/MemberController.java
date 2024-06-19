package com.example.flywaydemo.controller;

import com.example.flywaydemo.controller.dto.MemberUpdateDto;
import com.example.flywaydemo.model.Member;
import com.example.flywaydemo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberRepository repository;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return repository.save(member);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    @PatchMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member updateMember) {
        updateMember.setId(id);
        return repository.save(updateMember);


    }
}
