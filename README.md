# Openapi JVM17 toolchain not generating openapi spec in correct location

# how to reproduce
1. Set java version to 17 for javaToolChain in gradle build
   See https://github.com/dniel/demo-openapi-jvm17-toolchain-not-working/blob/main/build.gradle.kts#L27-L31
2. build openapi, the file will be generated in its default build location and not as specified in application.yaml
   ```
    openapi:
        target:
            file: ./generated-docs/demo-doc.yml
   ```
3. update java to 19+ and the 
