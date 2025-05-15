package problems.onlineshopping.model;

import java.util.ArrayList;
import java.util.List;

import common.utils.TextUtil;

public class User {

    private String id;
    private String name;
    private List<Address> addresses;
    private Address defaultAddress;

    public User(String name) {
        this.id = TextUtil.generateRandomText(5);
        this.name = name;
        this.addresses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAddress(Address addAddress) {
        addresses.add(addAddress);
    }

    public void setDefaultAddress(Address address) {
        this.defaultAddress = address;
    }

}
