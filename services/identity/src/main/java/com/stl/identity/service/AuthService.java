package com.stl.identity.service;


import com.stl.identity.dto.request.LoginRequestDTO;
import com.stl.identity.dto.request.RegisterRequestDTO;
import com.stl.identity.dto.response.LoginResponseDTO;
import com.stl.identity.dto.response.UserResponseDTO;
import com.stl.identity.entity.User;
import com.stl.identity.exception.UserNotFoundException;
import com.stl.identity.mapper.UserMapper;
import com.stl.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private EncryptionService encryptionService;

    public UserResponseDTO registerUser(User user) {
        if(userRepository.findByMobileNumber(user.getMobileNumber()).isPresent()){
            throw new IllegalStateException("user already exists");
        }
        User newuser = new User();
        newuser.setEmail(user.getEmail());
        newuser.setFirstname(user.getFirstname());
        newuser.setLastname(user.getLastname());
        newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
        newuser.setMobileNumber(user.getMobileNumber());
        User saved =userRepository.save(newuser);

        return userMapper.toUserResponseDTO(saved);
    }



    public LoginResponseDTO login(LoginRequestDTO user) {
        User current = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new UserNotFoundException("User Not Found!"));

        if (encryptionService.verifyPassword(user.getPassword(), current.getPassword())) {
            String token = jwtService.generateJWT(current);
            return new LoginResponseDTO(userMapper.toUserResponseDTO(current), token);
        } else {
            throw new IllegalStateException("Password is incorrect!");
        }

    }


//    public String createCustomer(@Valid CustomerRequest request) {
//
//    }
}
