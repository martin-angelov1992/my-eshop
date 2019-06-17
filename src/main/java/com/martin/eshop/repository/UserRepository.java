package com.martin.eshop.repository;

import com.martin.eshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Basic user repository. Can be replaced by a proper one later.
@Repository
public class UserRepository
{
    private Map<String, User> userMap = new HashMap<>(  );

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUsers() {
        List<GrantedAuthority> authorities = new ArrayList<>(  );
        String encodedPassword = passwordEncoder.encode( "password" );
        authorities.add( new SimpleGrantedAuthority( "customer" ) );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" );
        LocalDateTime oldDateTime = LocalDateTime.parse( "2015-04-08 12:30", formatter );
        LocalDateTime newDateTime = LocalDateTime.parse( "2019-04-08 12:30", formatter );
        User[] users = new User[]{new User("employee", encodedPassword, authorities,
                                           true, false, newDateTime ),
                                  new User("affiliate", encodedPassword, authorities,
                                           false, true, newDateTime ),
                                  new User("oldTimeEmployee", encodedPassword, authorities,
                                           false, false, oldDateTime)};

        for ( User user: users ) {
            userMap.put( user.getUsername(), user );
        }
    }

    public User getUserByUsername(String username) {
        return userMap.get( username );
    }
}