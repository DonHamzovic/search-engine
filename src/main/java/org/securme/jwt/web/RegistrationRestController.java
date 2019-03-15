package org.securme.jwt.web;


import org.securme.jwt.dao.UserRepository;
import org.securme.jwt.entities.AppRole;
import org.securme.jwt.entities.AppUser;
import org.securme.jwt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRestController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userFrom){

        if(!userFrom.getPassword().equals(userFrom.getRepassword()))
                throw new RuntimeException("you must confirm your password");
        AppUser userfound = accountService.findUserByUsername(userFrom.getUsername());
        if(userfound!=null)
            throw new RuntimeException("username is already in used");

        AppUser user = new AppUser();
        user.setPassword(userFrom.getPassword());
        user.setUsername(userFrom.getUsername());
        accountService.saveUser(user);

        accountService.AddRoleToUser(user.getUsername(),"ADMIN");

        return  user;

    }


}
