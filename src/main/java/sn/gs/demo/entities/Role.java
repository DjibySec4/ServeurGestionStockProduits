package sn.gs.demo.entities;


import sn.gs.demo.util.RoleEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    private String name;

   /* @ManyToMany(fetch=FetchType.EAGER, mappedBy = "roles")
    private List<User> users = new ArrayList<User>();*/

    public Role() {
        super();
    }

    public Role(RoleEnum role) {
        super();
        this.name = role.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //On a generer ces 2 delegate methode
    //2 objets sont egaux s'ils ont le meme id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
