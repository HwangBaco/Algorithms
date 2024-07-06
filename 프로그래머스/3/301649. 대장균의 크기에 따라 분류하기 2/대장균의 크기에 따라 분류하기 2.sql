-- 코드를 작성해주세요
with colony_dist as (
    select id, ntile(4) over (order by size_of_colony desc) as dist
    from ecoli_data
)

select ed.id, case when cd.dist = 1 then 'CRITICAL'
        when cd.dist = 2 then 'HIGH'
        when cd.dist = 3 then 'MEDIUM'
        when cd.dist = 4 then 'LOW'
        END as COLONY_NAME
from ecoli_data ed
join colony_dist cd on ed.id = cd.id
order by id;