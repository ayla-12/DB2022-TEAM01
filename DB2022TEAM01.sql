# db 생성
create database DB2022Team01;
use DB2022Team01;



# db 유저 생성 + 권한 부여
create user 'DB2022Team01'@localhost identified by 'DB2022Team01';
grant all privileges on DB2022Team01.* to 'DB2022Team01'@localhost;

# 테이블 생성
create table `DB2022_user`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45) unique key,
    `password` varchar(45)
);

# 두개 묶어서 primary key -> ?
# 두개 묶어서 pk로 쓰면 아래 아이돌 그룹, 아이돌 이름 참조가 안 되어서 아이디 생성
# 할 줄 아시는 분 도와주시면 감사하겠습니다!
# group 변수명때문에 오류 났던 것 같음 -> gp로 수정
create table `DB2022_idol`(
	`gp` varchar(45) not null,
    `member` varchar(45) not null,
    `quantity` BIGINT
	
);

# 아이돌에 아이디
create table `DB2022_product`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45),
    `price` BIGINT,
    `seller` varchar(45),
    `category` varchar(45),
    `idol_id` bigint,
    `idol_group` varchar(45),
    `idol_member` varchar(45),
    `isSold` bool,
    `date` date,
    foreign key(idol_id) references DB2022_idol(id),
    foreign key(seller) references DB2022_user(name)
);



create table `DB2022_trade` (
	`id` bigint auto_increment primary key,
    `product_id` bigint,
    `name` varchar(45),
    `price` bigint,
    `seller` varchar(45),
    `buyer` varchar(45),
	foreign key(product_id) references DB2022_product(id),
    foreign key(seller) references DB2022_user(name),
    foreign key(buyer) references DB2022_user(name)
);

create table `DB2022_wishlist`(
    `user_id` bigint,
    `product_id` bigint,
    foreign key(user_id) references DB2022_user(id),
    foreign key(product_id) references DB2022_product(id)
);
