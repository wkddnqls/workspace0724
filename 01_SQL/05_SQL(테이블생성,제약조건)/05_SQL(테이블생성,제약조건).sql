/*
  DDL(Date Definition Langiage) : 데이터 정의어
  데이버테이스에서 사용하는 SQL 명령어 중 데이터를 저장할 객체의 구조를 정의하거나 변경 의미
  
  오라클에서 객체(구조) : 테이블 , 뷰 , 시퀀스, 인덱스, 패키지 ,트리거 ,포르시저 ,함수 사용자 등등
  
  객체를 새아성(CREATE) , 변경(ALRER) , 삭제(DROP)하는 구문
*/


/*
<CREATE>
객체를 새로 생성하는 구문

1. 테이블 생성 
 - 테이블 : 행과열로 구성되는 가장 기본적인 데이터베이스 객체
           모든 데이터들은 테이블을 통해서 저장된다.
           (DBMS 용어 중 하나로 , 데이터를 일종의 표 형태로 표한한 것)
           
           
     [표현식]
     CREATE TABLE 테이블명(
        컬럼명 자료형(크기),
        컬럼명 자료형(크기),
        컬럼명 자료형,
        ....
     )
     
     * 자료형
     - 숫자(NUMBER)
     - 문자 ( CHAR(바이트크기) | VARCHAR2 (바이트크기)) -> 반드시 크기를 지정해야 함
        - CHAR :최대 2000바이트까지 지정가능 / 고정길이(고정된 글자수의 데이터가 담길 경우)
        - VARCHAR2: 최대 4000바이트까지 지정가능 / 가변길이(몇글자의 데이터가 들어올지 확신이 없을경우)
  
  */

--회원에 대한 데이터를 담귀위한 테이블 MEMBER 생성
CREATE TABLE MEMBER(
     MEM_NO NUMBER ,
     MEM_ID VARCHAR2(30) , --user 1 , test 1234
     MEM_PWD VARCHAR2(30),
     MEM_NAME VARCHAR2(21),
     GENDER CHAR(3),
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE
     );
     
     
     
 -----------------------------------------------------------
 /*
 2. 컬럼에 주석달기(컬럼에대한 간단한 설명)
   [표현법]
   COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
 */
     
COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.GENDER IS '성멸(남/여)';
COMMENT ON COLUMN MEMBER.PHONE IS '전화번호';
COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.CREATE_AT IS '회원가입일';

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

SELECT *
FROM MEMBER;

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , NULL ,  NULL , '010-3333-3222' ,  NULL ,  NULL);


----------------------------------------------------------------------

/*
<제약조건>
-원하는 데이터값(유효한 형식의 값) 만 유지하기 위해서 특정 컬럼에 설정하는 제약
-데이터 무결성 보장을 목적으로 함 -> 데이터베이스에 저장된 데이터가 정확하고 일관되며
 신뢰할 수 있는 상태를 유지 ->잘못된 값이 저장되지않음

종류 : NOT NULL , UNIQUE , CHECK , PRIMARY KEY , FOREIGN KEY ,,,,

*/

/*
*NOT NULL
해당 컬럼에 반드시 값이 존재해야만 하는경우(즉, 절대NULL이 들어오면 안되는 경우)
삽입/수정시 NULL값을 허용하지 않도록 제한 

<제약조건 부여방식>
1.컬럼레벨 제약조건부여 ( 컬럼 옆에다 제약조건을 그냥 써서 부여)
CREATE TABLE MEMBER(
NAME VARCHAR2(30) PRIMARY KEY 
)

CREATE TABLE MEMBER(
NAME VARCHAR2(30) NOT NULL
)


2.테이블레벨 제약조건부여 (따로 줄을 써서 부여)
CREATE TABLE MEMBER(
NAME VARCHAR2(30) ,
CONSTRAINT MEM_PK PRIMARY KEY(NAME)
)


*/
DROP TABLE MEMBER;


CREATE TABLE MEMBER(
     MEM_NO NUMBER NOT NULL,
     MEM_ID VARCHAR2(30) NOT NULL, --user 1 , test 1234
     MEM_PWD VARCHAR2(30)NOT NULL,
     MEM_NAME VARCHAR2(21)NOT NULL,
     GENDER CHAR(3),
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE
     );
     
INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

SELECT *
FROM MEMBER;

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길순' ,  NULL , NULL ,  NULL ,  NULL);


--아이디가 중복되었음에도 불구하고 잘 추가가 됨.


-------------------------------------------------------------

/*
            *UNIQUE 제약조건
            해당 컬럼에 중복값이 들어가서는 안될 경우 사용한다
            컬럼값에 중복값을 제한하는 제약조건.
            삽입/수정시 기존에 있는 데이터값 중 중복값이 있을 경우 오류를 발생시킴.
*/

