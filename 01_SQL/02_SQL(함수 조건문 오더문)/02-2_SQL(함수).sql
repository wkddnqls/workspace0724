/*

<함수 FUNCTION> - 하나의 기능만? 한번만 쓸수있나 하나만
전달된 컬럼값을 읽여들어서 함수(기능)를 실행한 결과를 반환
-단일행 함수 :N개의 값을 읽여들여서 N개의 결과값을 리턴 (매행마다 함수실행결과를 반환)

-그룹함수 :N개의 값을 읽어들여서 1개의 결과값을 리턴(그룹을 지어 그룹별로 함수 실행 결과를 반환)

>>SELECT 절에 단일행 함수와 그룹함수를 함께 사용하지못한다.
왜? 결과 행의 갯수가 서로 다르기 때문에
>>함수를 사용할 수 있는 위치 : SELECT절 WHERE 절 ORDERY NY절 GROUP BY 절 HAVING 절



DUAL : Oracle에서 단일 행과 단일 열을 가진 가상 테이블
*/

---------------------단일행 함수 ------------------------------------

/*
      <문자처리함수>
      *LANGTH (컬럼 | '문자열') : 해당 문자열의 글자수를 반환
      *LANGTHB(컬럼 | '문자열') : 해당 문자열의 바이트수를 반환
      
      
    '최' '나' 'ㄱ' 한글은 글자당 3BYTE
    영문자 , 숫자 , 특수문자 글자당 1BYTE
       
*/

SELECT LENGTH ('오라클') , LENGTHB('오라클')
FROM DUAL;

SELECT LENGTH ('ORACLE') , LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH (EMP_NAME), LENGTHB(EMAIL)
FROM EMPLOYEE;

/*
*INSTR
문자열로부터 특정 문자의 시작위치를 찾아서 반환
INSTR (컬럼 | '문자열', ' 찾고자하는 문자' , ['찾을 위치의 시작값',순번]) ->결과는 NUMBER

*/
SELECT INSTR ('AABAACAABBAA' , 'B') FROM DUAL;
--찾을 위치의 시작 값:1 , 순번:1 -> 기본값
SELECT INSTR ('AABAACAABBAA' , 'B', 1) FROM DUAL;

SELECT INSTR ('AABAACAABBAA' , 'B', -1) FROM DUAL;
SELECT INSTR ('AABAACAABBAA' , 'B', 1 , 2) FROM DUAL;
--1부터 찾는거에대한 2번째B의 값

SELECT EMAIL , INSTR (EMAIL, '@') AS "@위치"
FROM EMPLOYEE;

/*
*SUBSTR
문자열에서 특정 문자열을 추출해서 반환
[표현법]
SUBSTR (컬럼 | '문자열' , 추출 시작위치 , [추출 문자 갯수])

*/

SELECT SUBSTR ('SHOWMETHEMONEY' , 7)
FROM DUAL; --7번 위치부터 끝까지

SELECT SUBSTR ('SHOWMETHEMONEY' ,5 , 2)
FROM DUAL;

SELECT EMP_NAME , EMP_NO ,SUBSTR (EMP_NO , 8 ,1) AS "성별"
FROM EMPLOYEE;

--사원들 중 여자 사원들만 이름과 주민등록번호를 조회
SELECT EMP_NAME , EMP_NO
FROM EMPLOYEE
WHERE SUBSTR (EMP_NO , 8 ,1) IN('2' , '4');

