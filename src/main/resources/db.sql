#建立表


#Module 1 权限模块[根据RBAC设计模式设计表]
	airsys_user airsys_role airsys_resource
#Module 2 人资模块[并没有统一的标准：就是根据实际情况设置]

#Module 3 行政模块

#模板模块
create table if not exists account(
	id int primary key auto_increment,
	name varchar(50) not null,
	balance double
);

create table if not exists user(
	id int primary key auto_increment,
	name varchar(50) not null,
	age int
);

insert into user(name,age) values("zss",45);
insert into user(name,age) values("lgg",78);

