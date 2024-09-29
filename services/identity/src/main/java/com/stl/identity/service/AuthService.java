package com.stl.identity.service;


import com.stl.identity.dto.request.RegisterRequestDTO;
import com.stl.identity.dto.response.UserResponseDTO;
import com.stl.identity.entity.User;
import com.stl.identity.mapper.UserMapper;
import com.stl.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO registerUser(User user) {
        var newUser = userRepository.save(user);
        return userMapper.toUserResponseDTO(newUser);
    }

    public Customer getCustomer(String nic) {
        Customer customer = this.repository.findByNIC(nic).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
        return customer;
    }
//    public String createCustomer(@Valid CustomerRequest request) {
//
//    }
}
