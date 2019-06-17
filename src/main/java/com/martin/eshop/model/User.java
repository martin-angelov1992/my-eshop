package com.martin.eshop.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;

public class User implements UserDetails
{
    private boolean isEmployee;
    private boolean isAffiliate;
    private LocalDateTime registrationDate;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public User( String username, String password, Collection<? extends GrantedAuthority> authorities,
                 boolean isEmployee, boolean isAffiliate, LocalDateTime registrationDate ) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isEmployee = isEmployee;
        this.isAffiliate = isAffiliate;
        this.registrationDate = registrationDate;
    }

    public boolean isEmployee( )
    {
        return isEmployee;
    }

    public boolean isAffiliate( )
    {
        return isAffiliate;
    }

    public LocalDateTime getRegistrationDate( )
    {
        return registrationDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities( )
    {
        return authorities;
    }

    @Override
    public String getPassword( )
    {
        return password;
    }

    @Override
    public String getUsername( )
    {
        return username;
    }

    @Override
    public boolean isAccountNonExpired( )
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked( )
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired( )
    {
        return true;
    }

    @Override
    public boolean isEnabled( )
    {
        return true;
    }
}