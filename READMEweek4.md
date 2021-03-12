# Continuity Project: Week Four

Over the coming weeks you will be building a full stack application that will take your skills to the next level! 
This week we will be using Java Spring JPA to interact with a MySQL database that will store information for our application.

### In order to get started:

Create a new database in the MySQL REPL named continuity. 

``CREATE DATABASE continuity;``

This is where you will be adding your tables for this project. If you are using your own repo, make sure to update your applications.properties to reflect this database.

You must handle the following endpoints for crewmembers:
- A GET request to the `/crewmember` endpoint that returns all crewmembers from the database
- A GET request to the `/crewmember/{crewmemberId}` endpoint which returns information from a specific crewmember from the database
- A POST request to the `/crewmember` endpoint which accepts JSON data in the request body and saves it in the database
- A DELETE request to the `/crewmember/{crewmemberId}` endpoint which removes information about a specific crewmember from the database


You must handle the following endpoints for spaceships:
- A GET request to the `/spaceship` endpoint that returns all spaceships from the database
- A GET request to the `/spaceship/{spaceshipId}` endpoint which returns information from a specific spaceship from the database
- A POST request to the `/spaceship` endpoint which accepts JSON data in the request body and saves it in the database
- A DELETE request to the `/spaceship/{spaceshipId}` endpoint which removes information about a specific spaceship from the database
- A GET request to the `/spaceship/current` which accesses the cookies to retrieve the current spaceship

The main objective is to:

```terminal
Practice creating CRUD(L) endpoints using Java Spring
and JPA and accessing information in a MySQL database.
```

## Getting Started


- Fork and Clone this repository:
    - In terminal: `git clone`
    - Create a new database in the MySQL REPL named continuity.
    - To run your server: `./gradlew bootRun`


## Requirements

This solo sprint is a method of review for the week's important concepts, you are encouraged to go beyond the initial MVP and add your own personal features and flair!

- We have not yet discussed writing tests for our database information, please test your endpoints using the methods described in learn. 

### Crewmembers:

- Create an Entity and Interface for your Crewmember
  - It should include at least an id, name, and morale field
  - Feel free to add additional fields if you would like, but note that the examples will not include them in JSON
- Create a GET request to the `/crewmember` which returns JSON:
    
    
For example:
```
GET /crewmember
```
Would return:
```json
[
  {
    "id": 1,
    "name": "Alice",
    "morale": 100
  },
  {
    "id": 2,
    "name": "Bob",
    "morale": 100
  }
]
```
A GET request to ```/crewmember``` with no crewmembers in the database would return
```json
[]
```


- A GET request to the `/crewmember/{crewmemberId}` endpoint with:
    - a path variable `crewmemberId`
      
For example:
```
GET /crewmember/23
```
Would respond with:
```json
{
  "id": 23,
  "name": "John",
  "morale": 100
}
```
A get request to an id that does not exist in the database would return null
```
GET /crewmember/155
```
Would respond: ```null```


- A POST request to the `/crewmember` endpoint that:
    - accepts JSON data in the body of the request
    - responds with the row that has been created in the database
    

For example:
```
POST /crewmember
```
```json
{
  "name": "Alice",
  "morale": 100 
}
```
Would respond:
```json
{
  "id": 1,
  "name": "Alice",
  "morale": 100
}
```
- A DELETE request to the `/crewmember/{crewmemberId}` endpoint with:
  - a path variable `crewmemberId`
  - a response stating which id was deleted

For example:
```
DELETE /crewmember/23
```
Would respond with:
```
"The crewmember with an id of 23 has been deleted from the database"
```

### Spaceships:

- Create an Entity and Interface for your Spaceship
  - It should include at least an id, name, and fuel field
  - Feel free to add additional fields if you would like, but note that the examples will not include them in JSON 
- Create a GET request to the `/spaceship` which returns JSON:


For example:
```
GET /spaceship
```
Would return:
```json
[
  {
    "id": 1,
    "name": "Apollo 11",
    "fuel": 100
  },
  {
    "id": 2,
    "name": "Hyperion",
    "fuel": 100
  }
]
```
A GET request to ```/spaceship``` with no spaceships in the database would return
```json
[]
```


- A GET request to the `/spaceship/{spaceshipId}` endpoint with:
  - a path variable `spaceshipId`

For example:
```
GET /spaceship/1
```
Would respond with:
```json
{
  "id": 1,
  "name": "Apollo 11",
  "fuel": 100
}
```
A get request to an id that does not exist in the database would return null
```
GET /spaceship/155
```
Would respond: ```null```


- A POST request to the `/spaceship` endpoint that:
  - accepts JSON data in the body of the request
  - responds with the row that has been created in the database


For example:
```
POST /spaceship
```
```json
{
  "name": "Apollo 11",
  "fuel": 100
}
```
Would respond:
```json
{
  "id": 1,
  "name": "Apollo 11",
  "fuel": 100
}
```

- A DELETE request to the `/spaceship/{spaceshipId}` endpoint with:
  - a path variable `spaceshipId`
  - a response stating which id was deleted

For example:
```
DELETE /spaceship/3
```
Would respond with:
```
"The spaceship with an id of 3 has been deleted from the database"
```

-  A GET request to the `/spaceship/current` that:
    - accesses the cookies to retrieve the current spaceship under the `current` key
```
GET /spaceship/current
Cookie: current=12
```
Would respond: `Your current spaceship has the id of 12`

```
GET /spaceship/current
Cookie: <empty>
```
Would respond: `You do not have a current spaceship`    




- Take it to the next level. Your journey into outerspace is just beginning!

    - You could create additional endpoints to handle new functionality.
    - Add a POST request to `/spaceship/current` which sets your current spaceship using cookies
    - Add sorting functionality to your GET requests, experiment with the request paramaters from week three!
    - Add a way to update your rows using PUT/PATCH
    - Add additional functionality, behavior, or methods to existing endpoints



## Resources

You may use online resources including the learn content from this week to assist you in creating your classes.
