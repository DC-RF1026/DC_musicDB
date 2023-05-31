create table musics(
    id int not null auto_increment,
    singer varchar(100) not null,
    title varchar(100) not null,
    genre varchar(100) not null,
    uri varchar(100) default 'https://sites.google.com/g.dreamcareer.co.jp/dcits',
    primary key(id)
);