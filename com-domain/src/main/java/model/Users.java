package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Serg on 17.09.2017.
 */
@Entity
public class Users {
    private int id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private RoleType role;
    private Collection<Weight> weightsById = new ArrayList<>();

    public Users() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (firstname != null ? !firstname.equals(users.firstname) : users.firstname != null) return false;
        if (lastname != null ? !lastname.equals(users.lastname) : users.lastname != null) return false;
        if (role != null ? !role.equals(users.role) : users.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }


    @OneToMany(mappedBy = "usersByIdUser")
    public Collection<Weight> getWeightsById() {
        return weightsById;
    }

    public void setWeightsById(Collection<Weight> weightsById) {

        this.weightsById = weightsById;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                '}';
    }

    public enum RoleType {
        ROLE_ADMIN, ROLE_USER
    }

}
