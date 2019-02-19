package com.usermanagement.app.entiry;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.usermanagement.app.entiry.DateConverter.convertStringToDate;

@Entity
@Table(name = "users")
public class User {

    @Embedded
    private UserId userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public User(String firstName, String lastName, Date dof, String phone,
                String email) {
        Assert.hasLength(firstName, "Username must not be empty");
        Assert.hasLength(lastName, "Username must not be empty");
        Assert.notNull(dof, "Date of birth must not be empty");
        this.userId = new UserId(firstName, lastName, dof);
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }

    public User(HttpServletRequest user) {
        String firstName = user.getParameter("firstName");
        String lastName = user.getParameter("lastName");
        String dob = user.getParameter("dob");
        Assert.hasLength(firstName, "Username must not be empty");
        Assert.hasLength(lastName, "Username must not be empty");
        Assert.hasLength(dob, "Date of birth must not be empty");
        this.userId = new UserId(firstName, lastName,
                convertStringToDate(dob));
        this.email = user.getParameter("email");
        this.phone = user.getParameter("phone");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
