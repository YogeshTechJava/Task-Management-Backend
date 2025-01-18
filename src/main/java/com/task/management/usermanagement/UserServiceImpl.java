package com.task.management.usermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterFace {

	private final UserConvertor userObjectConvertor;
	private final UserRepo userRepo;

	UserServiceImpl(UserRepo userRepo, UserConvertor userObjectConvertor) {
		this.userRepo = userRepo;
		this.userObjectConvertor = userObjectConvertor;
	}

	@Override
	public void registerUser(UserDto userDto) {
		if (userDto != null) {
			UserMaster userMaster = userObjectConvertor.convertUserDtoEntity(userDto, new UserMaster());
			userRepo.save(userMaster);

		}

	}

	@Override
	public void updateRegisterUser(UserDto userDto) {
		if (userDto != null && userDto.getUserId() != null) {
			Optional<UserMaster> userMasterWithOptional = userRepo.findById(userDto.getUserId());

			if (userMasterWithOptional.isPresent()) {
				UserMaster userMaster = userMasterWithOptional.get();
				userMaster = userObjectConvertor.convertUserDtoEntity(userDto, userMaster);
				userRepo.save(userMaster);

			}
		}

	}

	@Override
	public List<UserDto> getAllRegisteredUsers() {
		List<UserMaster> userMasterData = userRepo.findAll();
		List<UserDto> userDto = new ArrayList<>();
		if (userMasterData != null && !userMasterData.isEmpty()) {
			userDto = userMasterData.stream()
					.map(userMaster -> userObjectConvertor.convertUserMasterToDto(userMaster, new UserDto()))
					.collect(Collectors.toList());

		}
		return userDto;
	}

}
