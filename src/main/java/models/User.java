package models;

public class User {
    private String socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    private boolean receiveOffers;
    private boolean dataPrivacy;
    private boolean newsletter;
    private boolean userAgreement;

    private User(UserBuilder userBuilder){
        this.socialTitle = userBuilder.socialTitle;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.birthDate = userBuilder.birthDate;
        this.receiveOffers = userBuilder.receiveOffers;
        this.dataPrivacy = userBuilder.dataPrivacy;
        this.newsletter = userBuilder.newsletter;
        this.userAgreement = userBuilder.userAgreement;
    }

    public static class UserBuilder{
        private String socialTitle;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthDate;
        private boolean receiveOffers;
        private boolean dataPrivacy;
        private boolean newsletter;
        private boolean userAgreement;

        public UserBuilder(){

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

        public UserBuilder withReceiveOffers(boolean receiveOffers) {
            this.receiveOffers = receiveOffers;
            return this;
        }

        public UserBuilder withDataPrivacy(boolean dataPrivacy) {
            this.dataPrivacy = dataPrivacy;
            return this;
        }

        public UserBuilder withNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public UserBuilder withUserAgreement(boolean userAgreement) {
            this.userAgreement = userAgreement;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}