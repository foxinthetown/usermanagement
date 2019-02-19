package com.usermanagement.app.entiry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class UserId implements Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "dof", nullable = false)
    private Date dof;

    UserId(String firstName, String lastName, Date dof) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dof = dof;
    }

    public UserId() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDof() {
        return dof;
    }

    public void setDof(Date dof) {
        this.dof = dof;
    }
}
