# Running the application in dev mode: API
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

# API to load database with records to play
## Clear all records
```
DELETE
/team/v1/rest
```
## Load some records
```
POST
/team/v1/init
```