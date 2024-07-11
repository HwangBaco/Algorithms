# Write your MySQL query statement below
with manager_tb as (
    select managerId, count(*) as direct_reports
    from employee
    group by managerId
)
select name
from employee
join manager_tb on employee.id = manager_tb.managerId
where direct_reports >= 5;