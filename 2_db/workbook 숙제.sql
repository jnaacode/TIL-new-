-- SELECT(BASIC) 숙제1

-- 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오, 
--    단, 출력 헤더는 "학과 명", "계열"으로 표시하도록 한다.
SELECT DEPARTMENT_NAME "학과 명", CATEGORY 계열
FROM TB_DEPARTMENT;

-- 2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력한다.
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명 입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT;

-- 3. "국어국문학과"에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이 들어왔다.
--    누구인가? (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아내도록 하자)
SELECT STUDENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
AND SUBSTR(STUDENT_SSN,8,1) = 2
AND ABSENCE_YN = 'Y';

-- 4. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 한다. 그 대상자들의
--    학번이 다음과 같을 때 대상자들을 찾는 적절한 SQL 구문을 작성하시오.
--    A513079, A513090, A513091, A513110, A513119
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

-- 5. 입학정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열을 출력하시오.
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6. 춘 기술대학교는 총장을 제외하고 모든 교수들이 소속 학과를 가지고 있다. 그럼 춘 기술대학교
--    총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7. 혹시 전산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 한다.
--    어떠한 SQL 문장을 사용하면 될 것인지 작성하시오.
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8. 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는 과목들은
--    어떤 과목인지 과목번호를 조회해보시오.
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9. 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해보시오.
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 10. 02학번 전주 거주자들의 모임을 만들려고 한다. 휴학한 사람들은 제외한 재학중인 학생들의
--     학번, 이름, 주민번호를 출력하는 구문을 작성하시오.
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE SUBSTR(ENTRANCE_DATE,3,2) = 02
AND STUDENT_ADDRESS LIKE '%전주%'
AND ABSENCE_YN = 'N';

------------------------------------------------------------------------------

-- SELECT(FUNCTION) - 함수 숙제2

-- 1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른순으로
--    표시하는 SQL 문장을 작성하시오.(단, 헤더는 "학번", "이름", "입학년도" 가 표시되도록 한다.)
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, ENTRANCE_DATE 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO = 002
ORDER BY ENTRANCE_DATE;

-- 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의 이름과
--    주민번호를 화면에 출력하는 SQL문장을 작성해 보자.(* 이때 올바르게 작성한 SQL문장의 
--    결과 값이 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것)
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단 이때 나이가
--    적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오. (단, 교수 중 2000년 이후
--    출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 '만'으로 계산한다.)
SELECT PROFESSOR_NAME 교수이름, 
    FLOOR(MONTHS_BETWEEN(SYSDATE, 
    TO_DATE(TO_CHAR(TO_DATE(SUBSTR(PROFESSOR_SSN,1,6),'YYMMDD'),'YYYYMMDD')-1000000,'RRRRMMDD')) /12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN,8,1) = 1
ORDER BY 2; 

-- 3. 선생님 풀이 코드
SELECT PROFESSOR_NAME 교수이름,
        FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('19'||SUBSTR(PROFESSOR_SSN,1,6), 'YYYYMMDD')) / 12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = 1
ORDER BY 나이;
        

-- 4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL문장을 작성하시오, 출력 헤더는 "이름"이
--    찍히도록 한다. (성이 2자인 경우는 교수는 없다고 가정하시오)
SELECT SUBSTR(PROFESSOR_NAME,2,LENGTH(PROFESSOR_NAME)-1) 이름
FROM TB_PROFESSOR;


-- 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가? 이때, 19살에
--    입학하면 재수를 하지 않은 것으로 간주한다.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - 
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN,1,6),'RRMMDD')) > 19;
    
-- 5.선생님 코드 풀이
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) -
      EXTRACT(YEAR FROM TO_DATE(19||SUBSTR(STUDENT_SSN,1,6), 'YYYYMMDD')) > 19;
    
-- 6. 2020년 크리스마스는 무슨 요일인가?
SELECT TO_CHAR(TO_DATE('20201225', 'YYMMDD'), 'YYYY"년 "MM"월 "DD"일 "DY"요일"') FROM DUAL;
-- 답 >> 금요일
 
-- 7. TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD')은 각각 
--    몇 년 몇 월 몇 일을 의미할까? 또 TO_DATE('99/10/11','RR/MM/DD'),
--    TO_DATE('49/10/11','RR/MM/DD')은 각각 몇 년 몇 월 몇 일을 의미할까?
-- 답 >>
-- TO_DATE('99/10/11','YY/MM/DD') -> 2099년 10월 11일
-- TO_DATE('49/10/11','YY/MM/DD') -> 2049년 10월 11일
-- TO_DATE('99/10/11','RR/MM/DD') -> 1999년 10월 11일
-- TO_DATE('49/10/11','RR/MM/DD') -> 2049년 10월 11일

