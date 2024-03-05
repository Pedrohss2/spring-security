package com.pedro.demo.services;

import com.pedro.demo.entities.UserRole;
import com.pedro.demo.entities.User;
import com.pedro.demo.projection.UserDetailsProjection;
import com.pedro.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repostory;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repostory.searchUserAndRolesByEmail(username);

        if(result.isEmpty()) {
                throw new UsernameNotFoundException("User not found!");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());

        for(UserDetailsProjection role : result) {
            user.addRole(new UserRole(role.getRoleId(), role.getAuthotiry()));
        }

        return user;
    }
}
