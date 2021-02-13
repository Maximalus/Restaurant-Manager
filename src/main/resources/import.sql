DELETE FROM ingredients;
ALTER SEQUENCE ingredient_generator RESTART;
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit) VALUES (nextval('ingredient_generator'), 'Grapefruit juice', 1980, 2000, 24000, 12);
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit) VALUES (nextval('ingredient_generator'), 'Orange juice', 1980, 2000, 24000, 12);
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit) VALUES (nextval('ingredient_generator'), 'Apple juice', 1980, 2000, 24000, 12);
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit) VALUES (nextval('ingredient_generator'), 'Pineapple juice', 1980, 2000, 24000, 12);
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit) VALUES (nextval('ingredient_generator'), 'Mango juice', 1980, 2000, 24000, 12);

DELETE FROM ingredient_groups;
ALTER SEQUENCE ingredient_group_generator RESTART;
INSERT INTO ingredient_groups (id, name) VALUES (nextval('ingredient_group_generator'), 'Milk');
INSERT INTO ingredient_groups (id, name) VALUES (nextval('ingredient_group_generator'), 'Water');
INSERT INTO ingredient_groups (id, name) VALUES (nextval('ingredient_group_generator'), 'Spices');