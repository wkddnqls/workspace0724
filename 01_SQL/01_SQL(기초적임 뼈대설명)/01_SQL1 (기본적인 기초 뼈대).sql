

/*
테이블
-데이터베이스에서 데이터를 저장하는 기본 개념
- 행과 열로 구성된 데이터 집합

컬럼
-테이블 내의 각 데이터 속성을 정의하는 필드 (EX 총수령액/ 이름/ 등등
-컬럼은 테이블에서 저장할 떄 속성 = 값 (총수령액 = 3000) 으로 저장

=> 테이블은 여러 컬럼으로 구성되고 , 각 컬럼은 테이블이 표현하는 데이터의 세부적인 속성을 나타냄
<SELECT>
SELECT 컬럼명 1, 컬럼명 2 ,,,,,
FROM 테이블명
[WHERE 조건]
[ORDER BY 정렬기준 [ASC | DESC]오름 내림차순]




*/


-- 1.JOB 테이블의 모든 정보 조회
SELECT * FROM JOB;

--2 JOB 테이블의 직급 이름만 조회
 SELECT JOB_NAME
 FROM JOB;
--3 DEPARTMENT 테이블의 모든 정보 조회
SELECT * FROM DEPARTMENT;

--4 EMPLOYEE 테이블의 직원명 이메일 전화번호 고용일 조회
SELECT EMP_NAME,EMAIL ,PHONE ,HIRE_DATE
FROM EMPLOYEE;

-- 5 . EMPLOYEE 테이블에서 이름 연봉 총수령액 실수령액 조회
SELECT EMP_NAME, SALARY*12, salary + (SALARY * NVL(BONUS,0))*12 "총수령액"
, ((SALARY+(SALARY * NVL(BONUS,0)))*12)- (SALARY*12*0.03) AS 실수령액
FROM employee;

--데이터베이스에서 NULL은 빈값을 의미
-- 모든연산에 NULL이 포함된 경우 , 결과는 NULL이 된다.

--사원명 , 입사일, 근무일수를 EMPLOYEE 테이블에서 조회

-- 코드 실행시 현제 날짜를 표시하는 상수 : SYSDATE [년/월/일/시/분/초]
-- 데이터베이스에서는 날짜를 계산할때 덧셈 뺄셈이 가능하다.
-- 현재시간 - 입사일=근무시간
--DATE-DATE =>결과를 무조건 일로 표시

SELECT EMP_NAME , HIRE_DATE, SYSDATE - HIRE_DATE "근무일자(일)"
FROM EMPLOYEE;
-- DUAL테이블 = 오라클에서 제공하는 가상테이블. (조회할때 쓰는거)
SELECT SYSDATE FROM DUAL;

/*
<컬럼 별칭>
컬럼명에 별칭을 부여하면 깔끔하게 표현할 수 있음
[표현식]
컬럼명 별칭 / 컬럼명 AS 별칭 / 컬럼명 "별칭" / 컬럼명 AS "별칭"

*/

SELECT EMP_NAME 사원명 , SALARY AS 급여
FROM EMPLOYEE;

/*
    <리터럴>
    직접 값을 나타내는 단위, 임의로 지정한 값
    {EX '원'}
    별칭 "??"
    리터럴 '??'
*/
SELECT EMP_ID, EMP_NAME,SALARY, '원'
FROM EMPLOYEE;
/* <연결 연산자: ||>
    여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있음.
*/
SELECT EMP_NAME || '님 급여는' || SALARY ||'원'
FROM EMPLOYEE;
/*
<DISTINCT>
중복제거 - 컬럼에 표시된 값들을 한번씩만 조회하고자 할때 사용



실제로 사용되고 있는 직급목록
*/
SELECT DISTINCT JOB_CODE 
FROM EMPLOYEE;

--실제로 사용되고 있는 부서목록
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

--SELECT DISTINCT EMP_NAME, DISTINCT JOB_CODE, DISTINCT DEPT_CODE
--FROM EMPLOYEE;
-- 위처럼 사용시 에러 . DISTINCT한 명령어에서 한번만 사용가능

/* DISTINCT는 항상 ROW 데이터 전체에 대해서 중복제거
    --EX (J1 D9) 세트임 

*/
SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;
-- EX (JOB_CODE, DEPT_CODE) 세트로 묶어서 중복제거

=================================================================

/*
 <WHERE 절>
 조회하고자하는 테이블로부터 특정 조건에 만족하는 데이터만 조회하고자 할 때 사용
 조건식에서도 다양한 연산자를 사용할 수 있음.
 [표현법]
 SELECT 컬럼,컬럼 '''
 FROM 테이블명
 WHERE 조건;
 >> 비교연산자 <<
 > < >= <= : 대소비교
 = : 양쪽동일
 != ^= <> : 양쪽이 다르다

*/
-- EMPLOYEE 테이블에서 부서코드가 D9인 사원들만 조회 (모든컬럼)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' ;
-- EMPLOYEE에서 부서코드가 'D1' 인 사원들의 사원명 급여 부서코드 조회
SELECT EMP_NAME , SALARY , DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1' ;

-- EMPLOYEE에서 부서코드가 'D1'아닌 사원들의 사원명 급여 부서코드 조회
SELECT EMP_NAME , SALARY , DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D1';

-- 월급이 400만원 이상인 사원들의 사원명 부서코드 급여조회
SELECT EMP_NAME 사원명 , DEPT_CODE 부서코드 , SALARY 급여
FROM EMPLOYEE
WHERE SALARY >= '4000000' ;

/*
 <AND , OR 연산자>
 조건을 여러개 연결할 때 사용.
 [표현법]
 조건A AND 조건B -> (곱연산)조건 A와 조건 B가 모두만족시 참
  조건A OR 조건B -> (합연산)하나만 만족시 참
  <BETWEEN AND>
  조건식에 사용되는 구문
  몇이상 몇이하인 범위에 대한 조건을 제시할 때 주로 이상 이하일때 쓰는 연산자
  [표현법]
  비교대상 컬럼 BETWEEN 하안값 AND 상한값 ; 
  
*/

-- 급여가 350이상 600이하인 모든 사원의 사원명 사번 급여 조회
SELECT EMP_NAME , EMP_ID ,SALARY
FROM EMPLOYEE
WHERE SALARY >= '3500000' AND SALARY <= '6000000' ;
--WHERE SALARY BETWEEN 3500000 AND 6000000;

--NOT : 논리부정연산자 (조건뒤집을때)?
--컬럼명 앞에 또는 BETWEEN 앞에 선언
SELECT EMP_NAME , EMP_ID ,SALARY
FROM EMPLOYEE
--WHERE SALARY >= '3500000' AND SALARY <= '6000000' ;
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
-- 입사일이 '90/01/01' 이상 01,01,01 이하인 사원들을 전체 조회
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

--NULL 을 비교연산 할때 주의
--NULL값을 비교할 때는 IS NULL , IS NOT NULL을 사용한다.

SELECT *
FROM EMPLOYEE
WHERE BONUS IS NULL;
--WHERE BONUS IS NOT NULL;