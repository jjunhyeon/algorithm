-- 코드를 입력하세요
-- 월별 기준이 아닌, 총 기간 동안 5회 이상인 CAR_ID를 반환해야한다.
    SELECT EXTRACT(MONTH FROM A.START_DATE) AS "MONTH"
         , A.CAR_ID 
         , COUNT(*) AS "RECORDS"
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
     WHERE A.START_DATE 
   BETWEEN TO_DATE('2022-08-01','YYYY-MM-DD') 
       AND TO_DATE('2022-11-01','YYYY-MM-DD')
       AND A.CAR_ID IN ( SELECT CAR_ID
                           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                          WHERE START_DATE 
                        BETWEEN TO_DATE('20220801','YYYYMMDD') 
                            AND TO_DATE('20221101','YYYYMMDD')
                       GROUP BY CAR_ID
                         HAVING COUNT(*) > 4 )
  GROUP BY EXTRACT(MONTH FROM A.START_DATE)
         , A.CAR_ID
    HAVING COUNT(*) > 0
  ORDER BY EXTRACT(MONTH FROM A.START_DATE) 
         , CAR_ID DESC;