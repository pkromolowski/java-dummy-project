# Test Company

Test Slogan!

---
##  Maven Build Script Documentation

**1. Overview:**

This Maven `pom.xml` file defines the build configuration for a Java project named "dummy-java-project". It specifies project metadata, dependencies, and plugins required for compiling, testing, and packaging the project. 

**2. Build Tool:** Maven

**3. Script/File Name:** pom.xml

**4. Detailed Documentation:**

   - **Project Information:**
     -  **Description:** Defines basic project information like group ID, artifact ID, version, and encoding.
     -  **Parameters:** 
         - `groupId`: Unique identifier for the project's group (org.example).
         - `artifactId`: Unique identifier for the project within its group (dummy-java-project).
         - `version`: Current version of the project (1.0-SNAPSHOT).
     -  **Important Logic:** None

   - **Properties:**
     -  **Description:** Sets various properties used throughout the build process, such as Java source and target versions, encoding, and dependency versions.
     -  **Parameters:** 
         - `maven.compiler.source`: Source code compatibility version (17).
         - `maven.compiler.target`: Target bytecode version (17).
         - `project.build.sourceEncoding`: Source code encoding (UTF-8).
         - `junit.jupiter.version`: Version of JUnit Jupiter used for testing (5.10.0).
     -  **Important Logic:** None

   - **Dependencies:**
     -  **Description:** Lists external libraries required by the project, categorized as "test" dependencies for testing purposes.
     -  **Parameters:** 
         - `groupId`: Group ID of the dependency.
         - `artifactId`: Artifact ID of the dependency.
         - `version`: Version of the dependency.
         - `scope`: Dependency scope (e.g., "test").
     -  **Important Logic:** The script includes dependencies for testing frameworks like JUnit Jupiter, AssertJ, Mockito, and Mockito-JUnit-Jupiter.

   - **Build Plugins:**
     -  **Description:** Defines plugins used during the build process. In this case, it uses the Maven Surefire Plugin for running tests.
     -  **Parameters:** 
         - `groupId`: Group ID of the plugin (org.apache.maven.plugins).
         - `artifactId`: Artifact ID of the plugin (maven-surefire-plugin).
         - `version`: Version of the plugin (3.0.0).
     -  **Important Logic:** The Surefire Plugin executes tests defined in the project and reports their results.

**5. Language Version:** Java 17 (based on `maven.compiler.source` and `maven.compiler.target`)

**6. Dependency Versions:**

   - Mockito: 5.6.0
   - AssertJ: 3.24.2
   - JUnit Jupiter Engine: 5.10.0
   - JUnit Jupiter API: 5.10.0
   - Mockito-JUnit-Jupiter: 5.6.0

**7. Pseudo Code:**

1. **Project Initialization:**
    - Read `pom.xml` file.
    - Extract project metadata (groupId, artifactId, version).
    - Define properties based on values in `properties` section.
2. **Dependency Resolution:**
    - Download dependencies specified in the `dependencies` section.
3. **Compilation:**
    - Use Java compiler with source and target versions defined by `maven.compiler.source` and `maven.compiler.target`.
    - Compile all Java source files.
4. **Testing:**
    - Configure JUnit Jupiter test runner using the `junit-jupiter-engine` and `junit-jupiter-api` dependencies.
    - Use Mockito for mocking dependencies in tests.
    - Execute all test classes defined in the project.
5. **Packaging:**
    - Create a distributable archive (e.g., JAR) containing compiled code, resources, and dependencies.

**8. Dependencies and Plugins Equivalents:**

   - **Maven Surefire Plugin:**
      - Gradle: `test` task with `Test` plugin
      - npm: Jest or Mocha frameworks for testing



