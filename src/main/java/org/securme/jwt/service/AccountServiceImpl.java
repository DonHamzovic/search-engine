package org.securme.jwt.service;

import org.securme.jwt.dao.RoleRepository;
import org.securme.jwt.dao.UserRepository;
import org.securme.jwt.entities.AppRole;
import org.securme.jwt.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public AppUser saveUser(AppUser user) {

        System.out.println("user password : "+user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("User password after encrypting : "+user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {

        return roleRepository.save(role);

    }

    @Override
    public void AddRoleToUser(String username, String roleName) {

        AppRole role = roleRepository.findByRolename(roleName);
        AppUser user = userRepository.findByUsername(username);

        user.getRoles().add(role);

    }

    @Override
    public AppUser findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
