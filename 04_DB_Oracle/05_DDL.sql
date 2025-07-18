/*
    DDL (Data Definition Language) : 데이터 정의어
    - 실제 데이터 값이 아닌 구조 자체를 정의하는 언어
    - 객체(스키마)를 만들고 (CREATE), 변경하고 (ALTER), 삭제 (DROP)하는 언어
    - DB 관리자, 설계자가 사용
    
    오라클에서 제공하는 객체(구조) / 스키마 (Schema) :
        테이블 (TABLE), 뷰 (VIEW), 시퀀스 (SEQUENCE)
        인덱스 (INDEX), 패키지 (PACKAGE), 트리거 (TRIGGER)
        프로시저 (PROCEDURE), 함수 (FUNCTION), 동의어 (SYNONYM)
        사용자 (USER)
*/
/*
    CREATE
    - 객체를 생성하는 구문
    
    테이블 생성
    테이블이란? 행 (ROW)과 열 (COLUMN)로 구성되는 가장 기본적인 데이터베이스 객체
                데이터베이스 내에 모든 데이터는 테이블에 저장
                
    CREATE TABLE 테이블명(
        컬럼명 자료형(크기),
        컬럼명 자료형(크기),
        ...
    );
    
    * 자료형
    1. 문자 (CHAR / VARCHAR2) - 반드시 크기를 지정
        - CHAR : 최대 2000 BYTE 까지 저장 가능
                고정 길이 (아무리 작은 값이 들어와도 처음 할당된 크기 그대로)
                고정된 글자수의 데이터만 담길 때 사용
        - VARCHAR2 : 최대 4000 BYTE 까지 저장 가능
                    가변 길이 (담긴 값에 따라서 공간의 크기를 맞춤)
                    몇 글자의 데이터가 들어올지 모를 경우
                    
    2. 숫자 (NUMBER)
    3. 날짜 (DATE)
*/
-- 회원에 대한 데이터를 담는 MEMBER 테이블 생성
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20),
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR(20),
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

-- 테이블 구조를 표시
DESC MEMBER;
/*
    데이터 딕셔너리
    - 다양한 객체들의 정보를 저장하고 있는 시스템 테이블
    - 사용자가 객체를 생성하거나 객체를 변경하는 등의 작업을 할 때
      데이터 베이스 서버에 의해서 자동으로 갱신되는 테이블
*/
-- USER_TABLES : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인할 수 있는 시스템 테이블
SELECT * FROM USER_TABLES;

-- USER_TAB_COLUMNS : 사용자가 가지고 있는 테이블들 상의
--                    모든 컬럼의 전반적인 구조를 확인할 수 있는 시스템 테이블
SELECT * FROM USER_TAB_COLUMNS;

/*
    컬럼 주석
    - 테이블 컬럼에 대한 설명을 작성할 수 있는 구문
    
    COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
*/
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원번호';

