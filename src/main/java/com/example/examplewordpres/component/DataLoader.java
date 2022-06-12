package com.example.examplewordpres.component;

import com.example.examplewordpres.entity.Users;
import com.example.examplewordpres.entity.enums.RoleEnum;
import com.example.examplewordpres.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    final PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    String mode;

    final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")) {
            Users user = new Users();
            user.setUsername("worker");
            user.setPassword(passwordEncoder.encode("worker"));
            user.setEmail("farruxbekaxmadaliyev850@gmail.com");
            user.setEmailpassword("igcmadxdtdjdbezx");
            user.setRoleEnum(RoleEnum.WORKER);
            userRepository.save(user);

            Users admin = new Users();
            admin.setRoleEnum(RoleEnum.LABARANT);
            admin.setUsername("labarant");
            admin.setEmail("labarant@gmail.com");
            admin.setPassword(passwordEncoder.encode("labarant"));
            userRepository.save(admin);

            Users superadmin = new Users();
            superadmin.setRoleEnum(RoleEnum.DIRECTOR);
            superadmin.setUsername("director");
            superadmin.setEmail("director@gmail.com");
            superadmin.setPassword(passwordEncoder.encode("director"));
            userRepository.save(superadmin);
        }


    }
}
