# db 생성
create database DB2022Team01;
use DB2022Team01;

# db 유저 생성 + 권한 부여
# create user 'DB2022Team01'@localhost identified by 'DB2022Team01';
grant all privileges on DB2022Team01.* to 'DB2022Team01'@localhost;

# 테이블 생성
create table `DB2022_user`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45) unique key,
    `password` varchar(45),
    `login` bool default false
);

create table `DB2022_idol`(
	`idol_id` bigint not null auto_increment,
	`gp` varchar(45) not null,
    `member` varchar(45) not null,
    primary key(idol_id)
);

# 상품
create table `DB2022_product`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45),
    `user_id` BIGINT,
    `price` BIGINT,
    `seller` varchar(45),
    `category` varchar(255),
    `idol_id` bigint,
    `isSold` bool default false,
    `date` date,
    foreign key(user_id) references DB2022_user(id),
    foreign key(idol_id) references DB2022_idol(idol_id),
    foreign key(seller) references DB2022_user(name),
    check((category) in ('포토카드', '앨범', '인형', '시즌그리팅', '공식키트', '폴라로이드', '포스터', '잡지', '기타'))
);

# 유저의 거래 내역
create table `DB2022_trade` (
	`trade_id` bigint auto_increment primary key,
    `product_id` bigint,
    `buyer_id` bigint default null,
    `buyer_name` varchar(45) default null,
	foreign key(product_id) references DB2022_product(id),
    foreign key(buyer_id) references DB2022_user(id),
    foreign key(buyer_name) references DB2022_user(name)
);

create table `DB2022_wishlist`(
    `user_id` bigint,
    `product_id` bigint,
    foreign key(user_id) references DB2022_user(id),
    foreign key(product_id) references DB2022_product(id)
);


# 인덱스 생성
create index idx_idol on db2022team01.db2022_idol
(gp, member);

create index idx_user on db2022team01.db2022_user
(name, password);

create index idx_category on db2022team01.db2022_product
(category);

create index idx_user_login on db2022team01.db2022_user
(login);

# 예시 데이터 삽입 이후 실행 할 것
# 뷰 생성
create view DB2022_idol_list as
select gp, member from db2022team01.db2022_idol;


create view DB2022_product_list as
select id, name, gp, member, category, seller, price, date
from DB2022_idol, DB2022_product where isSold = false and DB2022_idol.idol_id = DB2022_product.idol_id 
order by date;

create view DB2022_product_withidol as
select id, name, price, seller, category, date, DB2022_product.idol_id, gp, member
from DB2022_product, DB2022_idol where DB2022_idol.idol_id = DB2022_product.idol_id;

#유저 데이터
insert into DB2022_user(name, password)
values
	("선의", "1234"),
    ("지원", "4321"),
    ('dlrbals', '0000'), 
	("jy0115", "1234"), 
	("guswowogus", "1234"), 
	('dlsgud', '1234'), 
	('qhqkd', '1234'), 
	('wndus54321', '1234'), 
	('reveal33', '1234'),  
	('dkssud', '1234'), 
	('ejqhdlwm', '1234'), 
	('bana55', '1234'), 
	('grp00', '1234'), 
	('xkfejql', '1234'), 
	('wndusaldks', '1234'),
    ("tmzlwm325", "1234"),
    ("bangchan", "1234"),
    ("leeknow", "1234"),
    ("changbin", "1234"),
    ("hyunjin", "1234"),
    ("han", "1234"),
    ("felix", "1234"),
    ("seungmin", "1234"),
    ("in", "1234"),
    ("qkdcks", "1234"),
    ("dlalsgh", "1234"),
    ("tjckdqls", "1234"),
    ("ghkdguswls", "1234"),
    ("gkswltjd", "1234"),
    ("dldydqhr", "1234"),
    ("rlatmdals", "1234"),
    ("didwjddls", "1234"),
    ("wolfchan", "1234"),
    ("leebit", "1234"),
    ("dwakki", "1234"),
    ("jiniret", "1234"),
    ("hanqukka", "1234"),
    ("bbokari", "1234"),
    ("puppym", "1234"),
    ("foxiny", "1234"),
    ("sumin", "0000"),
    ("sieun", "1111"),
    ("isa", "2222"),
    ("seeun", "3333"),
    ("yoon", "4444"),
    ("yeeun", "5555")
    ;
	
