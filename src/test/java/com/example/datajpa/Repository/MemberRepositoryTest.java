package com.example.datajpa.Repository;

import com.example.datajpa.entity.Member;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = new Member("Member A");
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId()).get();

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());

        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember).isEqualTo(member);

    }
}