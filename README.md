# Camunda-C8 - Showcase - V8.6 

Base project for showcasing and testing Camunda 8.6 released Q3-2024
**This project uses the following versions:**
- A running instance of Camunda 8.6.5, we use [Camunda 8 Run](https://docs.camunda.io/docs/self-managed/setup/deploy/local/c8run/#install-and-start-camunda-8-run) 
- Java 17
- Spring Zeebe Library 8.6.5 

## URLS when working with Camunda 8 Run

Access each component at the following urls:

* Operate:                     http://localhost:8080/operate
* Tasklist:                    http://localhost:8080/tasklist
* Zeebe Cluster Endpoint:      http://localhost:26500
* Inbound Connectors Endpoint: http://localhost:8085

When using the Desktop Modeler, Authentication may be set to None.


## Spring Zeebe Library

* We use this SDK library of Camunda: https://docs.camunda.io/docs/apis-tools/spring-zeebe-sdk/getting-started/
  ````angular2html
    <dependency>
        <groupId>io.camunda</groupId>
        <artifactId>spring-boot-starter-camunda-sdk</artifactId>
        <version>8.6.x</version>
    </dependency>
  ````
* This library was released in Autumn 2024 and is maintained by Camunda, it is part of the main github repository https://github.com/camunda/camunda/tree/main/clients/spring-boot-starter-camunda-sdk
* An older version of the above-mentioned library was maintained by the community, and it was archived by the time version 8.5 was released; the old library repository is https://github.com/camunda-community-hub/spring-zeebe, the repo still contains valuable documentation, therefore it is mentioned here
* All the code examples using this library can be found in the module `zeebe-worker_spring-zeebe`

## Library for Testing

* By the time of this release there are 2 testing libraries for Camunda 8
  * The "old library" [Zeebe Process Test](https://docs.camunda.io/docs/apis-tools/java-client/zeebe-process-test/)
  * The "new library" [Camunda Process Test](https://docs.camunda.io/docs/apis-tools/testing/getting-started/) , the new version is in alpha version, it will replace the old version
  * Both libraries require JUnit 5, for other requirements check the provided links

  * For projects with Java version < 21 ***(This project uses this library)***:
    ````angular2html
    <dependency>
    <groupId>io.camunda</groupId>
    <artifactId>camunda-process-test-spring</artifactId>
    <version>X.Y.Z</version>
    <scope>test</scope>
    </dependency>
    ```` 
* Best pratices for testing: https://docs.camunda.io/docs/components/best-practices/development/testing-process-definitions/

## Library for Mastodon

* This project posts a message to Mastodon https://mastodon.social/@jit_public
  * The "old library" https://github.com/sys1yagi/mastodon4j
  * The "new library" https://docs.joinmastodon.org/client/libraries/#java


