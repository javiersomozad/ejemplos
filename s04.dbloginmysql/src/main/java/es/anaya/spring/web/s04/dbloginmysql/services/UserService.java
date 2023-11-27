package es.anaya.spring.web.s04.dbloginmysql.services;

import es.anaya.spring.web.s04.dbloginmysql.domain.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public void saveUser(User user);
}