package utils;

import com.github.javafaker.Faker;
import models.User;

public class UserFactory{
    public User getRandomUser(){
        Faker faker = new Faker();
        User user = new User.UserBuilder().build();
        return user;
    }
    public User getAlreadyRegisteredUser(){
        User user = new User.UserBuilder().build();
        return user;
    }
}
