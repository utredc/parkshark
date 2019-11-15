package be.wailsharks.parkshark.api.division.dto;

public class CreateDivisionDto {

	public String name, originalName;
	public String director;

	public CreateDivisionDto(String name, String originalName, String director) {
		this.name = name;
		this.originalName = originalName;
		this.director = director;
	}
}
