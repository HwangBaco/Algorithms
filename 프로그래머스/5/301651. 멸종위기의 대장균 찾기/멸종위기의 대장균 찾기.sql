with recursive tmp as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    union all
    select ed.id, ed.parent_id, tmp.generation + 1
    from tmp
    join ecoli_data ed on tmp.id = ed.parent_id
)

select count(*) count, generation
from tmp
where id not in (select parent_id
                from tmp
                where parent_id is not null)
group by generation
order by 2;
