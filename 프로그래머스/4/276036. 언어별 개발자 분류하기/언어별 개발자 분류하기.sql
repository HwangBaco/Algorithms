-- 코드를 작성해주세요
with tmp as (
    select d.id, case when skill_code & (select sum(code) from skillcodes where category like 'Front %') and skill_code & (select code from skillcodes where name = 'Python') then 'A'
    when skill_code & (select code from skillcodes where name = 'C#') then 'B'
    when skill_code & (select sum(code) from skillcodes where category like 'Front %') then 'C'
    else null
    end as grade
    from developers d    
)
select grade, d.id, email
from developers d
join tmp on tmp.id = d.id
group by grade, d.id, email
having grade is not null
order by grade, d.id