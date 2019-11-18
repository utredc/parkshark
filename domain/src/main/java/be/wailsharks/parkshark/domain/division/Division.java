package be.wailsharks.parkshark.domain.division;

import javax.persistence.*;
import java.util.Objects;

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
    private String originalName;

    @Column(name = "DIRECTOR_NAME")
    private String director;

    @Column(name = "PARENT_DIVISION_ID")
    private Long parentDivisionId;


    public Division() {
    }

    public Division(String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public Division(String name, String originalName, String director, Long parentDivisionId) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentDivisionId = parentDivisionId;
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

    public Long getParentDivisionId() {
        return parentDivisionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id == division.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
