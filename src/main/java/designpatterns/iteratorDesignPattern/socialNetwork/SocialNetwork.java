package designpatterns.iteratorDesignPattern.socialNetwork;

import designpatterns.iteratorDesignPattern.Profile;
import designpatterns.iteratorDesignPattern.iterator.Iterator;

import java.util.List;

public interface SocialNetwork {

    List<Profile> getFriendsFromApi(String profileId);
    List<Profile> getColleaguesFromApi(String profileId);
}
