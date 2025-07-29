create table user_info(
  user_no INT PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(50)  NOT NULL,
  email VARCHAR(100) UNIQUE,
  id VARCHAR(50) UNIQUE NOT NULL,
  pwd VARCHAR(300) NOT NULL,
  phone VARCHAR(50) UNIQUE,
  addr VARCHAR(200),
  gender int CHECK (GENDER IN ('1', '2', '3', '4')),
  hire_date DATE DEFAULT (CURRENT_DATE),
  quit_date DATE,
  birthdate DATE,
  dept_no INT,
  grade_no INT
);

create table customer(
customer_no int primary key auto_increment,
 name VARCHAR(50), -- NOT NULL,
 email VARCHAR(100), -- UNIQUE,
 phone VARCHAR(50), -- UNIQUE,
 notes text,
 create_date DATE DEFAULT (CURRENT_DATE),
 user_no int
);
create table grade (
grade_no int primary key auto_increment,
grade_name varchar(50) -- not null
);
create table department (
dept_no int primary key auto_increment,
dept_name varchar(50), -- not null,
dept_color varchar(50) -- unique
);
create table customer_log (
log_no int primary key auto_increment,
customer_no int,
user_no int,
contact_date date default(current_date),
contact_type varchar(50), -- not null,
notes text
);
create table schedule (
sche_no int primary key auto_increment,
sche_title varchar(50), -- not null,
sche_desc text,
start_date date,
end_date date,
location varchar(50),
sche_type varchar(50), -- not null,
project_id int,
user_no int,
create_date date default(current_date),
update_date date default(current_date)
);
 CREATE TABLE approval_history (
  approval_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '승인 이력 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  approver_id INT NOT NULL COMMENT '승인자 ID',
  status VARCHAR(20) COMMENT '승인 상태 (대기, 승인, 반려)',
  comment TEXT COMMENT '승인 의견',
  approved_at DATETIME COMMENT '승인 일자'
);
CREATE TABLE chemical (
  chemical_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '시약 ID',
  product_name VARCHAR(200) NOT NULL COMMENT '제품명',
  cas_no VARCHAR(50) COMMENT 'CAS 번호',
  msds_url VARCHAR(255) COMMENT 'MSDS 문서 링크',
  hazard_class VARCHAR(50) COMMENT '위험물 분류 (지정수량 등)',
  stock_qty INT COMMENT '보유 수량'
);
 CREATE TABLE lab (
  lab_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '연구실 ID',
  lab_name VARCHAR(100) NOT NULL COMMENT '연구실명',
  location VARCHAR(255) COMMENT '위치',
  contact VARCHAR(100) COMMENT '연락처'
);
CREATE TABLE project (
  project_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '프로젝트 고유 ID',
  project_code VARCHAR(50) NOT NULL COMMENT '프로젝트 코드 (예: PJT-2025-001)',
  project_name VARCHAR(200) NOT NULL COMMENT '프로젝트명',
  project_type VARCHAR(50) COMMENT '프로젝트 유형 (신약개발, 제네릭 등)',
  manager_id INT DEFAULT 0 COMMENT '프로젝트 책임자 ID',
  status VARCHAR(20) COMMENT '상태 (계획중, 진행중, 완료 등)',
  start_date DATE COMMENT '프로젝트 시작일',
  end_date DATE COMMENT '프로젝트 종료일',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
);

 CREATE TABLE project_budget (
  budget_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '예산 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  item VARCHAR(100) COMMENT '예산 항목 (시약비, 인건비 등)',
  amount INT COMMENT '예산 금액',
  used_amount INT COMMENT '사용된 금액',
  approved_by INT COMMENT '승인자 ID'
);

CREATE TABLE project_chemical (
  chem_use_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '시약 사용 기록 고유 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  chemical_id INT NOT NULL COMMENT '시약 ID (CAS 번호)',
  quantity_used INT COMMENT '사용량',
  unit VARCHAR(10) COMMENT '단위 (mg, g 등)',
  used_at DATE COMMENT '사용 일자'
);