-- 테이블에 데이터 추가시키는 구문 (DML : INSERT)
-- INSERT INTO 테이블명 VALUES(값, 값, 값, ...);
INSERT INTO MEMBER VALUES(1, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEMBER(MEM_NO, MEM_ID, MEM_PWD, MEM_NAME) VALUES(2, 'user02', 'pass02', '이진용');
INSERT INTO MEMBER VALUES(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
SELECT * FROM MEMBER;

/*
    제약조건 (CONSTRAINTS)
    - 사용자가 원하는 조건의 데이터만 유지하기 위해서 각 컬럼에 대해 저장될 값에 대한 제약조건을 설정
    - 제약조건은 데이터 무결성 보장을 목적으로 한다. (데이터의 정확성과 일관성을 유지시키는 것)
    - 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
    
    CREATE TABLE 테이블명(
        컬럼명 자료형(크기) [CONSTRAINT 제약조건명] 제약조건,
        ...
    );
*/
/*
    NOT NULL 제약조건
    - 해당 컬럼에 반드시 값이 존재해야만 하는 경우 (해당 컬럼에 절대 NULL이 들어와서는 안되는 경우)
    - 추가 / 수정 시 NULL 값을 허용하지 않도록 제한
*/
CREATE TABLE MEM_NOTNULL (
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GENDER CHAR(3) ,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE NOT NULL
);
INSERT INTO MEM_NOTNULL VALUES(1, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_NOTNULL (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE) VALUES(2, 'user02', 'pass02', '이진용', SYSDATE);
INSERT INTO MEM_NOTNULL VALUES(1, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_NOTNULL (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE) VALUES(2, 'user02', 'pass02', '이진용', SYSDATE);
SELECT * FROM MEM_NOTNULL;

/*
    UNIQUE 제약조건
    - 해당 컬럼에 중복된 값이 들어와서는 안 되는 경우
    - 컬럼값에 중복값을 제한하는 제약조건
    - 추가/ 수정 시 기존에 있는 데이터값 중 중복값이 있을 경우 오류
*/
CREATE TABLE MEM_UNIQUE (
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GENDER CHAR(3) ,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE NOT NULL
);
INSERT INTO MEM_UNIQUE 
    VALUES(1, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_UNIQUE (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE) 
    VALUES(2, 'user02', 'pass02', '이진용', SYSDATE);
INSERT INTO MEM_UNIQUE (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, GENDER, MEM_DATE) 
    VALUES(3, 'user03', 'pass03', '곽병현', 'ㅇ', SYSDATE);
SELECT * FROM MEM_UNIQUE;

/*
    CHECK(조건식) 제약조건
    - 해당 컬럼에 들어올 수 있는 값에 대한 조건을 제시
    - 해당 조건에 만족하는 데이터 값만 담길 수 있음
*/
DROP TABLE MEM_CHECK;
CREATE TABLE MEM_CHECK (
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남','여')) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50) CHECK(EMAIL LIKE '%@%'),
    MEM_DATE DATE NOT NULL
);
INSERT INTO MEM_CHECK 
    VALUES(1, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_CHECK (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE, GENDER) 
    VALUES(2, 'user02', 'pass02', '이진용', SYSDATE,'남');
INSERT INTO MEM_CHECK (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, GENDER, MEM_DATE, EMAIL) 
    VALUES(3, 'user03', 'pass03', '곽병헌', '남', SYSDATE , 'bbb@google.com');
SELECT * FROM MEM_CHECK;

/*
    PRIMARY KEY(기본키) 제약조건
    - 테이블에서 각 행들을 식별하기 위해 사용될 컬럼에 부여하는 제약 (식별자 역할)
     EX) 회원번호, 학번, 사원번호, 부서코드, 직급코드, 주문번호, 예약번호, 운송장번호 ...
    - PRIMARY KEY 제약조건을 부여하면 그 컬럼은 자동으로 NOT NULL + UNIQUE 제약조건이 설정
    - 한 테이블 당 오로지 한 개만 설정 가능
*/
DROP TABLE MEM_PRI;
DROP SEQUENCE MEM_SEQ;
CREATE TABLE MEM_PRI(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남','여')) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50) CHECK(EMAIL LIKE '%@%'),
    MEM_DATE DATE NOT NULL
);

INSERT INTO MEM_PRI
    VALUES(1, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_PRI (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE, GENDER) 
    VALUES(2, 'user02', 'pass02', '이진용', SYSDATE,'남');
INSERT INTO MEM_PRI (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, GENDER, MEM_DATE, EMAIL) 
    VALUES(1, 'user03', 'pass03', '곽병헌', '남', SYSDATE , 'bbb@google.com');
SELECT * FROM MEM_PRI;

-- PRIMARY KEY 는 자동 -> SEQUENCE 사용
CREATE SEQUENCE MEM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

INSERT INTO MEM_PRI
    VALUES(MEM_SEQ.NEXTVAL, 'user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_PRI (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE, GENDER) 
    VALUES(MEM_SEQ.NEXTVAL, 'user02', 'pass02', '이진용', SYSDATE,'남');
INSERT INTO MEM_PRI (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, GENDER, MEM_DATE, EMAIL) 
    VALUES(MEM_SEQ.NEXTVAL, 'user03', 'pass03', '곽병헌', '남', SYSDATE , 'bbb@google.com');
SELECT * FROM MEM_PRI;

-- 오라클 예전 버전 X
CREATE TABLE MEM_PRI2(
    MEM_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남','여')) NOT NULL,
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50) CHECK(EMAIL LIKE '%@%'),
    MEM_DATE DATE NOT NULL
);

INSERT INTO MEM_PRI2 (MEM_ID, MEM_PWD, MEM_NAME, GENDER, PHONE, EMAIL, MEM_DATE) 
    VALUES('user01', 'pass01', '윤의진', '남', '010-1111-1111', 'aaa@naver.com', '25/06/05');
INSERT INTO MEM_PRI2 (MEM_ID, MEM_PWD, MEM_NAME, MEM_DATE, GENDER) 
    VALUES('user02', 'pass02', '이진용', SYSDATE,'남');
INSERT INTO MEM_PRI2 (MEM_ID, MEM_PWD, MEM_NAME, GENDER, MEM_DATE, EMAIL) 
    VALUES('user03', 'pass03', '곽병헌', '남', SYSDATE , 'bbb@google.com');
SELECT * FROM MEM_PRI2;

-- 회원등급에 대한 데이터를 보관하는 테이블 
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL 
);
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('일반회원');
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('우수회원');
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('특별회원');

SELECT * FROM MEM_GRADE;

DROP TABLE MEM_MEMBER;
CREATE TABLE MEM_MEMBER(
    MEM_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GRADE_ID NUMBER -- 회원등급 번호를 보관할 컬럼
);
INSERT INTO MEM_MEMBER (MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID) 
    VALUES('user01', 'pass01', '윤의진', 1);
INSERT INTO MEM_MEMBER (MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)  
    VALUES('user02', 'pass02', '이진용', 2);
INSERT INTO MEM_MEMBER (MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID) 
    VALUES('user03', 'pass03', '곽병헌', 10);
    
SELECT * FROM MEM_MEMBER;

SELECT MEM_ID, MEM_NAME, GRADE_NAME FROM MEM_MEMBER JOIN MEM_GRADE ON GRADE_ID = GRADE_CODE;

/*
    FOREIGN KEY (외래키) 제약조건
    - 외래키 역할을 하는 컬럼에 부여하는 제약조건
    - 다른 테이블에 존재하는 값만 들어와야 하는 특정 컬럼에 부여하는 제약조건
    
    -> 다른 테이블을 참조한다고 표현
    -> 주로 FOREIGN KEY 제약조건에 의해 테이블 간의 관계가 형성
*/
DROP TABLE MEM_MEMBER2;
CREATE TABLE MEM_MEMBER2(
    MEM_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR(20) NOT NULL,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) -- 외래키 
);
    
INSERT INTO MEM_MEMBER2 (MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID) 
    VALUES('user01', 'pass01', '윤의진', 1);
INSERT INTO MEM_MEMBER2 (MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)  
    VALUES('user02', 'pass02', '이진용', 2);
INSERT INTO MEM_MEMBER2 (MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID) 
    VALUES('user03', 'pass03', '곽병헌', 3);
SELECT * FROM MEM_MEMBER2;

-- MEM_MEMBER2(자식 테이블) ->---|- MEM_GRADE(부모 테이블)

-- 데이터 삭제 : DELETE FROM 테이블명 WHERE 조건;
-- MEM_GRADE 테이블에서 GRADE_CODE가 1인 걸 삭제
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 1;

-- 부모테이블(MEM_GRADE)에서 데이터 값을 삭제할 경우 문제 발생
-- 이유 : 자식 레코드가 있어서 삭제되지 않음
DELETE FROM MEM_MEMBER2 WHERE MEM_NO =1;

SELECT * FROM MEM_MEMBER2;
SELECT * FROM MEM_GRADE;

-- 테이블 삭제 FORNIGN KEY가 있는 테이블 먼저 삭제
DROP TABLE MEM_MEMBER2;
DROP TABLE MEM_GRADE;

/*
    자식테이블 생성시 외래키 제약조건을 부여할 때 삭제옵션 지정 가능
    * 삭제옵션 : 부모테이블의 데이터 삭제 시 그 데이터를 사용하고 있는 자식테이블의 값을 어떻게 처리할 건지
    
    - ON DELETE RESTRICTED (기본값)
        : 자식데이터로 쓰이는 부모데이터는 삭제 불가
    - ON DELETE SET NULL
        : 부모데이터 삭제시 해당 데이터를 사용중인 자식데이터 값을 NULL로 변경
    - ON DELETE CASCADE
        : 부모데이터 삭제시 해당 데이터를 쓰고 있는 자식데이터도 삭제
*/

CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('일반회원');
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('우수회원');
INSERT INTO MEM_GRADE(GRADE_NAME) VALUES ('특별회원');

CREATE TABLE MEM_MEMBER2(
    MEM_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GRADE_ID NUMBER,
    FOREIGN KEY (GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
);
INSERT INTO MEM_MEMBER2(MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)
    VALUES('user01', 'pass01', '윤의진', 1);
INSERT INTO MEM_MEMBER2(MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)
    VALUES('user02', 'pass02', '이진용', 2);
INSERT INTO MEM_MEMBER2(MEM_ID, MEM_PWD, MEM_NAME, GRADE_ID)
    VALUES('user03', 'pass03', '곽병현', 3);
    
SELECT * FROM MEM_MEMBER2;
SELECT * FROM MEM_GRADE;

DELETE FROM MEM_GRADE WHERE GRADE_CODE = 2;

/*
    DEFAULT 기본값 
    - 제약조건 X
    - 컬럼을 선정하지 않고 INSERT 시 NULL이 아닌 기본값을 INSERT 하고자 할 때 세팅해둘 수 있는 값
*/
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    MEM_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_AGE NUMBER DEFAULT 10,
    HOBBY VARCHAR2(20) DEFAULT '게임',
    ENROLL_DATE DATE DEFAULT SYSDATE
);
INSERT INTO MEMBER(MEM_NAME) VALUES('윤의진');
INSERT INTO MEMBER(MEM_NAME, MEM_AGE) VALUES ('이진용',20);
INSERT INTO MEMBER(MEM_NAME, MEM_AGE, HOBBY) VALUES ('곽병현', 15, '영화감상');
SELECT * FROM MEMBER;

-- 도서관리 프로그램 테이블들
-- 테이블명 : PUBLISHER
-- 컬럼 : PUB_NO - 숫자, 기본키
--       PUB_NAME - 문자(50), NULL 허용X
--       PHONE - 문자(20)

-- 테이블명 : BOOK
-- 컬럼 : BK_NO - 숫자,기본키
--       BK_TITLE - 문자(50), NULL X
--       BK_AUTHOR - 문자(50), NULL X
--       PUB_NO - 숫자, 외래키(PUBLISHER의 PUB_NO, 삭제 조건 CASCADE

-- 테이블명 : MEMBER (위에 존재 -> DROP)
-- 컬럼 : MEMBER_NO - 숫자, 기본키
--       MEMBER_ID - 문자(50), 중복허용X

-- 테이블명 : RENT
-- 컬럼 : RENT_NO - 숫자, 기본키
--       MEMBER_NO - 숫자, 외래키 (MEMBER의 MEMBER_NO, 삭제 조건 SET NULL)
--       BK_NO - 숫자, 외래키 (BOOK의 BK_NO, 삭제 조건 SET NULL)
CREATE TABLE PUBLISHER (
    PUB_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PUB_NAME VARCHAR2(50) NOT NULL,
    PHONE VARCHAR2(20)
);
INSERT INTO PUBLISHER(PUB_NAME,PHONE) VALUES('오픈도어북스','070-4170-1080');
INSERT INTO PUBLISHER(PUB_NAME,PHONE) VALUES('모티브','02-3141-6921');
SELECT * FROM PUBLISHER;

CREATE TABLE BOOK(
    BK_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    BK_TITLE VARCHAR2(50) NOT NULL,
    BK_AUTHOR VARCHAR2(50) NOT NULL,
    PUB_NO NUMBER REFERENCES PUBLISHER(PUB_NO) ON DELETE CASCADE
);
INSERT INTO BOOK (BK_TITLE, BK_AUTHOR, PUB_NO) VALUES ('누구도 대신 살아 주지 않는다','브라이언 트레이시', 1);
INSERT INTO BOOK (BK_TITLE, BK_AUTHOR, PUB_NO) VALUES ('게으르게 살지만 부자는 되고싶어','예프리',2);
INSERT INTO BOOK (BK_TITLE, BK_AUTHOR, PUB_NO) VALUES ('왜 항상 아가리로만 할까?','이창현', 2);
SELECT * FROM BOOK;

CREATE TABLE MEMBER(
    MEMBER_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEMBER_ID VARCHAR2(50) UNIQUE
);
INSERT INTO MEMBER (MEMBER_ID) VALUES('박민수');
INSERT INTO MEMBER (MEMBER_ID) VALUES('전민철');
SELECT * FROM MEMBER;

CREATE TABLE RENT(
    RENT_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MEMBER_NO NUMBER REFERENCES MEMBER(MEMBER_NO) ON DELETE SET NULL,
    BK_NO NUMBER REFERENCES BOOK(BK_NO) ON DELETE SET NULL
);
INSERT INTO RENT (MEMBER_NO,BK_NO) VALUES (1,1);
INSERT INTO RENT (MEMBER_NO,BK_NO) VALUES (2,3);
INSERT INTO RENT (MEMBER_NO,BK_NO) VALUES (2,2);

--RENT : MEMBER_ID, BK_TITLE, PUB_NAME
SELECT MEMBER_ID, BK_TITLE, PUB_NAME
FROM RENT R
JOIN MEMBER M ON(R.MEMBER_NO = M.MEMBER_NO)
JOIN BOOK B ON(R.BK_NO = B.BK_NO) 
JOIN PUBLISHER P ON(P.PUB_NO = B.PUB_NO);


DROP TABLE PUBLISHER;
DROP TABLE BOOK;
DROP TABLE MEMBER;
DROP TABLE RENT;

/*
    ALTER
    - 객체를 수정하는 구문
    
    ALTER TABLE 테이블명 수정할 내용;
*/
/*
    1. 컬럼 추가 / 수정 / 삭제 / 이름 변경
    1-1. 컬럼 추가 (ADD)
    ADD 컬럼명 데이터타입 [DEFAULT 기본값];
*/
-- 새로운 컬럼이 만들어지고 기본적으로 기존 데이터는 NULL 로 채워짐
ALTER TABLE USER_INFO ADD CNAME VARCHAR2(20);

-- 새로운 컬럼이 만들어지고 내가 지정한 기본값(DEFAULT)으로 채워짐;
ALTER TABLE USER_INFO ADD LNAME VARCHAR(20) DEFAULT '한국';

/*
    1-2. 컬럼 수정 (MODIFY)
        - 데이터 타입 변경 : MODIFY 컬럼명 변경할데이터타입;
        - 기본값 변경 : MODIFY 컬럼명 DEFAULT 변경할기본값;      
*/
-- 설정되어있는 값 조회
DESC USER_INFO;
ALTER TABLE USER_INFO MODIFY ADDRESS VARCHAR(100); 
-- 변경하려는 자료형의 크기보다 이미 큰 값이 존재하면 에러
ALTER TABLE USER_INFO MODIFY ADDRESS VARCHAR(10);
-- 변경하려는 자료형의 데이터가 존재할 시 바꾸려고 하면 에러
ALTER TABLE USER_INFO MODIFY ADDRESS NUMBER;
-- 값이 없으면 데이터타입 변경 가능
ALTER TABLE USER_INFO MODIFY CNAME NUMBER;

-- 다중 수정
ALTER TABLE USER_INFO
    MODIFY ADDRESS VARCHAR(50)
    MODIFY LNAME DEFAULT '아시아';
    
INSERT INTO USER_INFO(USER_ID,NAME) VALUES(USER_INFO_SEQ.NEXTVAL,'테스트');

/*
    1-3. 컬럼 삭제 (DROP)
    DROP COLUMN 컬럼명;
    
    - 데이터 값이 있어도 같이 삭제 (삭제된 컬럼은 복구불가)
*/
ALTER TABLE USER_INFO DROP COLUMN LNAME;

-- 부모키 (PRIMARY KEY) 참조되고 있는 컬럼이 있다면 삭제불가
ALTER TABLE BOOK DROP COLUMN BK_NO;

-- 참조되고 있는 컬럼이 삭제되어 있을 시 가능
ALTER TABLE PUBLISHER DROP COLUMN PUB_NO;

SELECT * FROM BOOK;

/*
    1-4. 컬럼명 변경
    RENAME COLOMN 기존 컬럼명 TO 변경할 컬럼명;
*/
ALTER TABLE USER_INFO RENAME COLUMN CONTACT TO PHONE;

SELECT * FROM USER_INFO;

/*
    2. 제약조건
    2-1. 제약조건 추가
    ADD [CONSTRAINT 제약조건명]
    - PRIMARY KEY : PRIMARY KEY(컬럼명);
    - FOREIGN KEY : FOREIGN KEY(컬럼명) REFERENCES 테이블명(컬럼명);
    - UNIQUE : UNIQUE(컬럼명);
    - CHECK : CHECK (컬럼에 대한 조건);
    
    NOT NULL : MODIFY 컬럼명 [CONSTRAINT 제약조건명] NOT NULL;
*/
CREATE TABLE DEPT_COPY
AS SELECT *FROM DEPARTMENT;

-- 제약조건명 없이 추가
ALTER TABLE DEPT_COPY
    ADD PRIMARY KEY(DEPT_ID);

-- 제약조건명 있게 추가
ALTER TABLE DEPT_COPY
    ADD CONSTRAINT DEPT_PK PRIMARY KEY(DEPT_ID);
/*
    2-2. 제약조건 삭제
    DROP CONSTRAINT 제약조건명;
    
*/
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_PK;

-- 제약조건 확인
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'DEPT_COPY';

/*
    2-3. 제약조건명 변경
    RENAME CONSTRAINT 기존 제약조건명 TO 변경할 제약조건명;
*/

ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C008505 TO DEPT_ID_PK;

/*
    3. 테이블명 변경
    ALTER TABLE 기존 테이블명 RENAME TO 변경할 테이블명;
                RENAME 기존테이블명 TO  변경할 테이블명;
*/

ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;
SELECT * FROM DEPT_TEST;

/*
    DROP
    - 객체를 삭제하는 구문
*/

DROP TABLE DEPT_TEST;

-- 참조되고 있는 부모 테이블은 함부로 삭제불가
DROP TABLE BOOK;

-- 만약 삭제하고자 한다면
-- 방법 1. 부모 테이블 삭제시 제약조건까지 같이 삭제
DROP TABLE BOOK CASCADE CONSTRAINT;

-- 방법 2. 자식 테이블 먼저 삭제 후 부모 테이블 삭제
-- 자식 테이블
DROP TABLE RENT;
-- 부모 테이블
DROP TABLE MEMBER; 

/*
    TRUNCATE
    - 테이블 구조는 유지, 데이터만 삭제`
*/
TRUNCATE TABLE DEPT_COPY;  
SELECT * FROM DEPT_COPY;