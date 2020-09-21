package sn.gs.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.gs.demo.dao.RoleRepository;
import sn.gs.demo.entities.Role;
import sn.gs.demo.entities.User;
import sn.gs.demo.util.RoleEnum;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/crud_user")
public class CrudUserController extends  CrudController<User, Long>{

    //Envoie une liste d'users qui ont des password null. c pr n pas afficher les password dans le front
    //sinon  si on inspecte le code, on p voir les password en claire .

    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAll()
    {
        List<User> users = super.getAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }

    @PostMapping
    public void add(@RequestBody User user)
    {
        Role role =  roleRepository.findByName(RoleEnum.ROLE_USER.getName());
        user.setRoles(Arrays.asList(role));
        user.setEnable(true);
        super.add(user);
    }

}
