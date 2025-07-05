-- 코드를 입력하세
    SELECT MCDP_CD AS "진료과코드"
         , COUNT(*) AS "5월예약건수"
      FROM APPOINTMENT
     WHERE TO_CHAR(APNT_YMD, 'YYYYMMDD') LIKE '202205%'
  GROUP BY MCDP_CD        
  ORDER BY COUNT(*), MCDP_CD;
  
     
 