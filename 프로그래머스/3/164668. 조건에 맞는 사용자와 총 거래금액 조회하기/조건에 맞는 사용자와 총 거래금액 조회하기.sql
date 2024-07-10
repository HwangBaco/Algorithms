-- 코드를 입력하세요
SELECT user_id, nickname, sum(price) as total_sales
from used_goods_user
join used_goods_board on used_goods_user.user_id = used_goods_board.writer_id
where status = 'done'
group by user_id
having total_sales >= 700000
order by total_sales;