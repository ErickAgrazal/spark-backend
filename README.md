# Spark Simple app

Simple project that works as a bootstrap for a spark backend.

## Build

1. Build the first time the container locally: `docker build --tag <name>:<version> .`
   - Example: `docker build --tag erickagrazal/spark:simple .`

## Run

After building the first time, we can use the container to compile and execute the `jar` file.

1. Compile using docker: `docker run -v $(pwd):/code <name>:<version> mvn package`
   - Example: `docker run -v $(pwd):/code erickagrazal/spark:simple mvn package`
2. Run using docker: `docker run -p 4567:4567 -v \$(pwd):/code <name>:<version> java -jar target/ApplicationMain-1.0.jar`
   - Example: `docker run -p 4567:4567 -v \$(pwd):/code erickagrazal/spark:simple java -jar target/ApplicationMain-1.0.jar`
