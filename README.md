[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/IB4W8LC6)
# Lab: Docker Multi-Stage Build

## Goal
Create an optimized Docker image for a Spring Boot application using multi-stage builds.

## Learning Objectives
- Understand Docker image layers
- Implement multi-stage builds
- Optimize image size
- Configure .dockerignore

## Pre-requisites
- Docker installed
- Sample Spring Boot application (provided)

## Tasks

### Task 1: Analyze the "Fat" Image
Build the provided application with the basic Dockerfile:

```bash
cd starter_code
docker build -f Dockerfile.basic -t myapp:fat .
docker images myapp:fat
```

**Record**: Image size = _______ MB

### Task 2: Create Multi-Stage Dockerfile
Create a new `Dockerfile` with two stages:

**Stage 1 (Build)**:
- Use `maven:3.9-eclipse-temurin-17` as base
- Copy `pom.xml` first (for dependency caching)
- Copy source code
- Run `mvn package`

**Stage 2 (Runtime)**:
- Use `eclipse-temurin:17-jre-alpine` as base
- Copy only the JAR from stage 1
- Set the entrypoint

### Task 3: Build and Compare
```bash
docker build -t myapp:slim .
docker images | grep myapp
```

**Record**:
- Fat image size: _______ MB
- Slim image size: _______ MB
- Size reduction: _______ %

### Task 4: Create .dockerignore
Create a `.dockerignore` file to exclude:
- `target/` directory
- `.git/` directory
- `*.md` files
- IDE files (`.idea/`, `.vscode/`)

### Task 5: Test the Image
```bash
docker run -d -p 8080:8080 --name myapp myapp:slim
curl http://localhost:8080/hello
docker logs myapp
```

## Deliverables
1. Completed multi-stage `Dockerfile`
2. `.dockerignore` file
3. Screenshot showing both image sizes
4. Answers to size comparison questions

## Starter Code
- `Dockerfile.basic` - Single-stage Dockerfile
- `pom.xml` - Maven configuration
- `src/` - Simple Spring Boot application
