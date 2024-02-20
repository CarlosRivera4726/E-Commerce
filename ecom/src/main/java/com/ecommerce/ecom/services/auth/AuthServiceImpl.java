package com.ecommerce.ecom.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.dto.SignupRequest;
import com.ecommerce.ecom.dto.UserDto;
import com.ecommerce.ecom.entity.User;
import com.ecommerce.ecom.enums.UserRol;
import com.ecommerce.ecom.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequest signupRequest)
    {
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setRole(UserRol.CUSTOMER);

        User createdUser = userRepository.save(user);

        UserDto userDto = new UserDto();

        userDto.setId_user(createdUser.getId_user());

        return userDto;
    }

    public Boolean hasUserWithEmail(String email)
    {
        return userRepository.findFirstByEmail(email).isPresent();
    }


    @PostConstruct
    public void createAdminAccount()
    {
        User adminAccount = userRepository.findByRole(UserRol.ADMIN);
        if(adminAccount == null)
        {
            User user = new User();
            user.setEmail("admin@mail.com");
            user.setName("Admin");
            user.setRole(UserRol.ADMIN);
            user.setPassword(bCryptPasswordEncoder.encode("admin"));
            userRepository.save(user);
        }
    }

}
