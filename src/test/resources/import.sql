DELETE FROM ingredient_groups;
ALTER SEQUENCE ingredient_group_generator RESTART;
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Milk', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Water', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Spices', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Juices', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');

DELETE FROM ingredients;
ALTER SEQUENCE ingredient_generator RESTART;
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Grapefruit juice', 1980, 2000, 24000, 12, 'Liter', false, 4, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Orange juice', 1980, 2000, 24000, 12, 'Liter', false, 4, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Apple juice', 1980, 2000, 24000, 12, 'Liter', false, 4, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Pineapple juice', 1980, 2000, 24000, 12, 'Liter', false, 4, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Mango juice', 1980, 2000, 24000, 12, 'Liter', false, 4, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');

DELETE FROM outlets;
ALTER SEQUENCE outlet_generator RESTART;
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Crystal', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'La Spiga', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Market', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Spice market', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Wahm', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'W cafe', false, '2021-03-01T16:06:44.332858', '2021-03-01T16:06:44.332858');

DELETE FROM roles;
ALTER SEQUENCE roles_generator RESTART;
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'ADMINISTRATOR');
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'GENERAL_MANAGER');
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'MANAGER');
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'CASHIER');
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'CAPTAIN');
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'WAITER');
INSERT INTO roles (id, name) VALUES (nextval('roles_generator'), 'DEFAULT');

DELETE FROM permissions;
ALTER SEQUENCE permission_generator RESTART;
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'ADMIN-READ');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'ADMIN-WRITE');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'GENERAL_MANAGER-READ');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'GENERAL_MANAGER-WRITE');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'MANAGER-READ');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'MANAGER-WRITE');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'CAPTAIN-READ');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'CAPTAIN-WRITE');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'CASHIER-READ');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'CASHIER-WRITE');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'WAITER-READ');
INSERT INTO permissions (id, name) VALUES (nextval('permission_generator'), 'WAITER-WRITE');

DELETE FROM roles_permissions;
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1,1);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1,2);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (3,1);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (3,5);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (3,6);