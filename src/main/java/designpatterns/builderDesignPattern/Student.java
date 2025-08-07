package designpatterns.builderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int rollNo;
    private String name;
    private String contactNumber;
    private String address;
    private List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.rollNo = studentBuilder.rollNo;
        this.name = studentBuilder.name;
        this.contactNumber = studentBuilder.contactNumber;
        this.address = studentBuilder.address;
        this.subjects = studentBuilder.subjects;
    }

    @Override
    public String toString() {
        return "Student [Roll no=" + rollNo + ", name=" + name + ", contact number=" + contactNumber +
                ", address=" + address + ", subjects=" + subjects.toString() + "]";
    }

    public static class StudentBuilder {

        private int rollNo;
        private String name;
        private String contactNumber;
        private String address;
        private List<String> subjects;

        public StudentBuilder(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
            this.subjects = new ArrayList<>();
        }

        public StudentBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder addSubjects(String subject) {
            subjects.add(subject);
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}
