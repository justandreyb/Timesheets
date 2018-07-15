package com.justandreyb.timesheets.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import com.justandreyb.timesheets.domain.base.DataObject;

/**
 * Describing {@link User} settings.
 *
 * @author justandreyb
 */
@Entity
@Table(name = "user_settings")
public class UserSettings extends DataObject {

    /**
     * Work time in hours (i.e. {@code 8})
     */
    @Positive
    @Min(1) @Max(24)
    @Column(name = "daily_work_time", nullable = false)
    private int dailyWorkTime;

    /**
     * User currency
     */
    @Column(name = "currency", nullable = false)
    private Currency currency;

    /**
     * Salary in {@link UserSettings#currency}
     */
    @Positive
    @Min(1)
    @Column(name = "month_salary", precision = 10, scale = 2)
    private BigDecimal monthSalary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserSettings that = (UserSettings) o;
        return dailyWorkTime == that.dailyWorkTime &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(monthSalary, that.monthSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailyWorkTime, currency, monthSalary);
    }

    public int getDailyWorkTime() {
        return dailyWorkTime;
    }

    public void setDailyWorkTime(int dailyWorkTime) {
        this.dailyWorkTime = dailyWorkTime;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(BigDecimal monthSalary) {
        this.monthSalary = monthSalary;
    }
}
