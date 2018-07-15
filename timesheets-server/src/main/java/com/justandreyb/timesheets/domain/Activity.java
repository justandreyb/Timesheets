package com.justandreyb.timesheets.domain;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.justandreyb.timesheets.domain.base.DataObject;

/**
 * Activity performed by user which has a start time, optional end time, description and tags.
 *
 * @author justandreyb
 */
@Entity
@Table(name = "activity")
public class Activity extends DataObject {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "start_point", nullable = false)
    private Instant startPoint;

    @Column(name = "end_point")
    private Instant endPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_category_id", nullable = false)
    private ActivityCategory activityCategory;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tags_to_activities",
        joinColumns = @JoinColumn(name = "activity_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Iterable<Tag> tags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(user, activity.user) &&
                Objects.equals(startPoint, activity.startPoint) &&
                Objects.equals(endPoint, activity.endPoint) &&
                Objects.equals(project, activity.project) &&
                Objects.equals(activityCategory, activity.activityCategory) &&
                Objects.equals(description, activity.description) &&
                Objects.equals(tags, activity.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, startPoint, endPoint, project, activityCategory, description, tags);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Instant startPoint) {
        this.startPoint = startPoint;
    }

    public Instant getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Instant endPoint) {
        this.endPoint = endPoint;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ActivityCategory getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(ActivityCategory activityCategory) {
        this.activityCategory = activityCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Iterable<Tag> getTags() {
        return tags;
    }

    public void setTags(Iterable<Tag> tags) {
        this.tags = tags;
    }
}
