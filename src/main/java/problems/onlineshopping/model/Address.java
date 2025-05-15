package problems.onlineshopping.model;

public class Address {
    
    private String addressLine1;
    private String addressLine2;
    private int pincode;

    public Address(String addressLine1, String addressLine2, int pincode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.pincode = pincode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public int getPincode() {
        return pincode;
    }
}
