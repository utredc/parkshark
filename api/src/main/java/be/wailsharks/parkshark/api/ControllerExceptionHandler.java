package be.wailsharks.parkshark.api;

import be.wailsharks.parkshark.domain.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(ParkingLotFullException.class)
	protected void parkingLotFullException(ParkingLotFullException ex, HttpServletResponse response) throws IOException {
		LOGGER.info(ex.getMessage(), ex);
		response.sendError(BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(LicensePlateMissMatchException.class)
	protected void licensePlateMissMatchException(LicensePlateMissMatchException ex, HttpServletResponse response) throws IOException {
		LOGGER.info(ex.getMessage(), ex);
		response.sendError(BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(NoMemberWithIdException.class)
	protected void noMemberWithIdException(NoMemberWithIdException ex, HttpServletResponse response) throws IOException {
		LOGGER.info(ex.getMessage(), ex);
		response.sendError(BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@Order(-1)
	protected void exception(Exception ex, HttpServletResponse response) throws IOException {
		LOGGER.error("Unexpected internal server error", ex);
		response.sendError(INTERNAL_SERVER_ERROR.value(), "Oops, something went wrong. Please contact an administrator if the problem persists.");
	}

}
