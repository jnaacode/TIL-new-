-- 오라클 11G 이전 버전의 SQL 작성을 가능하게 하는 구문.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;


-- C## : 일반 사용자(사용자 계정을 의미)

-- 계정 생성
CREATE USER C##workbook IDENTIFIED BY workbook1234;
CREATE USER workbook IDENTIFIED BY workbook1234;

-- 접속, 기본 객체 생성 권한
GRANT CONNECT, RESOURCE TO C##workbook;
GRANT CONNECT, RESOURCE TO workbook;

-- 객체가 생성될 수 있는 공간 할당량 지정
-- alter user [유저명] default tablespace [테이블스페이스] quota unlimited on [테이블스페이스];
ALTER USER C##workbook DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
ALTER USER workbook DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

UPDATE MEMBER SET 
PROFILE_IMG = ''
WHERE MEMBER_NO =1;

INSERT INTO MEMBER
VALUES('USER01','PASS01','박진아',DEFAULT);

COMMIT;
ROLLBACK;

INSERT INTO MEMBER VALUES('user01', 'pass01', '홍길동', DEFAULT);

INSERT INTO MEMBER VALUES('user02', 'pass02', '고길동', DEFAULT);

SELECT count(*) FROM MEMBER
WHERE MEMBER_ID = 'user01';