package utils;

import com.github.javafaker.Faker;
import models.User;

import java.text.SimpleDateFormat;

public class UserFactory {
    public static User getRandomUser() {
        Faker faker = new Faker();
        User user = new User.UserBuilder()
                .withSocialTitle(faker.bool().bool() ? "Mr" : "Mrs")
                .withFirstName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password())
                .withBirthDate(new SimpleDateFormat("MM/dd/yyyy")
                        .format(faker.date().birthday(20, 40)))
                .withReceiveOffers(faker.bool().bool())
                .withCustomerData(true)
                .withNewsletter(faker.bool().bool())
                .withUserAgreement(true)
                .build();
        return user;
    }

    public static User getAlreadyRegisteredUser() {
        User user = new User.UserBuilder()
                .withSocialTitle("Mr")
                .withFirstName("Janusz")
                .withLastName("Tytanowy")
                .withEmail("tytanowyjanusz@zfskurcz.pl")
                .withPassword("statuetki")
                .withBirthDate("05/06/1977")
                .withReceiveOffers(true)
                .withCustomerData(true)
                .withNewsletter(true)
                .withUserAgreement(true)
                .build();
        return user;
    }
}