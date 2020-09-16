#Grace Note

##About
Grace Note is a social network aware application that allows a user to note and/or share what they are grateful for.

This project is designed as a REST application that connects to an RDBMS repository.

##Motivation
There are three thoughts that motivated me to do this project.

One is to help everyone write grateful thoughts.

Two is to create a social network filled with positivity.

Lastly is to practice the tools I'm learning JPA, Spring Boot, Design patterns, etc.

- **TODO***: discuss these three further*

##Setup
I made this application in Eclipse 2020-06 (4.16.0), with full support for Java EE. Initial Spring classes and Maven config files are generated via Spring Initializr.

To set this up in Eclipse, all you need to do is simply:

- Import the project via Git.
- Run an `mvnw install` (or `mvn` if you prefer your own maven instance installed on your machine) and update the project.

While this is created using Eclipse, it's not required build this project. I only went with this IDE since Eclipse is already installed on my machine.

You may even use notepad and manually create the jar if you wish. Please look up for the equivalent steps for your preferred method/IDE.

##Usage 
Simply run the project with Spring Boot, and it automatically creates all you need such as the web server already configured with a port together with the project deployed on it. You can do this at the console with the command:

`mvnw spring-boot:run`

Or simply run the Main class `io.github.jmgloria07.gracenote.GracenoteApplication` as a Java Application (through Eclipse) once the setup is done.

With this you can then run your server instance (usually localhost:8080) on your web browser and, write your graces.

##REST Methods
Note: Only the following GET methods are currently available with mocked data.
- GET {user}/grace/ retrieves all graces associated with the user.
- GET {user}/grace/{grace-id} retrieves a single grace associated with the user and the ID.
- POST {user}/grace/ post a grace.
- POST {user}/grace/{grace-id} update/edit a posted grace.
- DELETE {user}/grace/{grace-id} delete a grace.

##Future Plans
- Create an actual database and remove the mocks.
- Create the POST method calls.
- Add validations.
- Improve exception response.
- Add security and authentication.
- Create a UserController /{user} with corresponding REST methods.
- Create a Feed
- Create logging implementation.
- Improve Swagger documentation.
- Add share to other social networks (use Toktive? or perhaps let the client application do this with their corresponding provided share buttons).
- Create a view/user interface. Looking into starting another project for this using Angular.
- Change DB supplier from H2.