--함수 중첩사용 가능
-- 이메일 아이디부분만 추출
SELECT EMP_NAME , EMAIL , SUBSTR (EMAIL , 1 , INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;

----------------------------------------------------------------
/*
*LPAD / RPAD
문자열을 조회할 때 통일감있게 조회하고자 정렬을 하는 함수
[표현법]
LPAD /RPAD (문자열, 최종적으로 반환할 문자열의 길이 , [덧붙이고자하는 문자])

*/
SELECT EMP_NAME , LPAD ( EMAIL,30,'#')
FROM EMPLOYEE;

SELECT EMP_NAME , RPAD ( EMAIL,30,'#')
FROM EMPLOYEE;

--사원들의 사원명 주민번호 ("123456- 1XXXXXX")
SELECT EMP_NAME, RPAD( SUBSTR (EMP_NO,1,8),14,'X')  
FROM EMPLOYEE;

SELECT EMP_NAME, SUBSTR (EMP_NO,1,8) || 'XXXXXX'  
FROM EMPLOYEE;


------------------------------------------------------
/*
LTRIM / RTRIM
문자열에서 특정 문자를 제거한 나머지를 반환
[표현법]
LTRIM/RTRIM(컬럼 | '문자열' , [제거하고싶은 문자들])

문자열의 왼쪽 또는 오른쪾에서 제거하고자하는 문자들을 찾아서 제거한 나머지 문자열 반환


*/

SELECT LTRIM('     K   H   ' )
FROM DUAL; --앞에서부터 다른 문자가 나올 대 까지 공백을 제거
SELECT LTRIM('123123KH123' , '123' )
FROM DUAL;
SELECT LTRIM('ACABACCAKHBA' , 'ABC' )
FROM DUAL; -- 제거하고자하는 문자는 문자열이 아닌 문자들
----------------------------------------------------------------
/*

TRIM
문자열의 앞/뒤/양쪽에 있는 저장한 문자들을 제거한 나머지 문자열 반환
TRIM([LEADING | TRAILING | BOTH ] 제거하고자하는 문자열 FROM 문자열)

*/

SELECT TRIM('     K   H   ' ) FROM DUAL; --기본값 왼쪽
SELECT TRIM(BOTH ' ' FROM '     K   H   ' )FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZZK   HZZZ')FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZZK   HZZZ')FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZK   HZZZ')FROM DUAL;

----------------------------------------------------
/*
 LOWER / UPPER / INITCAP
 LOWER : 모든 문자열을 소문자로 변경해서 반환
 UPPER : 모든 문자열을 대문자로 변경해서 반환
 INITCAP: 띄어쓰기 기준 첫글자마다 대문자로 변경한 문자열 반환
 
*/
SELECT LOWER ( 'Welcome To My HK') FROM DUAL;
SELECT UPPER ( 'Welcome To My HK') FROM DUAL;
SELECT INITCAP ( 'welcome to my hk') FROM DUAL;

---------------------------------------------------------------------

/*
*CONCAT
문자열 두개 전달받아서 하나로 합친 후 반환
CONCAT (STR1, STR2)

*/
SELECT CONCAT('가나다' , '라마') FROM DUAL;
SELECT '가나다' || '라마'  FROM DUAL;

-----------------------------------------------------------------------------
/*
*REPLACE
특정문자열에서 특정부분을 다른 부분으로 교체
REPLACE (문자열, 찾을 문자열, 치환할 문자열 )

*/
SELECT EMAIL , REPLACE(EMAIL, 'C##SERVER' , 'kh')
FROM EMPLOYEE;


------------------------------------------------------------------------------
/*
<숫자처리함수>
*ABS
숫자의 절대값을 구하는 함수
*/

SELECT ABS(-10), ABS(-8.5) FROM DUAL;

----------------------------------------------------------------------------

/*
*MOD
두 수를 나눈 나머지값을 반환
MOD(NUMBER1, NUMBER2)
     값   ,   나눌값

*/

SELECT MOD (10,3) FROM DUAL;

----------------------------------------------------------------------------

/*
*ROUND
반올림한 결과를 반환
ROUND (값 , [위치])
*/
SELECT ROUND(123.456) FROM DUAL; --기본값은 소수점 첫번째 자리에서 반올림
SELECT ROUND(123.456 , 1) FROM DUAL; --소수 첫째자리에서 +1해서 둘째자리에서 반올림
SELECT ROUND(123.456 , -1) FROM DUAL;-- 양수로증가시 소수점 한칸씩이동 음수는 반대로

---------------------------------------------------------------------------

/*
*CEIL
올림처리를 위한 함수
CEIL(값)

*/

SELECT CEIL(123.42) FROM DUAL;

---------------------------------------------------------------------------

/*
TRUNNC, FLOOR
버림처리함수

TRUNNC (값,위치)
FLOOR(값)

*/

SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456 , 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

-----------------------------------------------------------------------------
/*
<날짜처리함수>
*/

--SYSDATE : 이 함수가 실행된 컴퓨터의 시간을 가져온다 //미국에서 실행 <> 한국에서실행
SELECT SYSDATE FROM DUAL;

----------------------------------------------------------------------------

--MONTHS_BETWEEN : 두 날짜 사이의 개월 수

--사원들의 사원명 , 입사일 ,근무일수 , 근무 개월 수
SELECT EMP_NAME , HIRE_DATE , FLOOR(SYSDATE - HIRE_DATE) , 
CEIL (MONTHS_BETWEEN(SYSDATE , HIRE_DATE))
FROM EMPLOYEE;

---------------------------------------------------------------------------

--ADD_MONTHS : 특정 날짜에 개월수를 더한 값을 반환
SELECT ADD_MONTHS(SYSDATE, 7 ) FROM DUAL;

--사원테이블에서 사원명,입사일, 수습기간 종료일 (입사일로부터 3개월 뒤 ) 조회
SELECT EMP_NAME , HIRE_DATE , ADD_MONTHS (HIRE_DATE ,3)
FROM EMPLOYEE;

----------------------------------------------------------------------------

-- NEXT_DAY(DATE, 요일(문자 | 숫자)) : 특정 날짜 이휴 가장 가까운 요일의 날짜를 반환
SELECT NEXT_DAY(SYSDATE , 1) FROM DUAL;
SELECT NEXT_DAY(SYSDATE , '토요일' ) FROM DUAL;

//ALTER SESSION SET NLS_LANGUAGE = AMERICAN; --미국으로 패치 영어
//ALTER SESSION SET NLS_LANGUAGE = KOREAN;   --한국으로 패치 한글
-- 0:일 ~ 6 : 토  -> 다른언어
-- 1:일 ~ 7 : 토  ->오라클

------------------------------------------------------------------------------
--LAST_DAY(DATE):해당월의 마지막 날짜를 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

------------------------------------------------------------------------------

/*
EXTRACT : 특정 날짜로부터 년|월|일 값만 추출해서 반환

[표현법]
EXTRACT (YEAR FROM DATE) : 연도만 추출
EXTRACT (MONTH FROM DATE): 월만 추출 
EXTRACT (DAY FROM DATE) : 일만 추출

*/

--사원의 사원명, 입사년도 , 입사월 , 입사일 조회
SELECT EMP_NAME,
       EXTRACT (YEAR FROM HIRE_DATE ) "입사년도" ,
         EXTRACT (MONTH FROM HIRE_DATE ) "입사월",
            EXTRACT (DAY FROM HIRE_DATE ) "입사일"
            FROM EMPLOYEE;
            
-------------------------------------------------------------------

/*
 <형변환 함수>
 *TO _CHAT : 숫자타입 또는 날짜타입의 값을 문자타입으로 변환시켜주는 함수
 
[표현법]
TO_CHAR(숫자 | 문자 , [포멧] )
*/

-- 숫자 -> 문자
SELECT TO_CHAR(1234) FROM DUAL;

SELECT TO_CHAR(12, '99999')FROM DUAL; -- 9의 자리수만큼 공간 확보

SELECT TO_CHAR(12, '00000')FROM DUAL; -- 0의 자리수만큼 공간 확보, 빈칸 0으로 채움

SELECT TO_CHAR(2000000, 'L9999999')FROM DUAL; --현재 설정된 나라의 로컬 화페단위를 나타냄
SELECT TO_CHAR(2000000, '9,999,999')FROM DUAL;

