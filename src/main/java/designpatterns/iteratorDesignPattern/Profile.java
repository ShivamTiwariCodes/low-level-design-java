package designpatterns.iteratorDesignPattern;

import java.util.List;

public class Profile {

    private String profileId;
    private String name;
    private List<String> friends;
    private List<String> colleague;

    public Profile(String profileId, String name, List<String> friends, List<String> colleague) {
        this.profileId = profileId;
        this.name = name;
        this.friends = friends;
        this.colleague = colleague;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getName() {
        return name;
    }

    public List<String> getFriends() {
        return friends;
    }

    public List<String> getColleague() {
        return colleague;
    }
}
