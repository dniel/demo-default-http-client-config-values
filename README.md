# Openapi JVM17 toolchain not generating openapi spec in correct location

# how to reproduce
2. build openapi, the file will be generated in its default build location and not as specified in application.yaml
   ```
   micronaut:
     openapi:
       target:
         file: ./generated-docs/demo-doc.yml
   ```
2. output from build
```
➜  demo-openapi-jvm17-toolchain-not-working git:(main) ✗ ./gradlew clean build logJavaVersion

> Task :logJavaVersion
Gradle is running on Java version: 23
Java vendor: Oracle Corporation
Java home: /Users/daniel/Library/Java/JavaVirtualMachines/openjdk-23.0.2/Contents/Home

> Task :kaptKotlin
Note: Generating OpenAPI Documentation
Note: Writing OpenAPI file to destination: /Users/daniel/Downloads/demo-openapi-jvm17-toolchain-not-working/build/tmp/kapt3/classes/main/META-INF/swagger/demo-0.0.yml

[Incubating] Problems report is available at: file:///Users/daniel/Downloads/demo-openapi-jvm17-toolchain-not-working/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.14.2/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 2s
16 actionable tasks: 16 executed
➜  demo-openapi-jvm17-toolchain-not-working git:(main) ✗ 
```
