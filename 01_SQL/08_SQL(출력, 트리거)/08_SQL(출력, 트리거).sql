/*
    <PL/SQL>
    오라클 DBMS에서 사용하는 절차적 SQL 확장 언어다.
    일반 SQL의 단점을 보완해서 변수의 정의, 조건 (IF) , 반복(FOR , WHILE)등을 지원함.
    다수의 SQL문을 한번에 실행할 수 있음.
    PL/SQL 은 블록구조를 사용함.
    
    
    PL / SQL 구조
    DECLARE       -- (선택)선언부 : 변수 , 상수등을 선언
    BEGIN         -- 실행부 : SQL문 또는 제어문등의 로직을 기술
    EXCEPTION     -- (선택)예외처리부 : 오류 발생시 처리
    END;          -- PL/SQL의 마지막에 기술

*/

SET SERVEROUTPUT ON;


BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/

---------------------------------------------------------------------

/*
    1. DECLARE 선언부
    변수 및 상수를 선언하는 공간
    일반타임변수 , 래퍼런스타입변수, ROW타입변수
    
    1_1)일반타입 변수 선언및 초기화
    DECLARE 
       변수명 [CONSTANT] 자료형 [:=초기값]
       
*/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER :=3.14;
BEGIN
    EID := &번호;
    ENAME := &이름 ;
    
    DBMS_OUTPUT.PUT_LINE('EID :' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME:' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI :' || PI);

END;
/

-----------------------------------------------------------------------
/*
   1-2) 래퍼런스 타입 변수 : 어떤 테이블의 어떤 컬럼의 데이터타입을 참조해서 사용할지 정하는 방식
   
   
*/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
   /* EID := 800;
    ENAME := '최지원';
   SAL := 100000;*/
    
 SELECT EMP_ID,EMP_NAME , SALARY
    INTO EID , ENAME , SAL
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('EID :' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME:' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' ||  SAL);
END;
/