---------------------------------------------------------------------------
TO_CHAR
--날짜타입 -> 문자타입
SELECT SYSDATE 
FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE , 'HH:MI:SS' ) FROM DUAL;
SELECT TO_CHAR(SYSDATE , 'HH"시"MI"분"SS"초"' ) FROM DUAL;
SELECT TO_CHAR(SYSDATE , 'PM HH"시"MI"분"SS"초"' ) FROM DUAL;
SELECT TO_CHAR(SYSDATE , 'YYYY HH"시"MI"분"SS"초"' ) FROM DUAL;
SELECT TO_CHAR(SYSDATE , 'YYYY-MM-DD DAY HH"시"MI"분"SS"초"' ) FROM DUAL;
--년 월 일 시 분 초 가능
SELECT TO_CHAR(SYSDATE , 'YYYY"년"MM"월"DD"일" DAY HH"시"MI"분"SS"초"' ) FROM DUAL;
--년도와 관련된 포맷
SELECT 
TO_CHAR(SYSDATE, 'YYYY'),
TO_CHAR(SYSDATE, 'RRRR'),
TO_CHAR(SYSDATE, 'YY'),
TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT 
TO_DATE('2025' , 'YYYY' ),
TO_DATE('2025' , 'RRRR' ),
TO_DATE('25' , 'YY' ),
TO_DATE('25' , 'RR' ),
TO_DATE('60' , 'YY' ), -- YY는 항상 입력 그대로 해석->현재년도를 반영
TO_DATE('60' , 'RR' )  -- 2자리 입력시 현재 세기를 기준으로 자동보정
FROM DUAL;

--월과 관련된 포맷
SELECT 
TO_CHAR(SYSDATE, 'MM'),
TO_CHAR(SYSDATE, 'MON'),
TO_CHAR(SYSDATE, 'MONTH')
FROM DUAL;

--일과 관련된 포맷
SELECT 
TO_CHAR(SYSDATE, 'DD'), --오늘일자
TO_CHAR(SYSDATE, 'DDD'),--오늘이 이번년도 몇번째 일수
TO_CHAR(SYSDATE, 'D')   --요일
FROM DUAL;

--요일을 나타내는 포맷
SELECT 
TO_CHAR(SYSDATE, 'D'),
TO_CHAR(SYSDATE, 'DAY'),
TO_CHAR(SYSDATE, 'DY')
FROM DUAL;


---------------------------------------------------------------------------

/*
TO_DATE() :숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
TO_DATE(숫자 | 문자 , [포맷]) ->DATE

*/
SELECT TO_DATE(20100101) FROM DUAL;

SELECT TO_DATE(611218) FROM DUAL; --두자리 입력시 자동보정 (1961년으로 된거임)

SELECT TO_DATE(051010) FROM DUAL; --0으로 시작하는 숫자는 없다.
SELECT TO_DATE('051010') FROM DUAL;

SELECT TO_DATE('20020505 120500', 'YYYYMMDD HH24MISS') FROM DUAL;

-------------------------------------------------------------------------
/*
TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환해서 반환.
[표현법]
TO_NUMBER(문자 ,[포맷])
*/
SELECT TO_NUMBER('065431965841561') FROM DUAL;
SELECT '123' + '123' FROM DUAL; --문자열에서 숫자로 자동형변환이 진행된다
SELECT TO_NUMBER('100,000','999,999') FROM DUAL;

-----------------------------------------------------------------------

/*
 <NULL 처리 함수 >

*/

-- NVL (컬럼, 해당컬럼이 NULL일 경우 보여줄 값)
SELECT EMP_NAME , BONUS , NVL (BONUS,0)
FROM EMPLOYEE;

--전 사원의 이름 ,보너스 포함 연봉 조회
SELECT EMP_NAME, (SALARY+(SALARY*NVL(BONUS,0)))*12
FROM EMPLOYEE;

---------------------------------------------------------------------------
 
 --NVL2(컬럼,반환값2,반환값2)
 --반환값1 : 해당컬럼이 존재하면 보여줄 값
 -- 반환값2 : 해당컬럼이 존재하지 않으면 보여줄 값
 SELECT EMP_NAME , BONUS , NVL2(BONUS , 'O' , 'X')
 FROM EMPLOYEE;

--------------------------------------------------------------------------
--NULLIF (비교대상1, 비교대상 2)
--두값이 일치하면 NULL반환, 일치하지않으면 비교대상1 반환
SELECT NULLIF('123' , '123') FROM DUAL;
SELECT NULLIF('123' , '163') FROM DUAL;

--------------------------------------------------------------------------

