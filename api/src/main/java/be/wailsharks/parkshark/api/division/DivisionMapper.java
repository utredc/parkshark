package be.wailsharks.parkshark.api.division;

import be.wailsharks.parkshark.api.division.dto.CreateDivisionDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.domain.division.Division;

public class DivisionMapper {

	public static DivisionDto mapToDivisionDto(Division division) {
		return new DivisionDto()
				.setId(division.getId())
				.setName(division.getName())
				.setOriginalName(division.getOriginalName())
				.setDirector(division.getDirector())
				.setParentDivisionId(division.getParentDivisionId());
	}

	public static Division mapToDomain(CreateDivisionDto divisionDto) {
		return new Division(divisionDto.name, divisionDto.originalName, divisionDto.director, divisionDto.parentDivisionId );
	}

}
