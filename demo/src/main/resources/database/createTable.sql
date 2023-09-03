create table user(
created_at timestamp,
password varchar(24) not null,
user_id varchar(24) primary key,
mail_id varchar(30) not null
)

create table posts(
post_id serial primary key,
user_id varchar(24),
created_at timestamp,
content varchar(500) not null,
FOREIGN KEY (user_id) REFERENCES user(id)
)

create table comments(
comment_id serial primary key,
user_id varchar(24),
created_at timestamp,
comment_value varchar(200) not null,
FOREIGN KEY (user_id) REFERENCES user(user_id)
FOREIGN KEY (post_id) REFERENCES posts(post_id)
)