/*
[선택함수]
DECODE (비교하고자하는 대상 , 비교값1, 결과값1, 비교값2 ,결과값2 .....)

*/
--사번,사원명,주민등록번호,성별
SELECT EMP_ID,EMP_NAME , EMP_NO ,
DECODE(SUBSTR(EMP_NO,8,1),'1' ,'남', '2' ,'여' )
FROM EMPLOYEE;

--직원의 이름 , 기존급여, 인상된 급여 조회 (각 직급별로 차등인상)
-- 직급이 J7은 급여를 10%인상 (SALARY *1.1)
-- 직급이 J6은 급여를 15%인상 (SALARY *1.15)
-- 직급이 J5은 급여를 20%인상 (SALARY *1.2)
-- 그외의 직원들은 급여를 5% 인상 (SALARY* 1.05)

SELECT EMP_NAME ,JOB_CODE,  SALARY "인상전",
DECODE(JOB_CODE,
'J7' ,SALARY*1.1 ,
'J6' ,SALARY*1.15 ,
'J5' ,SALARY*1.2 ,
SALARY*1.05) AS "인상후"
FROM EMPLOYEE;

----------------------------------------------------------------------------

/*
  CASE 문
  SQL에서 조건에 따라 값을 분기하고 싶을 때 사용하는 구문
 
  [표현법]
  CASE
  WHEN 조건 1 THEN 결과1
  WHEN 조건 2 THEN 결과 2
  ....
  ELSE 기본결과
  END

  
*/
SELECT EMP_NAME , SALARY,
CASE
WHEN SALARY >= 5000000 THEN '시니어'
WHEN SALARY >= 3500000 THEN '미들'
ELSE '주니어'
END "각자의 노력 결과값"
FROM EMPLOYEE;

----------------------------------------------------------------------------

-- <그룹함수>

-- 1. SUM (숫자타입컬럼) : 해당 컬럼값들의 총 합계를 구해서 반환해주는 함수

--직원들의 모든 급여의 합
SELECT SUM (SALARY)
FROM EMPLOYEE;

--남자사원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO , 8 ,1) IN ('1' , '3');

--부서코드가 D5인 부서 사람들의 총 연봉(급여 *12)
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-----------------------------------------------------------------------------

--2. ANG(NUMBER) : 해당 컬럼값들의 평균을 구해서 반환
SELECT AVG (SALARY)
FROM EMPLOYEE;

----------------------------------------------------------------------------

--3. MIN(모든 타입 가능) : 해당 컬럼값 중 가장 작은 값을 구해서 반환
SELECT MIN(EMP_NAME), MIN(SALARY) , MIN (HIRE_DATE)
FROM EMPLOYEE;

---------------------------------------------------------------------------

--4. MAX (모든 타입 가능) : 해당 컬럼값 중 가장 큰 값을 구해서 반환
SELECT MAX(EMP_NAME) , MAX(SALARY) , MAX(HIRE_DATE)
FROM EMPLOYEE;

---------------------------------------------------------------------------

--5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
-- COUNT (*) : 조회된 결과에 모든 행의 갯수를 반환
-- COUNT(컬럼) : 제시한 컬럼값이 NULL이 아닌것만 행의 수를 세서 반환
-- COUNT(DISTINCT 컬럼) : 해당 컬럼값에서 중복을 제거한 후 행의 갯수를 세서 반환

--전체사원 수
SELECT COUNT(*) FROM EMPLOYEE;
--사원중 여자사원의 수
SELECT COUNT(*) 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8 ,1 ) IN ('2' , '4');

--보너스를 받는 사원의 수 
SELECT COUNT(BONUS) --보너스의 컬럼값이 널이 아닌 데이터만 카운트
FROM EMPLOYEE;
--WHERE BONUS IS NOT NULL;

--현재 사원들이 총 몇개의 부서에 분포되어 잇는지 알려줘
SELECT COUNT (DISTINCT DEPT_CODE) --널이 아닌값만 카운트
FROM EMPLOYEE;

----------------------------------------------------------------------------
/*
실행 우선순위는? 
SELECT *                       --세번째
FROM 테이블                     --첫번째 
WHERE 조건식                    --두번째
ORDER BY 정렬기준               --네번째 

*/





