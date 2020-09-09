# job-portal-be

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


## Features

These services can perform,
  1. Job apply and view status for Candidate 
  2. View request status and update status for job request for recruiter
  

  
 ## Cloud config

Heroku has been used for this project to be run in cloud server.
Added one ProcFile in root directory for heroku to know how to build this project.

Heroku url for application : https://job-portal-kajal-be.herokuapp.com

Sample healthcheck api url : https://job-portal-kajal-be.herokuapp.com/healthcheck


 ## Folder structure 
 
1. Controllers --> Layer to accept request and resturn respose for Candidate, Recruiter apis.
2. Services --> Layer to Get and update json files for recruiter and candidates.
3. Domain --> Entity classes for project
