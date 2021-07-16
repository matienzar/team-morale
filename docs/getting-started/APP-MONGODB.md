# MongoDB installation
1) Install docker
2) Create MongoDB instance
```shell script
docker run --name=mongodb-local -d -p 27017:27017 mongo:latest
```

See: [Getting started on mongodb on docker](https://hub.docker.com/_/mongo)

## Configure connection on project

Go to file application.properties and edit it
```shell script
# configure the MongoDB client for a replica set of two nodes
quarkus.mongodb.connection-string = mongodb://localhots:27017
# mandatory if you don't specify the name of the database using @MongoEntity
quarkus.mongodb.database = focus
```
