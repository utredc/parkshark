package be.wailsharks.parkshark.domain.members.dto;

import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;

import java.time.LocalDate;

public class MemberDto {

    private Name name;
    private LicensePlate licensePlate;
    private String telephoneNr;
    private String emailAddress;
    private LocalDate registrationDate;
}
