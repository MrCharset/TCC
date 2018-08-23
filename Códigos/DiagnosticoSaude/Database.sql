alter user 'root'@'localhost' identified with mysql_native_password by 'root';
set @@global.time_zone = '-3:00';

drop database if exists diagnostico_de_saude;
create database if not exists diagnostico_de_saude;
use diagnostico_de_saude;

create table if not exists enfermeiro 
(
	id varchar(32) primary key,
    nome varchar(100) not null,
    nascimento date not null,
    sexo varchar(1) not null,
    login varchar(100) not null,
    senha varchar(32) not null
);

create table if not exists paciente
(
	id varchar(32) primary key,
    nome varchar(100) not null,
    nascimento date not null,
    sexo varchar(1) not null
);

create table if not exists consulta
(
	id varchar(32) primary key,
    enfermeiro varchar(32) not null,
    paciente varchar(32) not null,
    datahora datetime not null,
    massaCorporal float,
    circAbdominal float,
    altura float,
    glicemia float,
    pressaoArterial varchar(7),
    respiracao int,
    temperatura float,
    batimentoCardio int,
    foreign key (enfermeiro) references enfermeiro(id),
    foreign key (paciente) references paciente(id)
);

create table if not exists historicoMedico
(
	paciente varchar(32) primary key,
    dadosConsulta text,
    foreign key (paciente) references paciente(id)
);

create table if not exists relatorio
(
	id varchar(32) primary key,
    conteudo text not null,
    datahora datetime not null,
    paciente varchar(32) not null,
    foreign key (paciente) references paciente(id)
);

create table if not exists problema
(
	id varchar(32) primary key,
    nome varchar(100) not null,
    detalhes text not null,
    descricao text not null
);

create table if not exists solucao
(
	id varchar(32) primary key,
    nome text not null,
    descricao text not null
);

create table if not exists problemaSolucao
(
	problema varchar(32) not null,
    solucao varchar(32) not null,
    foreign key (problema) references problema(id),
    foreign key (solucao) references solucao(id),
    primary key (problema, solucao)
);

create table if not exists problemaRelatorio
(
	problema varchar(32) not null,
    relatorio varchar(32) not null,
    foreign key (problema) references problema(id),
    foreign key (relatorio) references relatorio(id),
    primary key (problema, relatorio)
);

select * from enfermeiro;
select * from paciente;
select * from relatorio;