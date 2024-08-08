CREATE TABLE IF NOT EXISTS events
(
    id         serial PRIMARY KEY ,
    title      varchar(255) NOT NULL ,
    start_date date,
    end_date   date
);