DROP TABLE MEMBER;


CREATE TABLE MEMBER(
     MEM_NO NUMBER NOT NULL,
     MEM_ID VARCHAR2(30) NOT NULL UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)NOT NULL,
     MEM_NAME VARCHAR2(21)NOT NULL,
     GENDER CHAR(3),
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     UNIQUE(EMAIL) -- 테이블레벨 부여방식
     );

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

SELECT *
FROM MEMBER;

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길순' ,  NULL , NULL ,  NULL ,  NULL);
-- UNIQUE 제약조건에 위배되었으므로 INSERT 실패
-->오류구문을 제약조건명으로 알려준다.
-->쉽게 어떤 제약조건이 위반인지 알기 어렵다.
--> 제약조건 부여시 제약조건명을 지정해주면 오류구문에서 제약조건 확인이 쉽다.

----------------------------------------------------------------------------
/*
   제약조건 부여시 함께 제약조건명을 부여
   >컬럼레벨 방식
   
   CREATE TABLE 테이블명(
   컬럼명 자료형 CONSTRAINT 제약조건명 제약조건
   )
   
   >테이블레벨방식
   CREATE TABLE 테이블명(
   컬럼명 자료형 , CONSTRAINT 제약조건명 제약조건(컬럼명)
   )
*/

DROP TABLE MEMBER;


CREATE TABLE MEMBER(
     MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
     MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NULL CONSTRAINT MEMID_NT UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)CONSTRAINT MEMPWD_NT NULL,
     MEM_NAME VARCHAR2(21)CONSTRAINT MEMNAME_NT NOT NULL,
     GENDER CHAR(3),
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     UNIQUE(EMAIL)  -- 테이블레벨 부여방식
     );

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

SELECT *
FROM MEMBER;

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길순' ,  NULL , NULL ,  'AAA@naver.com' ,  NULL);
     
--------------------------------------------------------------------------------     
  /*
    *CHECK(조건식)
    해당 컬럼에 들어올 수 있는 값에 대한 조건을 제시할 수 잇음,
    데이터를 추가/수정시 조건식을 만족해야 정상적인 실행이 가능함.
  
  
  */
  
DROP TABLE MEMBER;  
     
CREATE TABLE MEMBER(
     MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
     MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NULL CONSTRAINT MEMID_NT UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)CONSTRAINT MEMPWD_NT NULL,
     MEM_NAME VARCHAR2(21)CONSTRAINT MEMNAME_NT NOT NULL,
     GENDER CHAR(3) NOT NULL CHECK(GENDER IN('남' , '여')) ,
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     CONSTRAINT EMAIL_UQ UNIQUE(EMAIL)  -- 테이블레벨 부여방식
     -- CHECK(GENDER IN('남' , '여')) 테이블레벨 부여방식
     );     
     
INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

SELECT *
FROM MEMBER;

INSERT INTO MEMBER
VALUES(1, 'UER02' , 'PASS02' , '홍길순' ,  '여' , 'D' ,  'AA@naver.com' ,  NULL);
-- CHECK 제약조건 때문에 '남' '여' 이외에 성별 입력시 예외 발생
-- 단 . NULL은 값이 없다는 뜻이기때문에 CHECK 제약조건과는 무관하다.

----------------------------------------------------------------------
/*
      PRIMARY KEY (기본 키) 제약조건
      테이블에서 각 행(ROW)를 식별하기위해 사용될 컬럼에 부여하는 제약조건(식별자 역할)
      
      EX)회원번호 , 학번, 부서코드 , 주민등록번호 , 택배운송장번호..
      기본키 ->중복금지 (UNIQUE) + NULL금지(NOT NULL)
      식별 , 무결 , 연결
      한테이블에 오직 한개만 설정 가능
*/
     
DROP TABLE MEMBER;  
     
CREATE TABLE MEMBER(
     MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,
     MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NULL CONSTRAINT MEMID_UQ UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)CONSTRAINT MEMPWD_NT NULL,
     MEM_NAME VARCHAR2(21)CONSTRAINT MEMNAME_NT NOT NULL,
     GENDER CHAR(3) NOT NULL CHECK(GENDER IN('남' , '여')) ,
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     CONSTRAINT EMAIL_UQ UNIQUE(EMAIL)  -- 테이블레벨 부여방식
     -- CHECK(GENDER IN('남' , '여')) 테이블레벨 부여방식
     -- CONSTRAINT MEMNO_PK PRIMARY KEY(MEM_NO) 테이블레벨 부여방식
     );     
INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

SELECT *
FROM MEMBER;

