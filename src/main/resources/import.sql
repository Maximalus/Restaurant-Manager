DELETE FROM ingredient_groups;
ALTER SEQUENCE ingredient_group_generator RESTART;
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Milk', false, current_timestamp, current_timestamp);
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Water', false, current_timestamp, current_timestamp);
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Spices', false, current_timestamp, current_timestamp);
INSERT INTO ingredient_groups (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('ingredient_group_generator'), 'Juices', false, current_timestamp, current_timestamp);

DELETE FROM ingredients;
ALTER SEQUENCE ingredient_generator RESTART;
INSERT INTO ingredients (id, name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Grapefruit juice', false, 4, current_timestamp, current_timestamp);
INSERT INTO ingredients (id, name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Orange juice', false, 4, current_timestamp, current_timestamp);
INSERT INTO ingredients (id, name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Apple juice', false, 4, current_timestamp, current_timestamp);
INSERT INTO ingredients (id, name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Pineapple juice', false, 4, current_timestamp, current_timestamp);
INSERT INTO ingredients (id, name, is_deleted, ingredient_group_id, creation_date, changing_date) VALUES (nextval('ingredient_generator'), 'Mango juice', false, 4, current_timestamp, current_timestamp);

DELETE FROM outlets;
ALTER SEQUENCE outlet_generator RESTART;
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Crystal', false, current_timestamp, current_timestamp);
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'La Spiga', false, current_timestamp, current_timestamp);
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Market', false, current_timestamp, current_timestamp);
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Spice market', false, current_timestamp, current_timestamp);
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'Wahm', false, current_timestamp, current_timestamp);
INSERT INTO outlets (id, name, is_deleted, creation_date, changing_date) VALUES (nextval('outlet_generator'), 'W cafe', false, current_timestamp, current_timestamp);

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