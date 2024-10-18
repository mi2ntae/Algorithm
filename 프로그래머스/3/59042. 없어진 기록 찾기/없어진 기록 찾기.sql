-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_INS as i
RIGHT OUTER JOIN ANIMAL_OUTS as o
ON i.animal_id = o.animal_id
WHERE o.animal_id not in (select animal_id from ANIMAL_INS)