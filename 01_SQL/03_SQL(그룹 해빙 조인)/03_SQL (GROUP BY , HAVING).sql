/*
    <GROUP BY>
    그룹기준을 제시할 수 잇는 구문(해당그룹기준별로 여러 그룹으로 묶을 수 있음
    여러개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용
*/

SELECT SUM(SALARY)
FROM EMPLOYEE;

--그룹 : 부서별
-- 각 부서별 급여 총합
SELECT DEPT_CODE , SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ASC;

--각 부서별 사원수
SELECT DEPT_CODE , COUNT(*), SUM(SALARY) --3
FROM EMPLOYEE           --1 
GROUP BY DEPT_CODE         --2
ORDER BY DEPT_CODE ASC;    --4

--GROUP BY 절에 함수식 사용가능(그룹을 나눌 수 있는 기준만 넣어주면)

--남자사원과 여자사원의 수를 조회
SELECT DECODE (SUBSTR(EMP_NO,8,1) ,'1', '남' , '2' , '여자'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO,8,1) ; 

-- GROUP BY 절에 여러 컬럼을 기술할 수 잇음
-- 여러개의 컬럼을 기술하면 해당 여러컬럼들 모두를 하나의 기준으로 사용함.
-- {중복없애는 (DISTINCT) 랑 비슷한 개념으로 사용하는거같음}
SELECT DEPT_CODE, JOB_CODE , COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

-------------------------------------------------------------------------------

/*
<HANING>
그룹에 대한 조건을 제시할 때 사용되는 구문 ( 주로 그룹함수식을 가지고 조건을 만듬)

*/

--각 부서별 평균 급여(부서코드, 평균급여)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--각 부서별 평균급여가 300만원 이상인 부서들만 부서코드, 평균급여조회
--WHERE 절이 GROUP BY 이전에 실행되므로 해당코드는 300만원 이상의 급여를 받는 사람
-- 먼저 필터링후 부서코드와 평균을 구한다 -> 잘못된 계산 계산순서떄문에 오류임
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE                --1 
WHERE SALARY >= 3000000      --2
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, ROUND(AVG(SALARY)) --3
FROM EMPLOYEE                --1 
GROUP BY DEPT_CODE           --2
HAVING AVG(SALARY) >= 3000000;  --4


--직급별 직급코드 ,총 급여합(단,직급별 총급여합이 1000만원 이상인 직급만 조회)
SELECT JOB_CODE , SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >=10000000;
-- 부서별 보너스를 받는 사원이 없는 부서의 부서코드
SELECT DEPT_CODE , COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS)=0 ;

/*SELECT DEPT_CODE 
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING MAX(BONUS) IS NULL;*/

------------------------------------------------------------------

/*

SELECT *                        --5
FROM 테이블                      --1
WHERE 조건식                     --2
GROUP BY 그룹기준 컬럼 |함수식     --3
HAVING 조건식                    --4
ORDER BY 정렬기준                --6
LIMIT (오라클에는 없는 존재)

*/


















