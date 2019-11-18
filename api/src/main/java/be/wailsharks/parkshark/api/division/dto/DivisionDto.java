package be.wailsharks.parkshark.api.division.dto;

import be.wailsharks.parkshark.domain.division.Division;

public class DivisionDto {

	public long id;
	public String name;
	public String originalName;
	public String  director;
	public Long parentDivisionId;

	public static DivisionDto DivisionDto() {
		return new DivisionDto();
	}

	public DivisionDto setId(long id) {
		this.id = id;
		return this;
	}

	public DivisionDto setName(String name) {
		this.name = name;
		return this;
	}

	public DivisionDto setOriginalName(String  originalName) {
		this.originalName = originalName;
		return this;
	}

	public DivisionDto setDirector(String  director) {
		this.director = director;
		return this;
	}

	public DivisionDto setParentDivisionId (Long parentDivisionId){
		this.parentDivisionId = parentDivisionId;
		return this;
	}

}
