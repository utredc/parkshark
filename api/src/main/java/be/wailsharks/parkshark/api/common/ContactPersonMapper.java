package be.wailsharks.parkshark.api.common;

import be.wailsharks.parkshark.api.common.dto.ContactPersonDto;
import be.wailsharks.parkshark.api.common.dto.CreateContactPersonDto;
import be.wailsharks.parkshark.domain.common.ContactPerson;

public class ContactPersonMapper {
    public static ContactPerson mapToDomain(CreateContactPersonDto createContactPersonLotDto) {
        return null;
    }

    public static ContactPersonDto mapToContactPersonDto(ContactPerson contactPerson) {
        return new ContactPersonDto()
                .setId(contactPerson.getId())
                .setLastName(contactPerson.getName().getLastName())
                .setFirstName(contactPerson.getName().getFirstName())
                .setEmail(contactPerson.getEmail())
                .setStreetName(contactPerson.getAddress().getStreetName())
                .setStreetNumber(contactPerson.getAddress().getStreetNumber());

    }
}
