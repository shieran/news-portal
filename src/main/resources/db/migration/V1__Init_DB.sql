create table hibernate_sequence (next_val bigint) engine=InnoDB;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table comment (
  id bigint not null,
  comment_text varchar(255),
  user_id bigint,
  news_id bigint,
  primary key (id)
) engine=InnoDB;

create table news (
  id bigint not null,
  news_name varchar(255),
  news_details varchar(255),
  user_id bigint, primary key (id)
) engine=InnoDB;

create table usr (
  id bigint not null,
  is_active bit not null,
  password varchar(255),
  role varchar(255),
  username varchar(255), primary key (id)
) engine=InnoDB;

alter table comment
add constraint comment_user_fk
foreign key (user_id) references usr (id);

alter table comment
add constraint comment_news_fk
foreign key (news_id) references news (id);

alter table news
add constraint news_user_fk
foreign key (user_id) references usr (id);