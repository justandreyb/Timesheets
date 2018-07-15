package com.justandreyb.timesheets.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.justandreyb.timesheets.domain.base.NamedDataObject;

/**
 * Category of {@link Activity} (i.e. {@code 'coding'}).
 * Categories are managed by the administrator.
 *
 * @author justandreyb
 */
@Entity
@Table(name = "activity_category")
public class ActivityCategory extends NamedDataObject {

    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActivityCategory that = (ActivityCategory) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
