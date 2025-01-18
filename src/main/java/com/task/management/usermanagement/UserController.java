package com.task.management.usermanagement;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.management.helpermanagement.ApiMapping;
import com.task.management.helpermanagement.ApiResponse;

@RestController
@RequestMapping(value = ApiMapping.USER_RESOURCES)
public class UserController {

	private final UserServiceInterFace userServiceInterFace;

	UserController(UserServiceInterFace userServiceInterFace) {
		this.userServiceInterFace = userServiceInterFace;

	}

	@PostMapping(ApiMapping.REGISTER_USER)
	public ApiResponse<Void> registerUser(@RequestBody UserDto userDto) {
		userServiceInterFace.registerUser(userDto);
		return ApiResponse.success(null);

	}

	@PutMapping(ApiMapping.UPDATE_REGISTER_USER)
	public ApiResponse<Void> updateRegisterUser(@RequestBody UserDto userDto) {
		userServiceInterFace.updateRegisterUser(userDto);
		return ApiResponse.success(null);

	}

	@GetMapping(ApiMapping.GET_ALL_REGISTER_USER)
	public ApiResponse<List<UserDto>> getAllRegisterUser() {
		List<UserDto> allRegisteredUsers = userServiceInterFace.getAllRegisteredUsers();
		return ApiResponse.success(allRegisteredUsers);
	}

}
