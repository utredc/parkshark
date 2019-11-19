package be.wailsharks.parkshark.api.members.dto;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MembershipLevel;
import org.springframework.stereotype.Component;

import static be.wailsharks.parkshark.domain.members.Member.DEFAULT_MEMBERSHIP_LEVEL;

@Component
public class MemberMapper {



    public Member convertCreateMemberDtoToMember(CreateMemberDto memberToCreate) {
        Name memberName = new Name(memberToCreate.getFirstName(), memberToCreate.getLastName());
        LicensePlate licensePlate = new LicensePlate(memberToCreate.getLicensePlateNr(), memberToCreate.getLicensePlateCountry());
        Address address = new Address(memberToCreate.getStreetName(),memberToCreate.getStreetNumber(), memberToCreate.getCityId());
        MembershipLevel memberLevel = chooseMembershipLevel(memberToCreate.getMembershipLevel());
        return new Member(memberName, licensePlate, memberToCreate.getTelephoneNr(), memberToCreate.getEmailAddress(), address, memberLevel);
    }

    public MembershipLevel chooseMembershipLevel(String memberLevel) {
        if (memberLevel == null) {
            return DEFAULT_MEMBERSHIP_LEVEL;
        } else {
            return MembershipLevel.valueOf(memberLevel.toUpperCase());
        }
    }

    public static MemberDto convertMemberToDto(Member memberToConvert) {
        return MemberDto.MemberDto()
                .setFirstName(memberToConvert.getName().getFirstName())
                .setLastName(memberToConvert.getName().getLastName())
                .setEmailAddress(memberToConvert.getEmailAddress())
                .setLicensePlateCountry(memberToConvert.getLicensePlate().getPlateCountry())
                .setLicensePlateNr(memberToConvert.getLicensePlate().getPlateNumber())
                .setTelephoneNr(memberToConvert.getTelephoneNr())
                .setRegistrationDate(memberToConvert.getRegistrationDate().toString())
                .setId(memberToConvert.getId())
                .setStreetName(memberToConvert.getAddress().getStreetName())
                .setStreetNr(memberToConvert.getAddress().getHouseNumber())
                .setMembershipLevel(memberToConvert.getMembershipLevel().name())
                ;
    }

    public static BasicMemberInfoDto convertMemberToBasicInfoDto(Member memberToConvert) {
        return BasicMemberInfoDto.BasicMemberInfoDto()
                .setFirstName(memberToConvert.getName().getFirstName())
                .setLastName(memberToConvert.getName().getLastName())
                .setEmailAddress(memberToConvert.getEmailAddress())
                .setLicensePlateNr(memberToConvert.getLicensePlate().getPlateNumber())
                .setTelephoneNr(memberToConvert.getTelephoneNr())
                .setRegistrationDate(memberToConvert.getRegistrationDate().toString())
                .setId(memberToConvert.getId());
    }
}
