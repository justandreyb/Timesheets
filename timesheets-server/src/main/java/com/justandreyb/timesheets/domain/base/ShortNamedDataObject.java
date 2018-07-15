package com.justandreyb.timesheets.domain.base;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * {@link NamedDataObject} which has {@code shortName}.
 *
 * @author justandreyb
 * @see NamedDataObject
 */
@MappedSuperclass
public abstract class ShortNamedDataObject extends NamedDataObject {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 3, max = 64)
    @Column(name = "short_name", unique = true, length = 64, nullable = false)
    private String shortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShortNamedDataObject that = (ShortNamedDataObject) o;
        return Objects.equals(shortName, that.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shortName);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
