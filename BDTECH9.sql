-- Criando o banco de dados 
CREATE DATABASE bdtech9;
-- escolher banco de dados 
	USE bdtech9;
    -- bloco que cria a tabela
    create table tbusuarios (
    iduser int primary key,
    usuario varchar(50) not null,
    fone varchar(15),
    login varchar(15) not null unique,
    senha varchar(15)
    );
    -- comando que descreve a tabela
    describe tbusuarios;
    -- a linha abaixo insere dados na tabela
    INSERT INTO tbusuarios(iduser,usuario,fone,login,senha)
    values (1,"Felipe Menezes da Silva","7487-8842","xflare",'123456');
    -- a linha abaixo exibe os dados da tabela
    select * from tbusuarios;
    INSERT INTO tbusuarios(iduser,usuario,fone,login,senha)
    values (2,"Administrador","7487-8842","admin",'admin');
    INSERT INTO tbusuarios(iduser,usuario,fone,login,senha)
    values (3,"Halana Augusto","7487-8842","halana",'123456');
    -- a linha abaixo modifica dados na tabela
    update tbusuarios set fone  = "5555-5555" where iduser = 2;
    -- a linha abaixo apaga um registro da tabela 
    delete from tbusuarios where iduser =3;
  -- Tabela de clientes 
   create table tbclientes (
    idcli int primary key auto_increment,
    nomecli varchar(50) not null,
    endcli varchar(70),
    fonecli varchar(50) not null,
    emailcli varchar(50) 
    );
    
    create table tbos (
    os int primary key auto_increment,
    data_os timestamp default current_timestamp,
    equipamento varchar (150) not null ,
    defeito varchar(150) not null,
    serviço varchar(150),
    tecnico varchar(40),
    valor decimal(10,2),
    idcli int not null,
    foreign key(idcli) references tbclientes(idcli)
    );
    
    insert into tbos(equipamento, defeito, serviço, tecnico, valor, idcli) 
    values ('notebook', 'quebrou a tela', 'troca de tela', 'felipe', 89.50,1); 
    select * from tbos;	
    
    -- o codigo abaixo tras info de duas tabelas
    select 
    O.os,equipamento,defeito,serviço,valor,
    C.nomecli,fonecli
    from tbos as O
    inner join tbclientes as C
    on (O.idcli = C.idcli);