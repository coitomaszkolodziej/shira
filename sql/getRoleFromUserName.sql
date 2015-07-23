SELECT USERS.user_id, USERS.login_name, ROLES.role_id,
ROLES.role_name FROM users USERS, roles ROLES WHERE USERS.user_id = 
ROLES.user_id AND USERS.login_name = ?