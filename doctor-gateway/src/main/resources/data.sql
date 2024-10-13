insert into users(username, password, enabled)
values ('admin', '$2y$10$O4HN5WEhJE03T17MrPCqIuQz289LjGMcfRs5m97gipAUDb/i/wYFW', true),
       ('vasyaPupkin', '$2y$10$H1xyDb7g2LE/widxZrGOguK3px2xo/2KiTmQUYD0h6N0CQE66qvsW', true);

insert into authorities (username, authority)
values ('admin', 'ROLE_admin'),
       ('vasyaPupkin', 'ROLE_doctor')