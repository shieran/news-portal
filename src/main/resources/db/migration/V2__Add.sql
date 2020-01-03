insert into usr (id, username, password, is_active, role)
            values (1, 'Alex', '$2a$08$OM/Ov4N75p7CsrBPfkmh5uHbs.5MMt2todPYE3xR.hy3yMWNo4zEG', 1, 'USER');
insert into usr (id, username, password, is_active, role)
            values (2, 'Nick', '$2a$08$OM/Ov4N75p7CsrBPfkmh5uHbs.5MMt2todPYE3xR.hy3yMWNo4zEG', 1, 'ADMIN');

insert into news (id, news_name, news_details, user_id)
            values (1, 'new year is coming', 'new year details', 2);
insert into news (id, news_name, news_details, user_id)
            values (2, 'ew restaurant opened', 'restaurant details', 2);

insert into comment (id, comment_text, user_id, news_id)
            values (1, 'happy new year', 1, 1);
insert into comment (id, comment_text, user_id, news_id)
            values (2, 'good restaurant', 1, 2);

