package be.wailsharks.parkshark.service;


import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(Member memberToRegister) {
        return memberRepository.save(memberToRegister);
    }

    public List<Member> getAllMembers() {
        List<Member> result = new ArrayList<>();
        memberRepository.findAll().forEach(result::add);
        return result;
    }

    public Member getSpecificMember(String id) {
        if (memberRepository.findById(Long.parseLong(id)).isPresent()){
            return memberRepository.findById(Long.parseLong(id)).get();
        } else throw new IllegalArgumentException("No member with this id");
    }
}
