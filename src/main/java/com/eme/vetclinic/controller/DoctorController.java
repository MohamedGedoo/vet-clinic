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

import com.eme.vetclinic.Dto.AssignDoctor;
import com.eme.vetclinic.Dto.ClinicDto;
import com.eme.vetclinic.Dto.DoctorDto;
import com.eme.vetclinic.Utils.Utils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.service.DoctorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/{id}")
	@ApiOperation(value = "Get Doctor Info By ID", response = DoctorDto.class, tags = { "Doctor" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getDoctorById(@PathVariable Integer id) {
		try {

			return ResponseEntity.ok(doctorService.getDoctorByID(id));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping
	@ApiOperation(value = "Add new Doctor Info", response = StatusResponse.class, tags = { "Doctor" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> addNewDoctor(@RequestBody DoctorDto doctorDto) {
		try {

			return ResponseEntity.ok(doctorService.addDoctor(doctorDto));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping("/assign")
	@ApiOperation(value = "Assign Doctor To Clinic", response = StatusResponse.class, tags = { "Doctor" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> assignDoctorToClinic(@RequestBody AssignDoctor assignDoctor) {
		try {

			return ResponseEntity.ok(doctorService.assignDoctor(assignDoctor));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
