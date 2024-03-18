show tables;
# user ##############################################################
-- select
select * from users;

select no, id, pass, name, gender
from users where id = 'aa' and pass = 'aa';

select no, id, pass, name, gender
from users where no = 1;

-- insert
insert into users 
values(null, 'aa', 'aa', '아무개', 'male');
insert into users values
(null, 'ss', 'ss', '아따맘마', 'female');

-- update
update users
set pass = 'aa',
    name = '아무게',
    gender = 'male'
where id='aa';

# board ###############################################################
-- select
select * from board;

-- insert
insert into board 
values(1, '익스', '안녕하세요', 0, now(), (select no from users where id = 'aa'));
insert into board 
values(null, '제목', '외않도ㅔ', 0, now(), (select no from users where id = 'aa'));

-- update


-- delete
delete from board where no = 1;

# rboard ##############################################################
-- select
select * from rboard;

-- insert
insert into rboard
values(null, 1, '일빠' ,'첫글 이다ㅏㅏ', 0, now(), 0, 0, 0);

# guestbook ############################################################
-- select
select u.name, b.title, b.content, b.hit, b.reg_date 
from users u, board b where b.title = '익스' and u.no = b.user_no;
select * from guestbook;
select book_id, name, pw, content, date
from guestbook;

-- insert
insert into guestbook
values(null, 'aa', 'aa', 'aa', now());

-- delete
delete from guestbook
where book_id = 7 and pw = 'aa';

# gallery ###############################################################
-- select
select * from gallery;
select g.no, user_no, content, org_name, save_name, file_path, file_size, u.no, u.name
from gallery g, users u
where user_no = u.no;

-- insert
alter table gallery auto_increment=1;
insert into gallery
values(null, 1, 'testContent', 'testOrgName', 'testSaveName', 'testFilePath', 0);

-- delete
delete from gallery
where no= 4;