-- 8. 춘 기술대학교의 2000년도 이후 입학자들은 학번이 A로 시작하게 되어있다. 2000년도 이전 학번을
--    받은 학생들의 학번과 이름을 보여주는 SQL문장을 작성하시오.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) < 2000;

-- 9. 학번이 A517178인 한아름 학생의 학점 총 평점을 구하는 SQL문을 작성하시오. 단, 이때
--    출력 화면의 헤더는 "평점"이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만
--    표시한다.
SELECT ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 10. 학과별 학생수를 구하여 "학과번호", "학생수(명)"의 형태로 헤더를 만들어 결과값이
--     출력되도록 하시오.
SELECT DEPARTMENT_NO, COUNT(STUDENT_NO)
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 11. 지도 교수를 배정받지 못한 학생의 수는 몇 명 정도 되는 알아내는 SQL문을 작성하시오.
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12. 학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL문을 작성하시오, 단, 이때
--     출력 화면의 헤더는 "년도", "년도 별 평점"이라고 찍히게 하고, 점수는 반올림하여
--     소수점 이하 한 자리까지만 표시한다.
SELECT SUBSTR(TERM_NO,1,4) 년도, ROUND(AVG(POINT),1) "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY SUBSTR(TERM_NO,1,4);

-- 12. 선생님 코드 풀이
SELECT SUBSTR(TERM_NO, 1, 4) AS "년도", ROUND(AVG(POINT),1) AS "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY 년도;

-- 13. 학과 별 휴학생 수를 파악하고자 한다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을 
--     작성하시오.
SELECT DEPARTMENT_NO 학과코드명, SUM(DECODE(ABSENCE_YN, 'Y',1,'N',0)) "휴학생 수"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 13. 선생님 코드 풀이
SELECT DEPARTMENT_NO, COUNT(DECODE(ABSENCE_YN, 'Y', 'Y', 'NO', 0)) "휴학생 수"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

SELECT DEPARTMENT_NO, SUM(DECODE(ABSENCE_YN, 'Y', 1, 0)) "휴학생 수"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 1;

-- 14. 춘 대학교에 다니는 동명이인 학생들의 이름을 찾고자 한다. 어떤 SQL문장을 사용하면
--     가능하겠는가?
SELECT STUDENT_NAME, COUNT(*)
FROM TB_STUDENT S1
WHERE S1.STUDENT_NAME IN (SELECT S2.STUDENT_NAME
                        FROM TB_STUDENT S2
                        WHERE S1.STUDENT_NO <> S2.STUDENT_NO)
GROUP BY STUDENT_NAME
ORDER BY STUDENT_NAME;

-- 14. 선생님 풀이 코드
SELECT STUDENT_NAME 동일이름, COUNT(*) "동명 인수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*) > 1
ORDER BY STUDENT_NAME;

-- 15. 학번이 A112113인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점, 총 평점을 구하는
--     SQL문을 작성하시오.(단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)
SELECT NVL(SUBSTR(TERM_NO,1,4),' ') 년도, NVL(SUBSTR(TERM_NO,5,2),' ') 학기,ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2))
ORDER BY SUBSTR(TERM_NO,1,4);


------------------------------------------------------------------------------

-- SELECT(OPTION) 숙제3

-- 1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고,
--    정렬은 이름으로 오름차순 표시하도록 한다.
SELECT STUDENT_NAME "학생 이름", STUDENT_ADDRESS 주소지
FROM TB_STUDENT
ORDER BY 1;

-- 2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.
SELECT STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
ORDER BY STUDENT_SSN DESC;

-- 3. 주소지가 강원도나 경기도인 학생들 중 1900년대 학번을 가진 학생들의 이름과 학번, 주소를
--    이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름", "학번", 
--    "거주지 주소"가 출력되도록 한다.
SELECT STUDENT_NAME 학생이름, STUDENT_NO 학번, STUDENT_ADDRESS "거주지 주소"
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%강원도%' 
    OR STUDENT_ADDRESS LIKE '%경기도%'
    AND SUBSTR(ENTRANCE_DATE,1,2) = 19;

-- 4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL문장을 작성하시오.
--    (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아내도록 하자)
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '법학과'
ORDER BY PROFESSOR_SSN;