CREATE TABLE project_document (
  doc_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '문서 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  doc_name VARCHAR(200) NOT NULL COMMENT '문서명',
  doc_type VARCHAR(50) COMMENT '문서 유형 (계획서, 분석 보고서 등)',
  file_path VARCHAR(255) COMMENT '파일 저장 경로',
  uploaded_by INT COMMENT '업로더 ID',
  uploaded_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '업로드 시각',
  lab_id int
);

CREATE TABLE project_member (
   -- member_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '프로젝트 멤버 고유 ID',
    project_id INT NOT NULL COMMENT '프로젝트 ID',
    user_id INT NOT NULL COMMENT '사용자(참여자) ID',
    role VARCHAR(50) COMMENT '역할 (책임자, 연구원 등)'
);

CREATE TABLE project_phase (
  phase_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '프로젝트 단계 고유 ID',
  project_id INT NOT NULL COMMENT '연결된 프로젝트 ID',
  phase_name VARCHAR(100) NOT NULL COMMENT '단계명 (기획, 임상1상 등)',
  responsible_dept int COMMENT '담당 부서 또는 팀',
  start_date DATE COMMENT '단계 시작일',
  end_date DATE COMMENT '단계 종료일',
  progress INT COMMENT '진행률 (%)',
  notes TEXT COMMENT '비고'
);

CREATE TABLE project_task (
  task_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '업무 고유 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  task_name VARCHAR(200) NOT NULL COMMENT '업무 이름',
  assignee_id INT COMMENT '담당자 ID',
  due_date DATE COMMENT '마감일',
  status VARCHAR(20) COMMENT '업무 상태 (대기, 진행, 완료)',
  priority VARCHAR(10) COMMENT '우선순위 (상, 중, 하)',
  notes TEXT COMMENT '업무 상세 설명'
);

CREATE TABLE storage (
  storage_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '보관함 ID',
  lab_id INT NOT NULL COMMENT '연구실 위치',
  type VARCHAR(50) COMMENT '보관 종류 (냉장, 상온 등)'
);


-- user_info
alter table user_info add foreign key (dept_no) references department(dept_no);
alter table user_info add foreign key (grade_no) references grade(grade_no);

-- customer
alter table customer add foreign key (user_no) references user_info(user_no);

-- customer_log
alter table customer_log add foreign key (customer_no) references customer(customer_no);
alter table customer_log add foreign key (user_no) references user_info(user_no);

-- schedule
alter table schedule add foreign key (project_id) references project(project_id);
alter table schedule add foreign key (user_no) references user_info(user_no);


-- approval_history
-- alter table approval_history add foreign key (project_id) references project(project_id);
ALTER TABLE approval_history ADD FOREIGN KEY (project_id) REFERENCES project(project_id);


-- project_budget
-- alter table project_budget add foreign key (project_id) references project(project_id);
ALTER TABLE project_budget ADD FOREIGN KEY (project_id) REFERENCES project(project_id);

-- project_chemical
alter table project_chemical add foreign key (project_id) references project(project_id);

-- project_document
alter table project_document add foreign key (project_id) references project(project_id);

-- project_member
alter table project_member add foreign key (project_id) references project(project_id);
alter table project_member add foreign key (user_id) references user_info(user_no);

-- storage
alter table storage add foreign key (lab_id) references lab(lab_id);

-- project_task
alter table project_task add foreign key (assignee_id) references project_member(user_id);
alter table project_task add foreign key (project_id) references project(project_id);

-- project_phase
alter table project_phase add foreign key (project_id) references project(project_id);
-- alter table project_phase add foreign key (responsible_dept) references user_info(dept_no) ON DELETE SET NULL;

drop table approval_history;
drop table chemical;
drop table customer_log;
drop table customer;
drop table project_budget;
drop table project_chemical;
drop table project_document;
drop table project_phase;
drop table project_task; 
drop table schedule;
drop table storage;
drop table user_info;
drop table grade;
drop table lab;
drop table project_member;
drop table project;
drop table department;