package com.rs.duan1.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private SinhVien sinhVien;
    public CustomUserDetails() {
        super();
    }

    public CustomUserDetails(SinhVien sinhVien) {
        super();
        this.sinhVien = sinhVien;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(sinhVien.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return sinhVien.getPassword();
    }

    @Override
    public String getUsername() {
        return sinhVien.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
