use quanlysinhvien;
select SubName,Credit,Status,max(Credit)
from subject ;
select MarkId,SubId,studentId,max(Mark)
from mark;
select * from student;
select * from Mark 
order by Mark Desc;