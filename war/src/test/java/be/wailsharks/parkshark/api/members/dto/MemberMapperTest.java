package be.wailsharks.parkshark.api.members.dto;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MembershipLevel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class MemberMapperTest {

    @Test
    void memberDto() {
        Member member = new Member(new Name("Freddy", "Fredson"), new LicensePlate("456", "BE"), "13213", "asda", new Address("straat", "4", 1), MembershipLevel.BRONZE);
        MemberDto result = MemberMapper.convertMemberToDto(member);
        Assertions.assertThat(result.getFirstName()).isEqualTo("Freddy");
    }

    @Test
    void chooseMemberShipLevel_givenString_getEnumWithThatValue() {
        MemberMapper mapper = new MemberMapper();
        Assertions.assertThat(mapper.chooseMembershipLevel("gold")).isEqualByComparingTo(MembershipLevel.GOLD);
    }

    @Test
    void chooseMembershipLevel_givenNull_getBronze() {
        MemberMapper mapper = new MemberMapper();
        Assertions.assertThat(mapper.chooseMembershipLevel(null)).isEqualByComparingTo(MembershipLevel.BRONZE);
    }
}