-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, if(FREEZER_YN is NULL, 'N', FREEZER_YN) as FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE WAREHOUSE_NAME like '%경기%'
ORDER BY WAREHOUSE_ID asc