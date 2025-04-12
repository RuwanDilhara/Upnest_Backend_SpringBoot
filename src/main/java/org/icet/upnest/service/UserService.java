package org.icet.upnest.service;

import org.icet.upnest.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    List<User> getUsers ();
    User register (User user);
    String verify(User user);
}
