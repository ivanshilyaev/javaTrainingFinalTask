package ft.training.by.bean;

import java.util.Objects;

public class TimetableGroup extends Entity {
    private Timetable timetable;
    private Subgroup subgroup;

    public TimetableGroup() {
    }

    public TimetableGroup(int id) {
        super(id);
    }

    public TimetableGroup(int id, Timetable timetable, Subgroup subgroup) {
        super(id);
        this.timetable = timetable;
        this.subgroup = subgroup;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public Subgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TimetableGroup that = (TimetableGroup) o;
        return timetable.equals(that.timetable) &&
                subgroup.equals(that.subgroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timetable, subgroup);
    }

    @Override
    public String toString() {
        return "TimetableGroup{" +
                "id=" + getId() +
                ", timetable=" + timetable +
                ", subgroup=" + subgroup +
                '}';
    }
}
