package com.rs.duan1.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SInhVienDTO {

    @NotBlank(message = "Nhập lại tài khoản")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Nhập lại mật khẩu")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Nhập lại mật khẩu")
    @Size(min = 10, max = 10, message = "Số điện thoại phải có đúng 10 ký tự")
    private String Sdt;

    @NotBlank(message = "Nhập lại Email")
    @Email(message = "Email should be valid")
    private String email;
}
