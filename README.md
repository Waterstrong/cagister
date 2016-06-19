# POS Simulation in Java
Pair Kata & Dojo for POS simulation

### [收银机 - 单品批发价出售](docs/收银机-单品批发价出售.md)
### [收银机 - 打折](docs/收银机-打折.md)


# How to start

### Check All Tasks
`./gradlew tasks --all`

### Reload IntelliJ IDEA project
`./gradlew cleanIdea idea`

### Run clean and build tasks
`./gradlew clean build`, will auto create database

### Run unit test
`./gradlew test`, it depends on `build` task.

### Run integration test
`./gradlew integrationTest` or `./gradlew iT`, it depends on `build` task.

### Run build exclude integration test
`./gradlew build -x integrationTest` or `./gradlew build -x iT`

### Run checkstyle
`./gradlew check`

### Run code coverage check
`./gradlew checkTestCoverage`, it depends on `build` task.
To see the test coverage report: `open build/reports/jacoco/test/html/index.html`.

### Run findBugs


### Run sonar


### Start Application
`./gradlew bootRun`

### Remote Debug
1. Edit Configurations -> Add New Configuration -> Remote -> set name as `RemoteDebug`, port as `5005` -> Apply/OK
2. Launch `./gradlew run --debug-jvm`
3. Choose `RemoteDebug` -> Debug

### Run the JAR file
`java -jar build/libs/cagister-0.1.0.jar`


### Check service health


### Load Swagger UI
[http://localhost:8080/cagister/swagger-ui.html](http://localhost:8080/cagister/swagger-ui.html)


### Database & Flyway Migration

Already used the H2 embedded database, no need to follow below steps:

1. If Install MySQL in local, should create schema using script in `create_db.sql`


#### Commands tips:
- Run `./gradlew flywayRepair` to repair the Flyway metadata table
- `./gradlew clean` depends on task `flywayRepair`

- Run `./gradlew flywayMigrate` to migrate the schema to the latest version
- `./gradlew build` depends on task `flywayMigrate`

- Run `./gradlew bootRun` will auto check and load the new db.migration scripts

- **Warning: Only know what you are doing: ** Run `./gradlew flywayClean` to drops all objects in the configured schema

[More about using flyway](https://flywaydb.org/documentation/gradle/): `flywayInfo`, `flywayValidate`, `flywayBaseline`

### Build Dockerfile
No need to build image

#### Using Docker Compose (not adding yet)
Firstly, goto the docker directory:
`cd infrastructure`

Run Docker Compose:
`docker-compose up`

If want to run in background:
`docker-compose up -d`

Check the status:
`docker-compose ps`

Stop docker services:
`docker-compose stop`

View the logs (press CTRL+C to exit):
`docker-compose logs`

Kill the containers and remove them:
```
docker-compose kill
docker-compose rm -f
```

More options:
`docker-compose --help`

If on Mac and using default docker-machine, try to hit:
[http://192.168.99.100:8080/cagister/swagger-ui.html](http://192.168.99.100:8080/cagister/swagger-ui.html)
