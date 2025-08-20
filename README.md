# Virtual Threads vs. Reactive Streams Performance (vt-reactive-performance)
This project aims to provide a comparative performance analysis of two prominent concurrency models in modern Java:
* Virtual Threads and Reactive Streams (Spring WebFlux).

By implementing identical business logic using each model within a Spring Boot environment, this project measures and compares their throughput, latency, and resource consumption under various load scenarios. The goal is to explore the trade-offs of each approach and identify their optimal use cases based on empirical data.

## Project Goals
* Performance Comparison:
  * To quantitatively compare the performance of Virtual Threads and Reactive Streams for different workloads, such as I/O-bound tasks and real-time streaming.
* Resource Efficiency Analysis:
  * To analyze how each model utilizes system resources—including CPU, memory, and platform threads—under the same load conditions. 
* Code Complexity & Productivity:
  * To examine the differences in code complexity and developer productivity when implementing the same logic with these two distinct paradigms. 
* Data-Driven Insights:
  * To offer practical, data-driven insights on when to choose one concurrency model over the other based on the analysis.

## Tech Stack
* Java 21+
* Spring Boot 3.5.4+
* Gradle (Kotlin DSL)
* Virtual Threads for a blocking I/O model
* Spring WebFlux for a non-blocking, reactive model
* Testcontainers for isolated integration testing
* PostgreSQL for data persistence
* Apache Kafka for messaging
* k6 for load testing
* JUnit 5 for test orchestration

## Test Methodology
This project focuses on relative performance comparison, not absolute benchmarking. The primary goal is to determine how these two concurrency models perform relative to each other under identical, controlled conditions.

To achieve this, I use **Testcontainers** extensively. This approach ensures that every test run—whether on a local machine or in a CI pipeline—uses a pristine, consistent, and identical environment (including databases, message brokers, and mock servers). By eliminating environmental variables, this setup ensures that any observed performance differences are due to the architectural choice between Virtual Threads and Reactive Streams.

### Test Scenarios
Within this controlled environment, the following key scenarios are compared:

* Simple I/O-Bound Task:
  * A REST API endpoint that simulates a network call by waiting for a response. This measures how each model handles a high number of concurrent requests that are primarily waiting on I/O. 
* Real-time Streaming:
  * A Server-Sent Events (SSE) endpoint that streams data continuously to multiple connected clients. This measures the stability and resource efficiency of maintaining a large number of long-lived connections.
* Mixed Workload (I/O + CPU-Bound Task):
  * A scenario that mimics a common real-world workflow: fetching data from a database (I/O-bound) and then performing a non-trivial computation on it (CPU-bound). This test highlights how each model handles tasks that are not purely I/O-bound.

## Getting Started
### Prerequisites
* Java 21+
* Docker
* Gradle

### Running the Project and Tests
1. Clone the repository
2. Build the project
```bash
./gradlew build 
```
3. Run the performance tests
```bash
./gradlew test 
```

## Result Analysis
After the tests complete, the results can be analyzed from the following perspectives, based on `k6` output and server-side metrics:
* Throughput (RPS):
* Latency (P50, P95, P99):
* Resource Utilization (CPU, Memory):

_(This section will be populated with detailed analysis, including graphs and tables, once the benchmarks are complete.)_