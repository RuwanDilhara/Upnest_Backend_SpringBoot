package org.icet.upnest.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.User;
import org.icet.upnest.entity.UserEntity;
import org.icet.upnest.repository.UserRepository;
import org.icet.upnest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository repository;
    final ModelMapper mapper = new ModelMapper();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public List<User> getUsers() {
        return repository.findAll().stream().map(userEntity ->
                mapper.map(userEntity,User.class)).toList();
    }

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        UserEntity save = repository.save(mapper.map(user, UserEntity.class));
        return mapper.map(save,User.class);
    }
}
