insert into cookery (id, name)
values (1, 'Tailandesa');
insert into cookery (id, name)
values (2, 'Indiana');
insert into cookery (id, name)
values (3, 'Italiana');
insert into cookery (id, name)
values (4, 'Japonesa');
insert into cookery (id, name)
values (5, 'Mediterrânea');
insert into cookery (id, name)
values (6, 'Coreana');
insert into cookery (id, name)
values (7, 'Francesa');
insert into cookery (id, name)
values (8, 'Mexicana');
insert into cookery (id, name)
values (9, 'Chinesa');
insert into cookery (id, name)
values (10, 'Brasileira');
insert into cookery (id, name)
values (11, 'Grega');
insert into cookery (id, name)
values (12, 'Espanhola');

insert into state (id, name)
values (1, 'Minas Gerais');
insert into state (id, name)
values (2, 'São Paulo');
insert into state (id, name)
values (3, 'Ceará');
insert into state (id, name)
values (4, 'Rio de Janeiro');
insert into state (id, name)
values (5, 'Rio Grande do Sul');
insert into state (id, name)
values (6, 'Paraná');
insert into state (id, name)
values (7, 'Bahia');
insert into state (id, name)
values (8, 'Santa Catarina');
insert into state (id, name)
values (9, 'Pernambuco');
insert into state (id, name)
values (10, 'Goiás');

insert into city (id, name, state_id)
values (1, 'Uberlândia', 1);
insert into city (id, name, state_id)
values (2, 'Belo Horizonte', 1);
insert into city (id, name, state_id)
values (3, 'São Paulo', 2);
insert into city (id, name, state_id)
values (4, 'Campinas', 2);
insert into city (id, name, state_id)
values (5, 'Fortaleza', 3);
insert into city (id, name, state_id)
values (6, 'Rio de Janeiro', 4);
insert into city (id, name, state_id)
values (7, 'Porto Alegre', 5);
insert into city (id, name, state_id)
values (8, 'Curitiba', 6);
insert into city (id, name, state_id)
values (9, 'Salvador', 7);
insert into city (id, name, state_id)
values (10, 'Florianópolis', 8);
insert into city (id, name, state_id)
values (11, 'Recife', 9);
insert into city (id, name, state_id)
values (12, 'Goiânia', 10);

insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (1, 'Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (2, 'Thai Delivery', 9.50, 1, 1, '38400-777', 'Avenida Brasil', '500', 'Jardim América', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (3, 'Tuk Tuk Comida Indiana', 15, 2, 1, '38400-555', 'Rua das Acácias', '300', 'Vila Nova', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (4, 'Pizzaria Bella Italia', 8.50, 3, 1, '38400-111', 'Rua Itália', '150', 'Centro', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (5, 'Sushi Express', 12, 4, 1, '38400-222', 'Avenida Japão', '250', 'Jardim Oriental', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (6, 'Le Bistro Français', 10.50, 7, 1, '38400-888', 'Rua Paris', '100', 'Centro', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (7, 'Mexicanos Sabores', 9, 8, 1, '38400-333', 'Avenida México', '400', 'Jardim Mexicano', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (8, 'Restaurante Chinês Imperial', 11, 9, 1, '38400-444', 'Rua China', '200', 'Vila Oriental',
        CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (9, 'Sabores Brasileiros', 7.50, 10, 1, '38400-666', 'Avenida Brasil', '100', 'Centro', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (10, 'Taverna Grega', 10, 11, 1, '38400-777', 'Rua Grécia', '300', 'Jardim Grego', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (11, 'Tapas Españolas', 8, 12, 1, '38400-555', 'Avenida Espanha', '400', 'Vila Espanhola', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (12, 'Korean BBQ House', 12.50, 6, 1, '38400-111', 'Rua Coreia', '200', 'Centro', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());
insert into restaurant (id, name, delivery_fee, cookery_id, address_city_id, address_cep, address_street,
                        address_number, address_district, creation_timestamp, update_timestamp)
values (13, 'La Cucina Italiana', 9.50, 3, 1, '38400-222', 'Avenida Itália', '100', 'Jardim Italiano',
        CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into payment_methods (id, description)
values (1, 'Cartão de crédito');
insert into payment_methods (id, description)
values (2, 'Cartão de débito');
insert into payment_methods (id, description)
values (3, 'Dinheiro');
insert into payment_methods (id, description)
values (4, 'Transferência bancária');
insert into payment_methods (id, description)
values (5, 'Pix');
insert into payment_methods (id, description)
values (6, 'Vale-refeição');
insert into payment_methods (id, description)
values (7, 'Boleto bancário');
insert into payment_methods (id, description)
values (8, 'Cheque');
insert into payment_methods (id, description)
values (9, 'Apple Pay');
insert into payment_methods (id, description)
values (10, 'Google Pay');

insert into compilation (id, name)
values (1, 'Gerente'),
       (2, 'Vendedor'),
       (3, 'Secretária'),
       (4, 'Cadastrador'),
       (5, 'Cozinheiro'),
       (6, 'Garçom'),
       (7, 'Barman');

insert into permission (id, name, description)
values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permission (id, name, description)
values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
insert into permission (id, name, description)
values (3, 'EXCLUIR_COZINHAS', 'Permite excluir cozinhas');
insert into permission (id, name, description)
values (4, 'CONSULTAR_RESTAURANTES', 'Permite consultar restaurantes');
insert into permission (id, name, description)
values (5, 'EDITAR_RESTAURANTES', 'Permite editar restaurantes');
insert into permission (id, name, description)
values (6, 'EXCLUIR_RESTAURANTES', 'Permite excluir restaurantes');
insert into permission (id, name, description)
values (7, 'CONSULTAR_PAGAMENTOS', 'Permite consultar pagamentos');
insert into permission (id, name, description)
values (8, 'EDITAR_PAGAMENTOS', 'Permite editar pagamentos');
insert into permission (id, name, description)
values (9, 'EXCLUIR_PAGAMENTOS', 'Permite excluir pagamentos');
insert into permission (id, name, description)
values (10, 'CONSULTAR_PERMISSOES', 'Permite consultar permissões');

INSERT INTO compilation_permissions (compilation_id, permission_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (4, 4),
       (4, 5),
       (4, 6),
       (5, 1),
       (5, 2),
       (6, 7),
       (6, 8),
       (7, 10);

insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (1, 'João da Silva', 'joao.ger@algafood.com.br', '123', utc_timestamp, utc_timestamp);
insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (2, 'Maria Joaquina', 'maria.vnd@algafood.com.br', '123', utc_timestamp, utc_timestamp);
insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (3, 'José Souza', 'jose.aux@algafood.com.br', '123', utc_timestamp, utc_timestamp);
insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (4, 'Sebastião Martins', 'sebastiao.cad@algafood.com.br', '123', utc_timestamp, utc_timestamp);
insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (5, 'Manoel Lima', 'manoel.loja@gmail.com', '123', utc_timestamp, utc_timestamp);
insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (6, 'Débora Mendonça', 'email.teste.aw+debora@gmail.com', '123', utc_timestamp, utc_timestamp);
insert into user (id, name, email, password, creation_timestamp, update_timestamp)
values (7, 'Carlos Lima', 'email.teste.aw+carlos@gmail.com', '123', utc_timestamp, utc_timestamp);

insert into user_compilation (user_id, compilation_id)
values (1, 1),
       (1, 2),
       (2, 2);

insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (1, 3),
       (1, 5),
       (1, 7),
       (1, 8);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (2, 2),
       (2, 3),
       (2, 4),
       (2, 9),
       (2, 10);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (3, 1),
       (3, 4),
       (3, 6);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (4, 2),
       (4, 3),
       (4, 5),
       (4, 6),
       (4, 10);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (5, 1),
       (5, 2),
       (5, 6),
       (5, 7);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (6, 1),
       (6, 2),
       (6, 3),
       (6, 8),
       (6, 9);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (7, 1),
       (7, 2),
       (7, 4),
       (7, 7),
       (7, 10);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (8, 1),
       (8, 2),
       (8, 3),
       (8, 4);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (9, 1),
       (9, 2),
       (9, 4),
       (9, 5),
       (9, 10);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (10, 1),
       (10, 3),
       (10, 4),
       (10, 5),
       (10, 6);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (11, 2),
       (11, 4),
       (11, 6);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (12, 1),
       (12, 3),
       (12, 5),
       (12, 6);
insert into restaurants_payment_methods (restaurant_id, payment_methods_id)
values (13, 1),
       (13, 2),
       (13, 4);

insert into product (id, active, name, description, price, restaurant_id)
values (12, true, 'Coxinha', 'Coxinha de frango com massa crocante e recheio suculento.', 4.99, 5);
insert into product (id, active, name, description, price, restaurant_id)
values (13, true, 'Sanduíche de Churrasco', 'Sanduíche com fatias de carne de churrasco, pão e molhos.', 8.99, 6);
insert into product (id, active, name, description, price, restaurant_id)
values (14, true, 'Salada de Frutas', 'Mix refrescante de frutas da estação.', 6.99, 7);
insert into product (id, active, name, description, price, restaurant_id)
values (15, true, 'Nhoque ao Molho Pesto', 'Nhoque de batata com molho pesto e queijo parmesão.', 10.99, 8);
insert into product (id, active, name, description, price, restaurant_id)
values (16, true, 'Salmão Grelhado', 'Salmão grelhado com legumes frescos.', 16.99, 9);
insert into product (id, active, name, description, price, restaurant_id)
values (17, true, 'Wrap Vegetariano', 'Wrap com variedade de vegetais frescos e molho de iogurte.', 7.99, 10);
insert into product (id, active, name, description, price, restaurant_id)
values (18, true, 'Spaghetti à Bolonhesa', 'Spaghetti com molho de carne à bolonhesa.', 11.99, 11);
insert into product (id, active, name, description, price, restaurant_id)
values (19, true, 'Sopa de Legumes', 'Sopa caseira com uma mistura de legumes frescos.', 6.99, 12);
insert into product (id, active, name, description, price, restaurant_id)
values (20, true, 'Mousse de Limão', 'Mousse de limão cremoso e refrescante.', 4.99, 13);
insert into product (id, active, name, description, price, restaurant_id)
values (21, true, 'Chá Gelado', 'Chá gelado de frutas cítricas.', 3.99, 1);
insert into product (id, active, name, description, price, restaurant_id)
values (22, true, 'Ramen', 'Sopa de macarrão japonês com caldo rico e ingredientes variados.', 12.99, 2);
insert into product (id, active, name, description, price, restaurant_id)
values (23, true, 'Empadão', 'Empadão com massa crocante e recheio de frango desfiado.', 9.99, 3);
insert into product (id, active, name, description, price, restaurant_id)
values (24, true, 'Salada Caprese', 'Salada com tomate, mussarela de búfala, manjericão e azeite.', 8.99, 4);
insert into product (id, active, name, description, price, restaurant_id)
values (25, true, 'Ravioli de Queijo', 'Ravioli recheado com queijo e servido com molho de tomate.', 11.99, 5);
insert into product (id, active, name, description, price, restaurant_id)
values (26, true, 'Peixe ao Molho de Maracujá', 'Filé de peixe grelhado com molho de maracujá.', 14.99, 6);
insert into product (id, active, name, description, price, restaurant_id)
values (27, true, 'Sanduíche Vegano', 'Sanduíche vegano com hambúrguer de legumes e molhos especiais.', 10.99, 7);
insert into product (id, active, name, description, price, restaurant_id)
values (28, true, 'Canelone de Espinafre', 'Canelone recheado com espinafre e ricota ao molho branco.', 13.99, 8);
insert into product (id, active, name, description, price, restaurant_id)
values (29, true, 'Canja de Galinha', 'Sopa de frango com arroz e legumes.', 7.99, 9);
insert into product (id, active, name, description, price, restaurant_id)
values (30, true, 'Torta de Maçã', 'Torta de maçã com massa crocante e recheio suculento.', 5.99, 10);
insert into product (id, active, name, description, price, restaurant_id)
values (31, true, 'Suco Detox', 'Suco refrescante com ingredientes desintoxicantes.', 6.99, 11);
insert into product (id, active, name, description, price, restaurant_id)
values (32, true, 'Lasanha de Berinjela', 'Lasanha vegetariana com camadas de berinjela, molho de tomate e queijo.',
        10.99, 12);
insert into product (id, active, name, description, price, restaurant_id)
values (33, true, 'Sanduíche de Frango', 'Sanduíche com filé de frango grelhado, alface, tomate e maionese.', 7.99, 13);
insert into product (id, active, name, description, price, restaurant_id)
values (34, true, 'Creme de Ervilha', 'Creme de ervilha com toque de hortelã.', 5.99, 1);
insert into product (id, active, name, description, price, restaurant_id)
values (35, true, 'Salada Waldorf', 'Salada com maçã, aipo, nozes e molho de iogurte.', 8.99, 2);
insert into product (id, active, name, description, price, restaurant_id)
values (36, true, 'Macarrão à Puttanesca', 'Macarrão com molho de tomate, azeitonas, alcaparras e anchovas.', 11.99, 3);
insert into product (id, active, name, description, price, restaurant_id)
values (37, true, 'Filé Mignon', 'Filé mignon grelhado com molho de pimenta e acompanhamentos.', 16.99, 4);
insert into product (id, active, name, description, price, restaurant_id)
values (38, true, 'Quiche de Queijo', 'Quiche com recheio de queijo e ervas.', 9.99, 5);
insert into product (id, active, name, description, price, restaurant_id)
values (39, true, 'Sopa de Lentilha', 'Sopa nutritiva de lentilha com temperos especiais.', 6.99, 6);
insert into product (id, active, name, description, price, restaurant_id)
values (40, true, 'Torta de Morango', 'Torta de morango com massa crocante e recheio de creme.', 8.99, 7);
insert into product (id, active, name, description, price, restaurant_id)
values (41, true, 'Suco de Laranja', 'Suco natural de laranja fresca.', 3.99, 8);
insert into product (id, active, name, description, price, restaurant_id)
values (42, true, 'Camarão na Moranga', 'Camarões refogados servidos dentro de uma moranga.', 19.99, 9);
insert into product (id, active, name, description, price, restaurant_id)
values (43, true, 'Sanduíche de Carne de Porco', 'Sanduíche com carne de porco desfiada, molho barbecue e picles.',
        12.99, 10);
insert into product (id, active, name, description, price, restaurant_id)
values (44, true, 'Salada de Quinoa', 'Salada com quinoa, legumes e vinagrete de limão.', 8.99, 11);
insert into product (id, active, name, description, price, restaurant_id)
values (45, true, 'Tortellini ao Molho Rosé', 'Tortellini recheado com queijo ao molho rosé.', 11.99, 12);
insert into product (id, active, name, description, price, restaurant_id)
values (46, true, 'Peixe Frito', 'Peixe frito crocante acompanhado de batatas fritas.', 14.99, 13);
insert into product (id, active, name, description, price, restaurant_id)
values (47, true, 'Sanduíche de Falafel', 'Sanduíche com bolinhos de falafel, salada e molho tahine.', 9.99, 1);
insert into product (id, active, name, description, price, restaurant_id)
values (48, true, 'Penne à Carbonara', 'Penne com molho cremoso de queijo, bacon e pimenta-do-reino.', 12.99, 2);
insert into product (id, active, name, description, price, restaurant_id)
values (49, true, 'Sopa de Cebola', 'Sopa gratinada de cebola com queijo derretido.', 7.99, 3);
insert into product (id, active, name, description, price, restaurant_id)
values (50, true, 'Torta de Limão', 'Torta de limão com massa crocante e recheio de creme azedo.', 5.99, 4);
insert into product (id, active, name, description, price, restaurant_id)
values (51, true, 'Iced Latte', 'Café gelado com leite e cubos de gelo.', 4.99, 5);
