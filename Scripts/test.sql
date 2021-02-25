select user(), database();

show tables;

desc title;
desc department;
desc employee;

select * from title;

update title set tname = '계약직' where tno = 6;

select tno, tName from title where tno = 3;
select deptNo,deptName,floor from department;
select empno,empname,title,manager,salary,dept from employee;

insert into title values(6, '인턴');

delete from title where tno = 6;

update department set deptName = '인사' where deptNo = 5;

delete from department where deptNo = 5;
select * from department;
insert into department values (5, '연구', 6);
select deptNo, deptName, floor from department where deptNo = 1;


select * from employee ;

insert into employee values(2000, '김상건', 3, 4377, 3000000, 2);
delete from employee where empno = 2000;

update employee set empname = '김민희' where empno = 2000;

select * from employee;
select * from title;
select * from department ;


select * from vm_employee;

create view vw_employee
as
select *
from employee e join title t on e.title = t.tno 
left join employee m on e.manager = m.empno
join department d on e.dept =d.deptNo ;


select e.*, t.* m.empno, m.empname, d.*
from employee e join title t on e.dept =t.tno 
left join employee m on e.manager =m.empno 
join department d on e.dept =d.deptNo ;


select * from employee;
select * from title;

create or replace view vw_full_employee
as
select e.empno,
	   e.empname,
       t.tno as title_no, 
       t.tname as title_name, 
       e.manager as	manager_no,
       m.empname as manager_name,
       e.salary,
       d.deptNo,
       d.deptName,
       d.floor
from employee e join title t on e.title=t.tno
left join employee m on e.manager =m.empno 
join department d on e.dept = d.deptNo;

select empno,empname,title_no,title_name,manager_no,
manager_name,salary,deptNo,deptName,floor 
from vw_full_employee ;

select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo from employee;

insert into employee values(1004, '천사', 5, 4377, 2000000, 1);
select * from employee;

update employee
set dept = 3
where empno =1004;

delete from employee 
where empno = 1004;

select * from employee;

select * from vw_full_employee

select tno, tname from title;
select deptNo,deptName,floor from department ;

delete from title where tno = 6;
delete from department where deptno = 5;

select * from employee;

select empno,empname,title,manager,salary,dept 
from employee where dept in 
(select deptno from department where deptno =1) ;

select * from title;
delete from title where tno = 6;

select * from department;
delete from department where deptno = 5;

select * from vw_full_employee;

select empno,empname,title_no,title_name,
manager_no,manager_name,salary,deptNo,deptName,floor 
from vw_full_employee;

select * from title;
select * from department;

delete from title where tno = 6;
delete from department where deptno = 5;
