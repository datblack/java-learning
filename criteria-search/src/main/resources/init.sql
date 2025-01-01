-- create database --
CREATE DATABASE criteria_search CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- create table --
USE criteria_search;
create table category
(
    id     bigint auto_increment
        primary key,
    name   varchar(255)         CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci      ,
    status enum ('ACTIVE', 'INACTIVE') null
) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci ;

create table `order`
(
    id           bigint auto_increment
        primary key,
    address      varchar(255)           CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci    ,
    phone_number varchar(255)                null,
    user_name    varchar(255)           CHARACTER SET utf8mb4   COLLATE utf8mb4_unicode_ci   ,
    status       enum ('ACTIVE', 'INACTIVE') null
) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci ;

create table order_product
(
    id         bigint auto_increment
        primary key,
    order_id   bigint                      null,
    product_id bigint                      null,
    status     enum ('ACTIVE', 'INACTIVE') null
) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci ;

create table product
(
    price       int                         null,
    category_id bigint                      null,
    id          bigint auto_increment
        primary key,
    description varchar(1000)       CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci       ,
    name        varchar(255)        CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci       ,
    status      enum ('ACTIVE', 'INACTIVE') null
) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci ;
-- insert data --
INSERT INTO `criteria_search`.category (id, name, status) VALUES (1, 'DELL', 'ACTIVE');
INSERT INTO `criteria_search`.category (id, name, status) VALUES (2, 'ASUS', 'ACTIVE');
INSERT INTO `criteria_search`.category (id, name, status) VALUES (3, 'ACER', 'ACTIVE');
INSERT INTO `criteria_search`.category (id, name, status) VALUES (4, 'MAC BOOK', 'ACTIVE');
INSERT INTO `criteria_search`.category (id, name, status) VALUES (5, 'LENOVO', 'ACTIVE');

INSERT INTO `criteria_search`.`order` (id, address, phone_number, user_name, status) VALUES (1, 'Cầu Giấy - Hà Nội', '09999888222', 'amy', 'ACTIVE');
INSERT INTO `criteria_search`.`order` (id, address, phone_number, user_name, status) VALUES (2, 'Nam Từ Liêm - Hà Nội', '0888999111', 'frode', 'ACTIVE');
INSERT INTO `criteria_search`.`order` (id, address, phone_number, user_name, status) VALUES (3, 'Thanh Xuân - Hà Nội', '0788666333', 'alex', 'ACTIVE');
INSERT INTO `criteria_search`.`order` (id, address, phone_number, user_name, status) VALUES (4, 'Ba Đình - Hà Nội', '0471723712', 'thomas', 'ACTIVE');

INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (1, 1, 1, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (2, 1, 2, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (3, 2, 3, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (4, 2, 4, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (5, 3, 5, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (6, 3, 3, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (7, 4, 2, 'ACTIVE');
INSERT INTO `criteria_search`.order_product (id, order_id, product_id, status) VALUES (8, 4, 1, 'ACTIVE');

INSERT INTO `criteria_search`.product (price, category_id, id, description, name, status) VALUES (2000, 4, 1, 'Macbook Air M1 là dòng sản phẩm có thiết kế mỏng nhẹ, sang trọng và tinh tế cùng với đó là giá thành phải chăng nên MacBook Air đã thu hút được đông đảo người dùng yêu thích và lựa chọn. Đây cũng là một trong những phiên bản Macbook Air mới nhất mà khách hàng không thể bỏ qua khi đến với CellphoneS. Dưới đây là chi tiết về thiết kế, cấu hình của máy.', 'Macbook Air M1 2020', 'ACTIVE');
INSERT INTO `criteria_search`.product (price, category_id, id, description, name, status) VALUES (1000, 2, 2, 'Laptop Asus Tuf Gaming F15 FX506HF-HN078W với thiết kế năng động, mang vẻ đẹp thu hút với CPU core intel i5, GPU GeForce RTX™ 2050 và RAM 8 GB. Kết hợp là màn hiển thị FHD IPS 144Hz cực kỳ rõ nét.', 'Asus Tuf Gaming F15 FX506HF-HN078W', 'ACTIVE');
INSERT INTO `criteria_search`.product (price, category_id, id, description, name, status) VALUES (900, 5, 3, 'Laptop Lenovo V14 G4 AMN 82YT00M8VN với thiết kế tối giản, lịch sự cùng kích thước nhỏ gọn sẽ phù hợp với đa số đối tượng người dùng là học sinh, sinh viên, người làm văn phòng.', 'Laptop Lenovo V14 G4 AMN 82YT00M8VN', 'ACTIVE');
INSERT INTO `criteria_search`.product (price, category_id, id, description, name, status) VALUES (950, 3, 4, 'Laptop Acer Aspire 3 A314-42P-R3B3 là một chiếc laptop Acer Aspire đa năng với thiết kế gọn nhẹ và hiệu suất đủ mạnh đáp ứng nhu cầu sử dụng hàng ngày. Với màn hình kích thước 14 inch, máy sở hữu vi xử lý AMD Ryzen 7, RAM 16GB, và ổ cứng SSD 512GB, đảm bảo khởi động nhanh chóng và trải nghiệm làm việc mượt mà. ', 'Laptop Acer Aspire 3 A314-42P-R3B3 ', 'ACTIVE');
INSERT INTO `criteria_search`.product (price, category_id, id, description, name, status) VALUES (2890, 1, 5, 'Laptop Dell Inspiron 15 3520 YTC9K sở hữu hiệu năng đột phá nhờ sở hữu thông số cấu hình khủng từ CPU Intel thế hệ 12 cùng RAM 8GB (mở rộng tối đa 16GB) và SSD 256GB. Chất lượng hình ảnh của dòng laptop này cũng vô cùng sắc nét với card đồ họa Intel Iris Xe Graphics kết hợp cùng màn hình Full HD 15.6 inch. Đặc biệt hơn, máy còn sở hữu viên pin lên tới 41Wh hỗ trợ sạc nhanh, nâng cấp trải nghiệm giải trí, công việc suốt ngày dài.', 'Laptop Dell Inspiron 15 3520 YTC9K', 'ACTIVE');
