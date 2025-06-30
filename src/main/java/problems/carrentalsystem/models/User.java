package problems.carrentalsystem.models;

public class User {

//    name, contact details, and driver's license information

    private String id;
    private String name;
    private String mobileNumber;
    private String drivingLicenseNumber;

    public User(String id, String name, String mobileNumber, String drivingLicenseNumber) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }
}
