# track-hub

Spring Boot REST API for Track-hub (frontend: track-hub-front).

## Configuration

Settings come from environment variables; nothing secret is stored in the repo.

| Variable | Purpose | Local default |
|---|---|---|
| `JDBC_DATABASE_URL` | Postgres JDBC URL (set automatically by Heroku Postgres) | `jdbc:postgresql://localhost:5432/trackhub` |
| `JDBC_DATABASE_USERNAME` | Database user | `postgres` |
| `JDBC_DATABASE_PASSWORD` | Database password | `postgres` |
| `CORS_ALLOWED_ORIGINS` | Comma-separated origins allowed to call the API | Heroku frontend + `http://localhost:4200` |

`track-hub.sql` creates the schema and seed data.

## Run

```
./mvnw spring-boot:run   # serves the API on http://localhost:8080/api
./mvnw test              # uses an in-memory H2 database
```
