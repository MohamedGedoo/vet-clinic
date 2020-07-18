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
import com.eme.vetclinic.Dto.PetDto;
import com.eme.vetclinic.Utils.Utils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.service.PetService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping
	@ApiOperation(value = "Get All Pets", response = PetDto.class, tags = { "Pets" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getAllPets() {
		try {

			return ResponseEntity.ok(petService.getAll());
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get Pet by id", response = PetDto.class, tags = { "Pets" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getPetById(@PathVariable Integer id) {
		try {

			return ResponseEntity.ok(petService.getById(id));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/owner/{id}")
	@ApiOperation(value = "Get All Pets by Owner Id", response = PetDto.class, tags = { "Pets" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> getPetByOwnerId(@PathVariable Integer id) {
		try {

			return ResponseEntity.ok(petService.getOwenerPets(id));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping("/owner/{ownerId}/pet")
	@ApiOperation(value = "Add new Pets to Owner Id", response = StatusResponse.class, tags = { "Pets" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ClinicDto.class),
			@ApiResponse(code = 400, message = "Error 400 and a status message, In case of an error with the request data", response = StatusResponse.class),
			@ApiResponse(code = 500, message = "Error 500 in case an unexpected system failure", response = StatusResponse.class) })
	public ResponseEntity<?> addPet(@PathVariable Integer ownerId, @RequestBody PetDto petDto) {
		try {

			return ResponseEntity.ok(petService.addPet(ownerId, petDto));
		} catch (ApplicationException e) {
			return new ResponseEntity<StatusResponse>(e.getStatus(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