-- 5. 2004 년 2 학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회하려고 한다. 학점이
--    높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해보시오.
SELECT STUDENT_NO, TO_CHAR(POINT, '0.00')
FROM TB_GRADE
WHERE TERM_NO = 200402
    AND CLASS_NO = 'C3118100'
ORDER BY POINT DESC, STUDENT_NO;

-- 6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL문을
--    작성하시오.
SELECT STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
ORDER BY STUDENT_NAME;

-- 7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO);

-- 8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL문을 작성하시오.
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);

-- 8. 선생님 풀이 코드
-- TB_CLASS_PROFESSOR : 과목별 교수의 정보를 저장한 테이블 (과목 코드, 학과 코드)

-- ANSI 구문
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);

-- 오라클 구문
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS C, TB_CLASS_PROFESSOR CP, TB_PROFESSOR P
WHERE C.CLASS_NO = CP.CLASS_NO 
AND CP.PROFESSOR_NO = P.PROFESSOR_NO;

-- TB_CLASS 와 TB_PROFESSOR 테이블이 공통으로
-- DEPARTMENT_NO 컬럼을 가지고 있다 해서 이를 이용해서 JOIN을 하면 안됨!
/*
TB_CLASS와 TB_PROFESSOR 테이블을 조회 해보면
같은 컬럼 값을 가지는 DEPARTMENT_NO가 많이 존재함
--> 이럴 경우
    TB_CLASS의 DEPARTMENT_NO와
    TB_PROFESSOR의 DEPARTMENT_NO 컬럼 값들이
    서로 연결되기 위한 모든 경우의 수를 만들어냄 (곱집합이 되어버림)
*/