----------------------------------------------------------------------------
/*
   래퍼런스타입 변수로 EID , ENAME , SAL , DTITLE을 선언하고
   각 자료형 EMPLOYEE (EMP_ID , EMP_NAME, JOB_CODE, SALARY) ,
   DEPARTMENT(DEPT_TITLE) 을 참조하고
   사용자가 입력한 사번의 사번,사원명, 직급코드 , 급여 ,부서명 조회후 각 변수에 담아서 출력
   
   
*/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    
BEGIN

   SELECT EMP_ID,EMP_NAME , SALARY , JOB_CODE, DEPT_TITLE
    INTO EID , ENAME , SAL , JCODE , DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE EMP_ID = &사번;

 DBMS_OUTPUT.PUT_LINE('EID :' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME:' || ENAME);
    DBMS_OUTPUT.PUT_LINE('JCODE' || JCODE);
    DBMS_OUTPUT.PUT_LINE('SAL : ' ||  SAL);
    DBMS_OUTPUT.PUT_LINE('DTITLE: ' ||  DTITLE);
    END;
    /

----------------------------------------------------------------------------

/*
 1_3) ROW타입 변수 선언
 -- 테이블의 한 행에 대한 모든 컬럼값을 한번에 담을 수 있는 변수
  변수명 테이블명&ROWTYPE
  
*/

DECLARE
E EMPLOYEE%ROWTYPE;
BEGIN
   SELECT *
   INTO E
   FROM EMPLOYEE
   WHERE EMP_ID = &사번;
   
   DBMS_OUTPUT.PUT_LINE( E.EMP_ID ||  ',' || E.EMP_NAME || ',' || E.BONUS );
    
END;
/


-------------------------------------------------------------------------

/*
    2)BEGIN 실행부
    <조건문>
    1) 단일 IF (IF를 단독으로 사용할 때)
       IF 조건식 
        THEN 실행내용 
           END IF;
*/

-- 입력받은 사번에 해당하는 사원의 사번, 사원명 , 직급코드 , 보너스 조회
-- + 보너스를 받지않는 사원은 보너스를 지급받지 않는 사원입니다.
-- 보너스를 받는 사원은 보너스는 ~~~ 출력
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
    
BEGIN

   SELECT EMP_ID,EMP_NAME , SALARY , JOB_CODE, NVL(BONUS ,0)
    INTO EID , ENAME , SAL , JCODE , BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    

 DBMS_OUTPUT.PUT_LINE('사번: ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름: ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여: ' ||  SAL);
    
     IF BONUS = 0
    THEN DBMS_OUTPUT.PUT_LINE('보너스를 받지않는 사원입니다  ');
    END IF;
    
    IF BONUS != 0
    THEN DBMS_OUTPUT.PUT_LINE('보너스 : ' || BONUS);
    END IF;
    
    END;
    /
/*
  <IF-ELSE 조건식>
  
  IF 조건식
  TLSE 
    실행내용
  ELSE
    실행내용
  END IF;
*/


-- 래퍼런스 변수 ( EID,ENAME,DTITLE , NCODE)생성하고
-- 각 테이블에서 EMP_ID , EMP_NAME , DEPT_TITLE , NATIONAL_CODE참조
-- 일반타입변수 TEAM을 문자열 타입으로 생성하고 사용자가 입력한 사원정보를 가져와서
-- 사번, 이름, 부서명 , 근무국가코드 조회후에 각 변수에 대입
-- NCODE값이 KO일 경우 -> TEAM = 국내팀
-- NCODE값이 KO가 아닐경우 -> TEAM =해외팀 대입
-- 사번 ,이름 , 부서명 , 소속(TEAM)을 출력

DECLARE

      EID EMPLOYEE.EMP_ID%TYPE;
      ENAME EMPLOYEE.EMP_NAME%TYPE;
      DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
      NCODE LOCATION.NATIONAL_CODE%TYPE;
      TEAM VARCHAR2(10);
      
BEGIN
  SELECT EMP_ID , EMP_NAME, DEPT_TITLE , NATIONAL_CODE
  INTO EID , ENAME , DTITLE , NCODE
  FROM EMPLOYEE
  JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
  JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
  WHERE EMP_ID = &사번;

IF NCODE = 'KO'
  THEN TEAM := '국내팀';
ELSE TEAM := '해외팀';
END IF;
  
 DBMS_OUTPUT.PUT_LINE('사번: ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름: ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('부서명: ' ||  DTITLE);
     DBMS_OUTPUT.PUT_LINE('소속: ' ||  TEAM);
END;
/

--3) IF 조건식 1
--    THEN 실행내용 
--   ELSE IF 조건식 2
--     THEN 실행내용
-- .....
-- [ELSE 실행내용]
-- END;/

DECLARE
   SCORE NUMBER;
   GRADE VARCHAR2(1);
BEGIN
 SCORE :=&점수;
 
 IF SCORE>= 90
    THEN GRADE := 'A';
 ELSIF SCORE >= 80
     THEN GRADE := 'B';
 ELSIF SCORE >= 70
     THEN GRADE := 'C';
 ELSIF SCORE >= 60
     THEN GRADE := 'D';
 ELSE
        GRADE := 'F';
  END IF ;

DBMS_OUTPUT.PUT_LINE('당신의 점수는 : ' || SCORE ||' 점이며 , 학점은 ' || GRADE|| '');
END;
/

------------------------------------------------------------------------
/*
    <반복문>
1) BASIC LOOP문
LOOP
  반복하고싶은 실행문
  *EXIT WHEN 탈출조건
  END LOOP;
  
  *탈출조건은 조건식과
  1)IF 조건식 THEN EXIT; END IF;
  2) EXIT WHEN 조건식;

*/
DECLARE
 I NUMBER := 0;
 
 BEGIN
 LOOP
 I := I+1;
 DBMS_OUTPUT.PUT_LINE (I) ;
 EXIT WHEN I = 10;
 END LOOP;
 END;
 /

--------------------------------------------------------------------
/*
   2) FOR LOOP 문 (횟수가 정해진 반복)
    
    [표현식]
    
    FOR 변수 IN [REVERSE] 초기값..최종값
    LOOP
       반복할 코드
    END LOOP;
    
 
*/


-- I에 1부터 10을 부여해서 각각 반복문내의 코드를 실행함.

BEGIN 
 FOR I IN 1..10
 LOOP
   DBMS_OUTPUT.PUT_LINE (I);
   END LOOP;
   END;
   /

-- I에 10부터 1을 부여해서 각각 반복문내의 코드를 실행함. 역순으로 실행
BEGIN 
 FOR I IN REVERSE 1..10
 LOOP
   DBMS_OUTPUT.PUT_LINE (I);
   END LOOP;
   END;
   /

DROP TABLE TEST;

CREATE TABLE TEST(
TNO NUMBER PRIMARY KEY,
TDATE DATE
);

CREATE SEQUENCE SEQ_TNO;

BEGIN 
FOR I IN 1..100
LOOP
   INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
   END LOOP;
   END;
   /


------------------------------------------------------------------------
/*
 WHILE LOOP 문
 
 [표현식]
 
 WHILE 반복문이 수행될 조건
 LOOP 
  반복할 명령어
  END LOOP
 
*/

DECLARE
I NUMBER :=0 ;
BEGIN
 WHILE I<10
 LOOP 
  DBMS_OUTPUT.PUT_LINE (I);
  I := I+1; --탈출조건방향의 증감식
  END LOOP;
  
  END;
  /

----------------------------------------------------------------------------

/*
    3. 예외처리부
    예외(EXCEPTION)  : 실행 중 발생하는 오류
  
    EXCEPTION
     WHEN 예외명 1  THEN 처리구문1;
     WHEN 예외명 2  THEN 처리구문2;
     .....
     
     *시스템 예외 (오라클이 미리 설정해둔 예외)
     - NO_DATE_FOUND : SELECT한 결과가 한행도 없을 때
     - TOO_MNAY_ROWS : SELECT한 결과가 여러행일 경우
     - ZERO_DIVIDE : 0으로 나눌경우
     - DUP_BAL_ON_INDEX : UNIQUE 제약조건 위배
     ...
     
*/

-- 사용자가 입력한 수로 나눗셈한 결과를 출력

DECLARE
 RESULT NUMBER;
 
BEGIN
  RESULT := 10/&숫자;
  
  DBMS_OUTPUT.PUT_LINE(RESULT);
  
  EXCEPTION
  -- WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산자는 0으로 나눌수없다 ');
  WHEN OTHERS THEN 
  DBMS_OUTPUT.PUT_LINE('예외 발생 ');  
  END;
  /

BEGIN
      UPDATE EMPLOYEE
      SET EMP_ID = &변경할사번
      WHERE EMP_NAME = '노옹철';
      EXCEPTION
WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산자는 0으로 나눌수없다 ');
WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원번호입니다 ');
END;
/

----------------------------------------------------------------------

/*
<트리거>
특정 테이블에 대해 INSERT , UPDATE , DELETE 와 같은 DML 이벤트가 발생했을 때
자동으로 실행되는 PL/SQL 코드 불록

예) - 회원 탈퇴시 기존의 회원테이블에 데이터를 DELETE하기 전에 항상 탈퇴한 회원들을
      저장하는 테이블에 INSERT 시켜줘야한다. ->DELETE만 해도 자동으로 INSERT됨
   
   - 신고횟수가 일정 수를 넘었을 때 묵시적으로 해당 회원을 블랙리스트 목록에 추가해야할때.
   
 트리거 특징
  - 사용자가 명시적으로 실행하지 않아도 자동 실행됨.
  - 데이터 무결성 , 로깅 , 자동처리등에 유용
  - 테이블 단위로 작성되며 , 트리거 대상은 테이블.
  
  트리거 분류
  *시점(언제 실행되냐?)
   - BEFORE TRIGGER : 내가 지정한 테이블에 DML이벤트가 실행되기 전에 동작
   - AFTER TRIGGER : 내가 지정한 테이블에 DML 이벤트가 실행된 직후에 동작
   
   *적용대상(어디에 적용하는가?)
   - 문장 트리거 : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행 (FOR EACH ROW없음)
   - 행 트리거 : 이벤트가 적용된 각 행마다 실행(FOR EACH ROW 필요)
   * 행 트리거에서는 변경 전/후 데이터를 참조 가능
    :OLD = 기존행데이터
    :NEW = 새로 들어오는 데이터
   
   [트리거 생성 표현식]
   CREATE [OR REPLACE] TRIGGER 트리거명
   BEFORE | AFTER       INSERT | UPDATE | DELETE
   ON 테이블명
   
   
   [FOR EACH ROW] -- 행트리거일 경우 표시
   [DECLARE 변수선언]
   BEGIN
       실행할 내용
   [EXCEPTION ... ] -- 예외처리가능
   END;
   /
   
*/

SET SERVEROUTPUT ON;

-- EMPLOYEE 테이블에 새로운 행이 추가될때마다 자동으로 '신입사원님 안녕하세요 ' 출력

CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT
ON EMPLOYEE
BEGIN
  DBMS_OUTPUT.PUT_LINE('신입사원님 안녕하세요.');
  END;
  /

INSERT INTO EMPLOYEE( EMP_ID , EMP_NAME , EMP_NO , JOB_CODE)
VALUES( 301 , '김지원' , '115511-1234567' , 'J7');

--------------------------------------------------------------------------

--입출고에 대한 데이터기록 (INSERT) 될때마다 해당 상품에대한 재고수량을 매번 수정(UPDATE)
-- 상품테이블 (재고), 입출고기록테이블

-- 1. 상품에대한 데이터를 보관할 상품 테이블(TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
   PCODE NUMBER PRIMARY KEY, -- 상품번호
   PNAME VARCHAR2(30) NOT NULL, --상품명
   BRAND VARCHAR2(30) NOT NULL, --제조사
   PRICE NUMBER,                -- 가격
   STOCK NUMBER DEFAULT 0       -- 재고
   
);

CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5 ;

INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시S25' , '삼성' , 1500000 , DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '아이폰 16' , '애플' , 1000000 , DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '대륙폰' , '샤오미' , 1100000 , DEFAULT);
DROP TABLE TB_PRODERAL;
--2. 상품 입출고 상세 이력 테이블 생성(TB_PRODETALL)
-- 어떤 상품이 어떤 날짜에 몇개가 입/출고 되는지 기록
CREATE TABLE TB_PRODETAIL(
 DECODE NUMBER PRIMARY KEY,               --이력번호
 PCODE NUMBER REFERENCES TB_PRODUCT,       -- 상품번호
 PDATE DATE NOT NULL,                  --입출고날짜
 AMOUNT NUMBER NOT NULL,                --입출고 수량
 STATUS CHAR(3) CHECK(STATUS IN ( 'IN','OUT'))
);
CREATE SEQUENCE SEQ_DECODE;

--200번 상품이 오늘 날짜로 10개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL , 200 , SYSDATE , 10 , 'IN');

