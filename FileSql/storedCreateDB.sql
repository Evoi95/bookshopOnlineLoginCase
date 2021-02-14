# create tables

CREATE TABLE if not exists USERS (idUser INT primary key not null auto_increment, idRuolo VARCHAR(1) NOT NULL DEFAULT 'U', Nome VARCHAR(40),
						Cognome VARCHAR(40),Email VARCHAR(50) UNIQUE, pwd VARCHAR(16),descrizione text, DataDiNascita date);
                        
Create table  if not exists AMMINISTRATORE
						  ( idAdmin int primary key not null auto_increment,
                          idUser int, FOREIGN KEY (idUser) REFERENCES USERS(idUser) );                        
                        
Create table  if not exists EDITORE 
						  ( idEditor int primary key not null auto_increment,
                          idUser int,
                          casaEditrice VARCHAR (200), 
						  FOREIGN KEY (idUser) REFERENCES USERS(idUser) );
                          
Create table  if not exists SCRITTORI
						  ( idScrittore int primary key not null auto_increment,
						  idUser int, editoreAssociato int, 
						  FOREIGN KEY (editoreAssociato) REFERENCES EDITORE(idEditor) ,					  FOREIGN KEY (idUser) REFERENCES USERS(idUser) );
                          
Create table  if not exists LIBRO ( titolo VARCHAR(200), numeroPagine int, 
						 Cod_isbn varchar(10)  not null unique ,
						 editore varchar(200) ,
						 autore varchar(200), lingua varchar(10),
						 categoria Varchar(60), dataPubblicazione date,
						 recensione text, copieVendute int, breveDescrizione text,
						 disp int, prezzo float,
						 copieRimanenti int,
						id_prod int primary key auto_increment);      
                        
Create table  if not exists LIBRO (titolo VARCHAR(200),numeroPagine int, 
						Cod_isbn varchar(10)  not null unique ,
						editore varchar(200),
						autore varchar(200), lingua varchar(10),
						categoria Varchar(60), dataPubblicazione date,
						recensione text, copieVendute int, breveDescrizione text,
						disp int, prezzo float,
						copieRimanenti int,
						id_prod int primary key auto_increment);     


create table if not exists pagamento(
						id_op int primary key auto_increment,
						metodo varchar(10),esito int ,
						nomeUtente varchar(10),spesaTotale float,
						eMail varchar(100 ),tipoAcquisto varchar(20),
						id_prod int );                        

Create table if not exists RIVISTA 
						( titolo VARCHAR(200),tipologia Varchar(60),
						autore varchar(200), lingua varchar(10),
						editore varchar(200) ,
						Descrizione text, dataPubblicazione date,
						disp int,prezzo float,copieRimanenti int,
						id int primary key not null auto_increment);
                        
Create table if not exists GIORNALE 
						( titolo VARCHAR(200),tipologia Varchar(60),
						lingua varchar(10),
						editore varchar(200) ,dataPubblicazione date,
						copiRim int,disp int,prezzo float,
						id int primary key not null auto_increment);  
 
 Create table if not exists cartacredito 
						( nomeP VARCHAR(10),cognomeP  Varchar(20),
						codiceCarta varchar(20), scad date ,codicePin varchar(5) ,
						ammontare float );
                        
 Create table if not exists FATTURA 
						( nome varchar(10),cognome varchar(10),
						via varchar(50),comunicazoni text,
						id int auto_increment not null  primary key,
						ammontare float);
                        
Create table if not exists NEGOZIO
						( idNegozio int not null auto_increment primary key, 
						nome VARCHAR(100) , via VARCHAR(100),
