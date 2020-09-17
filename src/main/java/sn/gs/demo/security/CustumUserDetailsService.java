package sn.gs.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.gs.demo.dao.UserRepository;
import sn.gs.demo.entities.Role;
import sn.gs.demo.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Cette classe authentifie l'utilisateur dans la BD

@Service
public class CustumUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usename) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(usename);

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                usename,
                user.getPassword(),
                user.isEnable(),
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRoles())
                );
        return userDetails;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles)
    {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : roles)
        {
            GrantedAuthority grantedAuthority= new SimpleGrantedAuthority(role.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        return grantedAuthorities;
    }
}
