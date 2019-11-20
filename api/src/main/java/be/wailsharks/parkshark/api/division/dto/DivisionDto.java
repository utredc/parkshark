package be.wailsharks.parkshark.api.division.dto;

import be.wailsharks.parkshark.domain.division.Division;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DivisionDto that = (DivisionDto) o;
		return id == that.id &&
				Objects.equals(name, that.name) &&
				Objects.equals(originalName, that.originalName) &&
				Objects.equals(director, that.director) &&
				Objects.equals(parentDivisionId, that.parentDivisionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, originalName, director, parentDivisionId);
	}
}
