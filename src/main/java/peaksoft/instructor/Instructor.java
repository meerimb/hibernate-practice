package peaksoft.instructor;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String subject;
    private String subjectLanguage;

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String subject, String subjectLanguage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.subjectLanguage = subjectLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectLanguage() {
        return subjectLanguage;
    }

    public void setSubjectLanguage(String subjectLanguage) {
        this.subjectLanguage = subjectLanguage;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subject='" + subject + '\'' +
                ", subjectLanguage='" + subjectLanguage + '\'' +
                '}';
    }
}
