package sn.gs.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    //Pr activer ou desactiver l'utilisateur
    private boolean enable;

    //Avec FetchType.EAGER a chak fois kon selectionne un user ds la BD, on selectionne =ment la liste de ses roles
    //si on utilise FetchType.LAZI, quand on select un user spécique on n selectionne pas ses roles en meme tps.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES",
            joinColumns={@JoinColumn(name = "USER_ID")},
            inverseJoinColumns={@JoinColumn(name = "ROLE_ID")})
    private List<Role> roles;

    public User() {
        super();
    }

    public User(String username, String password, boolean enable) {
        this.username = username;
        this.password = password;
        this.enable = enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }


    //On a generer ces 2 delegate methode
    //2 objets sont egaux s'ils ont le meme id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return  result;
    }
}
