# Tennis API

This project contains the source code for the Tennis API application.

## Getting Started

These instructions will help you build and run the Tennis API application using Docker.

### Prerequisites

Make sure you have Docker installed on your machine.

### Pull the image from dockerHub

To pull the image directly from the docker Hub run the following command:
 ```bash
  docker pull ksait/tennis-api
```

### Building and run the Docker Image

To build the Docker image, follow these steps:

1. Clone this repository to your local machine.

2. Open a terminal or command prompt and navigate to the project directory.

3. Build the Docker image using the following command:

   ```bash
   docker build -t tennis-api:latest .
    ```
4. Once the Docker image is built, you can run the container using the following command::

   ```bash
   docker run -p 8080:8080 tennis-api
    ```
## API documentation

The Swagger UI page will be available at : http://server:port/context-path/swagger-ui.html

the OpenAPI description will be available at the following url for json format: http://server:
port/context-path/v3/api-docs

