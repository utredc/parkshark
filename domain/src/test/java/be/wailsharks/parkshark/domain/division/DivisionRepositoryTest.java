package be.wailsharks.parkshark.domain.division;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//@ActiveProfiles("test")
class DivisionRepositoryTest {

    private final DivisionRepository divisionRepository;

    @Autowired
    public DivisionRepositoryTest(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Test
    void whenAddingDivision_thenDivisionThatIsSavedIdIsNotNullAndHasCorrectName() {
        Division division = new Division("jimmy.jamma", "timmy.tamma", "billy.balla");

        Division savedDivision = divisionRepository.save(division);

        assertThat(savedDivision).isNotNull();
        assertThat(savedDivision.getId()).isNotNull();
        assertThat(savedDivision.getName()).isEqualTo("jimmy.jamma");
        assertThat(divisionRepository.findAll()).contains(savedDivision);
    }

    @Test
    void whenGettingAllDivisionsInEmptyRepository_thenReturnNull() {
        Iterable<Division> getDivision = divisionRepository.findAll();

        assertThat(getDivision).isEmpty();
    }
}
