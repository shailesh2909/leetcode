# Write your MySQL query statement below
select r.contest_id, ROUND((COUNT(r.user_id))/(select COUNT(*) from Users) * 100, 2) as percentage 
from Register as r
group by r.contest_id
order by percentage desc, r.contest_id asc