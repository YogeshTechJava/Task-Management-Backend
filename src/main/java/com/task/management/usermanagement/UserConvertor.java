package com.task.management.usermanagement;

import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

	public UserMaster convertUserDtoEntity(UserDto userDto, UserMaster userMaster) {

		if (userDto.getUserId() != null) {
			userMaster.setUserId(userDto.getUserId());

		}
		userMaster.setName(userDto.getName());
		userMaster.setEmail(userDto.getEmail());
		userMaster.setContactNumber(userDto.getContactNumber());
		userMaster.setAddress(userDto.getAddress());
		return userMaster;

	}

	public UserDto convertUserMasterToDto(UserMaster userMaster, UserDto userDto) {
		userDto.setUserId(userMaster.getUserId());
		userDto.setName(userMaster.getName());
		userDto.setEmail(userMaster.getEmail());
		userDto.setContactNumber(userMaster.getContactNumber());
		userDto.setAddress(userMaster.getAddress());
		return userDto;

	}

}
