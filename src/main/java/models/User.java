package models;

public class User {

    private final String socialTitle;
    private final String firstName;
    private final String lastName;
    private final String email;
    private String password;
    private final String birthDate;
    private Boolean receiveOffers;
    private final Boolean customerData;
    private Boolean newsletter;
    private final Boolean userAgreement;

    public String getSocialTitle() {
        return socialTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Boolean getReceiveOffers() {
        return receiveOffers;
    }

    public Boolean getCustomerData() {
        return customerData;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public Boolean getUserAgreement() {
        return userAgreement;
    }

    private User(UserBuilder userBuilder) {
        this.socialTitle = userBuilder.socialTitle;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.birthDate = userBuilder.birthDate;
        this.receiveOffers = userBuilder.receiveOffers;
        this.customerData = userBuilder.customerData;
        this.newsletter = userBuilder.newsletter;
        this.userAgreement = userBuilder.userAgreement;
    }

    public static class UserBuilder {
        private String socialTitle;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthDate;
        private Boolean receiveOffers;
        private Boolean customerData;
        private Boolean newsletter;
        private Boolean userAgreement;

        public UserBuilder() {

        }

        public UserBuilder withSocialTitle(String socialTitle) {
            this.socialTitle = socialTitle;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder withReceiveOffers(Boolean receiveOffers) {
            this.receiveOffers = receiveOffers;
            return this;
        }

        public UserBuilder withCustomerData(Boolean customerData) {
            this.customerData = customerData;
            return this;
        }

        public UserBuilder withNewsletter(Boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public UserBuilder withUserAgreement(Boolean userAgreement) {
            this.userAgreement = userAgreement;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}