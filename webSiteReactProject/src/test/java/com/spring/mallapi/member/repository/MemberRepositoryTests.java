package com.spring.mallapi.member.repository;

import com.spring.mallapi.member.domain.Member;
import com.spring.mallapi.member.domain.MemberRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testInsertMember() {
        for(int i = 0; i<10; i++) {
            Member member = Member.builder()
                    .email("user" + i + "@naver.com")
                    .pw(passwordEncoder.encode("1234"))
                    .nickname("USER"+i).build();

            member.addRole(MemberRole.USER);
            if(i>=5) {
                member.addRole((MemberRole.MANAGER));
            }
            if(i>=8) {
                member.addRole(MemberRole.ADMIN);
            }
            memberRepository.save(member);
        }
    }

    @Test
    public void testRead() {
        String email = "user9@naver.com";
        Member member = memberRepository.getWithRoles(email);

        log.info("email: {}",email);
        log.info("============");
        log.info("member: {}",member);
    }
}
