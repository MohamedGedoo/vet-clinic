package com.eme.vetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eme.vetclinic.Dto.ClinicDto;
import com.eme.vetclinic.Dto.ClinicSearchDto;
import com.eme.vetclinic.Dto.DoctorDto;
import com.eme.vetclinic.Utils.Utils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.service.ClinicService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@GetMapping("/{id}")
	@ApiOperation(value = "Get Clinic By ID", response = ClinicDto.class, tags = { "Clinic" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getClinicById(@PathVariable Integer id) {
		try {

			return ResponseEntity.ok(clinicService.getClinicByID(id));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/doctors/{id}")
	@ApiOperation(value = "Get Doctors by ClinicID", response = DoctorDto.class, tags = { "Clinic" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getDoctorsByClinicId(@PathVariable Integer id) {
		try {

			return ResponseEntity.ok(clinicService.getDoctorsByClinicId(id));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping
	@ApiOperation(value = "Add New Clinic", response = StatusResponse.class, tags = { "Clinic" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> addClinic(@RequestBody ClinicDto clinicDto) {
		try {

			return ResponseEntity.ok(clinicService.addClinic(clinicDto));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping("/search")
	@ApiOperation(value = "search for Clinic by phone or address", response = ClinicDto.class, tags = { "Clinic" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> searchClinic(@RequestBody ClinicSearchDto clinicSerchDto) {
		try {

			return ResponseEntity.ok(clinicService.searchClinic(clinicSerchDto));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
