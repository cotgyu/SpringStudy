package net.study.com.user.commons;

public class GoogleAuth {
    private String clientId;
    private String clientSecret;


    public GoogleAuth(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }


    public String getClientId() {
        return clientId;
    }


    public String getClientSecret() {
        return clientSecret;
    }

}
