# General information
Application for managing of your timesheets.

Modules:
 - `docker` - [Docker configs](./docker/README.md)
 - `timesheets-server` - [Server part of application](./timesheets-server/README.md)

# Before start

### Environment
**Run as standalone modules**
 - Java 1.8

**Run app in docker**
 - Java 1.8
 - Docker
 - Docker-compose

### Application structure
    .
    ├── data                    # Folder for mongodb
    ├── docker                  #
    ├── gradle                  #
    ├── timesheets-server       #
    ├── build.gradle            #
    ├── settings.gradle         #
    ├── gradlew                 #
    ├── gradlew.bat             #
    └── ...

# Starting application

**Run app in docker**
 - On linux : `./gradlew startWeb` 
