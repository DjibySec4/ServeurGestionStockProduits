package sn.gs.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    protected void configure(HttpSecurity http) throws Exception
    {
        //L'utilisateur ki a le role USER n p acceder qu'aux ressource definie ds l'API et user ki a le role
        //ADMIN p acceder a tous les ressources.
        http.httpBasic().and().authorizeRequests().antMatchers("/api/**")
                .hasRole("USER").antMatchers("/**")
                .hasRole("ADMIN").and()
                .csrf().disable().headers().frameOptions().disable();
    }

    //Mock configuration pr l'authentification
    //Un user a un seul role (USER) alors k un admin a  2 roles (USER et ADMIN)
    //user se connect avec le login user et le mdp password1 alors k admin se connect avec le login admin et le mdp password2
   /* protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().passwordEncoder(
                NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password1").roles("USER").and()
                .withUser("admin").password("password2").roles("USER", "ADMIN");
    }*/

    //Vrai Configuration
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(
                NoOpPasswordEncoder.getInstance());
    }

}
