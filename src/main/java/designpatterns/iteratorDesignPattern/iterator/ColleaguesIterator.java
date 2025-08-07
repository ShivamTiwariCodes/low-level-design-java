package designpatterns.iteratorDesignPattern.iterator;

import designpatterns.iteratorDesignPattern.Profile;
import designpatterns.iteratorDesignPattern.socialNetwork.SocialNetwork;

import java.util.List;

public class ColleaguesIterator implements Iterator{

    private SocialNetwork socialNetwork;
    private String profileId;
    private List<Profile> colleaguesList;
    private int currentPosition;


    public ColleaguesIterator(SocialNetwork socialNetwork, String profileId) {
        this.socialNetwork = socialNetwork;
        this.profileId = profileId;
        this.currentPosition = 0;
        this.colleaguesList = socialNetwork.getColleaguesFromApi(profileId);
    }

    @Override
    public boolean hasNext() {
        if(currentPosition < colleaguesList.size()) return true;
        return false;
    }

    @Override
    public Profile next() {
        if(hasNext()) {
            return colleaguesList.get(currentPosition++);
        }
        return null;
    }
}
