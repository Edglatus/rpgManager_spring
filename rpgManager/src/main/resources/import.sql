insert into campanha (nome, cdate) values ('Tower at Worlds End', TO_DATE('17/12/2015', 'DD/MM/YYYY')), ('Ashes of the Sun', TO_DATE('31/12/5420', 'DD/MM/YYYY'));
insert into jogador (nome) values ('Zé'), ('Lara'), ('Capiroto');
insert into classe (nome) values ('Mago'), ('Ladino'), ('Patrulheiro');
insert into personagem (nome, fk_player, fk_class, fk_campaign) values ('Aidan', '2', '2', '1'), ('Astora', '2', '1', '2'), ('Jarret', '1', '3', '2');