-- 사용자
CREATE TABLE user(
	user_id INT AUTO_INCREMENT PRIMARY KEY, -- 사용자 ID
	email VARCHAR(100) NOT NULL UNIQUE, -- 이메일 (로그인 ID)
	password VARCHAR(255) NOT NULL, -- 비밀번호 (암호화 저장)
	name VARCHAR(50) NOT NULL, -- 이름
	dept_id INT, -- department.dept_id
	grade_id INT, -- grade.grade_id
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP -- 등록일
);
-- 직급 (고정데이터)
CREATE TABLE grade(
	grade_id INT PRIMARY KEY AUTO_INCREMENT,
	grade_name VARCHAR(50) NOT NULL, -- 직급명
	role VARCHAR(20) NOT NULL DEFAULT 'ROLE_RESEARCHER' -- 권한 설정 (RESEARCHER/MANAGER/ADMIN)
);
-- 부서 (고정데이터)
CREATE TABLE department(
	dept_id INT PRIMARY KEY AUTO_INCREMENT, -- 부서 고유 ID
	dept_name VARCHAR(100) NOT NULL UNIQUE -- 부서 이름
);

-- 프로젝트 : 프로젝트 목록 / 상세, 프로젝트 참여자 조회, 내 프로젝트 보기, 프로젝트 등록 시 참여자 추가, 프로젝트 상세 내 참여자 역할 구분, 책임자 필터 (캘린더에 추가)
CREATE TABLE project (
    project_id INT AUTO_INCREMENT PRIMARY KEY,       -- 프로젝트 고유 ID
    project_code VARCHAR(50) NOT NULL UNIQUE,        -- 프로젝트 코드 (예: PJT-2025-001)
    project_name VARCHAR(100) NOT NULL,              -- 프로젝트명
    project_type VARCHAR(50),                        -- 프로젝트 유형
    user_id INT,                                     -- 책임자 (user.user_id 참조 예정)
    start_date DATE NOT NULL,                        -- 시작일
    end_date DATE NOT NULL,                          -- 종료일
    status VARCHAR(20) DEFAULT '계획중',               -- 상태 (계획중, 진행중, 완료 등)
    description TEXT,                                -- 설명
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,   -- 생성일시
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP    -- 최종 수정일시
);
CREATE TABLE project_member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,        -- 프로젝트 참여 고유 ID
    project_id INT NOT NULL,                         -- 프로젝트 ID
    user_id INT NOT NULL,                            -- 참여자 ID
    role VARCHAR(50),                                -- 프로젝트 내 역할 (예: 연구책임자, 실험 담당 등)
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP    -- 참여일
);

-- 실험 일정 (차라리 task를 없앰) 그냥 연구원별로 각 업무에 대한 것 관리 
CREATE TABLE schedule (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,      -- 일정 ID
    title VARCHAR(100) NOT NULL,                     -- 일정 제목
    description TEXT,                                -- 상세 내용
    user_id INT NOT NULL,                            -- 작성자 ID (모든 직원 개인 관리)
    project_id INT,									 -- 프로젝트 ID (필수 x)
    start_datetime DATETIME NOT NULL,                -- 시작 일시
    end_datetime DATETIME NOT NULL,                  -- 종료 일시
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP    -- 등록일
);

-- 전체 시약 목록
CREATE TABLE chemical (
    chemical_id INT AUTO_INCREMENT PRIMARY KEY,      -- 시약 ID
    name VARCHAR(100) NOT NULL,                      -- 시약명
    cas_no VARCHAR(50),                              -- CAS 번호
    storage_unit VARCHAR(50),                        -- 보관 단위 (예: g, mL)
    storage_id INT NOT NULL,                         -- 보관소 ID
    stock_qty INT DEFAULT 0,                         -- 현재 재고 수량
    threshold_qty INT DEFAULT 5,                     -- 경고 기준 재고 수량
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP    -- 등록일
);
CREATE TABLE storage (
    storage_id INT AUTO_INCREMENT PRIMARY KEY,       -- 보관소 ID
    name VARCHAR(100) NOT NULL,                      -- 보관소 이름 (예: 실험실 냉장고1)
    location VARCHAR(200),                           -- (연구소)위치 -> lab 테이블 제거 간단하게 가는 게 나을거 같아서요! 스토리지 보관 위치까지만
    type VARCHAR(100),                               -- 보관 방식
    description TEXT                                 -- 기타 설명
);
CREATE TABLE project_chemical (
    project_chemical_id INT AUTO_INCREMENT PRIMARY KEY, -- 고유 ID
    project_id INT NOT NULL,                         -- 프로젝트 ID
    chemical_id INT NOT NULL,                        -- 시약 ID
    user_id INT NOT NULL,                            -- 사용한 연구원 ID (USER)
    used_qty INT NOT NULL,                           -- 사용 수량
    used_at DATETIME DEFAULT CURRENT_TIMESTAMP       -- 사용 일시 (수량 변경 시점 기록)
);

