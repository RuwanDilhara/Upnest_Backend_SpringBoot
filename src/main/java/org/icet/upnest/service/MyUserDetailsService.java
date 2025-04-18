package org.icet.upnest.service;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.User;
import org.icet.upnest.dto.UserPrincipal;
import org.icet.upnest.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    final UserRepository repository;
    final ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = mapper.map(repository.findByUsername(username),User.class);
        if (user == null){
            System.out.println("User not found !");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
