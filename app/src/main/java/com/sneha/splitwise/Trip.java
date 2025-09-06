package com.sneha.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    List<Person> friends;

    Trip(List<Person> friends) {

    }

    void addFriendOnTrip(Person person){
        friends.add(person);
    }

    List<Person> getFriends(){
        return  friends;
    }



}