-- 문서
CREATE TABLE project_document (
    document_id INT AUTO_INCREMENT PRIMARY KEY,      -- 문서 ID
    project_id INT NOT NULL,                         -- 관련 프로젝트 ID
    user_id INT NOT NULL,                            -- 업로드한 사용자 ID
    file_name VARCHAR(255) NOT NULL,                 -- 파일명
    file_path VARCHAR(255) NOT NULL,                 -- 저장 경로
    version INT DEFAULT 1,                           -- 문서 버전
    uploaded_at DATETIME DEFAULT CURRENT_TIMESTAMP   -- 업로드 일시 (고정값)
);
-- 승인 요청 기록
CREATE TABLE approval (
    approval_id INT AUTO_INCREMENT PRIMARY KEY,      -- 승인 요청 ID
    project_id INT NOT NULL,                         -- 관련 프로젝트 ID
    requested_by INT NOT NULL,                       -- 요청자 ID (연구원 ID -> user_id)
    approval_type VARCHAR(50),                       -- 요청 유형 (문서, 예산, 시약 등)
    target_id INT,                                   -- 대상 항목 ID (문서 ID 등)
    status VARCHAR(20) DEFAULT '대기',                -- 상태 (대기, 승인, 반려)
    comment TEXT,                                    -- 관리자 코멘트
    approved_by INT,                                 -- 승인자 ID (관리자 ID -> user_id)
    approved_at DATETIME                             -- 승인 일시
);

-- 고객
CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,      -- 고객 ID
    name VARCHAR(100) NOT NULL,                      -- 담당자명
    department VARCHAR(100),                         -- 소속(기관명 등)
    assign_id INT,		                             -- 담당자 (user_id)
    phone VARCHAR(50),                               -- 연락처
    email VARCHAR(100),                              -- 이메일
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP    -- 등록된 날짜
);
-- 고객 컨택 이력 (클레임 배분)
CREATE TABLE customer_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,           -- 이력 ID
    customer_id INT NOT NULL,                        -- 고객 ID (작성자일 경우, board_no 가져옴)
    project_id INT,                                  -- 관련 프로젝트 ID (배분 시 필요)
    description TEXT,								 -- 요약
    log_date DATETIME DEFAULT CURRENT_TIMESTAMP      -- 이력 일시
);
-- 게시판 내 작성된 문건 (고객 클레임의 경우, 고객관계관리 내 데이터로 반영됨)
CREATE TABLE board (
    board_no INT AUTO_INCREMENT PRIMARY KEY,     	-- 게시물 ID
    title VARCHAR(50) NOT NULL,                 	-- 게시물 제목
    content TEXT,                      				-- 게시물 내용
    url VARCHAR(200),                 				-- 파일 경로
    type VARCHAR(20) NOT NULL,						-- 게시물 유형 (공지, 클레임..)
    uploader_type VARCHAR(20) NOT NULL,				-- 작성자 유형 ('USER', 'CUSTOMER' 두 테이블의 ID를 모두 저장)
    uploaded_by INT NOT NULL,						-- 작성자 ID
    uploaded_at DATETIME DEFAULT CURRENT_TIMESTAMP,	-- 등록 일자
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP 	-- 최종 수정 일시
);

