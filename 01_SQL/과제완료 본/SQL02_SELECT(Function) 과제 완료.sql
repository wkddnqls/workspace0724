--1. 영문학과(학과코드 002) 학생들의 학번과 이름, 입학년도를 입학년도가 빠른순으로 표시하는 
--SQL문장을 작성하시오 ( 단, 헤더는 "학번" , "이름" "입학년도"가 표시되도록한다.)

SELECT STUDENT_NO AS "학번" , STUDENT_NAME AS "이름" , ENTRANCE_DATE AS "입학년도"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = 002
ORDER BY ENTRANCE_DATE ASC;

--2 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의
-- 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE NOT(PROFESSOR_NAME LIKE '___' OR PROFESSOR_NAME LIKE '____');

-- 3 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오,
-- 단 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오. 
-- (교수중 2000년 이후 출생자는없으며 출력헤더는 "교수이름" , "나이"로 한다 나이는 '만'으로 계산
SELECT PROFESSOR_NAME AS "교수이름",
       FLOOR(MONTHS_BETWEEN(SYSDATE,
             TO_DATE('19' || SUBSTR(PROFESSOR_SSN, 1, 6), 'YYYYMMDD')) / 12) AS "나이"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1'  -- 남자
ORDER BY "나이";
 
 --4 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오, 출력헤더는 "이름"
  --  이 찍히도록하고 성이 2자인경우는 교수는 없다고가정하시오
SELECT 
  CASE 
    WHEN LENGTH(PROFESSOR_NAME) = 3 THEN SUBSTR(PROFESSOR_NAME, 2) -- 성 1글자
    WHEN LENGTH(PROFESSOR_NAME) = 4 THEN SUBSTR(PROFESSOR_NAME, 3) -- 성 2글자
    ELSE NULL
  END AS "이름"
FROM TB_PROFESSOR;

-- 5 춘 기술대학교의 재수생 입학자를 구하려고한다. 어떻게 찾아낼것인가?
-- 이때 19살에 입학하면 재수를 하지 않은것으로 간주한다
SELECT STUDENT_NAME
FROM TB_STUDENT 
WHERE FLOOR(MONTHS_BETWEEN(
    TO_DATE(ENTRANCE_DATE, 'RR/MM/DD'),
    TO_DATE(SUBSTR(STUDENT_SSN, 1, 6), 'RRMMDD')
) / 12) > 19;

-- 6 2020년 크리스마스는 무슨 요일인가
SELECT TO_CHAR(TO_DATE('2020-12-25', 'YYYY-MM-DD'), 'DAY') AS "요일"
FROM DUAL;

-- 7  TO_DATE('99/10/11' , 'YY/MM/DD'), TE_DATE('49/10/11','YY/MM/DD')은 각각
-- 몇년 몇월 몇일을 의미할까, 또 
--TO_DATE('99/10/11' , 'RR/MM/DD'), TE_DATE('49/10/11','RR/MM/DD')몇년 몇월 몇일을 의미할까
SELECT 
  TO_CHAR(TO_DATE('99/10/11', 'RR/MM/DD'), 'YYYY-MM-DD') AS "99날짜",
  TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'), 'YYYY-MM-DD') AS "49날짜"
FROM DUAL;

SELECT 
  TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'), 'YYYY-MM-DD') AS "99날짜",
  TO_CHAR(TO_DATE('49/10/11', 'YY/MM/DD'), 'YYYY-MM-DD') AS "49날짜"
FROM DUAL;

--8 춘 기술대학교의 2000년도 이후 입학자들은 학번이 A 로 시작하게되어있다, 2000년도 
-- 이전 학번을 받은 학생들의 학번과 이름을 보여주는 문장만드시오
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE NOT(SUBSTR(STUDENT_NO,1,1) = 'A');

--9 학번이 A517178인 한아름 학생의 학점 총 평점을 구하는 SQL문을 작성하시오
-- 평점으로 헤더 표시 점수 반올림 소수 첫쨰짜리까지 보이게
SELECT ROUND(AVG(POINT),1)
FROM TB_GRADE
GROUP BY STUDENT_NO
HAVING STUDENT_NO = 'A517178';

--10 학과별 학생수를 구하여 "학과번호" 학생수(명)" 의 형태로 헤더를 만들어 결과값출력
SELECT DEPARTMENT_NO "학과번호" , COUNT(*) "학생수(명)" 
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO ;

--11 지도 교수를 배정받지 못한 학생의 수는 몇 명 정도 되는 알아내는 SQL문 작성
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

--12 학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL문을 작성
-- 헤더 "년도" "년도 별 평점" 점수 반올림하여 소수점이하 한자리까지만 표시
SELECT 
  SUBSTR(TERM_NO, 1, 4) AS "년도",
  ROUND(AVG(POINT), 1) AS "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY "년도";


--13 학과 별 휴학생 수를 파악하고자 한다. 학과번호와 휴학생수를 표시해라
SELECT DEPARTMENT_NO , COUNT(*)
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
GROUP BY department_no;

-- 14 춘 대학교에 다니는 동명이인 학생들의 이름을 찾고자 한다. 어떤 SQL 문장을 사용해야하나
SELECT STUDENT_NAME, COUNT(*) AS "인원수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*) >= 2;

--15 학번이 A112113인 김고운 학생의 년도 , 학기 별 평정 과 년도별 누적평정,
 -- 총 평점을 구하시오 소수점 1자리까지 반올림
/*
SELECT 
  SUBSTR(TERM_NO, 1, 4) AS "년도",
  SUBSTR(TERM_NO, 5, 2) AS "학기",
  ROUND(AVG(POINT), 1) AS "학기 별 평점",
  ROUND(SUM(POINT) OVER (PARTITION BY SUBSTR(TERM_NO, 1, 4)), 1) AS "년도 별 누적평점",
  ROUND(AVG(POINT) OVER (), 1) AS "총 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
ORDER BY "년도", "학기";
*/
 
 SELECT 
  SUBSTR(TERM_NO, 1, 4) AS "년도",
  SUBSTR(TERM_NO, 5, 2) AS "학기",
  ROUND(AVG(POINT), 1) AS "학기 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, 5, 2)
ORDER BY "년도", "학기";
 
 SELECT 
  SUBSTR(TERM_NO, 1, 4) AS "년도",
  ROUND(SUM(POINT), 1) AS "년도 별 누적평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY "년도";
 
 SELECT 
  ROUND(AVG(POINT), 1) AS "총 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113';
 
 
 
 
 
 
 
 