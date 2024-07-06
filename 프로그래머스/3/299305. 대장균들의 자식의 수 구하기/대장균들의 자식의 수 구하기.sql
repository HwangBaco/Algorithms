-- 코드를 작성해주세요
select id, ifnull(cnt, 0) as CHILD_COUNT
from ecoli_data
left join (select parent_id, count(*) as cnt
     from ecoli_data
     group by parent_id) as p on p.parent_id = ecoli_data.id;