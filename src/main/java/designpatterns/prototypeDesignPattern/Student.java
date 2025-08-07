package designpatterns.prototypeDesignPattern;


public class Student implements Prototype {

    private int rollNo;
    private String name;
    private String contactNumber;
    private String address;

    public Student(int rollNo, String name, String contactNumber, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [Roll no=" + rollNo + ", name=" + name + ", contact number=" + contactNumber +
                ", address=" + address + "]";
    }

    @Override
    public Prototype clone() {
        return new Student(rollNo, name, contactNumber, address);
    }
}
