DELETE FROM ingredients;
ALTER SEQUENCE ingredient_generator RESTART;
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name) VALUES (nextval('ingredient_generator'), 'Grapefruit juice', 1980, 2000, 24000, 12, 'Liter');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name) VALUES (nextval('ingredient_generator'), 'Orange juice', 1980, 2000, 24000, 12, 'Liter');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name) VALUES (nextval('ingredient_generator'), 'Apple juice', 1980, 2000, 24000, 12, 'Liter');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name) VALUES (nextval('ingredient_generator'), 'Pineapple juice', 1980, 2000, 24000, 12, 'Liter');
INSERT INTO ingredients (id, name, current_quantity, initial_quantity, total_price, cost_per_unit, unit_name) VALUES (nextval('ingredient_generator'), 'Mango juice', 1980, 2000, 24000, 12, 'Liter');

DELETE FROM ingredient_groups;
ALTER SEQUENCE ingredient_group_generator RESTART;
INSERT INTO ingredient_groups (id, name) VALUES (nextval('ingredient_group_generator'), 'Milk');
INSERT INTO ingredient_groups (id, name) VALUES (nextval('ingredient_group_generator'), 'Water');
INSERT INTO ingredient_groups (id, name) VALUES (nextval('ingredient_group_generator'), 'Spices');

DELETE FROM outlets;
ALTER SEQUENCE outlet_generator RESTART;
INSERT INTO outlets (id, name) VALUES (nextval('outlet_generator'), 'Crystal');
INSERT INTO outlets (id, name) VALUES (nextval('outlet_generator'), 'La Spiga');
INSERT INTO outlets (id, name) VALUES (nextval('outlet_generator'), 'Market');
INSERT INTO outlets (id, name) VALUES (nextval('outlet_generator'), 'Spice market');
INSERT INTO outlets (id, name) VALUES (nextval('outlet_generator'), 'Wahm');
INSERT INTO outlets (id, name) VALUES (nextval('outlet_generator'), 'W cafe');

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
INSERT INTO roles_permissions (role_id, permissions_id) VALUES (1,1);
INSERT INTO roles_permissions (role_id, permissions_id) VALUES (1,2);
INSERT INTO roles_permissions (role_id, permissions_id) VALUES (3,1);
INSERT INTO roles_permissions (role_id, permissions_id) VALUES (3,5);
INSERT INTO roles_permissions (role_id, permissions_id) VALUES (3,6);