Spring Boot REST APIs example
===

### Topic

- Authentication using a X-Auth-Token header for REST APIs
- Spring Session backend jdbc (MySQL)

### Usage

- see the database configuration `application-dev.properties`

- initialize database

```bash
$ mysql -uroot -e "CREATE DATABASE spring_rest;"

# initialize schemes
$ ./gradlew flywayClean flywayMigrate

# run an app
$ ./gradlew bootRun
```

### client sample

```bash
$ cat credential.json
{
  "user": "user",
  "password": "password"
}

# login
$ curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" localhost:8080/api/auth -d @credential.json
{"user": "user", "token": "1ad4df3a-778d-40dd-bfb1-0cc7fcf1dc77", "authenticated": true}

# invoke a REST API
$ cat example-input.json
{
  "id": 1,
  "name": "rkaneko"
}

$ curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -H "X-Auth-Token: 1ad4df3a-778d-40dd-bfb1-0cc7fcf1dc77" localhost:8080/api/example -d @example-input.json
{"name": "rkaneko"}

# logout
$ curl -X DELETE -H "X-Auth-Token: 1ad4df3a-778d-40dd-bfb1-0cc7fcf1dc77" localhost:8080/api/auth
```