#아이돌 데이터
INSERT INTO DB2022_idol(gp, member)
values
	("세븐틴", "에스쿱스"),
	("세븐틴", "정한"),
	("세븐틴", "조슈아"),
	("세븐틴", "준"),
	("세븐틴", "호시"),
    ('더보이즈', '현재'), 
	('더보이즈', '주연'), 
	('더보이즈', '영훈'), 
	('더보이즈', '뉴'), 
	('더보이즈', '큐'), 
	('더보이즈', '선우'), 
	('더보이즈', '학년'), 
	('더보이즈', '상연'), 
	('더보이즈', '케빈'), 
	('더보이즈', '제이콥'), 
	('더보이즈', '더보이즈'),
	("스트레이키즈","방찬"),
	("스트레이키즈","리노"),
	("스트레이키즈","창빈"),
	("스트레이키즈","현진"),
	("스트레이키즈","한"),
	("스트레이키즈","필릭스"),
	("스트레이키즈","승민"),
	("스트레이키즈","아이엔"),
	("드림캐쳐","지유"),
	("드림캐쳐","수아"),
	("드림캐쳐","시연"),
	("드림캐쳐","한동"),
	("드림캐쳐","유현"),
	("드림캐쳐","다미"),
	("드림캐쳐","가현"),
	("cix","BX"),
	("cix","승훈"),
	("cix","용희"),
	("cix","진영"),
	("cix","현석"),
	("엔믹스","릴리"),
	("엔믹스","해원"),
	("엔믹스","지니"),
	("엔믹스","배이"),
	("엔믹스","설윤"),
	("엔믹스","지우"),
	("엔믹스","규진"),
	("에이티즈","홍중"),
	("에이티즈","성화"),
	("에이티즈","윤호"),
	("에이티즈","여상"),
	("에이티즈","산"),
	("에이티즈","민기"),
	("에이티즈","우영"),
	("에이티즈","종호"),
	("우주소녀","설아"),
	("우주소녀","보나"),
	("우주소녀","엑시"),
	("우주소녀","수빈"),
	("우주소녀","루다"),
	("우주소녀","다원"),
	("우주소녀","은서"),
	("우주소녀","여름"),
	("우주소녀","다영"),
	("우주소녀","연정"),
	("엔플라잉","승협"),
	("엔플라잉","차훈"),
	("엔플라잉","재현"),
	("엔플라잉","회승"),
	("엔플라잉","동성"),
	("스테이씨", "수민"),
	("스테이씨", "시은"),
	("스테이씨", "아이사"),
	("스테이씨", "세은"),
	("스테이씨", "윤"),
	("스테이씨", "재이")
	;

