-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF fh
JOIN ICECREAM_INFO ii on fh.flavor = ii.flavor
group by ii.ingredient_type