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
import com.eme.vetclinic.Dto.OwnerDto;
import com.eme.vetclinic.Utils.Utils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.service.OwnerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@GetMapping("/{id}")
	@ApiOperation(value = "Get Owner by id", response = OwnerDto.class, tags = { "Owner" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getPetById(@PathVariable Integer id) {
		try {

			return ResponseEntity.ok(ownerService.getOwnerById(id));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping
	@ApiOperation(value = "Add new Owner", response = StatusResponse.class, tags = { "Owner" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> addOwner(@RequestBody OwnerDto ownerDto) {
		try {

			return ResponseEntity.ok(ownerService.addNewOwner(ownerDto));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
