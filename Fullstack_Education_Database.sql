-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2024 at 07:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `duan1`
--

-- --------------------------------------------------------

--
-- Table structure for table `khdangky`
--

CREATE TABLE `khdangky` (
  `student_id` bigint(20) NOT NULL,
  `course_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khdangky`
--

INSERT INTO `khdangky` (`student_id`, `course_id`) VALUES
(2, 40);

-- --------------------------------------------------------

--
-- Table structure for table `khoahoc`
--

CREATE TABLE `khoahoc` (
  `id_khoa_hoc` bigint(20) NOT NULL,
  `tenkh` varchar(255) DEFAULT NULL,
  `gia_kh` double DEFAULT NULL,
  `thong_tin` text DEFAULT NULL,
  `dang_ky` bit(1) NOT NULL,
  `id_khoa_hoc_chinh` bigint(20) DEFAULT NULL,
  `id_sinh_vien` bigint(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khoahoc`
--

INSERT INTO `khoahoc` (`id_khoa_hoc`, `tenkh`, `gia_kh`, `thong_tin`, `dang_ky`, `id_khoa_hoc_chinh`, `id_sinh_vien`, `img`) VALUES
(5, 'Java Backend 1', 5000, 'Lập trình Java Backend là quá trình sử dụng ngôn ngữ lập trình Java để xây dựng phần mềm đảm nhiệm các chức năng xử lý logic, xử lý dữ liệu và quản lý tài nguyên của một ứng dụng hoặc trang web. Java là một trong những ngôn ngữ lập trình phổ biến được sử dụng trong lập trình Backend.', b'0', 4, 3, 'Java Backend 1.png'),
(8, 'Kiến thức nền tảng 1', 0, 'Kiến thức nền tảng/căn bản: Đây là những thứ như thuật toán, kiến thức về mạng máy tính, hệ điều hành, OOP. Kiến thức dạng khái niệm: Những thứ như design pattern, Testing (Unit Test/Autmation TesT), IoC, System Design, Software Architecture.', b'0', 7, 2, 'Kiến thức nền tảng 1.png'),
(40, 'Mới học lập trình 1', 0, 'Lập trình là việc sử dụng ngôn ngữ chỉ dẫn cho máy tính, cùng các tiện ích và công cụ khác nhau để xây dựng nên các chương trình và ứng dụng có thể chạy trên máy tính, thiết bị điện tử.', b'0', 1, 2, 'Mới học lập trình 1.png'),
(42, 'Mới học lập trình 2', 0, 'Các phần mềm quản lý, nhờ đó mà những người thu ngân, kế toán có thể dễ dàng vận hành được với số liệu đồ sộ chỉ bằng vài cú nhấp chuột. Hệ thống website, blog, mạng xã hội,… những nơi mà hàng ngày chúng ta vẫn thường xuyên truy cập để tìm kiếm thông tin, kinh doanh và chia sẻ thông tin.', b'0', 1, 2, 'Mới học lập trình 2.png'),
(43, 'Mới học lập trình 3', 0, 'Học lập trình khá khó, đó là điều mà mỗi người chúng ta đều không thể phủ nhận được. Nhưng khi mang nó ra so sánh với các kỹ năng và con đường sự nghiệp từ các ngành nghề khác thì nó lại trở thành một ngành có nhiều lựa chọn nhất mà ta có thể thực hiện được. Bạn có thể không cần bỏ ra 4 năm để học tại các trường đại học để tham gia lĩnh vực này. Bạn thực sự có thể bắt đầu vào nghề chỉ sau ít tháng học tập trùng có chủ đích và với cường độ cao.', b'0', 1, 2, 'Mới học lập trình 3.png'),
(44, 'Mới học lập trình 4', 0, 'Các lập trình viên làm việc trong ngành công nghiệp đều mang hơi thở của sự thú vị, thời đại và là nơi làm việc mà mỗi người đều mang đến kiến thức và những thử thách mới. Nền kinh tế trong ngành lập trình luôn đối xử rất công bằng với những người nỗ lực phát triển kỹ năng, kiến thức của bạn. Người làm nghề lập trình luôn có khả năng tạo ra những cơ hội riêng cho bản thân, ở bất kỳ đâu bất kể thời gian nào mà họ muốn.', b'0', 1, 2, 'Mới học lập trình 4.png'),
(45, 'Cơ sở dữ liệu 1', 4500, 'Cơ sở dữ liệu là một bộ sưu tập dữ liệu có hệ thống, được lưu trữ bằng điện tử. Nó có thể chứa bất kỳ loại dữ liệu nào, bao gồm từ, số, hình ảnh, video và tệp. Bạn có thể sử dụng phần mềm được gọi là hệ thống quản lý cơ sở dữ liệu (DBMS) để lưu trữ, truy xuất và chỉnh sửa dữ liệu. Trong các hệ thống máy tính, cơ sở dữ liệu từ cũng có thể tham khảo bất kỳ DBMS, đến hệ thống cơ sở dữ liệu, hoặc một ứng dụng liên kết với cơ sở dữ liệu.', b'0', 2, 2, 'Cơ sở dữ liệu 1.png'),
(46, 'Cơ sở dữ liệu 2', 4500, 'Cơ sở dữ liệu hiệu năng cao có ý nghĩa quan trọng đối với bất kỳ tổ chức nào. Cơ sở dữ liệu hỗ trợ các hoạt động nội bộ trong công ty và lưu trữ hoạt động tương tác với khách hàng cũng như nhà cung cấp. Chúng cũng lưu giữ thông tin quản trị và nhiều dữ liệu chuyên biệt hơn, chẳng hạn như các mô hình kỹ thuật hoặc kinh tế. Ví dụ bao gồm hệ thống thư viện kỹ thuật số, hệ thống đặt chỗ du lịch và hệ thống kiểm kê. Sau đây là một số lý do cho thấy mức độ quan trọng của cơ sở dữ liệu.', b'0', 2, 2, 'Cơ sở dữ liệu 2.png'),
(47, 'Cơ sở dữ liệu 3', 4500, 'Các ứng dụng cơ sở dữ liệu có thể quản lý một lượng lớn dữ liệu, giúp điều chỉnh quy mô thành hàng triệu, hàng tỷ và hơn thế nữa. Nếu không có cơ sở dữ liệu thì không thể lưu trữ lượng dữ liệu kỹ thuật số này.', b'0', 2, 2, 'Cơ sở dữ liệu 3.png'),
(48, 'Cơ sở dữ liệu 4', 4500, 'Cơ sở dữ liệu hỗ trợ những yêu cầu về quyền riêng tư và khả năng tuân thủ liên quan đến bất kỳ dữ liệu nào. Ví dụ: để có quyền truy cập cơ sở dữ liệu, người dùng phải đăng nhập. Người dùng khác nhau cũng có thể được truy cập ở những cấp độ khác nhau, chẳng hạn như chỉ đọc.', b'0', 2, 2, 'Cơ sở dữ liệu 4.png'),
(49, 'Lập trình web 1', 5000, 'Lập trình web là công việc của một Web Developer (Lập trình viên website) có nhiệm vụ nhận toàn bộ dữ liệu (Giao diện web tĩnh) từ bộ phận thiết kế web để chuyển thành một hệ thống website hoàn chỉnh có tương tác với CSDL và tương tác với người dùng dựa trên ngôn ngữ máy tính.', b'0', 3, 2, 'Lập trình WeB 1.png'),
(50, 'Lập trình web 2', 5000, 'Học lập trình web cơ bản là hiện đang là một cơ hội lớn cho các bạn về cả tài chính và nghề nghiệp. Vì một nhân viên lập trình có mức lương rất cao và cơ hội thăng tiến nhanh. Dưới đây là một số công việc mà bạn có thể làm sau khi học lập trình web. Đồng thời cũng là câu trả lời cho câu hỏi Có nên học lập trình web hay không. ', b'0', 3, 2, 'Lập trình WeB 2.png'),
(51, 'Lập trình web 3', 5000, 'Nếu bạn là một nhân viên lập trình Full – Stack thì bạn có thể làm tất cả mọi việc từ việc thiết kế giao diện. Các công việc liên quan tới databases, systems engineering, servers và client work giúp cho hệ thống hoạt động tốt nhất.', b'0', 3, 2, 'Lập trình WeB 3.png'),
(52, 'Lập trình web 4', 5000, 'Công việc của các chuyên viên phân tích kinh doanh sẽ là kết nối người sử dụng với nhà sản xuất. Các lập trình viên sẽ không thể hiểu hết khách hàng, hiểu họ muốn gì. Và ngược lại các lập trình viên cũng không thể hiểu hết được ý nghĩa của những code đó là gì. Đồng thời họ sẽ đưa ra các giải pháp khả thi và viết các code theo ngôn ngữ dễ hiểu nhất.', b'0', 3, 2, 'Lập trình WeB 4.png'),
(53, 'Java Backend 2', 5500, 'Lập trình Java Backend là quá trình sử dụng ngôn ngữ lập trình Java để xây dựng phần mềm đảm nhiệm các chức năng xử lý logic, xử lý dữ liệu và quản lý tài nguyên của một ứng dụng hoặc trang web. Java là một trong những ngôn ngữ lập trình phổ biến được sử dụng trong lập trình Backend.', b'0', 4, 3, 'Java Backend 2.png'),
(54, 'Java Backend 3', 5500, 'Các ứng dụng Java Backend có thể được xây dựng trên các nền tảng như Spring Framework, JavaServer Pages (JSP), Java Servlet và Enterprise JavaBeans (EJBs). Java cung cấp nhiều tính năng và thư viện hỗ trợ phát triển các ứng dụng Web Backend đáp ứng được các yêu cầu về hiệu suất, bảo mật và quản lý tài nguyên.', b'0', 4, 3, 'Java Backend 3.png'),
(55, 'Java Backend 4', 5500, 'Người lập trình Java Backend cần có kiến thức sâu về ngôn ngữ lập trình Java, các công nghệ phát triển backend, cơ sở dữ liệu, các giao thức mạng, hệ thống quản lý phiên, các công cụ quản lý mã nguồn và các kiến thức khác liên quan đến phát triển phần mềm.', b'0', 4, 3, 'Java Backend 4.png'),
(56, 'Java Fullstack 1', 12000, 'Full Stack Developer là một trong những vị trí hot nhất hiện nay trong lĩnh vực Công nghệ thông tin. Với khả năng phát triển cả phía front-end và back-end của một ứng dụng, Full Stack Developer là người có vai trò quan trọng trong việc đáp ứng nhu cầu của khách hàng và người dùng.', b'0', 5, 3, 'Java Fullstack 1.png'),
(57, 'Java Fullstack 2', 12000, 'Để trở thành một lập trình viên Full Stack, người ta cần có kiến thức về các ngôn ngữ lập trình phía client như HTML, CSS, JavaScript và các framework như React, Angular hay Vue. Ngoài ra, họ cũng cần hiểu về các ngôn ngữ lập trình phía server như Node.js, Ruby on Rails, Python hay PHP và các framework đi kèm. Cuối cùng, lập trình viên Full Stack cần có kiến thức về cơ sở dữ liệu, các công cụ quản lý dữ liệu và kiến thức về mạng máy tính để triển khai ứng dụng.', b'0', 5, 3, 'Java Fullstack 2.png'),
(58, 'Java Fullstack 3', 12000, 'Lập trình viên Full Stack đóng một vai trò quan trọng trong các dự án phát triển phần mềm và ứng dụng web. Với sự phát triển không ngừng của công nghệ thông tin, việc trở thành một lập trình viên Full Stack đang trở thành một xu hướng và được rất nhiều người quan tâm và lựa chọn.', b'0', 5, 3, 'Java Fullstack 3.png'),
(59, 'Java Fullstack 4', 12000, 'Làm việc với nhóm: Full Stack Developer thường làm việc trong một nhóm phát triển và phải liên lạc và tương tác với các thành viên trong nhóm để đảm bảo sự hợp tác tốt nhất trong quá trình phát triển.', b'0', 5, 3, 'Java Fullstack 4.png'),
(60, 'Data Science 1', 7500, 'Data Science được định nghĩa là tất cả những gì về thu thập, khai thác và phân tích dữ liệu để tìm ra insight giá trị. Sau đó trực quan hóa các Insight cho các bên liên quan, để chuyển hóa Insight thành hành động. Đây là lĩnh vực đa ngành sử dụng các phương pháp và quy trình khoa học để rút ra insight từ dữ liệu.', b'0', 6, 3, 'Data Science 1.png'),
(61, 'Data Science 2', 7500, 'Theo đó, yêu cầu bức thiết đặt ra cần có một chuyên gia “Data Scientist”, người mà có khả năng dùng các công cụ thống kê và Machine learning (một lĩnh vực nhỏ của Khoa Học Máy Tính, công cụ có khả năng tự học hỏi dựa trên dữ liệu đưa vào mà không cần phải được lập trình cụ thể).\r\n\r\nMột Data Scientist (Nhà khoa học dữ liệu) không chỉ dừng lại ở việc phân tích dữ liệu, mà còn biết sử dụng thuật toán Machine Learning để dự đoán tương lai của một sự kiện.', b'0', 6, 3, 'Data Science 2.png'),
(62, 'Data Science 3', 7500, 'Các công ty phụ thuộc vào nền tảng dữ liệu để cấu trúc, phát triển và cải tiến doanh nghiệp. Các Data Scientist làm việc với các con số, phân tích một một khối lượng lớn Data để xuất ra những Insight ý nghĩa. Những insight này rất hữu ích khi phân tích công ty và các hoạt động của công ty trên thị trường từ đó đưa ra các quyết định đúng đắn.', b'0', 6, 3, 'Data Science 3.png'),
(63, 'Data Science 4', 7500, 'Thống kê chỉ ra số lượng vai trò của các Data Scientist đã tăng trưởng 650% kể từ năm 2012. Khoảng 11,5 triệu việc làm liên quan đến chức danh này sẽ được tạo ra đến năm 2026 (theo  U.S. Bureau of Labor Statistics). Bên cạnh đó công việc của các Data Scientist được xếp hạng top các công việc nổi bật trên LinkedIn. ', b'0', 6, 3, 'Data Science 4.png'),
(64, 'Kiến thức nền tảng 2', 2500, 'ava được biết đến là ngôn ngữ lập trình bậc cao, hướng đối tượng và giúp bảo mật mạnh mẽ, và còn được định nghĩa là một Platform. Java được phát triển bởi Sun Microsystems, do James Gosling khởi xướng và ra mắt năm 1995. Java hoạt động trên rất nhiều nền tảng như Windows, Mac và các phiên bản khác nhau của UNIX.', b'0', 7, 2, 'Kiến thức nền tảng 2.png'),
(65, 'Kiến thức nền tảng 3', 2500, 'Hướng đối tượng: Trong Java, tất cả đều là một Object. Java có thể mở rộng và bảo trì dễ dàng bởi nó được xây dựng dựa trên mô hình Object.\r\nNền tảng độc lập: Khi được biên dịch, Java không được biên dịch thành ngôn ngữ máy trên nền tảng cụ thể mà thay vào mã byte – một nền tảng độc lập. Mã byte này được thông dịch từ máy ảo (JVM) trên một nền tảng nào đó mà nó đang chạy.', b'0', 7, 2, 'Kiến thức nền tảng 3.png'),
(66, 'Kiến thức nền tảng 4', 2500, 'Bảo mật: Tính năng an toàn của Java cho phép phát triển các hệ thống không virus, không giả mạo, việc xác thực dựa trên mã hoá khóa công khai.\r\nKiến trúc – trung lập: Trình biên dịch của Java tạo ra các định dạng tệp đối tượng kiến trúc trung lập, khiến mã biên dịch được thực thi trên nhiều bộ vi xử thông qua hệ điều hành Java.', b'0', 7, 2, 'Kiến thức nền tảng 4.png');

-- --------------------------------------------------------

--
-- Table structure for table `khoahocchinh`
--

CREATE TABLE `khoahocchinh` (
  `id_khoa_hoc_chinh` bigint(20) NOT NULL,
  `tenkhc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khoahocchinh`
--

INSERT INTO `khoahocchinh` (`id_khoa_hoc_chinh`, `tenkhc`) VALUES
(1, 'Mới học lập trình'),
(2, 'Cơ sở dữ liệu'),
(3, 'Lập trình Web'),
(4, 'Java Backend'),
(5, 'Java Fullstack'),
(6, 'Data Science'),
(7, 'Kiến thức nền tảng');

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
  `id_mon_hoc` bigint(20) NOT NULL,
  `chi_tiet` varchar(255) DEFAULT NULL,
  `tenmh` varchar(255) DEFAULT NULL,
  `khoa_hoc` bigint(20) DEFAULT NULL,
  `videos` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`id_mon_hoc`, `chi_tiet`, `tenmh`, `khoa_hoc`, `videos`) VALUES
(10, 'javav 2', 'javav 2', 5, NULL),
(35, '', 'Kiến thức nền tảng 1', 8, 'Mới học lập trình 1.mp4'),
(36, '', 'Mới học lập trình 1', 40, 'Mới học lập trình 1.mp4'),
(37, '', 'Mới học lập trình 2', 42, '23355-334950213_small.mp4'),
(38, '', 'Mới học lập trình 3', 43, '28320-369325356_small.mp4'),
(40, '', 'Mới học lập trình 4', 44, '49050-459186396_small.mp4'),
(41, '', 'Cơ sở dữ liệu 1', 45, '23355-334950213_small.mp4'),
(42, '', 'Cơ sở dữ liệu 2', 46, '28320-369325356_small.mp4'),
(43, '', 'Cơ sở dữ liệu 3', 47, 'Mới học lập trình 1.mp4'),
(44, '', 'Cơ sở dữ liệu 4', 48, '23355-334950213_small.mp4'),
(45, '', 'Lập trình web 1', 49, '28320-369325356_small.mp4'),
(46, '', 'Lập trình web 2', 50, '49050-459186396_small.mp4'),
(47, '', 'Lập trình web 3', 51, 'Mới học lập trình 1.mp4'),
(48, '', 'Lập trình web 4', 52, '23355-334950213_small.mp4'),
(49, '', 'Kiến thức nền tảng 2', 64, '23355-334950213_small.mp4'),
(50, '', 'Kiến thức nền tảng 3', 65, '49050-459186396_small.mp4'),
(51, '', 'Kiến thức nền tảng 4', 66, 'Mới học lập trình 1.mp4'),
(52, '', 'Java Fullstack 1', 56, 'Mới học lập trình 1.mp4'),
(53, '', 'Java Fullstack 2', 57, '23355-334950213_small.mp4'),
(54, '', 'Java Fullstack 3', 58, '28320-369325356_small.mp4'),
(55, '', 'Java Fullstack 4', 59, '49050-459186396_small.mp4'),
(56, '', 'Data Science 1', 60, '23355-334950213_small.mp4'),
(57, '', 'Data Science 2', 61, '28320-369325356_small.mp4'),
(58, '', 'Data Science 3', 62, '49050-459186396_small.mp4'),
(59, '', 'Data Science 4', 63, 'Mới học lập trình 1.mp4');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `mat_khau_cu` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `ma_xac_nhan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `sdt`, `email`, `hinh_anh`, `ho_ten`, `mat_khau_cu`, `password`, `role`, `user_name`, `ma_xac_nhan`) VALUES
(1, '09257013701', '', 'default.jpg', 'thống', '123', '$2a$10$a/AyOydbQUpnWuwb58RTvOU81Ama1xYHz1YNdz3bF98/1.OikYw56', 'ROLE_HOCSINH', 'Admin', '0'),
(2, '09257013701', 'tranthong155@gmail.com', 'default.jpg', 'giaovien', '123', '$2a$10$8/tSEzjJtIDpftwCVq4TZuMQrJCt1gyx.eWgNzpZdms4Z2mLLyKxW', 'ROLE_GIAOVIEN', 'giaovien', '255073'),
(3, '09257013701', '', 'default.jpg', 'giaovien2', '123', '$2a$10$VUlpeKZkwnF1kOVMDsmjReXvjID7GCGv.cHpY..x45eEItStntB5e', 'ROLE_GIAOVIEN', 'giaovien2', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `khdangky`
--
ALTER TABLE `khdangky`
  ADD PRIMARY KEY (`student_id`,`course_id`),
  ADD KEY `FK6kul4etb4j7nv9p65ayimcyo0` (`course_id`);

--
-- Indexes for table `khoahoc`
--
ALTER TABLE `khoahoc`
  ADD PRIMARY KEY (`id_khoa_hoc`),
  ADD KEY `FKeiaja6wikud9ki9l4vtjbqs22` (`id_khoa_hoc_chinh`),
  ADD KEY `FK3shugb7v67kysmybji828uvlr` (`id_sinh_vien`);

--
-- Indexes for table `khoahocchinh`
--
ALTER TABLE `khoahocchinh`
  ADD PRIMARY KEY (`id_khoa_hoc_chinh`);

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`id_mon_hoc`),
  ADD KEY `FK4mhf3875egw4mt10c9teglm7e` (`khoa_hoc`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khoahoc`
--
ALTER TABLE `khoahoc`
  MODIFY `id_khoa_hoc` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `khoahocchinh`
--
ALTER TABLE `khoahocchinh`
  MODIFY `id_khoa_hoc_chinh` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `monhoc`
--
ALTER TABLE `monhoc`
  MODIFY `id_mon_hoc` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `khdangky`
--
ALTER TABLE `khdangky`
  ADD CONSTRAINT `FK6kul4etb4j7nv9p65ayimcyo0` FOREIGN KEY (`course_id`) REFERENCES `khoahoc` (`id_khoa_hoc`),
  ADD CONSTRAINT `FKbl6hcmjtu1eq63acy6kkyk2ik` FOREIGN KEY (`student_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `khoahoc`
--
ALTER TABLE `khoahoc`
  ADD CONSTRAINT `FK3shugb7v67kysmybji828uvlr` FOREIGN KEY (`id_sinh_vien`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FKeiaja6wikud9ki9l4vtjbqs22` FOREIGN KEY (`id_khoa_hoc_chinh`) REFERENCES `khoahocchinh` (`id_khoa_hoc_chinh`);

--
-- Constraints for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD CONSTRAINT `FK4mhf3875egw4mt10c9teglm7e` FOREIGN KEY (`khoa_hoc`) REFERENCES `khoahoc` (`id_khoa_hoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
