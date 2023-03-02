package com.user.userservice.controllers;
import com.user.userservice.dto.RegistrationDto;
import com.user.userservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class  RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping
    public RegistrationDto createUserEntity(@RequestBody RegistrationDto user) {
        return registrationService.createUserEntity(user);
    }
    @GetMapping("/getAllUserDetails")
    public List<RegistrationDto> getAllUser() {
        return registrationService.getAllUser();
    }
    @GetMapping("/getAllUserDetails/{userId}")
    public Optional<RegistrationDto> getUserDetails(@PathVariable("userId") int id) {
        return registrationService.getUserDetails(id);
    }
    @PutMapping("/updateUser/{id}")
    public RegistrationDto updateUser(@RequestBody RegistrationDto user,@PathVariable Integer id) {
        registrationService.updateUserDetails(id,user);
        return user;
    }
    @DeleteMapping("/getAllUserDetails/{id}")
    public void deleteUserDetails(@PathVariable Integer id)
    {
        registrationService.userDelete(id);
    }
  @GetMapping("/getUserDetails")
    @ResponseBody
    public List<RegistrationDto> getAllUserDetailsByUsername(@RequestParam(name="userName") String userName) {
      return registrationService.getAllUserDetailsByUsername(userName);
  }

}