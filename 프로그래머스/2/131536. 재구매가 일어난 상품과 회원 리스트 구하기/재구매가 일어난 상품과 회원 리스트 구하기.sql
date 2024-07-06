-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
from (select user_id, product_id, count(*) as purchase_count
     from online_sale
     group by user_id, product_id) as a
where purchase_count > 1
ORDER BY USER_ID asc, PRODUCT_ID desc