
# Website quản lý văn phòng cho thuê

## Overview

 - Website quản lý văn phòng cho thuê được xây dựng bằng Java và sử dụng Spring Framework.
 - Website gồm các công nghệ sau:  Spring MVC, Spring Boot, Spring Security, Restful Web Service, Jquery, Bootstrap, Ajax, JSP, Java 8, JPA, Spring Data JPA. 

## Các chức năng quản lí tòa nhà bao gồm: 
 1. Thêm tòa nhà, sửa tòa nhà với nhiều field khác nhau, Xóa 1 tòa nhà hoặc nhiều tòa nhà theo yêu cầu client.
 2. Tìm kiếm tòa nhà với nhiều điều kiện, các field khác nhau.
 3. Giao các tòa nhà cho nhân viên quản lí. 
 4. Phân trang, upload ảnh cho tòa nhà.
 5. Hiển thị tất cả tòa nhà với role quản lí. Role nhân viên chỉ thấy các tòa nhà được giao.
 - Sử dụng design partern Builder trong task : Tìm kiếm tòa nhà.

## Chức năng quản lí khách hàng bao gồm: 
 1. Tìm kiếm customer theo các field khác nhau
 2. Thêm, sửa, xóa customer.
 3. Giao customer cho nhân viên quản lí.
 4. Phân trang, hiển thị tất cả khách hàng với Role quản lí, Role nhân viên chỉ thấy các khách hàng được giao. 

## Chức năng giao dịch của nhân viên với khách hàng
 1. Hiển thị thông tin giao dịch.
 2. Quản lí giao dịch, một giao dịch có nhiều loại giao dịch, các nhân viên quản lí thực hiện giao dịch với khách hàng.

## Chức năng quản lí người dùng bao gồm: 
 1. Tìm kiếm user
 2. Thêm user theo vai trò (role: quản lí hoặc nhân viên)
 3. Update lại user, mật khẩu người dùng.


## Cài đặt
- Clone repo về máy của bạn : 
> https://github.com/HoangThong37/real-estate-management.git
- IDE : Recomend Intellij IDEA.
- Cài đặt JDK 8 và Maven.
- Cài đặt MYSQL và tạo database có tên `dbproject`
- Chỉnh sửa file `application.properties` để cấu hình database, username và password
- Chạy command `mvn clean install` để build project
- Chạy command `mvn spring-boot:run` để start server

## Sử dụng
 - Truy cập vào địa chỉ `http://localhost:8081` (theo cài đặt của bạn) để truy cập website.
 -  Đăng nhập với tài khoản quản trị hoặc nhân viên.
 - Quản trị viên có thể thêm, sửa, xóa tòa nhà, customer và người dùng. Quản trị viên cũng có thể giao tòa nhà và customer cho nhân viên quản lí.
 - Nhân viên quản lí có thể xem và cập nhật thông tin của tòa nhà và customer được giao cho mình.
 
## DATABASE 
 - Sử dụng MYSQL
 - Sau khi các bạn clone project -> click vào package database lấy file .sql import vào db nhé! 

## Review code
- Code được xây dựng theo các best practice trong lập trình Java, sử dụng clean code và clear code.
- Các packages trong project được chia theo tính chức năng và rõ ràng.
- Các đoạn code được viết rõ ràng, dễ đọc và dễ hiểu. 
- Project được đóng gói và chạy bằng Maven.
- Review p1 : Xây dựng website với tư duy logic, giải quyết vấn đề, bài toán không sử dụng, phụ thuộc vào framework có sẵn.
- Review p2 : Áp dụng framework vào việc xây dựng website.

## HOÀNG TRUNG THÔNG - 2023
### Not only try but try your best. good luck everyone !
