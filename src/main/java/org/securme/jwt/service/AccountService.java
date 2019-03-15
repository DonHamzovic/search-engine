package org.securme.jwt.service;

import org.securme.jwt.entities.AppRole;
import org.securme.jwt.entities.AppUser;

public interface AccountService {

        public AppUser saveUser(AppUser user);
        public AppRole saveRole(AppRole role);
        public void AddRoleToUser(String user , String role);
        public  AppUser findUserByUsername(String username);



}
