/*
    함수 : 컬럼값을 읽어서 가공된 값을 반환
    
    - 단일행 함수 : N개의 값을 받아서 N개의 결과를 반환
    - 그룹 함수 : N개의 값을 받아서 1개의 결과를 반환
    
    >> 단일행 함수와 그룹 함수는 SELECT 절에서 함께 사용할 수 없음.
    >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/

-- 단일행 함수
/*
    문자 처리 함수
    
    LENGTH : 문자 수 반환
    - 한글 1글자 -> 1
    - 영문자/숫자/특수문자 -> 1
    
    LENGTHB : 바이트 수 반환
    - 한글 1글자 -> 3BYTE
    - 영문자/숫자/특수문자 -> 1BYTE
*/
SELECT
    LENGTH('데이터베이스'), LENGTHB('데이터베이스'),
    LENGTH('database'), LENGTHB('database')
FROM DUAL; -- 가상 테이블

/*
    INSTR(컬럼, 찾을문자, 시작위치, 몇번째)
    - 특정 문자가 몇 번째 위치하는지 반환
    - 없으면 0 반환
    - 시작 위치 : 1 (앞에서부터), -1 (뒤에서부터)
*/
SELECT
    INSTR('AABAACAABBAA','B', -1, 2), -- 뒤에서부터 2번째에 있는 B
    INSTR('AABAACAABBAA','D')
FROM DUAL;

-- USER_INFO에서 각 전화번호(CONTACT)에서 앞에서부터 5가 들어간 위치 조회
SELECT CONTACT,
    INSTR(CONTACT,'5',1)
FROM USER_INFO;   
-- EMPLOYEE에서 'S'가 포함되어 있는 이메일 중 @ 위치 조회
SELECT EMP_NAME,EMAIL,
    INSTR(EMAIL,'@',1)
FROM EMPLOYEE
WHERE EMAIL LIKE '%s%';

/*
    LPAD / RPAD (컬럼, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
    - 문자열을 조회 시 통일감있게 조회하고자 할 때 사용
*/
SELECT 
    LPAD('HELLO',10), -- 길이를 10 채우기위해 왼쪽 공백 5
    LPAD('HELLO',10,'A'),
    RPAD('HELLO',10), -- 길이를 10 채우기 위해 오른쪽 공백 5
    RPAD('HELLO',10,'A')
FROM DUAL;

/*
    LTRIM / RTRIM (컬럼, 제거하고자 하는 문자들)
    - 문자열에서 특정 문자를 제거한 나머지를 반환
*/
SELECT
    LTRIM ('      K    H    '), -- 왼쪽 공백 제거
    LTRIM('ACBAACCCKH','ABC'), -- 왼쪽에서 ABC에 해당하는 문자들 제거
    RTRIM('465485KH1854568','0123456789') -- 오른쪽에서 해당하는 숫자들 제거
FROM DUAL;

/*
    TRIM(LEADING|TRAILING|BOTH 제거하고자 하는 문자들 FROM 컬럼)
    - 문자열의 양쪽(앞/뒤)에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT
    TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'), -- LTRIM 
    TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'), -- RTRIM
    TRIM(BOTH 'Z' FROM 'ZZZKHZZZ'), -- 양쪽 모두 제거 
    TRIM('         KH             ')
FROM DUAL;

/*
    SUBSTR(컬럼, 시작 위치, 추출 길이)
    - 문자열에서 특정 부분을 잘라서 추출
*/
SELECT
    SUBSTR('PROGRAMMING', 5, 2), -- RA
    SUBSTR('PROGRAMMING', 1, 6), -- PROGRA
    SUBSTR('PROGRAMMING', -8, 3) -- GRA
FROM DUAL;

-- USER_INFO에서 전화번호(CONTACT)에서 가운데 4자리만 조회

SELECT NAME,CONTACT,
    SUBSTR(CONTACT,INSTR(CONTACT, '-')+1,4)
FROM USER_INFO;

-- EMPLOYEE EMAIL에서 아이디만(@ 앞에) 조회

SELECT EMP_NAME,EMAIL,
    SUBSTR(EMAIL,1,INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;

SELECT EMP_NAME,EMAIL,
    REPLACE(EMAIL, '@kh.or.kr','')
FROM EMPLOYEE;
-- 주민등록번호(EMP_NO)를 000000-0****** 로 조회 

SELECT EMP_NAME,EMP_NO,
    SUBSTR(EMP_NO,1,8),
    RPAD(SUBSTR(EMP_NO,1,8),14,'*') 
FROM EMPLOYEE
ORDER BY EMP_NO ASC;

SELECT EMP_NAME,EMP_NO,
    RPAD(SUBSTR(EMP_NO, 1,INSTR(EMP_NO,'-')+1),14,'*'),
    SUBSTR(EMP_NO, 1, 8) || '******',
    SUBSTR(EMP_NO, 1,INSTR(EMP_NO,'-')+1),
    INSTR(EMP_NO,'-') + 1
FROM EMPLOYEE;

SELECT EMP_NAME,EMP_NO,
    SUBSTR(EMP_NO,9,14),
    REPLACE (EMP_NO,SUBSTR(EMP_NO,-6,6),'******')
    FROM EMPLOYEE;

-- 남자 사원들만 조회

SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)=1; -- OR SUBSTR(EMP_NO,8,1)=3;