INSERT INTO MEMBER
VALUES(1, 'UER02' , 'PASS02' , '홍길순' ,  '여' , '241 1412 142' ,  'AA@naver.com' ,  NULL);     
--기본키에 중복된 값을 담으려고할 때(UNIQUE 제약조건 위반)     
     
INSERT INTO MEMBER
VALUES(NULL, 'UER02' , 'PASS02' , '홍길순' ,  '여' , '241 1412 142' ,  'AA@naver.com' ,  NULL);     
--기본키에 NULL 값을 담으려고할 때(NOT NULL 제약조건 위반)      
 
 INSERT INTO MEMBER
VALUES(2, 'UER02' , 'PASS02' , '홍길순' ,  '여' , '241 1412 142' ,  'AA@naver.com' ,  NULL);     
------------------------------------------------------------------------------

INSERT INTO MEMBER
VALUES(1, 'UER01' , 'PASS01' , '홍길동' , '남' , '010-3333-3222' , 'AAA@naver.com' , '25/07/30');

INSERT INTO MEMBER
VALUES(2, 'UER02' , 'PASS02' , '홍길순' ,  '여' , '241 1412 1421' ,  'AA@naver.com' ,  NULL);


INSERT INTO MEMBER
VALUES(3, 'UER03' , 'PASS03' , '홍길삼' ,  '여' , '241 1412 1442' ,  'A3A@naver.com' ,  NULL);

INSERT INTO MEMBER
VALUES(4, 'UER04' , 'PASS04' , '홍길사' ,  '여' , '241 1412 1422' ,  '4AA@naver.com' ,  NULL);

--복합키 : 2개의 컬럼을 동시에 하나의 PRIMARY KEY로 지정하는것
CREATE TABLE TB_LIKE(
MEM_NO NUMBER,
PRODUCT_NAME VARCHAR2(30),
LIKE_DATE DATE,
PRIMARY KEY(MEM_NO , PRODUCT_NAME)
);

SELECT *
FROM TB_LIKE;

--회원 4명(1,2,3,4 번) 
--상품2개(자전거A , 자전거 B)

INSERT INTO TB_LIKE VALUES(1,'자전거A', SYSDATE);
INSERT INTO TB_LIKE VALUES(1,'자전거B', SYSDATE);
INSERT INTO TB_LIKE VALUES(1,'자전거A', SYSDATE);

-----------------------------------------------------------------------------

--회원 등급에 대한 데이터 보관하는 테이블
CREATE TABLE MEM_GRADE(
       GRADE_CODE NUMBER PRIMARY KEY,
       GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO MEM_GRADE VALUES(10, '일반회원');
INSERT INTO MEM_GRADE VALUES(20, '우수회원');
INSERT INTO MEM_GRADE VALUES(30, '특별회원');
INSERT INTO MEM_GRADE VALUES(40, 'VIP회원');

SELECT *
FROM MEM_GRADE;

CREATE TABLE MEM(
     MEM_NO NUMBER PRIMARY KEY,
     MEM_ID VARCHAR2(30) NOT NULL UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)NOT NULL,
     MEM_NAME VARCHAR2(21) NOT NULL,
     GENDER CHAR(3) CHECK(GENDER IN('남' , '여')) ,
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     GRADE_ID NUMBER
);


INSERT INTO MEM
VALUES(1 , 'USER1' , 'PASS1' , '홍길동' , NULL , NULL ,NULL , '25/07/07',NULL );

INSERT INTO MEM
VALUES(2 , 'USER2' , 'PASS2' , '홍길이' , NULL , NULL ,NULL , '25/07/07',10 );

INSERT INTO MEM
VALUES(3 , 'USER3' , 'PASS3' , '홍길삼' , NULL , NULL ,NULL , '25/07/07',20 );

INSERT INTO MEM
VALUES(4 , 'USER4' , 'PASS4' , '홍길사' , NULL , NULL ,NULL , '25/07/07',40 );

INSERT INTO MEM
VALUES(5 , 'USER5' , 'PASS5' , '홍길오' , NULL , NULL ,NULL , '25/07/07',50 );



/*
FOREIGN_KEY (외래키) 제약조건
다른 테이블의 기본키(PK)또는 고유키 (UNIQUE)를 참조하도록 설정하는 제약조건
->다른 테이블을 참조한다고 표현
-> 대부분의 경우는 FOREIGN_KEY를 통해서 테이블간의 관계가 활성화된다

>컬럼레벨방식
컬럼 명 자료형 REFERENCES 참조할 테이블명 [참조할컬럼명]

>테이블레벨방식
FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명 [참조할컬럼명]
*/

