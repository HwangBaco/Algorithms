WITH tmp AS (
    SELECT b.category, b.book_id, SUM(bs.sales) AS sales_sum
    FROM book b
    JOIN book_sales bs ON b.book_id = bs.book_id
    WHERE bs.sales_date LIKE '2022-01-%'
    GROUP BY b.category, b.book_id
)
SELECT a.author_id, a.author_name, b.category, SUM(tmp.sales_sum * b.price) AS total_sales
FROM book b
JOIN author a ON b.author_id = a.author_id
JOIN tmp ON b.book_id = tmp.book_id
GROUP BY a.author_id, a.author_name, b.category
ORDER BY a.author_id, b.category DESC;