--200번 상품의 재고수량이 10증가
UPDATE TB_PRODUCT
SET STOCK = STOCK +10
WHERE PCODE = 200; 

COMMIT;

--205번 상품이 오늘 날짜로 20개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL , 205 , SYSDATE , 20 , 'IN');

--205번 상품의 재고수량이 20증가
UPDATE TB_PRODUCT
SET STOCK = STOCK +20
WHERE PCODE = 205; 


--TB_PRODETAIL 테이블에 INSERT 이벤트 발생시 
--TB_PRODUCT테이블에 매번 자동으로 재고수량을 UPDATE하는 트리거

/*
  -- 상품이 입고 -> 해당 상품을 찾아서 재고수량 증가 UPDATE
  UPDATE TB_PRODUCT
SET STOCK = STOCK +(INSERT된 자료의 AMOUNT)
WHERE PCODE = (INSERT된 자료의 PCODE); 

  
  
  -- 상품이 출고 -> 해당 상품을 찾아서 재고수량 증가 UPDATE
  UPDATE TB_PRODUCT
SET STOCK = STOCK -(INSERT된 자료의 AMOUNT)
WHERE PCODE = (INSERT된 자료의 PCODE); 
  

*/

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT
ON TB_PRODETAIL
FOR EATH ROW

BEGIN
  IF(TB_PRODETAIL.STATUS='IN')
  ELSE
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT
ON TB_PRODETAIL
FOR EACH ROW

BEGIN
  IF(:NEW.STATUS = 'IN')
  THEN UPDATE TB_PRODUCT
  SET STOCK = STOCK + :NEW.AMOUNT
  WHERE PCODE = : NEW.PCODE;

ELSE
UPDATE TB_PRODUCT
SET STOCK = STOCK - :NEW.AMOUNT
WHERE PCODE = :NEW.PCODE;
END IF;
  
END;
/

-- 210번 상품이 오늘날짜로 7개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 210 , SYSDATE , 7, 'IN');

--205번 상품이 오늘 날짜로 5개 출고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 205 , SYSDATE , 4, 'OUT');















































































