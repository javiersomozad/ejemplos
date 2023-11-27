package es.anaya.spring.web.s04.dbloginmysql.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.anaya.spring.web.s04.dbloginmysql.domain.Role;
import es.anaya.spring.web.s04.dbloginmysql.domain.User;
import es.anaya.spring.web.s04.dbloginmysql.repositories.RoleRepository;
import es.anaya.spring.web.s04.dbloginmysql.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        
        Role userAdminRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userAdminRole)));
        
        System.out.println("USer is ready: " + user);
		userRepository.save(user);
	}

}