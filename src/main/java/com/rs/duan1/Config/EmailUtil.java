package com.rs.duan1.Config;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {
    static final String from = "tranthong155@gmail.com";
    static final String password = "ecoiroqatvhltjjz";

    public static boolean sendEmail(String to, String tieuDe, String noiDung) {
        // Properties : khai báo các thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Phiên làm việc
        Session session = Session.getInstance(props, auth);

        // Tạo một tin nhắn
        MimeMessage msg = new MimeMessage(session);

        try {
            // Kiểu nội dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

            // Người gửi
            msg.setFrom(new InternetAddress(from));

            // Người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Tiêu đề email
            msg.setSubject(tieuDe);

            // Quy đinh ngày gửi
            msg.setSentDate(new Date());

            // Nội dung
            msg.setContent(noiDung, "text/HTML; charset=UTF-8");

            // Gửi email
            Transport.send(msg);
            System.out.println("Gửi email thành công");
            return true;
        } catch (Exception e) {
            System.out.println("Gặp lỗi trong quá trình gửi email");
            e.printStackTrace();
            return false;
        }
    }

    public String noiDung(String tenEmail, String maXacNhan) {
        String noiDung = "<figure class=\"table\">\n" +
                "<table style=\"background-color:rgb(255, 255, 255);\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td style=\"padding:0px;\">&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:0px;\">Mã đặt lại mật khẩu</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:25px 0px 0px;\">Xin dùng mã này để đặt lại mật khẩu cho tài khoản " + tenEmail + ".</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:25px 0px 0px;\">Đây là mã của bạn: <span style=\"color:rgb(42,42,42);\">\n" +
                "<strong>" + maXacNhan + "</strong>\n" +
                "</span>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:25px 0px 0px;\">&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:25px 0px 0px;\">Xin cám ơn</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"padding:0px;\">&nbsp;</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</figure>\n" +
                "<p>\n" +
                "<br>&nbsp;</p>";
        return noiDung;
    }



    public static void main(String[] args) {
        EmailUtil emailUtil = new EmailUtil(); // Tạo một đối tượng EmailUtil
        emailUtil.sendEmail("tranthong717@gmail.com", System.currentTimeMillis() + "", emailUtil.noiDung("Tranthong","505"));
    }
}
