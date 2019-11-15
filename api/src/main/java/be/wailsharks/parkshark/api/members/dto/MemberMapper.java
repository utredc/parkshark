package be.wailsharks.parkshark.api.members.dto;

import be.wailsharks.parkshark.domain.members.Member;

public class MemberMapper {

    public static Member memberDtoToMember(MemberDto memberDto) {
        return new Member();
    }
}
