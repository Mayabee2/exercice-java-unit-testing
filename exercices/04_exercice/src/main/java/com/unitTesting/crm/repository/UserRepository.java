package com.unitTesting.crm.repository;

import com.aitesting.crm.domain.User;

public interface UserRepository {
  User findById(Long id);

  User findByPhoneNumber(String phoneNumber);

  void save(User user);

  void deleteUser(Long id);
}
