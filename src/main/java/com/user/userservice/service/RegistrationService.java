package com.user.userservice.service;

import com.user.userservice.dto.RegistrationDto;
import com.user.userservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RegistrationService {
    @Autowired
    public RegistrationRepository registrationRepository;

    public RegistrationDto createUserEntity(RegistrationDto user) {
        return registrationRepository.save(user);
    }

    public List<RegistrationDto> getAllUser() {
        return registrationRepository.findAll();
    }

    public Optional<RegistrationDto> getUserDetails(int id) {
        return registrationRepository.findById(id);
    }

    public RegistrationDto updateUserDetails(int id, RegistrationDto user) {
        Optional<RegistrationDto> existingUser = registrationRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            RegistrationDto updatedUser = existingUser.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setUserAge(user.getUserAge());
            registrationRepository.save(updatedUser);

        }
        return user;
    }
    public void userDelete(int id) {
        registrationRepository.deleteById(id);

    }
  public List<RegistrationDto> getAllUserDetailsByUsername(String userName) {
    return registrationRepository.findByUserName(userName);
    }
}