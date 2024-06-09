package com.rs.duan1.Service;
import com.rs.duan1.Model.CustomUserDetails;
import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.SinhVienReponsi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private SinhVienReponsi sinhVienReponsi;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SinhVien sinhVien = sinhVienReponsi.findByUserName(username);
        if (sinhVien == null) {
            throw new UsernameNotFoundException("Tài khoản ko đúng");
        }
//
        return new CustomUserDetails(sinhVien);
    }
}