-- 9. 8번의 결과 중 '인문사회' 계열에 속한 과목의 교수 이름을 찾으려고 한다. 이에 해당하는 
--    과목 이름과 교수 이름을 출력하는 SQL문을 작성하시오.
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR P USING(PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON(D.DEPARTMENT_NO = P.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회';

SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO)
WHERE CATEGORY = '인문사회';


-- 9. 선생님 풀이 코드

-- ANSI
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR P USING(PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON(D.DEPARTMENT_NO = P.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회';

-- 오라클(ORACLE) 구문
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS C, TB_CLASS_PROFESSOR CP, TB_PROFESSOR P, TB_DEPARTMENT D
WHERE C.CLASS_NO = CP.CLASS_NO
AND CP.PROFESSOR_NO = P.PROFESSOR_NO
AND P.DEPARTMENT_NO = D.DEPARTMENT_NO
AND CATEGORY = '인문사회';


-- 10. '음악학과' 학생들의 평점을 구하려고 한다. 음악학과 학생들의 "학번", "학생 이름", 
--     "전체 평점"을 출력하는 SQL문장을 작성하시오. (단, 평점은 소수점 1자리까지만
--     반올림하여 표시한다.)
SELECT STUDENT_NO 학번, STUDENT_NAME "학생 이름", ROUND(AVG(POINT),1) "전체 평점"
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO, STUDENT_NAME
ORDER BY STUDENT_NO;


-------------------------------------------------------------------------------

-- 11. 학번이 A313047인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 전달하기 위한
--     학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용할 SQL문을 작성하시오. 
--     단, 출력헤더는 "학과이름","학생이름","지도교수이름"으로 출력되도록 한다.
SELECT DEPARTMENT_NAME 학과이름 , STUDENT_NAME 학생이름, PROFESSOR_NAME 지도교수이름
FROM TB_DEPARTMENT
JOIN TB_STUDENT USING(DEPARTMENT_NO)
LEFT JOIN TB_PROFESSOR ON(PROFESSOR_NO = COACH_PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';

-- 12. 2007년도에 '인간관계론' 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시하는
--     SQL 문장을 작성하시오.
SELECT STUDENT_NAME, TERM_NO
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_CLASS USING(CLASS_NO)
WHERE CLASS_NAME = '인간관계론'
AND TERM_NO LIKE '2007%';

-- 13. 예체는 계열 과목 중 과목 담당교수를 한 명도 배정받지 못한 과목을 찾아 그 과목 이름과
--     학과 이름을 출력하는 SQL 문장을 작성하시오
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS C
LEFT JOIN TB_CLASS_PROFESSOR CP ON (C.CLASS_NO = CP.CLASS_NO)
LEFT JOIN TB_DEPARTMENT D ON (C.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE PROFESSOR_NO IS NULL
AND CATEGORY = '예체능';

-- 13번 선생님 풀이
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS C
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;

-- 14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 한다. 학생이름과 지도교수 이름을
--     찾고 만일 지도 교수가 없는 학생일 경우 "지도교수 미지정"으로 표시하도록 하는 SQL문을
--     작성하시오. 단, 출력헤더는 "학생이름", "지도교수"로 표시하며 고학번 학생이 먼저 표시되도록 한다.
SELECT STUDENT_NAME 학생이름, NVL(PROFESSOR_NAME, '지도교수 미지정') 지도교수
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR P ON(COACH_PROFESSOR_NO = PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '서반아어학과'
ORDER BY ENTRANCE_DATE;

-- 14번 선생님 풀이
SELECT STUDENT_NAME 학생이름, NVL(PROFESSOR_NAME, '지도교수 미지정') 지도교수
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR P ON(S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '서반아어학과'
ORDER BY STUDENT_NO;

-- 15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과이름,
--     평점을 출력하는 SQL문을 작성하시오.
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, DEPARTMENT_NAME "학과 이름", AVG(POINT) 평점
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(STUDENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4.0;

-- 16. 환경조경학과 전공과목들의 과목 별 평점을 파악할 수 있는 SQL문을 작성하시오
SELECT CLASS_NO, CLASS_NAME, ROUND(AVG(POINT),8)
FROM TB_CLASS
JOIN TB_GRADE USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '환경조경학과'
AND CLASS_TYPE LIKE '전공%'
GROUP BY CLASS_NO, CLASS_NAME;

-- 17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL문을
--     작성하시오.
SELECT STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                        FROM TB_STUDENT
                        JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                        WHERE STUDENT_NAME = '최경희');

-- 18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL문을 작성하시오.
SELECT DISTINCT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT 
WHERE STUDENT_NAME = (SELECT STUDENT_NAME
                        FROM TB_STUDENT
                        JOIN TB_GRADE USING(STUDENT_NO)
                        JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                        WHERE DEPARTMENT_NAME = '국어국문학과'
                        GROUP BY STUDENT_NAME
                        HAVING AVG(POINT) = (SELECT MAX(AVG(POINT))
                                                FROM TB_DEPARTMENT
                                                JOIN TB_STUDENT USING(DEPARTMENT_NO)
                                                JOIN TB_GRADE USING(STUDENT_NO)
                                                WHERE DEPARTMENT_NAME = '국어국문학과'
                                                GROUP BY STUDENT_NAME));
                                                
                                                
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
GROUP BY STUDENT_NO, STUDENT_NAME
HAVING AVG(POINT) IN (SELECT MAX(AVG(POINT))
                        FROM TB_STUDENT
                        JOIN TB_GRADE USING(STUDENT_NO)
                        JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                        WHERE DEPARTMENT_NAME = '국어국문학과'
                        GROUP BY STUDENT_NAME);

-- 18번 선생님 풀이
SELECT STUDENT_NO, STUDENT_NAME
FROM 
        (SELECT STUDENT_NO, STUDENT_NAME, AVG(POINT) 평점
        FROM TB_GRADE
        JOIN TB_STUDENT USING(STUDENT_NO)
        WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                                                                                FROM TB_DEPARTMENT
                                                                                WHERE DEPARTMENT_NAME = '국어국문학과')
        GROUP BY STUDENT_NO, STUDENT_NAME
        ORDER BY 평점 DESC)
WHERE ROWNUM = 1;


                                                                                                

-- 19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을 파악하기
--     위한 적절한 SQL문을 찾아내시오. 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록
--     하고, 평점은 소수점 한 자리까지만 반올림하여 표시되도록 한다.
SELECT DEPARTMENT_NAME "계열 학과명", ROUND(AVG(POINT),1) 전공평점
FROM TB_DEPARTMENT
JOIN TB_CLASS USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(CLASS_NO)
WHERE CLASS_TYPE LIKE '전공%'
    AND CATEGORY = (SELECT CATEGORY
                    FROM TB_DEPARTMENT
                    WHERE DEPARTMENT_NAME = '환경조경학과')
GROUP BY DEPARTMENT_NAME
ORDER BY DEPARTMENT_NAME;

-- 19번 선생님 풀이
SELECT DEPARTMENT_NAME "계열 학과명", ROUND(AVG(POINT),1) 전공평점
FROM TB_DEPARTMENT 
JOIN TB_CLASS USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(CLASS_NO)
WHERE CATEGORY = (SELECT CATEGORY
                  FROM TB_DEPARTMENT
                  WHERE DEPARTMENT_NAME = '환경조경학과')
AND CLASS_TYPE LIKE '전공%'
GROUP BY DEPARTMENT_NAME
ORDER BY 1;

-------------------------------------------------------------------------------