DROP TABLE MEM;
SELECT *
FROM MEM_GRADE;
CREATE TABLE MEM_GRADE(
       GRADE_CODE NUMBER PRIMARY KEY,
       GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO MEM_GRADE VALUES(10, '일반회원');
INSERT INTO MEM_GRADE VALUES(20, '우수회원');
INSERT INTO MEM_GRADE VALUES(30, '특별회원');
INSERT INTO MEM_GRADE VALUES(40, 'VIP회원');


CREATE TABLE MEM(
     MEM_NO NUMBER PRIMARY KEY,
     MEM_ID VARCHAR2(30) NOT NULL UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)NOT NULL,
     MEM_NAME VARCHAR2(21) NOT NULL,
     GENDER CHAR(3) CHECK(GENDER IN('남' , '여')) ,
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     GRADE_ID NUMBER REFERENCES MEM_GRADE -- 써도되고 안써도댐(GRADE_CODE)
);


INSERT INTO MEM
VALUES(1 , 'USER1' , 'PASS1' , '홍길동' , NULL , NULL ,NULL , '25/07/07',NULL );

INSERT INTO MEM
VALUES(2 , 'USER2' , 'PASS2' , '홍길이' , NULL , NULL ,NULL , '25/07/07',10 );

INSERT INTO MEM
VALUES(3 , 'USER3' , 'PASS3' , '홍길삼' , NULL , NULL ,NULL , '25/07/07',20 );

INSERT INTO MEM
VALUES(4 , 'USER4' , 'PASS4' , '홍길사' , NULL , NULL ,NULL , '25/07/07',40 );


INSERT INTO MEM
VALUES(5 , 'USER5' , 'PASS5' , '홍길오' , NULL , NULL ,NULL , '25/07/07',50 );
--유효하지않은 회원등급번호는 정상적으로 INSERT할 수 없음.
/*
DELETE FROM MEM
WHERE MEM_NO = 4;
*/
SELECT * FROM MEM;
--MEM_GRADE(부모테이블) -) ----|- MEM(자식테이블)
-- 부모테이블 : 외래키로 참조되는 테이블 
-- 자식테이블 : 외래키를 통해 부모테이블을 참조하는 테이블
-- 1:N 일 경우 보통 N쪽이 자식테이블

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
--MEM 테이블에서 10이라는 GRADE_ID가 있기때문에 부모테이블의 GRADE_CODE 10을 가진
--데이터 삭제가 안됨

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 30;
--MEM 테이블에서 참조하고있지 않은 30의 GRADE_CODE를 가진 데이터는 삭제가 가능함.

--자식테이블에서 이미 사용하고 잇는 값이 있을경우
--부모테이블로부터 무조건 삭제가 안되는 "삭제제한"옵션이 기본값으로 설정되어있음.

/*
     자식테이블 생성시 외래키 제약조건 부여할 때 삭제옵션을 함께 지정가능.
   *삭제옵션: 부모테이블의 데이터 삭제시 그 데이터를 참조하고잇는 자식테이블의 데이터를 어떻게 처리할거냐

   - ON DELETE RESTRICTED(기본값) : 삭제제한옵션, 자식데이터로부터 쓰이는 부모데이터는 삭제X
   - ON DELETE SET NULL : 부모데이터 삭제시 해당 데이터를 사용하고있는 자식 데이터의 값 NULL로 변경
   - ON DELETE CASCADE : 부모데이터 삭제시 해당 데이터를 사용하고있는 자식데이터도 모두 삭제

*/

DROP TABLE MEM;

CREATE TABLE MEM(
     MEM_NO NUMBER PRIMARY KEY,
     MEM_ID VARCHAR2(30) NOT NULL UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)NOT NULL,
     MEM_NAME VARCHAR2(21) NOT NULL,
     GENDER CHAR(3) CHECK(GENDER IN('남' , '여')) ,
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     GRADE_ID NUMBER REFERENCES MEM_GRADE ON DELETE SET NULL
     -- 써도되고 안써도댐(GRADE_CODE)
);

INSERT INTO MEM
VALUES(1 , 'USER1' , 'PASS1' , '홍길동' , NULL , NULL ,NULL , '25/07/07',NULL );

INSERT INTO MEM
VALUES(2 , 'USER2' , 'PASS2' , '홍길이' , NULL , NULL ,NULL , '25/07/07',10 );

INSERT INTO MEM
VALUES(3 , 'USER3' , 'PASS3' , '홍길삼' , NULL , NULL ,NULL , '25/07/07',20 );

INSERT INTO MEM
VALUES(4 , 'USER4' , 'PASS4' , '홍길사' , NULL , NULL ,NULL , '25/07/07',40 );

/*
INSERT INTO MEM
VALUES(5 , 'USER5' , 'PASS5' , '홍길오' , NULL , NULL ,NULL , '25/07/07',50 );
*/

SELECT *
FROM MEM;

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 20 ;
--MEM_GRADE의 PK 20데이터가 삭제되면 SET NULL옵션에 따라 
-- GRADE_CODE 20인 데이터를 참조하던 자식데이터들은 전부 NULL을 가짐


