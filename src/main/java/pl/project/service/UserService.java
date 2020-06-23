package pl.project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.project.model.User;
import pl.project.model.UserRole;
import pl.project.repository.UserRepository;
import pl.project.repository.UserRoleRepository;

@Service
public class UserService {

	@Autowired
	JdbcTemplate template;
	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private UserRoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setRoleRepository(UserRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<User> findAll(){
		return userRepository.findAll();	
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	public UserRole getRole(Long id) {
		return roleRepository.findById(id).get();
	}
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	public void addWithDefaultRole(User user) {
		UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
		user.getRoles().add(defaultRole);
		String passwordHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHash);
		userRepository.save(user);
	}
}