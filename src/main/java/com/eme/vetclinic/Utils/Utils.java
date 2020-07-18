package com.eme.vetclinic.Utils;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.eme.vetclinic.exceptions.StatusResponse;

@Component
public class Utils {

	public static final String INTERNAL_SERVER_ERROR_CODE = "500";
	public static final String INTERNAL_SERVER_ERROR_KEY = "INTERNAL_SERVER_ERROR_KEY";



	public static boolean isNotEmpty(Object obj) {
		return obj != null;
	}

	public static Boolean isEmptyString(String str) {
		return str == null || str.equals("");
	}

	public static StatusResponse internalServerError(String message) {

		StatusResponse error = new StatusResponse(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR_KEY, message);
		return buildErrorMessage(error);
	}

	public static StatusResponse buildErrorMessage(StatusResponse response) {
		response.setMessage(response.getMessage());
		return response;
	}

	public static Timestamp getCurrentTime() {
		Date date = new Date();
		long time = date.getTime();
		return new Timestamp(time);
	}

}
