package com.rs.duan1.Controller;

import com.rs.duan1.Model.KhoaHoc;
import com.rs.duan1.Model.KhoaHocChinh;
import com.rs.duan1.Model.MonHoc;
import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.KhoaHocReponsi;
import com.rs.duan1.Reponsitory.MonHocReponsi;
import com.rs.duan1.Reponsitory.SinhVienReponsi;
import com.rs.duan1.Service.KhoaHocService;
import com.rs.duan1.Service.MonHocService;
import com.rs.duan1.Service.SinhVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
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

    @GetMapping("/")
    public String home(Model model, @Param("keyword") String keyword,
                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo  ) {
        List<KhoaHoc> listKhoaHoc = this.khoaHocService.getAll();
        model.addAttribute("listKhoaHoc", listKhoaHoc);

        List<MonHoc> listMonHoc = this.monHocService.getAllMonHoc();
        model.addAttribute("listMonHoc", listMonHoc);

        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);


        Page<KhoaHoc> list = this.khoaHocService.getAllKH(pageNo);
        if (keyword != null) {
            list = this.khoaHocService.serchKhoaHocPage(keyword, pageNo);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        model.addAttribute("list", list);



        return "index";
    }

    @GetMapping("/showInfo")
    public String edit(Model model,@RequestParam("idKhoaHoc") Long idKhoaHoc,
                       @RequestParam(name = "IdSV", defaultValue = "0") Long idSinhVien, HttpSession session) {
        KhoaHoc selectedKhoaHoc = this.khoaHocService.findByKhoaHocId(idKhoaHoc);
        model.addAttribute("selectedKhoaHoc", selectedKhoaHoc);
        List<MonHoc> listinfoMH = this.monHocReponsi.showList(khoaHocService.findByKhoaHocId(idKhoaHoc));
        model.addAttribute("listinfoMH", listinfoMH);
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);
        boolean isDangKyByCurrentUser = khoaHocService.isDangKyKhoaHoc(idKhoaHoc, idSinhVien);

        model.addAttribute("isDangKyByCurrentUser", isDangKyByCurrentUser);


        return "layout/SinhVien/gioHang";
    }

    @GetMapping("/showVideo")
    public String showVideo(Model model,@RequestParam("idKhoaHoc") Long idKhoaHoc,
                            @RequestParam("idMH") Long idMH,
                       @RequestParam(name = "IdSV", defaultValue = "0") Long idSinhVien, HttpSession session) {
        KhoaHoc selectedKhoaHoc = this.khoaHocService.findByKhoaHocId(idKhoaHoc);
        model.addAttribute("selectedKhoaHoc", selectedKhoaHoc);
        List<MonHoc> listinfoMH = this.monHocReponsi.showList(khoaHocService.findByKhoaHocId(idKhoaHoc));
        model.addAttribute("listinfoMH", listinfoMH);

        MonHoc selecIDMH = monHocService.findByMonHocId(idMH);
        model.addAttribute("selecIDMH", selecIDMH);

        return "layout/SinhVien/layouVideo";
    }

    @GetMapping("/showList-{id}")
    public String showList(Model model, @PathVariable("id") Long idKhoaHoc,@Param("keyword") String keyword,
                           @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo ) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        KhoaHoc selectedKhoaHoc = this.khoaHocService.findByKhoaHocId(idKhoaHoc);
        model.addAttribute("selectedKhoaHoc", selectedKhoaHoc);

        List<KhoaHoc> listinfoKHC = this.khoaHocReponsi.showListKH(khoaHocService.findIdKHC(idKhoaHoc));
        model.addAttribute("listinfoMH", listinfoKHC);

        KhoaHocChinh showIDkhc = khoaHocService.findIdKHC(idKhoaHoc);
        model.addAttribute("showIDkhc", showIDkhc);


        Page<KhoaHoc> list = this.khoaHocService.getAllKH(pageNo);
        if (keyword != null) {
            list = this.khoaHocService.serchKhoaHocPage(keyword, pageNo);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        model.addAttribute("list", list);

        return "index";
    }

    @GetMapping("/DkKhoaHoc")
    public String luuKhoaHoc(@RequestParam("idKH") Long idKhoaHoc, @RequestParam(value = "idSV", defaultValue = "0") Long idSinhVien) {
//        KhoaHoc selectedKhoaHoc = this.khoaHocService.findByKhoaHocId(idKhoaHoc);
//        selectedKhoaHoc = this.khoaHocService.luuKhoaHoc(selectedKhoaHoc);

        khoaHocService.DANGKYKhoaHoc(idKhoaHoc,idSinhVien);

        return "redirect:/showInfo?idKhoaHoc=" + idKhoaHoc + "&IdSV=" + idSinhVien;
    }

    @GetMapping("/huyKhoaHoc")
    public String huyKhoaHoc(@RequestParam("idKH") Long idKhoaHoc, @RequestParam("idSV") Long idSinhVien) {
        khoaHocService.HUYKhoaHoc(idKhoaHoc, idSinhVien);
        return "redirect:/showInfo?idKhoaHoc=" + idKhoaHoc + "&IdSV=" + idSinhVien;
    }


    @GetMapping("ShowThongTin-{id}")
    public String showInfo(Model model,@PathVariable("id") Long idMonHoc) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        SinhVien listIDsv = sinhVienService.findBySVId(idMonHoc);
        model.addAttribute("listIDsv", listIDsv);

        Set<KhoaHoc> khoaHocs = khoaHocService.getKhoaHocsBySinhVienId(idMonHoc);
        model.addAttribute("khoaHocs", khoaHocs);

        return "layout/ThongTin/layoutThongTin";

    }


    @GetMapping("KhoaHocCuaToi-{id}")
    public String khoaHocCuaToi(@PathVariable("id") Long idMonHoc,Model model) {
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        Set<KhoaHoc> khoaHocs = khoaHocService.getKhoaHocsBySinhVienId(idMonHoc);
        model.addAttribute("khoaHocs", khoaHocs);
        return "layout/ThongTin/layoutKHCuaToi";
    }






}
