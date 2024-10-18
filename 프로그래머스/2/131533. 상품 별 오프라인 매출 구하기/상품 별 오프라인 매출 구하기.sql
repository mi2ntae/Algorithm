-- 코드를 입력하세요
SELECT product_code, sum(p.price * o.sales_amount) as sales
FROM product as p
JOIN offline_sale as o
on p.product_id = o.product_id
GROUP BY p.product_code
ORDER BY sales desc, product_code asc