# Grace Note

## About
Grace Note is a social network aware application that allows a user to note and/or share what they are grateful for.

This project is designed as a REST application that connects to an RDBMS repository. You may also see its corresponding [Angular project](https://github.com/jmgloria07/gracenote-angular) that consumes the exposed REST methods.

## Motivation
There are three ideas that motivated me to do this project.

First is to help everyone express their gratitudes. Studies show that detailing one's emotions, especially gratitudes, through writing promotes one's mental well-being.<sup>1 2</sup> It's one way to cope with overwhelming stress.

Another is to create a social network feed filled with positivity. Gratefulness is equated to positivity and I believe it would be nice to scroll through a fully positive feed.

Lastly is I want to create a project that fully utilizes what I'm learning. I want to design an API that fits the image I'm looking at and utilize the tools I'm learning, such as: JPA, Spring Boot, Angular, Design Patterns, etc.

<sub><b>1</b>: [Expressive Writing for Mental Health](https://www.health.harvard.edu/newsletter_article/expressive-writing-for-mental-health). Retrieved September 17, 2020.</sub>

<sub><b>2</b>: [What Psychological Science Knows About Achieving Happiness](http://sonjalyubomirsky.com/files/2012/09/Nelson-Kurtz-Lyubomirsky-in-press.pdf). Retrieved September 17, 2020.</sub>


## Setup
I made this application in Eclipse 2020-06 (4.16.0), with full support for Java EE. Initial Spring classes and Maven config files are generated via Spring Initializr.

To set this up in Eclipse, all you need to do is simply:

- Import the project via Git.
- Run an `mvnw install` (or `mvn` if you prefer your maven instance installed on your machine) and update the project.

While this is created using Eclipse, it's not required to build this project. I only went with this IDE since Eclipse is already installed on my machine.

You may even use notepad and manually create the jar if you wish. Please look up for the equivalent steps for your preferred method/IDE.

## Usage 
Simply run the project with Spring Boot, and it automatically creates all you need, such as the web server already configured with a port together with the project deployed on it. You can do this at the console with the command:

`mvnw spring-boot:run`

Or simply run the Main class `io.github.jmgloria07.gracenote.GracenoteApplication` as a Java Application (through your IDE) once the setup is done.

With this, you can then run your server instance (usually localhost:8080) on your web browser and, write your graces.

## REST Methods
Basic REST methods. Please see /swagger-ui/index.html for other methods and details how they're used.
- GET /users/{user}/graces/ retrieves all graces associated with the user.
- GET /users/{user}/graces/{grace} retrieves a single grace associated with the user and the ID.
- POST /users/{user}/graces/ post a grace.
- GET /openings/ get a list of openings
- GET /openings/{opening} get a single opening
- (to follow) GET /users/{user}/
- (to follow) DELETE /users/{user}/grace/{grace-id} delete a grace.
- (to follow) PUT /users/{user}/graces/{grace-id} update/edit a posted grace.

## Future Plans
- Improve exception response.
- Add hypermedia data.
- Add security and authentication.
- Create a UserController /{user} with corresponding REST methods.
- Create logging implementation.
- Improve Swagger documentation.
- Add share to other social networks (use [Toktive](https://github.com/jmgloria07/toktive)? or perhaps let the client application do this with their corresponding provided share buttons).
- ~~Create a view/user interface. Looking into starting another project for this using Angular.~~ See https://github.com/jmgloria07/gracenote-angular.
- Change DB supplier from H2. Using H2/in memory database for now as I don't have a server to run this yet.
- Create some sort of implementation of Like.
