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

	public SinhVien(Long idUser, String hoTen, @NotBlank(message = "Tên đăng nhập không được để trống") String userName,
			@NotBlank(message = "Mật khẩu không được để trống") @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự") String password,
			@NotBlank(message = "Số điện thoại không được để trống") String sdt, String email, String role,
			String hinhAnh, String matKhauCu, String maXacNhan, Set<com.rs.duan1.Model.KhoaHoc> khoaHoc,
			Set<com.rs.duan1.Model.KhoaHoc> courses) {
		super();
		this.idUser = idUser;
		this.hoTen = hoTen;
		this.userName = userName;
		this.password = password;
		Sdt = sdt;
		this.email = email;
		this.role = role;
		this.hinhAnh = hinhAnh;
		this.matKhauCu = matKhauCu;
		this.maXacNhan = maXacNhan;
		KhoaHoc = khoaHoc;
		this.courses = courses;
	}
    
    public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMatKhauCu() {
		return matKhauCu;
	}

	public void setMatKhauCu(String matKhauCu) {
		this.matKhauCu = matKhauCu;
	}

	public String getMaXacNhan() {
		return maXacNhan;
	}

	public void setMaXacNhan(String maXacNhan) {
		this.maXacNhan = maXacNhan;
	}

	public Set<KhoaHoc> getKhoaHoc() {
		return KhoaHoc;
	}

	public void setKhoaHoc(Set<KhoaHoc> khoaHoc) {
		KhoaHoc = khoaHoc;
	}

	public Set<KhoaHoc> getCourses() {
		return courses;
	}

	public void setCourses(Set<KhoaHoc> courses) {
		this.courses = courses;
	}
    

}
