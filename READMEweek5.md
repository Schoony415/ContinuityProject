# Continuity Project: Week Five

Over the coming weeks you will be building a full stack application that will take your skills to the next level! 
This week we will continue using Java Spring JPA to interact with a MySQL database that will store information for our application. In addition, we will be adding tests to existing code.

### In order to get started:

This week you will be working on the same server as week four, and will be adding additional endpoints and tests.

You must handle the following endpoints for crewmembers:
- A PUT request to the `/crewmember/{crewmemberId}` endpoint which replaces a specific entry in your database
- A PATCH request to the `/crewmember/{crewmemberId}` endpoint which replaces values in your entry based on the JSON passed in the request body


You must handle the following endpoints for spaceships:
- A PUT request to the `/spaceship/{spaceshipId}` endpoint which replaces a specific entry in your database
- A PATCH request to the `/spaceship/{spaceshipId}` endpoint which replaces values in your entry based on the JSON passed in the request body

The main objective is to:

```terminal
Practice creating and testing CRUD(L) endpoints using Java Spring
and JPA and accessing information in a MySQL database.
```

## Requirements

This solo sprint is a method of review for the week's important concepts, you are encouraged to go beyond the initial MVP and add your own personal features and flair!

- Write tests to verify that your endpoints behave as you expect 

### Crewmembers:

- Create a PUT request to the `/crewmember/{crewmemberId}` endpoint:
    
    
For example:
```
PUT /crewmember/3
```
```json
{
  "name": "Charles",
  "morale": 50
}
```
Would update the crewmember with an id 3 and return:
```json
{
  "id": 3,
  "name": "Charles",
  "morale": 50
}
```



- Create a PATCH request to the `/crewmember/{crewmemberId}` endpoint:
    
    
For example:
Given an entry in your database that has the following information:
```json
{
  "id": 3,
  "name": "Christopher",
  "morale": 100
}

```

The request:
```
PATCH /crewmember/3
```
```json
{
  "name": "Charles"
}
```
Would update the crewmember with an id 3 with a new name and return:
```json
{
  "id": 3,
  "name": "Charles",
  "morale": 100
}
```
```
PATCH /crewmember/3
```
```json
{
  "morale": 75
}
```
Would update the crewmember with an id 3 with a new name and return:
```json
{
  "id": 3,
  "name": "Christopher",
  "morale": 75
}
```

### Spaceships:


- Create a PUT request to the `/spaceship/{spaceshipId}` endpoint:
    
    
For example:
```
PUT /spaceship/3
```
```json
{
  "name": "Apollo 11",
  "fuel": 75
}
```
Would update the spaceship with an id 3 and return:
```json
{
  "id": 3,
  "name": "Apollo 11",
  "fuel": 75
}
```



- Create a PATCH request to the `/spaceship/{spaceshipId}` endpoint:
    

Given an entry in your database that has the following information:
```json
{
  "id": 3,
  "name": "Voyager",
  "fuel": 100
}

```

The request:
```
PATCH /spaceship/3
```
```json
{
  "name": "Apollo 11"
}
```
Would update the spaceship with an id 3 with a new name and return:
```json
{
  "id": 3,
  "name": "Apollo 11",
  "fuel": 100
}
```
```
PATCH /spaceship/3
```
```json
{
  "fuel": 75
}
```
Would update the spaceship with an id 3 with a new name and return:
```json
{
  "id": 3,
  "name": "Voyager",
  "fuel": 75
}
```


### Go above and beyond

- Take it to the next level. Your journey into outerspace is just beginning!

    - You could create additional endpoints to handle new functionality.
    - Add sorting functionality to your GET requests, experiment with the request paramaters from week three!
    - Think about what information you might want to store / update in your database
    - Add additional functionality, behavior, or methods to existing endpoints


## Resources

You may use online resources including the learn content from this week to assist you in creating your classes.
