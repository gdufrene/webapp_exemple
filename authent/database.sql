create table personne(
	login varchar(30) not null primary key,
	mdp varchar(30) not null,
	prenom varchar(30),
	nom varchar(30)
);

insert into personne(login, mdp) values('guillaume', 'moi');
insert into personne(login, mdp) values('paul', 'paul');

