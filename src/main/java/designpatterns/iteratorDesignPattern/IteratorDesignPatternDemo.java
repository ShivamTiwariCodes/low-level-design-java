package designpatterns.iteratorDesignPattern;

import designpatterns.iteratorDesignPattern.iterator.ColleaguesIterator;
import designpatterns.iteratorDesignPattern.iterator.FriendsIterator;
import designpatterns.iteratorDesignPattern.iterator.Iterator;
import designpatterns.iteratorDesignPattern.socialNetwork.Facebook;
import designpatterns.iteratorDesignPattern.socialNetwork.SocialNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IteratorDesignPatternDemo {

    public void run() {

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("1", "John Doe", Arrays.asList("2", "3"), Arrays.asList("4")));
        profiles.add(new Profile("2", "Jane Smith", Arrays.asList("1"), Arrays.asList("4")));
        profiles.add(new Profile("3", "Jim Brown", Arrays.asList("1"), Arrays.asList("4")));
        profiles.add(new Profile("4", "Jake White", Arrays.asList("1", "2", "3"), Arrays.asList()));

        SocialNetwork facebook = new Facebook(profiles);

        Iterator friendsIterator = new FriendsIterator(facebook, "1");
        System.out.println("Friends list : ");
        while(friendsIterator.hasNext()) {
            System.out.println(friendsIterator.next().getName());
        }

        System.out.println("Colleagues list : ");
        Iterator colleaguesIteratorIterator = new ColleaguesIterator(facebook, "1");
        while(colleaguesIteratorIterator.hasNext()) {
            System.out.println(colleaguesIteratorIterator.next().getName());
        }
    }

}
