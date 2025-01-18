package com.task.management.helpermanagement;

import lombok.Data;

@Data
public class ApiResponse<T> {

	private String status;

	private T data;

	private String message;

	ApiResponse(String status, T data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>("success", data, null);
	}

	public static <T> ApiResponse<T> error(String message) {
		return new ApiResponse<T>("error", null, message);
	}

}
