package be.wailsharks.parkshark.service.division;

import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.domain.division.DivisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DivisionService {

	private DivisionRepository divisionRepository;

	public DivisionService(DivisionRepository divisionRepository) {
		this.divisionRepository = divisionRepository;
	}

	public Division addDivision(Division divisionToAdd){
		return divisionRepository.save(divisionToAdd);
	}

	public List<Division> getAllDivisions() {
		List<Division> result = new ArrayList<>();
		divisionRepository.findAll().forEach(result::add);
		return result;
	}

}
