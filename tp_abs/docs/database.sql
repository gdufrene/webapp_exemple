
drop table if exists absence;
drop table if exists justificatif;
drop table if exists personne;

-- Pour postgres : remplacer les auto_increment par des types serial

create table personne(
	pno int not null primary key,
	prenom varchar(50) not null,
    role enum('Etudiant', 'Enseignant', 'Secretaire') not null
);

create table absence(
	ano int not null primary key auto_increment,
	jour date not null,
	enseignant int not null,
	etudiant int not null,
	constraint fk_abs_enseignant foreign key (enseignant) references personne(pno),
	constraint fk_abs_etudiant foreign key (etudiant) references personne(pno)
);

create table justificatif(
	jno int not null primary key auto_increment,
	debut date not null,
	fin date not null,
	raison text,
	secretaire int not null,
	etudiant int not null,
	constraint fk_just_secretaire foreign key (secretaire) references personne(pno),
	constraint fk_just_etudiant foreign key (etudiant) references personne(pno)
);

insert into personne(pno, prenom, role) values
	(1, 'paul', 'Etudiant'),
	(2, 'pierre', 'Etudiant'),
	(3, 'alice', 'Etudiant'),
	(4, 'marc', 'Secretaire'),
	(5, 'elodie', 'Enseignant');

insert into justificatif(debut, fin, raison, secretaire, etudiant) 
values('2020-01-31', '2020-02-02', 'Consultation medicale', 4, 1);

insert into absence(jour, enseignant, etudiant) values
	-- absences de paul
	('2020-02-01', 5, 1),
	('2020-02-03', 5, 1),
	('2020-01-30', 5, 1),
	('2020-02-02', 5, 1),
	('2020-01-31', 5, 1),
	-- absence de pierre
	('2020-02-02', 5, 2),
	('2020-01-31', 5, 2);
