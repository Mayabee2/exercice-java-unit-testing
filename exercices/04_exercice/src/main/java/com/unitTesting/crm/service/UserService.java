package com.unitTesting.crm.service;

import com.unitTesting.crm.domain.User;
import com.unitTesting.crm.exception.NotAllowedException;
import com.unitTesting.crm.exception.PhoneNumberExistsException;
import com.unitTesting.crm.exception.UserInvalidInfoException;
import com.unitTesting.crm.repository.UserRepository;

import java.util.Objects;

public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String getUserName(Long id) {
    User user = userRepository.findById(id);
    return user != null ? user.name : "User not found";
  }

  public void createNewUser(User user) {
    if (user.name == null || user.phoneNumber == null || user.role == null) {
      throw new UserInvalidInfoException("User information is missing");
    }

    User userWithPhoneNumber = userRepository.findByPhoneNumber(user.phoneNumber);
    if (userWithPhoneNumber != null) {
      throw new PhoneNumberExistsException("This phone number is already in use");
    }
    userRepository.save(user);
  }

  public void deleteUser(Long id) {
    User user = userRepository.findById(id);
    if(user == null) {
      return;
    }
    if(Objects.equals(user.role, "admin")) {
      throw new NotAllowedException("You cannot delete an admin user");
    }
    userRepository.deleteUser(id);
  }

}
