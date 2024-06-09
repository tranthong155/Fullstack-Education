package com.rs.duan1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String hoTen;
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String userName;
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;
    @NotBlank(message = "Số điện thoại không được để trống")
    private String Sdt;
    private String email;
    private String role;
    private String hinhAnh;
    private String matKhauCu;
    private String maXacNhan;



    @OneToMany(mappedBy = "sinhVien")
    private Set<KhoaHoc> KhoaHoc;




    @ManyToMany
    @JoinTable(
            name = "khdangky",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<KhoaHoc> courses = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(idUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SinhVien sinhVien = (SinhVien) obj;
        return idUser.equals(sinhVien.idUser);
    }

}