CREATE TABLE MEM(
     MEM_NO NUMBER PRIMARY KEY,
     MEM_ID VARCHAR2(30) NOT NULL UNIQUE , --user 1 , test 1234
     MEM_PWD VARCHAR2(30)NOT NULL,
     MEM_NAME VARCHAR2(21) NOT NULL,
     GENDER CHAR(3) CHECK(GENDER IN('남' , '여')) ,
     PHONE VARCHAR2(13) ,
     EMAIL VARCHAR2(50),
     CREATE_AT DATE,
     GRADE_ID NUMBER REFERENCES MEM_GRADE ON DELETE CASCADE
     -- 써도되고 안써도댐(GRADE_CODE)
);

INSERT INTO MEM
VALUES(1 , 'USER1' , 'PASS1' , '홍길동' , NULL , NULL ,NULL , '25/07/07',NULL );

INSERT INTO MEM
VALUES(2 , 'USER2' , 'PASS2' , '홍길이' , NULL , NULL ,NULL , '25/07/07',10 );

INSERT INTO MEM
VALUES(3 , 'USER3' , 'PASS3' , '홍길삼' , NULL , NULL ,NULL , '25/07/07',20 );

INSERT INTO MEM
VALUES(4 , 'USER4' , 'PASS4' , '홍길사' , NULL , NULL ,NULL , '25/07/07',40 );

/*
INSERT INTO MEM
VALUES(5 , 'USER5' , 'PASS5' , '홍길오' , NULL , NULL ,NULL , '25/07/07',50 );
*/

SELECT *
FROM MEM;

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10 ;

--MEM_GRADE의 PK 10데이터가 삭제되면 CASCADE 옵션에 따라 
-- GRADE_CODE 10인 데이터를 참조하던 자식데이터들은 모두 함께 삭제됨

-------------------------------------------------------------------------------
/*
    <DEFAULT 기본값> *제약조건이 아니다.
    컬럼을 선정하지않고 INSERT시에 NULL이 아닌 기본값을 INSERT하고자한다.
    미리 값을 세팅해 둘 수 있음.
    
    컬럼명 자료형 DEFAULT 기본값
*/
/*
 NULL - 개발자가 잠깐 자리를 비워놓은거임
 UNDEFIEND - 개발자가 쓴다고해놓고 안씀
*/
DROP TABLE MEM;

CREATE TABLE MEM(
     MEM_NO NUMBER PRIMARY KEY,
     MEM_ID VARCHAR2(30) NOT NULL UNIQUE , --user 1 , test 1234
     MEM_AGE NUMBER,
     HOBBY VARCHAR2(20) DEFAULT '코딩',
     CREATE_AT DATE DEFAULT SYSDATE
);

-- INSERT INTO 테이블명 VALUES(값,값,,,,,,) -> 모든 컬럼값을 나열해야함.
INSERT INTO MEM VALUES(1,'USER01' , 20 , '운동' , '20/01/01');
INSERT INTO MEM VALUES(2,'USER02' , 24 , NULL , NULL);
INSERT INTO MEM VALUES(3,'USER03' , 27 , DEFAULT , NULL);
INSERT INTO MEM VALUES(4,'USER04' , 28 , DEFAULT , DEFAULT);
SELECT * FROM MEM;


--INSERT INTO 테이블명 (컬럼1, 컬럼2) VALUES(값1 , 값2); 
INSERT INTO MEM(MEM_NO,MEM_ID ,MEM_AGE) VALUES(5,'USER05' , 22 );
INSERT INTO MEM(MEM_NO,MEM_ID) VALUES(6,'USER06'  );
--> 선택되지 않은 컬럼에는 기본적으로 NULL이 적용됨
--> 단, 해당 컬럼에 DEFAULT값이 부여되어잇다면 NULL이 아닌 DEFAULT값이 적용됨

---------------------------------------------------------------------------

--관리자계정으로 계정생성
CREATE USER C##KH IDENTIFIED BY KH;

GRANT CONNECT, RESOURCE TO C##KH;

ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
--KH계정으로 전환

-----------------------------------------------------------------------------

--테이블을 복제할 수 있따 . 여기서부터 KH계정으로 진행함.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

--CREATE TABLE 테이블명 AS SELECT문 
-- AS 뒤에오는 SELECT문의 결과를 기반으로 테이블을 생성하겠다.
DROP TABLE EMPOYEE_COPY ;

CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE WHERE 1=20);


