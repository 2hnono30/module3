use quanlysinhvien;
select StudentName from student
where StudentName like 'h%';
select ClassName,StartDate from class
where StartDate like '_____12%';
select * from subject 
where Credit between 3 and 5;
update student
set ClassId=2
where StudentId = 1;
select StudentId,SubId,Mark from mark
order by Mark DESC;