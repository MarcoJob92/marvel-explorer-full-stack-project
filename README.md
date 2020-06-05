# Marvel explorer full-stack Project
A full-stack Java Application that interfaces with Marvel APIs and shows characters and related info on the UI.

## Technologies
The used technologies for this project are **Javascript / React** for the Front-end and **Java / Spring boot** for the Back-end.

## Getting Started
To get the Front-end App running locally:

- Clone the repo
- from terminal, `npm install` on the project directory to install all required dependencies
- `npm start` to start the local server 

To get the Back-end App running locally:
- Clone the Java Spring/Maven project
- You can import the project on Eclipse:
   - File -> Import -> Existing Maven Project
   - Right Click on the directory and Run as Maven install
   - Then Run Application.java as Java Application

## The Application
This is an application that interacts with external APIs (Marvel API), gets data from it and sends it to the client 
to show a dynamic list of characters and a dedicated page for each of these characters.  
A search bar, shown at the top of the page, can be used to search characters by name.

## The Technical Point of View
The Java Server comunicates with the Marvel APIs, so in theory there would be no need to have a back-end, 
beacuse the front-end could comunicate directly with these APIs.  
However the purpose of this project is to build a back-end that reproduces Serve-to-Server comunication, 
creates an Object-oriented Model and sends data to the Front-end to update the UI.  
**Jax-RS** was used to forward a Request from the Java code to the external APIs.  
**Spring MVC** was used to expose the services from the back-end to the fron-end of the same application.

## Integration Tests
The application has Integration tests to check that all the components involved in a REST request work properly.  
**JUnit** was used to write the test cases.

