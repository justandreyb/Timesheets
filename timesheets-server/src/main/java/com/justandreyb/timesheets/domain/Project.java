package com.justandreyb.timesheets.domain;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.justandreyb.timesheets.domain.base.ShortNamedDataObject;

/**
 * Describing projects in company.
 * Note that several {@link Department} may have the same {@link Project}.
 * Projects are managed by the administrator.
 *
 * @author justandreyb
 */
@Entity
@Table(name = "project")
public class Project extends ShortNamedDataObject {

    @NotNull
    @Column(name = "creation_date")
    private Instant creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Project project = (Project) o;
        return Objects.equals(creationDate, project.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate);
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }
}