--------------------------------------------------------------------------
/*
   테이블이 생성된 후에 제약조건을 수정하는 방법
   ALTER TABLE 테이블명 변경할 내용
   
   제약조건 추가방법
   -PRIMARY KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명]  PRIMARY KEY (컬럼명);
   -FOREIGN KEY : ALTER TABLE 테이블명 ADD[CONSTRAINT 제약조건명] FOREIGN KEY (컬럼명) REFERENCES 참조할테이블명(컬럼명);
   -UNIQUE : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명]UNIQUE(컬럼명);
   -CHECK : ALTER TABLE 테이블명 ADD[CONSTRAINT 제약조건명] CHECK(컬럼에대한 조건식)
   
   위의 제약조건을 제거하려면
   -ALTER TABLE 테이블명 DROP CONTRAINT 제약조건이름;
   
   -NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
               ALTER TABLE 테이블명 MODIFY 컬럼명 NULL;
        

*/

--EMPLOYEE_COPY 테이블에 PRIMARY KEY 제약조건 추가 (EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY (EMP_ID);

--EMPLOYEE 테이블에 DEPT_CODE에 외래키제약조건을 추가(DEPT_ID를 참조)
ALTER TABLE EMPLOYEE ADD CONSTRAINT DEPT_FK FOREIGN KEY (DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);

----------------------------------------------------------------------------

-- 실습문제 --
-- 도서관리 프로그램을 만들기 위한 테이블들 만들기 --
-- 이때, 제약조건에 이름을 부여할 것
-- 각 컬럼에 주석 달기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER)
-- 컬럼 : PUB_NO (출판사 번호) - 기본키 (PUBLISHER_PK)
--        PUB_NAME (출판사명) - NOT NULL (PUBLISHER_NN)
--        PHONE (출판사 전화번호) - 제약조건 없음

-- 샘플 3개 정도 생성
DROP TABLE TB_PUBLISHER;

CREATE TABLE TB_PUBLISHER(
PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
PUB_NAME VARCHAR2(30) CONSTRAINT PUBLISHER_NN NOT NULL,
PHONE VARCHAR2(15)
);
COMMENT ON COLUMN TB_PUBLISHER.PUB_NO IS '출판사 번호';
COMMENT ON COLUMN TB_PUBLISHER.PUB_NAME IS '출판사 번호';
COMMENT ON COLUMN TB_PUBLISHER.PHONE IS '전화번호';

INSERT INTO TB_PUBLISHER VALUES (1 , '일번' , '010-1111-1111');
INSERT INTO TB_PUBLISHER VALUES (2 , '이번' , '010-2222-2222');
INSERT INTO TB_PUBLISHER VALUES (3 , '삼번'  , '010-3333-3333');

DELETE FROM TB_PUBLISHER WHERE PUB_NO = 1;

SELECT * FROM TB_PUBLISHER;


-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블(TB_BOOK)
-- 컬럼 : BK_NO (도서번호) - 기본키 (BOOK_PK)
--        BK_TITLE (도서명) - NOT NULL (BOOK__NN_TITLE)
--        BK_AUTHOR (저자명) - NOT NULL (BOOK__NN_AUTHOR)
--        BK_PRICE (가격) - 제약조건 없음
--        BK_PUB_NO (출판사 번호) - 외래키 (BOOK_FK), TB_PUBLISHER 테이블 참조
--                                 이때 참조하고 있는 부모데이터 삭제 시 자식데이터도 삭제되도록 옵션 지정

DROP TABLE TB_BOOK;
CREATE TABLE TB_BOOK(
BK_NO      NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
BK_TITLE   VARCHAR2(30) CONSTRAINT BOOK__NN_TITLE NOT NULL,
BK_AUTHOR  VARCHAR2(15) CONSTRAINT BOOK__NN_AUTHOR NOT NULL,
BK_PRICE   NUMBER,
BK_PUB_NO  NUMBER CONSTRAINT BOOK_FK REFERENCES TB_PUBLISHER 
ON DELETE SET NULL -- CASCADE
);
COMMENT ON COLUMN TB_BOOK.BK_NO IS '도서번호';
COMMENT ON COLUMN TB_BOOK.BK_TITLE IS '도서명';
COMMENT ON COLUMN TB_BOOK.BK_AUTHOR IS '저자명';
COMMENT ON COLUMN TB_BOOK.BK_PRICE IS '가격';
COMMENT ON COLUMN TB_BOOK.BK_PUB_NO IS '출판사 번호';

INSERT INTO TB_BOOK VALUES (1,'숫자일' , '저자1', 1000,1);
INSERT INTO TB_BOOK VALUES (2,'숫자이' , '저자2', 2000,2);
INSERT INTO TB_BOOK VALUES (3,'숫자삼' , '저자3', 3000,3);
INSERT INTO TB_BOOK VALUES (4,'숫자사' , '저자4', 4000,4);
INSERT INTO TB_BOOK VALUES (5,'숫자오' , '저자5', 5000,5);

