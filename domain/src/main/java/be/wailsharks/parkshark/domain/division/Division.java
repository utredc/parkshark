package be.wailsharks.parkshark.domain.division;

import be.wailsharks.parkshark.domain.common.Name;

import javax.persistence.*;

@Entity
@Table(name = "DIVISION")
public class Division {

	@Id
	@SequenceGenerator(name = "division_seq_gen", sequenceName = "DIVISION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq_gen")
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ORIGINAL_NAME")
	private  String originalName;

	@Column(name ="DIRECTOR_NAME")
	private String director;

	public Division() {}

	public Division(String name, String originalName, String director) {
		this.name = name;
		this.originalName = originalName;
		this.director = director;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getDirector() {
		return director;
	}
}
