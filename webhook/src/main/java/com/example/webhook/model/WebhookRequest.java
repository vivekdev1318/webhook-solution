& "C:\Program Files\Android\Android Studio\jbr\bin\java.exe" -jar "C:\webhook\webhook\target\webhook-0.0.1-SNAPSHOT.jar"package com.example.webhook.model;

public class WebhookRequest {
    private String name;
    private String regNo;
    private String email;

    public WebhookRequest() {
    }

    public WebhookRequest(String name, String regNo, String email) {
        this.name = name;
        this.regNo = regNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
