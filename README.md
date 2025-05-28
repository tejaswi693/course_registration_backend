# Spring Boot Gradle Project Setup

## Requirements

* Java JDK 17 (recommended)
* Gradle (bundled or installed separately)
* IDE (IntelliJ IDEA, Eclipse, VS Code)

## Getting Started

### Clone the Repository

Clone this project to your local machine:

```bash
git clone <repository-url>
cd <project-directory>
```

### Build and Run

To build the project, open a terminal in the project root and execute:

```bash
./gradlew build
```

This will compile the code, run tests, and package the application.

To run the application locally, execute:

```bash
./gradlew bootRun
```

Your Spring Boot application should now be running at:

```
http://localhost:8080
```

### Run Tests

To execute all tests:

```bash
./gradlew test
```

## Configuration

Modify `application.properties` or `application.yml` located in:

```
src/main/resources/
```

Example `application.properties`:

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=password
```

## Using an IDE

### IntelliJ IDEA

* Open IntelliJ IDEA and select "Open."
* Navigate to the project folder and select it.
* Allow Gradle to import dependencies automatically.
* Run the main application class directly from the IDE.

### Eclipse

* Open Eclipse, then choose "Import" -> "Existing Gradle Project."
* Select the project root folder and follow prompts.

## Packaging

To create an executable JAR file:

```bash
./gradlew bootJar
```

The generated JAR file will be located in:

```
build/libs/
```

Run the packaged application using:

```bash
java -jar build/libs/<your-project-name>.jar
```

## Troubleshooting

If you encounter issues, ensure your Java and Gradle versions match project requirements. Use the following to verify your setup:

```bash
java -version
gradle -version
```

Clear caches and refresh the project if issues persist:

```bash
./gradlew clean build
```


