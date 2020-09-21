package sn.gs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sn.gs.demo.dao.ProduitRepository;
import sn.gs.demo.dao.RoleRepository;
import sn.gs.demo.dao.UserRepository;
import sn.gs.demo.entities.Produit;
import sn.gs.demo.entities.Role;
import sn.gs.demo.entities.User;
import sn.gs.demo.util.RoleEnum;

import java.util.Arrays;

@SpringBootApplication
public class ServeurGestionStockProduitsApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(ServeurGestionStockProduitsApplication.class, args);

        ProduitRepository produitRepositiry = ctx.getBean(ProduitRepository.class);

        produitRepositiry.save(new Produit("Livre", 50, 20));
        produitRepositiry.save(new Produit("Cahier", 200, 5.25f));
        produitRepositiry.save(new Produit("Stylo", 500, 2.10f));

        RoleRepository roleRepository = ctx.getBean(RoleRepository.class);

        //On creer les 2 roles de notre app
        Role roleUser = new Role(RoleEnum.ROLE_USER);
        Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);

        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);

        //On creer des users et on les attributs des roles
        UserRepository userRepository =  ctx.getBean(UserRepository.class);

        //user simple
        User user = new User("user","password1", true);
        user.setRoles(Arrays.asList(roleUser));
        userRepository.save(user);

        //Admin
        User admin = new User("admin","password2", true);
        admin.setRoles(Arrays.asList(roleUser, roleAdmin));
        userRepository.save(admin);

    }

}
