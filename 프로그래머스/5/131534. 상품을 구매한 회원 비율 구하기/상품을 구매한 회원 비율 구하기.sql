-- 코드를 입력하세요
SELECT year(o.sales_date) as YEAR, month(o.sales_date) as MONTH, count(distinct u.user_id) as PURCHASED_USERS, round(count(distinct u.user_id) / (select count(*) from USER_INFO where year(joined) = '2021'), 1) as PURCHASED_RATIO
FROM USER_INFO as u
JOIN ONLINE_SALE as o
ON u.user_id = o.user_id
WHERE year(JOINED) = '2021'
GROUP BY year, month
ORDER BY year asc, month asc