DELETE FROM TB_BOOK WHERE BK_NO = 1;

SELECT * FROM TB_BOOK;
-- 샘플 5개 정도 생성

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블(TB_MEMBER)
-- 컬럼 : MEMBER_NO (회원번호) - 기본키 (MEMBER_PK)
--        MEMBER_ID (아이디) - 중복금지 (MEMBER_UQ_ID)
--        MEMBER_PWD (비밀번호) - NOT NULL (MEMBER_NN_PWD)
--        MEMBER_NAME (회원명) - NOT NULL (MEMBER_NN_NAME)
--        GENDER (성별) - M 또는 F로 제한 (MEMBER_CK_GEN)
--        ADDRESS (주소) - 제약조건 없음
--        PHONE (연락처) - 제약조건 없음
--        STATUS (탈퇴여부) - 기본값 N, N 또는 Y만 허용 (MEMBER_CK_STA)
--        ENROLL_DATE (가입일) - 기본값 SYSDATE, NOT NULL (MEMBER_NN_EN)

-- 샘플 5개 정도 생성
DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
MEMBER_ID VARCHAR2(30) CONSTRAINT MEMBER_UQ_ID UNIQUE,
MEMBER_PWD VARCHAR2(30) CONSTRAINT MEMBER_NN_PWD NOT NULL,
MEMBER_NAME VARCHAR2(30) CONSTRAINT MEMBER_NN_NAME NOT NULL,
GENDER VARCHAR2(10) CONSTRAINT MEMBER_CK_GEN CHECK (GENDER IN ('M', 'F')),
ADDRESS VARCHAR2(30),
PHONE VARCHAR2(15),
STATUS VARCHAR2(30) DEFAULT 'N' 
CONSTRAINT MEMBER_CK_STA CHECK (STATUS IN ('N', 'Y')),
ENROLL_DATE VARCHAR2(30) DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL
);
COMMENT ON COLUMN TB_MEMBER.MEMBER_NO IS '회원번호';
COMMENT ON COLUMN TB_MEMBER.MEMBER_ID IS '아이디';
COMMENT ON COLUMN TB_MEMBER.MEMBER_PWD IS '비밀번호';
COMMENT ON COLUMN TB_MEMBER.MEMBER_NAME IS '회원명';
COMMENT ON COLUMN TB_MEMBER.GENDER IS '성별';
COMMENT ON COLUMN TB_MEMBER.ADDRESS IS '주소';
COMMENT ON COLUMN TB_MEMBER.PHONE IS '연락처';
COMMENT ON COLUMN TB_MEMBER.STATUS IS '탈퇴여부';
COMMENT ON COLUMN TB_MEMBER.ENROLL_DATE IS '가입일';


INSERT INTO TB_MEMBER VALUES (1,'1' , '1', '월요일' , 'M', '역삼' , '010-1111-1111' 
                              , 'N' , '월요일' );
INSERT INTO TB_MEMBER VALUES (2,'2' , '2', '화요일' , 'F', '역삼2' , '010-2111-1111' 
                              , 'N' , '화요일' );                              
INSERT INTO TB_MEMBER VALUES (3,'3' , '3', '수요일' , 'F', '역삼3' , '010-3111-1111' 
                              , 'N' , '수요일' );                        
INSERT INTO TB_MEMBER VALUES (4,'4' , '4', '목요일' , 'M', '역삼4' , '010-4111-1111' 
                              , 'N' , '목요일' );                              
INSERT INTO TB_MEMBER VALUES (5,'5' , '5', '금요일' , 'M', '역삼5' , '010-5111-1111' 
                              , 'N' , '금요일' );                              
                              
SELECT * FROM TB_MEMBER;

-- 4. 어떤 회원이 어떤 도서를 대여했는지에 대한 대여목록 테이블(TB_RENT)
-- 컬럼 : RENT_NO (대여번호) - 기본키 (RENT_PK)
--        RENT_MEM_NO (대여회원번호) - 외래키 (RENT_FK_MEM), TB_MEMBER 참조
--                                     부모 데이터 삭제 시 자식데이터 값이 NULL이 되도록 지정
--        RENT_BOOK_NO (대여도서번호) - 외래키 (RENT_FK_BOOK), TB_BOOK 참조
--                                      부모 데이터 삭제 시 자식데이터 값이 NULL이 되도록 지정
--        RENT_DATE (대여일) - 기본값 SYSDATE

-- 샘플 3개 정도 생성
CREATE TABLE TB_RENT(
RENT_NO NUMBER CONSTRAINT RENT_PK PRIMARY KEY,
RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER ON DELETE SET NULL,
RENT_BOOK_NO NUMBER CONSTRAINT RENT_FK_BOOK REFERENCES TB_BOOK ON DELETE SET NULL,
RENT_DATE VARCHAR2(15) DATE DEFAULT SYSDATE
);

