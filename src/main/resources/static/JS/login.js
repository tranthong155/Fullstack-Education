document.addEventListener("DOMContentLoaded", function() {
    var showThongTin = document.querySelector(".ShowThongTin");
    var hienToanBoTT = document.querySelector(".hienToanBoTT");

    showThongTin.addEventListener("mouseenter", function() {
        hienToanBoTT.classList.add("show");
    });

    showThongTin.addEventListener("mouseleave", function() {
        hienToanBoTT.classList.remove("show");
    });
});




var nut = document.querySelector(".header_DangNhap");
var xoabo1 = document.querySelector(".hiddenALl");
var xoabo2 = document.querySelector(".modal__inner--dangNhap");
var bodyDangNhap = document.querySelector(".bodyDangNhap");

nut.onclick = function(){
    bodyDangNhap.classList.add("ative");
    xoabo1.onclick = function(){
        bodyDangNhap.classList.remove("ative");
    }
    xoabo2.onclick = function(){
        bodyDangNhap.classList.remove("ative");
    }
}



var nut2 = document.querySelector(".header_DangKy");
var bodyDangKy = document.querySelector(".bodyDangKy")
var xoabo3 = document.querySelector(".hiddenALl__dangKy");
var xoabo4 = document.querySelector(".modal__inner--dangKy");


nut2.onclick = function(){
    bodyDangKy.classList.add("ative");

    xoabo3.onclick = function(){
        bodyDangKy.classList.remove("ative");
    }
    xoabo4.onclick = function(){
        bodyDangKy.classList.remove("ative");
    }
}