INSERT INTO customer (name, department, phone, email) VALUES
('김민지', '한빛바이오텍', '010-1234-5678', 'minji.kim@pharma.com'),
('이서준', '미래헬스케어', '010-2345-6789', 'seojun.lee@healthcare.com'),
('박지은', '새롬제약', '010-3456-7890', 'jieun.park@pharma.com'),
('정우진', '한국의료기기공단', '010-4567-8901', 'woojin.jeong@medical.com'),
('최수민', '은하정밀의료', '010-5678-9012', 'sumin.choi@biomed.com'),
('윤하은', '푸른메디컬', '010-6789-0123', 'haeun.yun@med.com'),
('서준혁', '태양생명과학', '010-7890-1234', 'junhyeok.seo@bio.com'),
('조예린', '새한병원', '010-8901-2345', 'yerin.jo@hospital.com'),
('임서연', '대한약품', '010-9012-3456', 'seoyeon.lim@pharma.com'),
('김도윤', '아침신약개발', '010-0123-4567', 'doyun.kim@rd.com'),
('이지원', '한빛바이오텍', '010-1111-2222', 'jiwon.lee@pharma.com'),
('박성현', '미래헬스케어', '010-2222-3333', 'seonghyeon.park@healthcare.com'),
('정서윤', '새롬제약', '010-3333-4444', 'seoyun.jeong@pharma.com'),
('최민준', '한국의료기기공단', '010-4444-5555', 'minjun.choi@medical.com'),
('윤채원', '은하정밀의료', '010-5555-6666', 'chaewon.yun@biomed.com'),
('서현우', '푸른메디컬', '010-6666-7777', 'hyeonwoo.seo@med.com'),
('조하늘', '태양생명과학', '010-7777-8888', 'haneul.jo@bio.com'),
('임지훈', '새한병원', '010-8888-9999', 'jihun.lim@hospital.com'),
('김예진', '대한약품', '010-9999-0000', 'yejin.kim@pharma.com'),
('이승민', '아침신약개발', '010-0000-1111', 'seungmin.lee@rd.com');       

INSERT INTO customer_log (customer_id, project_id, description, log_date) VALUES
(12, 5, '신규 약품 배송 중 포장재가 파손되어 내용물 일부가 오염된 클레임 접수됨.', '2024-08-15 11:23:45'),
(7, 18, '만성 통증 완화제 복용 후 예상치 못한 부작용(가려움증)이 발생했다는 문의사항 확인 및 기록.', '2024-08-03 14:01:22'),
(20, 9, '의료기기 사용법 관련 문의 전화. 사용 설명서의 내용이 불분명하다는 피드백 확인.', '2024-08-28 09:47:11'),
(3, 11, '처방된 A 약품이 유통기한이 지난 상태로 배송되어 즉시 교환 요청 처리.', '2024-08-10 16:55:08'),
(15, 2, '치과용 재료 주문 건에서 누락된 품목이 있어 추가 배송을 긴급하게 요청함.', '2024-08-21 10:30:00'),
(9, 13, '신규 제약품 샘플에 대한 클레임. 색상과 질감이 기존 제품과 다르다는 의견 접수.', '2024-08-05 08:15:33'),
(18, 7, '병원 내에서 사용 중인 소독제 용기가 자주 새는 문제에 대해 개선 방안 요구.', '2024-08-25 17:02:51'),
(1, 4, '피부과 클리닉에서 의약품 유통 과정 중 온도 관리가 미흡했다는 의혹 제기.', '2024-08-19 13:40:17'),
(10, 16, '환자가 복용한 약물에 대한 상세 정보 요청. 복용 후 복통을 호소했다는 내용 기록.', '2024-08-08 19:20:05'),
(5, 1, '의약품 배송 시 일부 상자의 파손으로 인해 수량 부족 사태 발생.', '2024-08-14 07:55:49'),
(14, 10, '성장 호르몬제 처방 오류에 대한 클레임. 용량이 잘못 기입된 문제 확인.', '2024-08-01 12:10:34'),
(17, 6, '임상 시험용 약물 보관 상태에 대한 문의. 적정 온도가 유지되지 않았다는 신고 접수.', '2024-08-29 15:44:02'),
(6, 19, '의약품 성분 분석 결과에 대한 이의 제기. 성분 함량에 대한 의문 제기.', '2024-08-12 21:05:16'),
(11, 8, '새롭게 도입된 의료용 주사기에 대한 불만 사항. 주입 시 통증이 심하다는 피드백 기록.', '2024-08-22 09:00:00'),
(2, 17, '유전자 분석 키트 반품 건에 대한 문의. 검사 결과가 불분명하여 재검 요청함.', '2024-08-09 18:33:19'); 