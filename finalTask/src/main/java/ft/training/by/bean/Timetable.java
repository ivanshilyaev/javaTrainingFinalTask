package ft.training.by.bean;

import ft.training.by.bean.enums.ClassType;
import ft.training.by.bean.enums.Day;

import java.util.Objects;

public class Timetable extends Entity {
    private Day day;
    private int pairNumber;
    private Subject subject;
    private ClassType classType;
    private Classroom classroom;
    private Tutor tutor;

    public Timetable() {
    }

    public Timetable(int id) {
        super(id);
    }

    public Timetable(int id, Day day, int pairNumber, Subject subject,
                     ClassType classType, Classroom classroom, Tutor tutor) {
        super(id);
        this.day = day;
        this.pairNumber = pairNumber;
        this.subject = subject;
        this.classType = classType;
        this.classroom = classroom;
        this.tutor = tutor;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int getPairNumber() {
        return pairNumber;
    }

    public void setPairNumber(int pairNumber) {
        this.pairNumber = pairNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Timetable timetable = (Timetable) o;
        return pairNumber == timetable.pairNumber &&
                day == timetable.day &&
                subject.equals(timetable.subject) &&
                classType == timetable.classType &&
                classroom.equals(timetable.classroom) &&
                tutor.equals(timetable.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), day, pairNumber, subject,
                classType, classroom, tutor);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id='" + getId() + '\'' +
                ", day=" + day +
                ", pairNumber=" + pairNumber +
                ", subject=" + subject +
                ", classType=" + classType +
                ", classroom=" + classroom +
                ", tutor=" + tutor +
                '}';
    }
}
