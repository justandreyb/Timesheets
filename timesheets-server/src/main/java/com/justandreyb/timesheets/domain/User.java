package com.justandreyb.timesheets.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.justandreyb.timesheets.domain.base.DataObject;

/**
 * Information about user.
 *
 * @author justandreyb
 */
@Entity
@Table(name = "user")
public class User extends DataObject {

    @Size(min = 2, max = 64)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 64)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_to_departments",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Iterable<Department> departments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_settings_id")
    private UserSettings userSettings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(departments, user.departments) &&
                Objects.equals(userSettings, user.userSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, email, departments, userSettings);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Iterable<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Iterable<Department> departments) {
        this.departments = departments;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }
}
