package com.example.webhook;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements ApplicationRunner {

    private final WebhookService webhookService;

    public StartupRunner(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=== App Started. Running Webhook Flow... ===");
        webhookService.execute();
    }

}