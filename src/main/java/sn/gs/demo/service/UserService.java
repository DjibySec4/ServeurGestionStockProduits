package sn.gs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sn.gs.demo.dao.UserRepository;
import sn.gs.demo.entities.User;

import java.util.List;

//Com on a 2 services qui implemente la meme interface(ProduitMockService et ProduitService), ca p poser probleme ds l
//controller. C prkw on a ajouter @Primary pr dire k ce service sera prooritaire si on appelle une meth du repository dans le controller
@Service
@Primary
public class UserService implements ICrudService<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);

    }
}
