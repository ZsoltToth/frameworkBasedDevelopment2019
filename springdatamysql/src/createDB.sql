create database springdata;
create user 'springuser'@'%' identified by 's3cret';
grant all on springdata.* to 'springuser'@'%';
