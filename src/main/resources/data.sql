insert into board (board_id,name,created_date,modified_date)
values
('c02dc9c9a96349cdabe7a0543d49bcfb', 'Board1', CURRENT_DATE(), CURRENT_DATE()),
('63b7b478952941669fd7f7686f266ff6', 'Board2', CURRENT_DATE(), CURRENT_DATE()),
('98e7d258c1644742ae8f4c02b72c5bf4', 'Board3', CURRENT_DATE(), CURRENT_DATE());

insert into task_group (task_group_id, board_id,name,created_date,modified_date)
values
('d81e374707294138b6161fa30bc5444c','c02dc9c9a96349cdabe7a0543d49bcfb', 'TG1', CURRENT_DATE(), CURRENT_DATE()),
('79629a5a6ee14d538e994efe33ccb210','c02dc9c9a96349cdabe7a0543d49bcfb', 'TG2', CURRENT_DATE(), CURRENT_DATE()),
('b702aa86376d4ef1812636b9abfa6afa','c02dc9c9a96349cdabe7a0543d49bcfb', 'TG3', CURRENT_DATE(), CURRENT_DATE());

insert into task (task_id, task_group_id, name,description,created_date,modified_date)
values
('b06b0fd64d484c42858dad911e278464','d81e374707294138b6161fa30bc5444c', 'Task1'
,'Do this first', CURRENT_DATE(), CURRENT_DATE()),
('1f700d599ed447d5a9417da3e45c0cc9','d81e374707294138b6161fa30bc5444c', 'Task2'
,'Then this', CURRENT_DATE(), CURRENT_DATE()),
('e63b9400e845410faffa4a4ebb0f240f','b702aa86376d4ef1812636b9abfa6afa', 'Task3'
,'And finally this', CURRENT_DATE(), CURRENT_DATE());

insert into comment (comment_id, task_id, text,created_date,modified_date)
values
('5dd95a301aa24eac83e9b12804de1919','b06b0fd64d484c42858dad911e278464', 'This is a comment', CURRENT_DATE(), CURRENT_DATE()),
('c52ecd8c0c26449fbecaacca9dd753f5','b06b0fd64d484c42858dad911e278464', 'This is another comment', CURRENT_DATE(), CURRENT_DATE()),
('bc374464206449ab8035219bf8459aac','1f700d599ed447d5a9417da3e45c0cc9', 'Test Message', CURRENT_DATE(), CURRENT_DATE());