/*
    LOWER : 다 소문자로 변경
    UPPER : 다 대문자로 변경
*/
SELECT LOWER('Welcome'), UPPER('Welcome')
FROM DUAL;

/*
    CONCAT (문자열, 문자열)
    - 문자열 두개를 전달받아 하나로 합친 후 결과 반환
*/
-- 가나다라, 1234 합치기
SELECT CONCAT('가나다라','1234')
FROM DUAL;

SELECT '가나다라'||'1234' 
FROM DUAL;

-- 가나다라, ABCD, 1234 합치기
SELECT CONCAT('가나다라', CONCAT('ABCD',CONCAT('12',CONCAT('3','4')))) 합체
-- CONCAT(CONCAT ('가나다라','ABCD'),'1234')
-- '가나다라'||'ABCD'||'1234'
FROM DUAL;

/*
    REPLACE(컬럼, 바꾸고 싶은 문자열, 바꿀 문자열)
    - 특정 문자열로 변경
*/
SELECT REPLACE('서울시 강남구 역삼동','역삼동','삼성동') FROM DUAL;

-- USER_INFO에서 서울 -> 경기
SELECT NAME,ADDRESS,
    REPLACE(ADDRESS,'서울','경기')
FROM USER_INFO;

--EMPLOYEE 에서 사원 이메일을 kh.or.kr -> gamil.com

SELECT EMP_NAME, EMAIL,
    REPLACE(EMAIL,'kh.or.kr','gamil.com')
FROM EMPLOYEE;

/*
    숫자 처리 함수
    
    ABS : 절대값 반환
    MOD(숫자, 숫자) : 두 수를 나눈 나머지 값 반환
    CEIL : 올림
    FLOOR : 내림
*/
SELECT 
    ABS(5.7), ABS(-10), 
    MOD(10,3), -- 1
    CEIL(123.152),
    FLOOR(123.952)
FROM DUAL;

/*
    ROUND(숫자, 위치)
    - 반올림한 결과 반환
*/
SELECT 
    ROUND(123.456), -- 위치 생략시 0 ->123
    ROUND(123.456, 1), -- 소수점 첫째 자리까지
    ROUND(123.456, -2) -- 십의 자리에서 반올림
FROM DUAL;

/*
    TRUNC(숫자, 위치)
    - 위치 지정하여 버림 처리
*/
SELECT
    TRUNC(123.952), -- 소수점 제거 -> 123
    TRUNC(123.952, 1) -- 소수점 첫째자리까지 -> 123.9     
FROM DUAL;

/*
    날짜 처리 함수
    
    SYSDATE : 시스템의 날짜를 반환 (현재 날짜)
    
*/
SELECT
    SYSDATE
FROM DUAL;

-- 날짜 포맷 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YY';

/*
    MONTHS_BETWEEN(날짜, 날짜)
    - 입력받은 두 날짜 사이의 개월 수 반환
*/

SELECT
    FLOOR(MONTHS_BETWEEN('20251216', SYSDATE))
FROM DUAL;

-- USER_INFO에서 몇개월 생인지 조회

SELECT NAME,BIRTHDATE,
    TRUNC(MONTHS_BETWEEN(SYSDATE, BIRTHDATE))
FROM USER_INFO;

/*
    ADD_MONTHS(날짜, 숫자)
    - 특정 날짜에 입력받는 숫자만큼 개월 수를 더한 날짜 반환
*/
SELECT 
    ADD_MONTHS(SYSDATE, 6)
FROM DUAL;

-- USER_INFO에서 해당 태어난 날짜부터 20년이 지났을 경우
SELECT BIRTHDATE,
    ADD_MONTHS(BIRTHDATE,12*20)
FROM USER_INFO;

/*
    NEXT_DAY(날짜, 요일(문자/숫자))
    - 특정 날짜에서 구하려는 요일의 가장 가까운 날짜 리턴
    - 요일 : 1 - 일요일, 2 - 월요일,... 7 - 토요일
*/
SELECT SYSDATE,
    NEXT_DAY(SYSDATE, '월요일')
FROM DUAL;

SELECT SYSDATE,
    NEXT_DAY(SYSDATE, 'THURSDAY')
FROM DUAL;

SELECT SYSDATE,
    NEXT_DAY(SYSDATE, 1)
FROM DUAL;

-- 언어 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = ENGLISH; -- AMERICAN

/*
    LAST_DAY(날짜)
    - 해당 월의 마지막 날짜 반환
*/
SELECT SYSDATE,
    LAST_DAY(SYSDATE), LAST_DAY('20250815'), LAST_DAY('2025/12/16')
FROM DUAL;

