package com.justandreyb.timesheets.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.justandreyb.timesheets.domain.base.ShortNamedDataObject;

/**
 * Describing departments in company.
 * Departments are managed by administrator.
 *
 * @author justandreyb
 */
@Entity
@Table(name = "department")
public class Department extends ShortNamedDataObject {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "projects_to_departments",
        joinColumns = @JoinColumn(name = "department_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Iterable<Project> projects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return Objects.equals(projects, that.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projects);
    }

    public Iterable<Project> getProjects() {
        return projects;
    }

    public void setProjects(Iterable<Project> projects) {
        this.projects = projects;
    }
}
