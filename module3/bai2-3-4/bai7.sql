use quanlysinhvien;
select Address, count(StudentId) as 'số lượng học viên'
from student
group by Address;
select student.StudentId,student.StudentName,avg(Mark)
from student 
student join Mark mark on student.StudentId = mark.StudentId
group by student.StudentId,student.StudentName
HAVING AVG(Mark) > 15;
SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);