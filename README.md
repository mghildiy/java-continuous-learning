# Java
* https://graciano.dev/
# JVM internals
* https://serce.me/posts/01-02-2023-jvm-field-guide-memory
* https://shipilev.net/jvm/anatomy-quarks/
# Multithreading
* https://jenkov.com/tutorials/java-concurrency/index.html
* https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
# Spring boot, Spring cloud
* https://www.marcobehler.com/guides/spring-framework
* https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring?utm_campaign=ls&utm_content=ls_dependency&utm_medium=email&utm_source=email
* https://www.baeldung.com/spring-vs-spring-boot?utm_campaign=ls&utm_content=ls_springboot&utm_medium=email&utm_source=email
* https://www.marcobehler.com/guides/spring-security
# Spring cloud
# Data persistence
# Microservices patterns
# DSA
* https://www.youtube.com/watch?v=CBYHwZcbD-s
* https://www.youtube.com/watch?v=RBSGKlAvoiM
* https://www.youtube.com/@mycodeschool/videos
# Design patterns
# Devops
* kubernetes: https://www.youtube.com/watch?v=kTp5xUtcalw
# Database
* https://use-the-index-luke.com/sql/anatomy
* https://www.youtube.com/watch?v=FzlpwoeSrE0
* https://www.youtube.com/watch?v=HXV3zeQKqGY
* https://www.youtube.com/watch?v=xh4gy1lbL2k
* https://www.youtube.com/watch?v=-t-8-xoLyv4&list=PLf-39075ydszFgJWvnESuz_u_pemT9eie
# jooq
# Redis
# gRPC
* https://grpc.io/docs/what-is-grpc/introduction/
* https://www.toptal.com/grpc/grpc-vs-rest-api
* https://grpc.io/docs/languages/java/basics/
# GraphQL
* https://www.baeldung.com/spring-graphql
# MicroProfile
# Opentelemetry/observability

API design principles:
 * Use commonly used data format standards for communication, like JSON
 * Use nouns instead of verbs in endpoint paths. HTTP request method already has the verb.
   
   /articles/, not /getArticles/
 * Use logical nesting on endpoints....to get comments for an article better to have /articles/:articleId/comments
 * Handle errors gracefully and return standard error codes so that users can understand the issue when error happens
 * Allow filtering, sorting, and pagination for better performance
 * Maintain good security practices...TLS for encryption, OAuth for authorization etc, role based access,API keys
 * Cache data to improve performance
 * Versioning APIs..semantic versioning
 * Good documentation
