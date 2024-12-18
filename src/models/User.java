package models;

import enums.Role;

public class User {
    private Long id;
    private String firstName;
    private String email;
    private String password;
    private Role role;

    public User(Long id, String firstName, String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "\n--------------------------" +
                "\nid        :" + id +
                "\nfirstName :" + firstName +
                "\nemail     :" + email +
                "\npassword  :" + password +
                "\nrole      :" + role;
    }
}
