# Continuity Project: Week Three

Over the coming weeks you will be building a full stack application that will take your skills to the next level! 
This week we will be using Java Spring to create the server for our application.

You must handle the following endpoints :
- A GET request to the `/crewmember` endpoint with optional request parameters
- A GET request to the `/crewmember/{crewmemberId}` endpoint
- A POST request to the `/crewmember` endpoint which accepts form data in the request body
- A GET request to the `/spaceship/current` which accesses the cookies to retrieve the current spaceship

The main objective is to:

```terminal
Practice creating Java Spring request handlers and accessing information 
coming in HTTP requests and test their behavior.
```

## Getting Started


- Fork and Clone this repository:
    - In terminal: `git clone`
    - To run your server: `./gradlew bootRun`


## Requirements

This solo sprint is a method of review for the week's important concepts, you are encouraged to go beyond the initial MVP and add your own personal features and flair!

- Write tests to verify that your endpoints behave as you expect

    
- Create GET request to the `/crewmember` with:
    - an optional `sort` request parameter that defaults to false
    
For example:
```
GET /crewmember?sort=true
```
Would respond: `This is a list of the crewmembers sorted alphabetically`
```
GET /crewmember?sort=false
```
Would respond: `This is a list of the crewmembers unsorted`
```
GET /crewmember
```
Would respond: `This is a list of the crewmembers unsorted`


- A GET request to the `/crewmember/{crewmemberId}` endpoint with:
    - a path variable `crewmemberId`
      
For example:
```
GET /crewmember/23
```
Would respond: `This is the record for crewmember 23`
```
GET /crewmember/thecurrentcrewmemember
```
Would respond: `Please access a valid crewmember's id`


- A POST request to the `/crewmember` endpoint that:
    - accepts url-encoded form data in the request body
    - the body will have two fields `name` and `crewmember_id`
    

For example:
```
POST /crewmember

name=Alice&crewmember_id=4
```
Would respond: `Alice has been added to the list of crewmembers with an id of 4`
```
POST /crewmember

name=Bob&crewmember_id=22
```
Would respond: `Bob has been added to the list of crewmembers with an id of 22`


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
    - Add additional functionality, behavior, or methods to existing endpoints



## Resources

You may use online resources including the learn content from this week to assist you in creating your classes.
