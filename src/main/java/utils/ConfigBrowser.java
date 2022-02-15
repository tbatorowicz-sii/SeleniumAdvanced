package utils;

import enums.Browser;

public class ConfigBrowser {
    private Browser browser;
    private String mainURL;
    private String logInPageURL;

    public Browser getBrowser() {
        return browser;
    }

    public String getMainURL() {
        return mainURL;
    }

    public String getLogInPageURL() {
        return logInPageURL;
    }
}