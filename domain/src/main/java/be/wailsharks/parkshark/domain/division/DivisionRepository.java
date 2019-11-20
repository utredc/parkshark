package be.wailsharks.parkshark.domain.division;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DivisionRepository extends CrudRepository<Division, Long> {

	Division findByName(String name);
}
