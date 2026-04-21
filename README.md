# webhook-solution

Spring Boot Webhook Application for HTTP callback integration.

## Quick Start

### Download and Run JAR

1. Download the latest JAR from [releases/](releases/) folder:
   ```bash
   wget https://raw.githubusercontent.com/vivekdev1318/webhook-solution/main/releases/webhook-0.0.1-SNAPSHOT.jar
   ```

2. Run the application:
   ```bash
   java -jar webhook-0.0.1-SNAPSHOT.jar
   ```

3. Application starts on **port 8080** with Tomcat webserver

### Requirements

- **Java 8 or higher**
- Check: `java -version`

## Project Structure

```
webhook/
├── releases/
│   ├── webhook-0.0.1-SNAPSHOT.jar  (Executable JAR)
│   └── README.md
├── webhook/
│   ├── src/main/java/
│   │   └── com/example/webhook/
│   │       ├── WebhookApplication.java
│   │       ├── WebhookService.java
│   │       ├── RestTemplateConfig.java
│   │       ├── StartupRunner.java
│   │       └── model/
│   │           ├── WebhookRequest.java
│   │           └── WebhookResponse.java
│   ├── pom.xml (Maven configuration)
│   └── mvnw (Maven Wrapper)
└── README.md (this file)
```

## JAR Availability

**Pre-built JAR:** [releases/webhook-0.0.1-SNAPSHOT.jar](releases/webhook-0.0.1-SNAPSHOT.jar)
- Size: ~17 MB
- Spring Boot Version: 2.7.14
- Compatible with: Java 8+

## Build from Source

```bash
cd webhook
./mvnw clean package
```

Output JAR: `webhook/target/webhook-0.0.1-SNAPSHOT.jar`

## License

This project is open source.