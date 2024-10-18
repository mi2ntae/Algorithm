-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
FROM BOOK b
JOIN AUTHOR a
ON b.author_id = a.author_id
WHERE b.category = '경제'
ORDER BY PUBLISHED_DATE asc