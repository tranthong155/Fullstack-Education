package com.rs.duan1.ServiceImpl;

import com.rs.duan1.Model.KhoaHoc;
import com.rs.duan1.Model.KhoaHocChinh;
import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.KhoaHocChinhReponsi;
import com.rs.duan1.Reponsitory.KhoaHocReponsi;
import com.rs.duan1.Reponsitory.MonHocReponsi;
import com.rs.duan1.Reponsitory.SinhVienReponsi;
import com.rs.duan1.Service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KhoaHocImpl implements KhoaHocService {

    @Autowired
    private KhoaHocReponsi khoaHocReponsi;

    @Autowired
    private KhoaHocChinhReponsi khoaHocChinhReponsi;

    @Autowired
    private MonHocReponsi monHocReponsi;

    @Autowired
    private SinhVienReponsi sinhVienReponsi;

    @Override
    public List<KhoaHoc> getAll() {
        return this.khoaHocReponsi.findAll();
    }

    @Override
    public KhoaHoc findByKhoaHocId(Long khoaHocId) {
        return this.khoaHocReponsi.findById(khoaHocId)
                .orElse(null);
    }



    @Override
    public KhoaHoc luuKhoaHoc(KhoaHoc khoaHoc) {
        if(khoaHoc.isDangKy()==true){
            khoaHoc.setDangKy(false);
            return khoaHocReponsi.save(khoaHoc);
        }else  if(khoaHoc.isDangKy()!=true){
            khoaHoc.setDangKy(true);
            return khoaHocReponsi.save(khoaHoc);
        }
        return khoaHocReponsi.save(khoaHoc);

    }


    @Override
    public void DANGKYKhoaHoc(Long idKhoaHoc, Long idSinhVien) {
        Optional<SinhVien> student = sinhVienReponsi.findById(idSinhVien);
        Optional<KhoaHoc> course = khoaHocReponsi.findById(idKhoaHoc);

        if (student.isPresent() && course.isPresent()) {
            SinhVien sinhVien = student.get();
            KhoaHoc khoaHoc = course.get();

            // Kiểm tra nếu sinh viên đã đăng ký khóa học này chưa để tránh vòng lặp
            if (!sinhVien.getCourses().contains(khoaHoc)) {
                sinhVien.getCourses().add(khoaHoc);
                sinhVienReponsi.save(sinhVien);
            }
        }
    }


    @Override
    public Set<KhoaHoc> getKhoaHocsBySinhVienId(Long idSinhVien) {
        Optional<SinhVien> optionalSinhVien = sinhVienReponsi.findById(idSinhVien);
        return optionalSinhVien.map(SinhVien::getCourses).orElse(null);
    }

    @Override
    public void HUYKhoaHoc(Long idKhoaHoc, Long idSinhVien) {
        Optional<SinhVien> optionalSinhVien = sinhVienReponsi.findById(idSinhVien);
        Optional<KhoaHoc> optionalKhoaHoc = khoaHocReponsi.findById(idKhoaHoc);

        if (optionalSinhVien.isPresent() && optionalKhoaHoc.isPresent()) {
            SinhVien sinhVien = optionalSinhVien.get();
            KhoaHoc khoaHoc = optionalKhoaHoc.get();
            sinhVien.getCourses().remove(khoaHoc);
            khoaHoc.getStudents().remove(sinhVien);
            sinhVienReponsi.save(sinhVien);
            khoaHocReponsi.save(khoaHoc);
        }
    }

    @Override
    public boolean isDangKyKhoaHoc(Long idKhoaHoc, Long idSinhVien) {
        Optional<SinhVien> optionalSinhVien = sinhVienReponsi.findById(idSinhVien);
        Optional<KhoaHoc> optionalKhoaHoc = khoaHocReponsi.findById(idKhoaHoc);

        if (optionalSinhVien.isPresent() && optionalKhoaHoc.isPresent()) {
            SinhVien sinhVien = optionalSinhVien.get();
            KhoaHoc khoaHoc = optionalKhoaHoc.get();
            return sinhVien.getCourses().contains(khoaHoc);
        }

        return false;
    }

    @Override
    public List<KhoaHoc> serchKhoaHoc(String keyword) {
        return this.khoaHocReponsi.serchKhoaHocRps(keyword);

    }

    @Override
    public Page<KhoaHoc> serchKhoaHocPage(String keyword, Integer pageNo) {
        List list = this.serchKhoaHoc(keyword);
        Pageable pageable = PageRequest.of(pageNo - 1, 10);

        Integer start = (int) pageable.getOffset();
        Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
                : pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<KhoaHoc>(list, pageable, this.serchKhoaHoc(keyword).size());
    }

    @Override
    public Page<KhoaHoc> getAllKH(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 10);
        return this.khoaHocReponsi.findAll(pageable);
    }


    @Override
    public List<KhoaHocChinh> getAllKhoaHocChinh() {
        return this.khoaHocChinhReponsi.findAll();
    }

    @Override
    public KhoaHocChinh findIdKHC(Long idKHC) {
        return this.khoaHocChinhReponsi.findById(idKHC).orElse(null);
    }

    @Override
    public Boolean create(KhoaHoc khoaHoc) {
        try {

            this.khoaHocReponsi.save(khoaHoc);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;}

    @Override
    public Boolean update(KhoaHoc khoaHoc) {
            try {
                this.khoaHocReponsi.save(khoaHoc);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
    }

    @Override
    public Boolean delete(Long id) {
                monHocReponsi.deleteByKhoaHocId(id);
                this.khoaHocReponsi.delete(findByKhoaHocId(id));
                return true;
    }




}
