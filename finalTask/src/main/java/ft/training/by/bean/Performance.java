package ft.training.by.bean;

import java.util.Objects;

public class Performance extends Entity {
    private Student student;
    private Subject subject;
    private int semester;
    private String credit;
    private String exam;

    public Performance() {
    }

    public Performance(int id) {
        super(id);
    }

    public Performance(Student student, Subject subject, int semester, String credit, String exam) {
        this.student = student;
        this.subject = subject;
        this.semester = semester;
        this.credit = credit;
        this.exam = exam;
    }

    public Performance(int id, Student student, Subject subject, int semester, String credit, String exam) {
        super(id);
        this.student = student;
        this.subject = subject;
        this.semester = semester;
        this.credit = credit;
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Performance that = (Performance) o;
        return semester == that.semester &&
                student.equals(that.student) &&
                subject.equals(that.subject) &&
                credit.equals(that.credit) &&
                exam.equals(that.exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), student, subject, semester, credit, exam);
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + getId() +
                ", student=" + student +
                ", subject=" + subject +
                ", semester=" + semester +
                ", credit='" + credit + '\'' +
                ", exam='" + exam + '\'' +
                '}';
    }
}
