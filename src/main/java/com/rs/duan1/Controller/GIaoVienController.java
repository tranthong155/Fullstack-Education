package com.rs.duan1.Controller;


import com.rs.duan1.Model.KhoaHoc;
import com.rs.duan1.Model.KhoaHocChinh;
import com.rs.duan1.Model.MonHoc;
import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.MonHocReponsi;
import com.rs.duan1.Service.KhoaHocService;
import com.rs.duan1.Service.MonHocService;
import com.rs.duan1.Service.SinhVienService;
import com.rs.duan1.Service.StorageSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class GIaoVienController {

    @Autowired
    private KhoaHocService khoaHocService;
    @Autowired
    private MonHocService monHocService;

    @Autowired
    private MonHocReponsi monHocReponsi;

    @Autowired
    private SinhVienService sinhVienService;



    @Autowired
    private StorageSevrice storageSevrice;



    @GetMapping("/addKhoaHoc-{id}")
    public String home(Model model,@PathVariable("id") Long idMonHoc) {
        List<KhoaHoc> listKhoaHoc = this.khoaHocService.getAll();
        model.addAttribute("listKhoaHoc", listKhoaHoc);

        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        KhoaHocChinh findByKHC = this.khoaHocService.findIdKHC(idMonHoc);
        model.addAttribute("findByKHC", findByKHC);

        KhoaHoc khoaHoc = new KhoaHoc();
        model.addAttribute("khoaHoc", khoaHoc);

        KhoaHoc selectedKH = this.khoaHocService.findByKhoaHocId(idMonHoc);
        model.addAttribute("selectedKH", selectedKH);

        SinhVien selectIDSV = sinhVienService.findBySVId(idMonHoc);
        model.addAttribute("selectIDSV", selectIDSV);

        return "layout/GiaoVien/layoutAdd";
    }

    @PostMapping("/saveKhoaHoc-{id}")
    public String save(Model model,@ModelAttribute("KhoaHoc") KhoaHoc khoaHoc,@PathVariable("id") Long idKH, @RequestParam("fileImage") MultipartFile file) {

        this.storageSevrice.store(file);
        String fileName = file.getOriginalFilename();
        SinhVien sinhVien = sinhVienService.findBySVId(idKH);
        khoaHoc.setSinhVien(sinhVien);
        khoaHoc.setImg(fileName);


        if (this.khoaHocService.create(khoaHoc)) {

            return "redirect:/";
        } else {

            return "redirect:/";
        }
    }


    @GetMapping("/editKH")
    public String showEdit(@RequestParam("idKhoaHoc") Long idKH,@RequestParam("idSV") Long idSV,Model model){
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        KhoaHoc selectedKhoaHoc = this.khoaHocService.findByKhoaHocId(idKH);
        model.addAttribute("selectedKhoaHoc", selectedKhoaHoc);

        KhoaHocChinh selectIdKHC = this.khoaHocService.findIdKHC(idKH);
        model.addAttribute("selectIdKHC", selectIdKHC);

        return "layout/GiaoVien/layoutEdit";
    }
    @PostMapping("/editKH")
    public String SuaKhoaHoc(@ModelAttribute("KhoaHoc") KhoaHoc khoaHoc,@RequestParam("idKhoaHoc") Long idKH,
                             @RequestParam("idSV") Long idSV,Model model,@RequestParam("fileImage") MultipartFile file){
        this.storageSevrice.store(file);
        String fileName = file.getOriginalFilename();
        SinhVien sinhVien = sinhVienService.findBySVId(idSV);
        khoaHoc.setSinhVien(sinhVien);
        khoaHoc.setImg(fileName);
        this.khoaHocService.create(khoaHoc);
        return "redirect:/showInfo?idKhoaHoc=" + idKH + "&IdSV=" +idSV;
    }

    @GetMapping("/deleteKH-{id}")
    public  String xoaKhoaHoc(@PathVariable("id") Long idKH){

        this.khoaHocService.delete(idKH);
        return "redirect:/";
    }


    @GetMapping("ShowaddMonHoc")
    public String ShowaddMonHoc(Model model,@RequestParam("idKhoaHoc") Long idKH,
                                @RequestParam("idSV") Long idSV){
        List<KhoaHocChinh> listKHChinh = this.khoaHocService.getAllKhoaHocChinh();
        model.addAttribute("listKHChinh", listKHChinh);

        KhoaHoc selectedKhoaHoc = this.khoaHocService.findByKhoaHocId(idKH);
        model.addAttribute("selectedKhoaHoc", selectedKhoaHoc);

        MonHoc monHoc = new MonHoc();
        model.addAttribute("monHoc", monHoc);
        return "layout/GiaoVien/MonHoc/layoutAdd";

    }


    @PostMapping("/addMonHoc")
    public String saveMomHoc(Model model,@ModelAttribute("MonHoc") MonHoc monHoc,@RequestParam("idKhoaHoc") Long idKH,
                             @RequestParam("idSV") Long idSV, @RequestParam("videoFile") MultipartFile videoFile) {
        KhoaHoc khoaHoc = khoaHocService.findByKhoaHocId(idKH);
        monHoc.setKhoaHoc(khoaHoc);
        model.addAttribute("monHocfile", videoFile);
        if (!videoFile.isEmpty()) {
            try {
                // Thay đổi đường dẫn theo nhu cầu của bạn
                Path uploadPath = Paths.get("src/main/resources/static/upload/video");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                String fileName = videoFile.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(videoFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Lưu đường dẫn video vào đối tượng MonHoc
                monHoc.setVideos(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // xử lý lỗi nếu cần
            }
        }
        if (this.monHocService.create(monHoc)) {
            return "redirect:/showInfo?idKhoaHoc=" + idKH + "&IdSV=" +idSV;
        } else {
            return "redirect:/showInfo?idKhoaHoc=" + idKH + "&IdSV=" +idSV;
        }
    }


    @GetMapping("/deleteMonHoc-{id}")
    public  String deleteMonHoc(Model model,@ModelAttribute("MonHoc") MonHoc monHoc,@PathVariable("id")Long id,@RequestParam("idKhoaHoc") Long idKH,
                                @RequestParam("idSV") Long idSV){
    this.monHocService.delete(id);
        return "redirect:/showInfo?idKhoaHoc=" + idKH + "&IdSV=" +idSV;
    }





}
