package be.wailsharks.parkshark.api.division.dto;

public class CreateDivisionDto {

	public String name, originalName;
	public String director;
	public Long parentDivisionId;

	public CreateDivisionDto() {
	}

	public CreateDivisionDto(String name, String originalName, String director) {
		this.name = name;
		this.originalName = originalName;
		this.director = director;
	}

	public CreateDivisionDto(String name, String originalName, String director, Long parentDivisionId) {
		this.name = name;
		this.originalName = originalName;
		this.director = director;
		this.parentDivisionId = parentDivisionId;
	}
}
