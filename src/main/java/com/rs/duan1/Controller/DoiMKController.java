package com.rs.duan1.Controller;

import com.rs.duan1.Config.EmailUtil;
import com.rs.duan1.Model.KhoaHocChinh;
import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.KhoaHocReponsi;
import com.rs.duan1.Reponsitory.MonHocReponsi;
import com.rs.duan1.Reponsitory.SinhVienReponsi;
import com.rs.duan1.Service.KhoaHocService;
import com.rs.duan1.Service.MonHocService;
import com.rs.duan1.Service.SinhVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller

public class DoiMKController {

    @Autowired
    private KhoaHocService khoaHocService;
    @Autowired
    private MonHocService monHocService;

    @Autowired
    private MonHocReponsi monHocReponsi;

    @Autowired
    private SinhVienReponsi sinhVienReponsi;

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private KhoaHocReponsi khoaHocReponsi;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/DoiMatKhau-{id}")
    public String layOutdoiMatKhau(@PathVariable("id") Long idMonHoc, Model model) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);
        return "layout/ThongTin/layoutDoiMatKhau";
    }


    @PostMapping("/DoiMatKhau-{id}")
    public String doiMatKhau(@PathVariable("id") Long idSinhVien,
                             @RequestParam("mkCu") String mkCu, @RequestParam("nhapLai") String nhapLai,
                             @RequestParam("mkMoi") String mkMoi, HttpSession session, Model model) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        SinhVien sinhVien = sinhVienService.findBySVId(idSinhVien);
//        model.addAttribute("sinhVien", sinhVien);
        if (sinhVien != null && passwordEncoder.matches(mkCu, sinhVien.getPassword())) {
            if (mkCu.equals(nhapLai)) {
                sinhVien.setMatKhauCu(mkMoi);
                // Cập nhật mật khẩu mới
                sinhVien.setPassword(passwordEncoder.encode(mkMoi));
                boolean isUpdated = sinhVienService.updateMK(sinhVien);
                if (isUpdated) {
                    model.addAttribute("success", "Mật khẩu đã được thay đổi thành công.");
                } else {
                    model.addAttribute("error", "Có lỗi xảy ra khi thay đổi mật khẩu.");
                }
            } else {
                model.addAttribute("error", "Mật khẩu cũ không khớp.");
            }
        } else {
            model.addAttribute("error", "Mật khẩu cũ không đúng.");
        }

        return "layout/ThongTin/layoutDoiMatKhau";
    }

    @GetMapping("/quenMatKhau")
    public String LayOutquenMatKhau(Model model) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);


        return "layout/ThongTin/layoutQuenMatKhau";
    }

    @PostMapping("/xacNhanMa")
    public String quenMatKhau(Model model,@RequestParam("email") String email) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);
        Random random = new Random();
        // Tạo một số ngẫu nhiên từ 100000 đến 999999
        int randomNumber = random.nextInt(900000) + 100000;
        // Chuyển đổi số ngẫu nhiên thành chuỗi
        String randomCode = String.valueOf(randomNumber);
        // Thêm mã vào model
        model.addAttribute("randomCode", randomCode);

        SinhVien maXacNhanSV = sinhVienReponsi.SVByEmail(email);
        maXacNhanSV.setMaXacNhan(randomCode);
        sinhVienReponsi.save(maXacNhanSV); // Cập nhật đối tượng SinhVien trong cơ sở dữ liệu
        model.addAttribute("maXacNhanSV", maXacNhanSV);

        EmailUtil emailUtil = new EmailUtil();
        emailUtil.sendEmail(email, System.currentTimeMillis() + "", emailUtil.noiDung(email,maXacNhanSV.getMaXacNhan()));


        return "layout/ThongTin/xacNhanMa";
    }

    @PostMapping("/xacNhanDoiMatKhau")
    public String xacNhanDoiMatKhau(Model model,@RequestParam("idUser") Long idUser,@RequestParam("maXacNhan") String maXacNhan) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);
        SinhVien sinhVien = sinhVienService.findBySVId(idUser);
        model.addAttribute("maXacNhanSV", sinhVien);

        if(maXacNhan.equals(sinhVien.getMaXacNhan())){
            return "layout/ThongTin/xacNhanDoiMatKhau";
        }else {
            model.addAttribute("saiMa", "Xin hãy nhập mã đúng");
            return "layout/ThongTin/xacNhanMa";
        }

    }


    @GetMapping("/thayDoiMatKhau")
    public String thayDoiMatKhau(Model model,@RequestParam("idUser") Long idUser
            ,@RequestParam("nhapLai") String nhapLai
            ,@RequestParam("mkMoi") String mkMoi) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);
        SinhVien sinhVien = sinhVienService.findBySVId(idUser);
        model.addAttribute("maXacNhanSV", sinhVien);

        if(nhapLai.equals(mkMoi)){
                sinhVien.setMatKhauCu(mkMoi);
                // Cập nhật mật khẩu mới
                sinhVien.setPassword(passwordEncoder.encode(mkMoi));
                boolean isUpdated = sinhVienService.updateMK(sinhVien);
                if (isUpdated) {
                    model.addAttribute("success", "Mật khẩu đã được thay đổi thành công.");
                } else {
                    model.addAttribute("error", "Có lỗi xảy ra khi thay đổi mật khẩu.");
                }
            } else {
                model.addAttribute("error", "Mật khẩu cũ không khớp.");
            }




        return "layout/ThongTin/xacNhanDoiMatKhau";
    }
}