/*
    EXTRACT(YEAR|MONTH|DAY FROM 날짜)
    - 특정 날짜에서 연도, 월, 일 정보를추출
*/
-- USER_INFO 에서 BIRTHDATE로 연도, 월, 일 따로 조회
SELECT BIRTHDATE,
    EXTRACT(YEAR FROM BIRTHDATE) 연,
    EXTRACT(MONTH FROM BIRTHDATE) AS 월,
    EXTRACT(DAY FROM BIRTHDATE) "일"
FROM USER_INFO;

/*
    형 변환 함수
    
    TO_CHAR(날짜|숫자, 포멧)
    - 날짜 또는 숫자형 데이터를 문자 타입으로 변환
*/
SELECT
    TO_CHAR(1234, 'L99,999') -- 현재 설정된 화폐 단위
FROM DUAL;

ALTER SESSION SET NLS_CURRENCY ='₩';

-- EMPLOYEE에서 연봉을 TO_CHAR를 이용해 조회 (,)

SELECT EMP_NAME,SALARY,
    TO_CHAR(SALARY*12,'L999,999,999') 연봉
FROM EMPLOYEE
ORDER BY 연봉 DESC;

-- 날짜 -> 문자
SELECT 
    TO_CHAR(SYSDATE, 'RRRR') 연, -- 년 : YYYY, YY, RRRR, RR, YEAR
    TO_CHAR(SYSDATE, 'MM') 월, -- 월 : MM, RM, (MON, MONTH) : -월
    TO_CHAR(SYSDATE, 'DD') 일, -- 일 : D - 주(일요일 - 1), DD - 월. DDD - 연 
    TO_CHAR(SYSDATE, 'DAY') 요일,  -- 요일 : DY, DAY
    TO_CHAR(SYSDATE, 'PM HH:MI:SS'), -- 시 분 초
    TO_CHAR(SYSDATE, 'AM HH24:MI:SS') -- 24시간 표기법
FROM DUAL;

-- BIRTHDATE를 '2025년 06월 04일 수요일' 포맷으로 조회
SELECT NAME, BIRTHDATE,
    TO_CHAR (BIRTHDATE,'YYYY"년" MM"월" DD"일" DAY')
FROM USER_INFO;

/*
    TO_DATE(숫자|문자, 포멧)
    - 숫자 또는 문자형 데이터를 날짜 타입으로 변환
*/
-- 숫자 -> 날짜
SELECT TO_DATE(20250604) FROM DUAL;
SELECT TO_DATE(20250604164230, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

-- 문자 -> 날짜
SELECT TO_DATE('20250604') FROM DUAL;
SELECT TO_DATE('20250604164230', 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

/*
    TO_NUMBER(문자, 포멧)
    - 문자형 데이터를 숫자 타입으로 변환
*/
SELECT '100000'+'550000' FROM DUAL;
SELECT TO_NUMBER('100,000','999,999') + TO_NUMBER('550,000','999,999') FROM DUAL;

/*
    NULL 처리 함수
    
    NVL/COALESCE(값1, 값2)
    - 값1이 NULL이 아니면 값1을 반환하고,
      값1이 NULL이면 값2를 반환
*/
-- USER_INFO에서 MBTI가 NULL인 경우 'MBTI 모름' 처리
SELECT NAME,MBTI,
    NVL(MBTI,'MBTI 모름'),
    COALESCE(MBTI,'MBTI 모름')
FROM USER_INFO;

-- COALESCE(값1, 값2, ...)
-- MBTI가 NULL이 아니면 MBTI, NULL이면 HOBBY, 이것 또한 NULL이면 '모름'
SELECT NAME,MBTI,HOBBY,
    COALESCE(MBTI, HOBBY, '모름')
FROM USER_INFO;

/*
    NVL2(값1,값2,값3)
    - 값1이 NULL이 아니면 값2, NULL이면 값3
*/
-- EMPLOYEE에서 부서코드(DEPT_CODE)가 있으면 '부서있음', 없으면 '부서없음'
SELECT EMP_NAME,DEPT_CODE,
    NVL2(DEPT_CODE,'부서 있음','부서 없음') 부서
FROM EMPLOYEE
ORDER BY DEPT_CODE ASC NULLS FIRST;

/*
    NULLIF(값1, 값2)
    - 두 개의 값이 동일하면 NULL, 동일하지 않으면 값1
*/
SELECT 
    NULLIF('123','123'),
    NULLIF('123','456')
FROM DUAL;

/*
    선택 함수 : 여러 가지 경우에 선택할 수 있는 기능을 제공
    
    DECODE(값, 조건값1, 결과값, 조건값2, 결과값2, ...)
    - 비교하고자 하는 값이 조건값과 일치하는 경우 그에 해당하는 결과값 반환
*/
-- EMPLOYEE에서 주민번호(EMP_NO)로 성별(남, 여) 조회
SELECT EMP_NAME, EMP_NO,
    DECODE(SUBSTR(EMP_NO,8,1),1,'남',2,'여') 성별
FROM EMPLOYEE;