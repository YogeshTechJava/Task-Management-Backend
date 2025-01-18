package com.task.management.usermanagement;

import java.util.List;

public interface UserServiceInterFace {

	public void registerUser(UserDto userDto);

	public void updateRegisterUser(UserDto userDto);

	public List<UserDto> getAllRegisteredUsers();

}
