/*
    <LIKE>
    비교하고자하는 컬럼값이 내가 제시한 특정 패턴에 만족할 경우 조회
    
    [표현법]
    비교한 대상컬럼 LIKE '특정패턴'; -> 일치하는 것만 조회
    
/* 특정패턴을 제시할 때 사용하는 와일드카드라는 개념이 정의되어있다.

1. '%' : 포함문자 검색 (0글자 이상 전부 조회)
EX) 비교할 대상 컬럼 like '문자%' : 비교할 대상컬럼 값 중에서 해당문자로 시작하는 값을 전부 조회.
     비교할 대상 컬럼 like '%문자' : 비교할 대상컬럼 값 중에서 해당문자로 끝나는 값을 전부 조회.
    비교할 대상 컬럼 like '%문자%' : 비교할 대상컬럼 값 중에서 해당문자로 포함된 값을 전부 조회.
   
2. '_' : 1글자를 대체검색할 때 사용
EX) 비교할 대상 컬럼 LIKE '_문자' : 비교할 대상컬럼 값 문자 앞에 아무문자나 딱 한글자가 있는 값을 조회
     비교할 대상 컬럼 LIKE '문자_' : 비교할 대상컬럼 값 문자 뒤에 아무문자나 딱 한글자가 있는 값을 조회
     비교할 대상 컬럼 LIKE '_문자_' : 비교할 대상컬럼 값 문자 앞 뒤에 아무문자나 딱 한글자가 있는 값을 조회\
    
     비교할 대상 컬럼 LIKE '_문자__' : 비교할 대상컬럼 값 문자 앞에 아무문자나 딱 한글자가 있는 값을 조회
*/
-- 사원들 중에서 전화번호 3번째 자리가 1인 사원들의 사번,사원명 전화번호 조회
SELECT EMP_NAME , EMP_ID , PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '__1%' ;


-- 이메일 중 _앞의 글자가 3글자인 사원들의 사번, 이름 이메일 조회
SELECT EMP_ID , EMP_NAME , EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___/_%' ESCAPE '/';
--WHERE EMAIL LIKE '___%' ; =>와일드 카드로 인식되기 때문에 정상적으로 출력불가
--와일드 카드를 직접 문자로 사용할 떄는 일반문자로 구분을 해줘야한다.
-- ESCAPE OPTION을 등록해서 나만의 탈출문자를 사용할 수 있음
----------------------------------------------------------------------------
/*
    <IN>
    WHERE절에 비교대상 컬럼값이 내가 제시한 목록중에 일치하는지
    검사하는 문법
    
    [표현법]
    비교대상 컬럼 IN (값 , 값 , 값 ...)

*/
-- 부서코드가 D6 이거나 D8이거나 D5인 부서원들의 이름 , 부서코드 , 급여 조회

SELECT EMP_NAME , DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5' ;
WHERE DEPT_CODE IN ('D6' , 'D8' , 'D5') ;


/*
    <연산자 우선순위 >
    1. 산술연산자
    2.연결연산자
    3.비교연산자
    4. IS NULL / LIKE / IN
    5. BETWEEN A AND B
    6. NOT 
    7. AND
    8. OR 

*/


--------------------------실습 -------------------------------------

--1 이름이 '연' 으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연' ;
--2 전화번호 처음 3자리가 010이 아닌 사원들의 사원명 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%' ;
--3 이름에 '하'가 포함되어있고 급여가 240만원 이상인 사원들의 사원명 , 급여 조
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= '2400000' ;
--4 부서 (DEPARTMENT) 테이블에서 해외영업부서인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID , DEPT_TITLE
FROM DEPARTMENT 
WHERE DEPT_TITLE LIKE '%해외영업%';
--5 사수 (MANAGER)가 없고 부서배치도 받지 않은 사원들의 사원명 사번 부서코드 조회
SELECT EMP_NAME , EMP_ID , DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL ;
--6 연봉(급여 *12) 이 3천만원 이상이고 보너스를 받지 않는 사원들의 사번 급여 보너스 조회
SELECT EMP_ID , SALARY , BONUS
FROM EMPLOYEE
WHERE (SALARY*12) >= '30000000' AND BONUS IS NULL ;
--7 입사일이 '95/01/01' 이상이고 부서배치를 받지 않은 사원들의 사번 사원명 입사일 부서코드 조회
SELECT EMP_ID , HIRE_DATE , DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;
--8 급여가 200이상 500이하인 사원 중에서 입사일이 '01/01/01' 이상이고 보너스를 받지 않는 사원들의
-- 사번 사원명 급여 입사일 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY , HIRE_DATE
FROM EMPLOYEE
WHERE ((SALARY >= '2000000' AND SALARY <= '5000000') AND HIRE_DATE >= '01/01/01') AND BONUS IS NULL;
--9 보너스를 포함 연봉 ((SALARY+(SALATY*BONUS)) *12) 이 NULL이 아니고 이름에 '하'가 포함된 사원들의
-- 사번 사원명 급여 보너스 포함 연봉 조회
SELECT EMP_ID, EMP_NAME , SALARY , ((SALARY+(SALARY*BONUS)) *12)
FROM EMPLOYEE
WHERE ((SALARY+(SALARY*BONUS)) *12) IS NOT NULL AND EMP_NAME LIKE '%하%';

---------------------------------------------------------------------------

/*

  <ORDER BY 절>
  데이터를 정렬해서 조회하기위한 구문
  SELECT문 가장 마지막 줄에 작성, 실행순서 또한 가장 마지막에 실행 된다.
  [표현법]
  SELECT 조회할 컬럼...
  FROM 테이블
  WHERE 조건문
  ORDER BY 정렬기준이 될 컬럼 |별칭|컬럼순번 [ASC | DESC] [NULLS FIRST | NULLS LAST]
  - ASC : 오름차순 (작은값으로 시작해서 점점 커지는 것) -> 기본값
  - DESC : 내림차순 (큰 값으로 시작해서 값이 점점 줄어드는것
  NULL의 기본적으로 가장 큰 값으로 분류해서 정렬한다.
  */
SELECT *
FROM EMPLOYEE
-- ORDER BY BONUS DESC;
--ORDER BY BONUS ASC NULLS FIRST;
ORDER BY BONUS DESC, SALARY ASC ;
--정렬기준에 컬럼값이 동일할 경우 그 다음차순을 위해서 여러개의 거준 컬럼을 제시가능

--전 사원의 사원명, 연봉 조회 (이때 연봉을 기준으로 내림차순)
SELECT EMP_NAME , SALARY*12 AS "연봉"
FROM EMPLOYEE
 -- ORDER BY SALARY*12 DESC;
 -- ORDER BY 연봉 DESC;
ORDER BY 2 DESC; <- 사용지향









