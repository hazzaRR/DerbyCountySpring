package com.DCFC.MatchTracker;

import com.DCFC.MatchTracker.model.Role;
import com.DCFC.MatchTracker.model.User;
import com.DCFC.MatchTracker.repository.RoleRepository;
import com.DCFC.MatchTracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MatchTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			if (roleRepository.findByAuthority("ADMIN").isPresent()) {
				return;
			}
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();

			roles.add(adminRole);

			User admin = new User(1, "admin", passwordEncoder.encode("password"), roles);

			userRepository.save(admin);

		};

	}

}
