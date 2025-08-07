package designpatterns.iteratorDesignPattern.socialNetwork;

import designpatterns.iteratorDesignPattern.Profile;
import designpatterns.iteratorDesignPattern.iterator.Iterator;

import java.util.List;
import java.util.stream.Collectors;

public class Facebook implements SocialNetwork{

    List<Profile> profiles;

    public Facebook(List<Profile> profiles) {
        this.profiles = profiles;
    }



    @Override
    public List<Profile> getFriendsFromApi(String profileId) {
        return profiles.stream()
                .filter(profile -> profile.getFriends().contains(profileId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Profile> getColleaguesFromApi(String profileId) {
        return profiles.stream()
                .filter(profile -> profile.getColleague().contains(profileId))
                .collect(Collectors.toList());
    }
}
