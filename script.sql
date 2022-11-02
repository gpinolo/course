create table student (
    id integer not null,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
);
create table teacher (
    id integer not null,
    first_name varchar(255),
    last_name varchar(255),
    subject varchar(255),
    primary key (id)
);
create table exam (
    id integer not null,
    date timestamp,
    title varchar(255),
    vote integer,
    student_id integer,
    primary key (id),
    foreign key (student_id) references student(id)
);
create table student_teacher (
    student_id integer not null,
    teacher_id integer not null,
    primary key (student_id, teacher_id),
    foreign key (student_id) references student(id),
    foreign key (teacher_id) references teacher(id)
);
