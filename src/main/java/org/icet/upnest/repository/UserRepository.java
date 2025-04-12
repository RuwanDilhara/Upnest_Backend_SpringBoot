package org.icet.upnest.repository;

import org.icet.upnest.dto.User;
import org.icet.upnest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
}