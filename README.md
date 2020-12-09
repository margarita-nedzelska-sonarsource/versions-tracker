![Build status](https://github.com/margarita-nedzelska-sonarsource/LanguagesVersionsRadar/workflows/Check/badge.svg) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=margarita-nedzelska-sonarsource_LanguagesVersionsRadar&metric=alert_status)](https://sonarcloud.io/dashboard?id=margarita-nedzelska-sonarsource_LanguagesVersionsRadar) 


Use this project to monitor latest and supported versions of languages:
 - Java
 - Kotlin
 - Scala
 - Go
 - Ruby
 - Swift
 - Dotty (aka Scala 3)
 
 This service uses github api, which has limited number of requests per hour. To increase the limit it's better to authorize with github token by setting environment variable $GITHUB_TOKEN. The service can access github api anonymously as well but at rate of 60 requests/hour.
 
 To build project and run all tests just run <code>./gradlew build</code> command.
 
 To start the server use <code>./gradlew run</code> command. The service will be available at localhost:8080. Available commands:
 
 - To get latest versions in json format use
 
   <b>GET</b> <code>/latest</code>
   
   <i>Arguments</i>: <code>langs</code>
   
   <i>Example</i>: <code>localhost:8080/latest?langs=java,kotlin,ruby,go</code>
   

- To get view latest and supported versions in json format use
 
   <b>GET</b> <code>/versions</code>
   
   <i>Arguments</i>: <code>langs</code>
   
   <i>Example</i>: <code>localhost:8080/versions?langs=java,kotlin,ruby,go</code>
   

 - To get view latest and supported versions as html table use
 
   <b>GET</b> <code>/view/versions</code>
   
   <i>Arguments</i>: <code>langs</code>
   
   <i>Example</i>: <code>localhost:8080/view/versions?langs=java,kotlin,ruby,go</code>
   
 - To invalidate cache and force updates of latest versions use
 
   <b>GET</b> <code>/invalidate</code>
   
   <i>Example</i>: <code>localhost:8080/invalidate</code>
   
   

<b>To deploy function in Google cloud you first need to run command <code>./gradlew buildFunction</code> to copy fat jar into separate directory "deploy". And then run (for this command you must be authorized in google cloud console)</b>

```
 gcloud functions deploy releases-function \
    --entry-point com.example.versions.function.ReleasesFunction \
    --source=function/build/deploy --runtime java11 \
    --memory 512MB --trigger-http --allow-unauthenticated
```

To run function locally run this command:

```./gradlew runFunction -PrunFunction.target=com.example.versions.function.ReleasesFunction```
