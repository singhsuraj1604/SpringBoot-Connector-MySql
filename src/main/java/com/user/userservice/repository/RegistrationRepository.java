package com.user.userservice.repository;
import com.user.userservice.dto.RegistrationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<RegistrationDto, Integer > {
   // public List<RegistrationDto> findById();
    // RegistrationDto getUserByUsername(String userName);
    public List<RegistrationDto> deleteById(int id);

   public  List<RegistrationDto> findByUserName(String userName);
}