#상품 데이터
insert into DB2022_product (user_id, name, price, seller, category, idol_id, date) 
values 
	(3, '영훈 스릴라이드 미공포 양도', 3200, 'dlrbals', '포토카드', 8, '2021-10-29'), 
	(3, '현재 매버릭 모교교복 포카 양도', 50000, 'dlrbals', '포토카드', 6, '2022-04-11'), 
	(3, '주연 크리스마씨 굿즈 스티커 분철 양도', 2000, 'dlrbals', '기타', 7, '2020-12-12'), 
	(3, '주연 더스틸러 위드드라마 미공포 양도', 5500, 'dlrbals', '포토카드', 7, '2020-09-29'),  
	(3, '주연 마뮤테 더스틸러 미공포 양도', 1000, 'dlrbals', '포토카드', 7, '2020-09-29'), 
	(3, '주연 더스틸러 조은뮤직 미공포 양도', 8000, 'dlrbals', '포토카드', 7, '2020-09-29'), 
	(4, '현재 더스틸러 키스마크 앨범포카 양도', 15000, 'jy0115', '포토카드', 6, '2020-09-29'), 
	(5, '현재 블룸블룸 공방 포카 양도', 135000, 'guswowogus', '포토카드', 6, '2021-04-13'),  
	(5, '현재 디디디 디삼 앨범 랜덤 포카 양도', 75000, 'guswowogus', '포토카드', 6, '2021-04-13'), 
	(6, '현재 인형 달곰이 양도', 50000, 'dlsgud', '인형', 6, '2022-02-02'), 
	(7, '영훈 인형 뽀빵', 20000, 'qhqkd', '인형', 8, '2022-04-03'), 
	(6, '주연 15cm 마물쭈 판매', 18000, 'dlsgud', '인형', 7, '2021-10-09'), 
	(8, '15센치 마물쭈', 18000, 'wndus54321', '인형', 7, '2021-10-01'), 
	(9, '밀꼬미 더보이즈 현재 인형 폼 이동', 16000, 'reveal33', '인형', 6, '2021-11-21'), 
	(9, '더비 3기 키트 풀셋 양도', 20000, 'reveal33', '공식키트', 16, '2021-06-20'), 
	(10, '로투킹 현재 와인잔 포카 판매', 40000, 'dkssud', '기타', 6,'2021-06-11'), 
	(10, '마물쭈 10, 15 일괄', 40000, 'dkssud', '인형', 7, '2021-09-25'),
	(11, '달곰쥬냥 일괄 양도', 90000, 'ejqhdlwm', '인형', 16, '2022-01-16'),  
	(11, '더보이즈 뉴 포카 일괄 양도', 30000, 'ejqhdlwm', '포토카드', 9, '2022-03-29'),
	(11, '더보이즈 큐 포카 일괄 양도', 30000, 'ejqhdlwm', '포토카드', 10, '2022-03-29'),
	(11, '좍켑콥 포카 일괄 양도', 5000, 'ejqhdlwm', '포토카드', 16,'2022-03-29'), 
	(11, '더보이즈 매버릭 미개봉 앨범 세트 양도', 1000, 'ejqhdlwm', '앨범', 16, '2022-03-29'), 
	(12, '더보이즈 2021 시즌그리팅 선우 분철 양도', 11000, 'bana55', '시즌그리팅', 11, '2020-01-05'), 
	(13, '라포티셀 영훈 포카', 6000, 'grp00', '포토카드', 8, '2021-07-10'), 
	(13, '현재 데이즈드 폴라 양도', 85000, 'grp00', '폴라로이드', 6, '2021-11-20'), 
	(11, '현재 엽서북 팔찌 일괄', 55000, 'ejqhdlwm', '기타',  6, '2021-05-23'), 
	(11, '더보이즈 현재 2022 홈마시그 양도', 21000, 'ejqhdlwm', '시즌그리팅', 6, '2021-12-23'), 
	(14, '더보이즈 데이즈드 잡지 양도 포카 포함', 10000, 'xkfejql', '잡지', 16, '2021-06-21'),
	(14, '더비 4기 키트 양도 아이디카드 제외', 15000, 'xkfejql', '공식키트', 16, '2022-05-10'), 
	(15, '덥뮤다 더스틸러 현재영훈주연 미화당 포카 일괄', 28000, 'wndusaldks', '포토카드', 16, '2020-10-10'),
    (46, '수민 자연광 포카', 20000, 'yeeun', '포토카드', 67, '2021-10-29'), 
	(46, '수민 2022 시즌그리팅 학생증', 8000, 'yeeun', '기타', 67, '2022-01-29'), 
	(46, '수민 런투유 폴라로이드', 5000, 'yeeun', '폴라로이드', 67, '2022-04-20'), 
	(46, '수민 렌즈미 포카', 6000, 'yeeun', '포토카드', 67, '2022-05-14'), 
	(46, '수민 SO BAD 애플뮤직 포카', 12000, 'yeeun', '포토카드', 67, '2020-12-12'), 
	(45, '시은 사만사타바사 폴라로이드', 5000, 'yoon', '폴라로이드', 68, '2022-06-01'),
	(45, '시은 에이셉 위드드라마 2차 포카', 20000, 'yoon', '포토카드', 68, '2021-08-21'),
	(45, '시은 에이셉 앨범 엽서', 5000, 'yoon', '기타', 68, '2021-05-02'),
	(45, '시은 색안경 접지 포스터', 4000, 'yoon', '포스터', 68, '2021-10-21'),
	(45, '시은 셀러버 포카', 10000, 'yoon', '포토카드', 68, '2022-05-05'),
	(44, '아이사 냥이사 인형', 45000, 'seeun', '인형', 69, '2022-05-05'),
	(44, '아이사 마리끌레르 4월호 잡지', 10000, 'seeun', '잡지', 69, '2022-05-05'),
	(44, '아이사 셀러버 블랙 포카', 13000, 'seeun', '포토카드', 69, '2022-06-04'),
	(44, '아이사 색안경 메이크스타 2차 포카', 10000, 'seeun', '포토카드', 69, '2021-11-11'),
	(44, '아이사 팔찌 포카', 15000, 'seeun', '포토카드', 69, '2022-04-05'),
	(43, '세은 런투유 쥬얼 앨범', 5000, 'isa', '앨범', 70, '2022-04-21'),
	(43, '세은 생일카페 특전 텀블러', 6000, 'isa', '기타', 70, '2021-06-14'),
	(43, '세은 SO BAD 모켓샵 포카', 15000, 'isa', '포토카드', 70, '2020-12-05'),
	(43, '세은 AR 포카', 8000, 'isa', '포토카드', 70, '2022-04-24'),
	(43, '세은 런투유 포스터', 5000, 'isa', '포스터', 70, '2022-04-28'),
	(42, '윤 윤호랑 인형', 40000, 'sieun', '인형', 71, '2022-04-28'),
	(42, '윤 잠옷 포카', 10000, 'sieun', '포토카드', 71, '2022-02-21'),
	(42, '윤 런투유 쥬얼 앨범', 5000, 'sieun', '앨범', 71, '2022-04-22'),
	(42, '윤 사만사타바사 폴라로이드', 8000, 'sieun', '폴라로이드', 71, '2022-05-13'),
	(42, '윤 썬캡 포카', 3000, 'sieun', '포토카드', 71, '2021-11-28'),
	(41, '재이 삐죽재이 포카', 20000, 'sumin', '포토카드', 72, '2020-12-28'),
	(41, '재이 시즌그리팅 포카', 6000, 'sumin', '포토카드', 72, '2022-01-03'),
	(41, '재이 에이셉 접지 포스터', 4000, 'sumin', '포스터', 72, '2021-05-01'),
	(41, '재이 향수 포카', 5000, 'sumin', '포토카드', 72, '2022-03-28'),
	(41, '재이 런투유 폴라로이드', 6000, 'sumin', '폴라로이드', 72, '2022-05-13'),
	(22, "스트레이키즈 popup the victory 포토북 방찬", 13000, "felix", "기타", 17, "2022-06-01"),
	(16, "스트레이키즈 popup the victory 포스터 세트 리노", 10000, "tmzlwm325", "포스터", 18, "2022-06-01"),
	(17, "스트레이키즈 noeasy 위드드라마 창빈 포토카드", 10000, "bangchan", "포토카드", 19, "2021-06-01"),
	(18, "스키주 팝업스토어 미니 지니렛", 30000, "leeknow", "인형", 20, "2022-05-30"),
	(19, "스키즈 한지성 비공굿 인형 일괄 판매", 60000, "changbin", "인형", 21, "2020-11-03"),
	(20, "스키즈 앳스타일 표지 필릭스 a버전", 5000, "hyunjin", "잡지", 22, "2021-07-16"),
	(21, "스트레이키즈 NOEASY 쥬얼 표지 승민 ver", 18000, "han", "앨범", 23, "2021-08-30"),
	(22, "2020 스트레이키즈 아이엔 시즌그리팅", 25000, "felix", "시즌그리팅", 24, "2020-01-23"),
	(25, "드림캐쳐 썸냐 1기 공식키트 지유 증명사진", 10000, "qkdcks", "공식키트", 25, "2020-02-03"),
	(26, "드림캐쳐 MAISON 이벤트 수아 싸인 폴라로이드", 60000, "dlalsgh", "폴라로이드", 26, "2022-04-30"),
	(27, "드림캐쳐 데뷔 앨범 시연 포토카드 포함", 100000, "tjckdqls", "앨범", 27, "2022-03-08"),
	(28, "드림캐쳐 오드아이 한동 메이크스타 미공포", 30000, "ghkdguswls", "포토카드", 28, "2021-02-13"),
	(29, "드림캐쳐 유현 응원 슬로건", 12000, "gkswltjd", "기타", 29, "2022-04-04"),
	(30, "다미 폴라로이드 드림캐쳐 날아올라 prequel", 50000, "dldydqhr", "폴라로이드", 30, "2019-05-24"),
	(31, "드림캐쳐 가현 BOCA 메이크스타 미공포", 30000, "rlatmdals", "포토카드", 31, "2020-09-18"),
	(32, "우주소녀 2022 팬미팅 여름 포카", 16000, "didwjddls", "포토카드", 59, "2022-03-20"),
	(33, "에이티즈 윤호 일본 콘서트 우치와", 30000, "wolfchan", "기타", 46, "2021-08-10"),
	(34, "엔플라잉 승협 moonshot 문샷 앨범포카", 2000, "leebit", "포토카드", 62, "2021-07-01"),
	(35, "cix fix 3기 공식키트 bx 풀셋 판매", 16000, "dwakki", "공식키트", 32, "2022-02-20"),
	(36, "엔믹스 100일 이벤트 해원 폴라로이드", 160000, "jiniret", "폴라로이드", 38, "2022-06-04"),
	(37, "세븐틴 페더선 face the sun 앨범 분철 - 조슈아 구함", 20000, "hanqukka", "앨범", 3, "2022-05-21"),
	(38, "스테이씨 윤 솜뭉치 윤호랑 양도", 20000, "bbokari", "인형", 71, "2021-06-14"),
	(39, "cix 시네마 어린왕자 용희 포카 양도", 18000, "puppym", "포토카드", 34, "2020-10-28"),
	(40, "드림캐쳐 you and i 유앤아이 가현 공방 포카 양도", 70000, "foxiny", "포토카드", 31, "2020-09-28")
    ;
	




