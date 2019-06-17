package com.martin.eshop.service.jwt;

import com.martin.eshop.repository.UserRepository;
import com.martin.eshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService
    implements UserDetailsService
{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String username )
        throws
        UsernameNotFoundException
    {
        User user = userRepository.getUserByUsername( username );

        return user;
    }
}