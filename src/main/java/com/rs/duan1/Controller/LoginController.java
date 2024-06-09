package com.rs.duan1.Controller;

import com.rs.duan1.DTO.SInhVienDTO;
import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.SinhVienReponsi;
import com.rs.duan1.Service.SinhVienService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class LoginController {

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private SinhVienReponsi sinhVienReponsi;
    @Autowired
    private PasswordEncoder passwordEncoder;




    @PostMapping("/signin")
    public String handleLogin( @RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        SinhVien sinhVien = sinhVienReponsi.findByUserName(username);
        if (sinhVien != null && passwordEncoder.matches(password, sinhVien.getPassword())) {
            session.setAttribute("hoTen", sinhVien.getHoTen());
            session.setAttribute("username", username);
            session.setAttribute("getRole", sinhVien.getRole());
            session.setAttribute("getIdSinhVien", sinhVien.getIdUser());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "redirect:/";
        }
    }



    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("sinhVien") SinhVien sinhVien, @RequestParam("img") MultipartFile file, HttpSession session)
            throws IOException {

        String imageName = file.isEmpty() ? "default.jpg" : file.getOriginalFilename();
        sinhVien.setHinhAnh(imageName);
        SinhVien saveUser = sinhVienService.saveUser(sinhVien);

        if (!ObjectUtils.isEmpty(saveUser)) {
            if (!file.isEmpty()) {
                File saveFile = new ClassPathResource("static/upload").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator +  File.separator
                        + file.getOriginalFilename());

//				System.out.println(path);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
            session.setAttribute("succMsg", "Register successfully");
        } else {
            session.setAttribute("errorMsg", "something wrong on server");
        }

        return "redirect:/";
    }
}
