package com.example.webhook;

import com.example.webhook.model.WebhookRequest;
import com.example.webhook.model.WebhookResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class WebhookService {
    
    private static final String SQL_QUERY = "SELECT e1.EMP_ID, e1.FIRST_NAME, e1.LAST_NAME, d.DEPARTMENT_NAME, COUNT(e2.EMP_ID) AS YOUNGER_EMPLOYEES_COUNT FROM EMPLOYEE e1 JOIN DEPARTMENT d ON e1.DEPARTMENT = d.DEPARTMENT_ID LEFT JOIN EMPLOYEE e2 ON e1.DEPARTMENT = e2.DEPARTMENT AND e2.DOB > e1.DOB GROUP BY e1.EMP_ID, e1.FIRST_NAME, e1.LAST_NAME, d.DEPARTMENT_NAME ORDER BY e1.EMP_ID DESC";
    
    private final RestTemplate restTemplate;

    public WebhookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void execute() {
        try {
            // Step 1: Send POST request to get webhook URL and access token
            String generateWebhookUrl = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
            
            WebhookRequest request = new WebhookRequest("John Doe", "REG12347", "john@example.com");
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            HttpEntity<WebhookRequest> requestEntity = new HttpEntity<>(request, headers);
            
            WebhookResponse response = restTemplate.postForObject(generateWebhookUrl, requestEntity, WebhookResponse.class);
            
            System.out.println("Step 1 - Webhook URL received: " + response.getWebhook());
            System.out.println("Step 1 - Access Token received: " + response.getAccessToken());
            
            // Step 2: Send POST request to webhook URL with SQL query
            String webhookUrl = response.getWebhook();
            String accessToken = response.getAccessToken();
            
            HttpHeaders webhookHeaders = new HttpHeaders();
            webhookHeaders.setContentType(MediaType.APPLICATION_JSON);
            webhookHeaders.set("Authorization", accessToken);
            
            WebhookQueryRequest queryRequest = new WebhookQueryRequest(SQL_QUERY);
            HttpEntity<WebhookQueryRequest> webhookRequestEntity = new HttpEntity<>(queryRequest, webhookHeaders);
            
            String finalResponse = restTemplate.postForObject(webhookUrl, webhookRequestEntity, String.class);
            
            System.out.println("Step 2 - Final Response: " + finalResponse);
            System.out.println("Flow execution completed successfully");
            
        } catch (Exception e) {
            System.err.println("Error during webhook flow: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class WebhookQueryRequest {
        private String finalQuery;

        public WebhookQueryRequest(String finalQuery) {
            this.finalQuery = finalQuery;
        }

        public String getFinalQuery() {
            return finalQuery;
        }

        public void setFinalQuery(String finalQuery) {
            this.finalQuery = finalQuery;
        }
    }
}