INSERT INTO TB_RENT VALUES ( 1 , 1 , 1 , '25/07/01');
INSERT INTO TB_RENT VALUES ( 2 , 2 , 2 , '25/07/02');
INSERT INTO TB_RENT VALUES ( 3 , 3 , 3 , '25/07/03');

DELETE FROM TB_RENT WHERE RENT_NO = 1;


SELECT * FROM TB_RENT;

SELECT *
FROM TB_RENT
JOIN TB_BOOK ON (RENT_BOOK_NO = BK_NO)
JOIN TB_MEMBER ON (RENT_MEM_NO = MEMBER_NO);



-- 대여목록 조회
-- TB_RENT, TB_MEMBER, TB_BOOK 테이블을 JOIN하여 대여 정보를 조회
















-----------------------------------------------------------------------------
-- 1. 
DROP TABLE TB_PUBLISHER;

CREATE TABLE TB_PUBLISHER(
PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
PUB_NAME VARCHAR2(30) CONSTRAINT PUBLISHER_NN NOT NULL,
PHONE VARCHAR2(15)
);
COMMENT ON COLUMN TB_PUBLISHER.PUB_NO IS '출판사 번호';
COMMENT ON COLUMN TB_PUBLISHER.PUB_NAME IS '출판사 번호';
COMMENT ON COLUMN TB_PUBLISHER.PHONE IS '전화번호';

INSERT INTO TB_PUBLISHER VALUES (1 , '일번' , '010-1111-1111');
INSERT INTO TB_PUBLISHER VALUES (2 , '이번' , '010-2222-2222');
INSERT INTO TB_PUBLISHER VALUES (3 , '삼번'  , '010-3333-3333');


SELECT * FROM TB_PUBLISHER;


--2.
DROP TABLE TB_BOOK;
CREATE TABLE TB_BOOK(
BK_NO NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
BK_TITLE VARCHAR2(30) CONSTRAINT BOOK__NN_TITLE NOT NULL,
BK_AUTHOR VARCHAR2(15) CONSTRAINT BOOK__NN_AUTHOR NOT NULL,
BK_PRICE NUMBER,
BK_PUB_NO NUMBER CONSTRAINT BOOK_FK REFERENCES TB_PUBLISHER ON DELETE SET NULL
);

INSERT INTO TB_BOOK VALUES (1,'숫자일' , '저자1', 1000,1);
INSERT INTO TB_BOOK VALUES (2,'숫자이' , '저자2', 2000,2);
INSERT INTO TB_BOOK VALUES (3,'숫자삼' , '저자3', 3000,3);
INSERT INTO TB_BOOK VALUES (4,'숫자사' , '저자4', 4000,4);
INSERT INTO TB_BOOK VALUES (5,'숫자오' , '저자5', 5000,5);

SELECT * FROM TB_BOOK;
--3.
DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
MEMBER_ID VARCHAR2(30) CONSTRAINT MEMBER_UQ_ID UNIQUE,
MEMBER_PWD VARCHAR2(30) CONSTRAINT MEMBER_NN_PWD NOT NULL,
MEMBER_NAME VARCHAR2(30) CONSTRAINT MEMBER_NN_NAME NOT NULL,
GENDER VARCHAR2(10) CONSTRAINT MEMBER_CK_GEN CHECK (GENDER IN ('M', 'F')),
ADDRESS VARCHAR2(30),
PHONE VARCHAR2(15),
STATUS VARCHAR2(30) DEFAULT 'N' 
CONSTRAINT MEMBER_CK_STA CHECK (STATUS IN ('N', 'Y')),
ENROLL_DATE VARCHAR2(30) DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL
);

--4
CREATE TABLE TB_RENT(
RENT_NO NUMBER CONSTRAINT RENT_PK PRIMARY KEY,
RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER ON DELETE SET NULL,
RENT_BOOK_NO NUMBER CONSTRAINT RENT_FK_BOOK REFERENCES TB_BOOK ON DELETE SET NULL,
RENT_DATE VARCHAR2(15) DATE DEFAULT SYSDATE
);

INSERT INTO TB_RENT VALUES ( 1 , 1 , 1 , '25/07/01');
INSERT INTO TB_RENT VALUES ( 2 , 2 , 2 , '25/07/02');
INSERT INTO TB_RENT VALUES ( 3 , 3 , 3 , '25/07/03');

DELETE FROM TB_RENT WHERE RENT_NO = 1;


SELECT * FROM TB_RENT;

SELECT *
FROM TB_RENT
JOIN TB_BOOK ON (RENT_BOOK_NO = BK_NO)
JOIN TB_MEMBER ON (RENT_MEM_NO = MEMBER_NO);




