package com.justandreyb.timesheets.domain.base;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * {@link DataObject} which has {@code name}.
 *
 * @author justandreyb
 * @see DataObject
 */
@MappedSuperclass
public abstract class NamedDataObject extends DataObject {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 5, max = 128)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NamedDataObject that = (NamedDataObject) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
