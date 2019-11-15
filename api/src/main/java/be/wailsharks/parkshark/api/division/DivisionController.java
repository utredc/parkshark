package be.wailsharks.parkshark.api.division;

import be.wailsharks.parkshark.api.division.dto.CreateDivisionDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.service.division.DivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(DivisionController.DIVISION_CONTROLLER_RESOURCE_URL)
public class DivisionController {

	public static final String DIVISION_CONTROLLER_RESOURCE_URL = "/divisions";
	private static final String APPLICATION_JSON_VALUE = MediaType.APPLICATION_JSON_VALUE;
	private static final Logger LOGGER = LoggerFactory.getLogger(DivisionController.class);

	private DivisionService divisionService;
	
	@Autowired
	public DivisionController(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

;	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public DivisionDto createDivision(@RequestBody CreateDivisionDto divisionDto) {
		LOGGER.info("Create division - name: " + divisionDto.name);
		return DivisionMapper.mapToDivisionDto(
				divisionService.addDivision(DivisionMapper.mapToDomain(divisionDto)));
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<DivisionDto> getAllDivisions() {
		LOGGER.info("Get all divisions");
		return divisionService.getAllDivisions().stream()
				.map(DivisionMapper::mapToDivisionDto)
				.collect(Collectors.toList());
	}

}
