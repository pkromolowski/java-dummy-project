![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
**1. Overview**  
The supplied `pom.xml` is a Maven Project Object Model (POM) for a simple Java project named **dummy‑java‑project**. It defines:

* Project coordinates (`groupId`, `artifactId`, `version`).  
* Build properties (Java 17 source/target, UTF‑8 encoding, JUnit 5 version).  
* Test‑only dependencies: JUnit 5, Mockito, AssertJ.  
* The Maven Surefire plugin (v3.0.0) to execute the unit tests during the *test* phase.

When Maven runs a build (`mvn clean verify` or similar), it will:

1. Resolve the defined properties.  
2. Download the test dependencies from Maven Central.  
3. Compile the main source set with Java 17.  
4. Compile the test source set with the same Java version.  
5. Execute the tests via Surefire.  
6. Fail the build if any test fails or if compilation errors occur.

---

**2. Build Tool**  
*Apache Maven* (standard `pom.xml` format, schema version 4.0.0).

---

**3. Script/File Name**  
`pom.xml`

---

**4. Detailed Documentation**

| Section / Task | Description | Parameters / Elements | Important Logic / Notes |
|----------------|-------------|-----------------------|------------------------|
| **4.1 Project Coordinates** | Identifies the artifact in a Maven repository. | `<groupId>org.example</groupId>`<br>`<artifactId>dummy-java-project</artifactId>`<br>`<version>1.0‑SNAPSHOT</version>` | `-SNAPSHOT` marks the version as mutable; each `mvn install` will overwrite the same snapshot in the local repo. |
| **4.2 Properties** | Centralised values that can be referenced elsewhere in the POM. | `<maven.compiler.source>17</maven.compiler.source>`<br>`<maven.compiler.target>17</maven.compiler.target>`<br>`<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>`<br>`<junit.jupiter.version>5.10.0</junit.jupiter.version>` | The `maven-compiler-plugin` (implicitly added by Maven) reads `maven.compiler.source`/`target` to set the Java language level. The JUnit version is stored in a property to avoid duplication. |
| **4.3 Dependencies** | External libraries required for compilation or testing. All listed have `<scope>test</scope>`, meaning they are **not** packaged with the final artifact. | • **Mockito Core** – `org.mockito:mockito-core:5.6.0`<br>• **AssertJ Core** – `org.assertj:assertj-core:3.24.2`<br>• **JUnit Jupiter Engine** – `org.junit.jupiter:junit-jupiter-engine:${junit.jupiter.version}`<br>• **JUnit Jupiter API** – `org.junit.jupiter:junit-jupiter-api:${junit.jupiter.version}`<br>• **Mockito JUnit Jupiter** – `org.mockito:mockito-junit-jupiter:5.6.0` | Maven resolves each dependency from the configured repositories (default = Maven Central). Because the scope is *test*, they are only placed on the test classpath. If any artifact cannot be resolved, the build aborts with a *dependency resolution* error. |
| **4.4 Build → Plugins** | Plugins extend Maven’s lifecycle. Only the Surefire plugin is explicitly declared. | `<plugin>`<br>`<groupId>org.apache.maven.plugins</groupId>`<br>`<artifactId>maven-surefire-plugin</artifactId>`<br>`<version>3.0.0</version>`<br>`</plugin>` | The Surefire plugin runs unit tests during the **test** phase. No additional configuration means defaults are used (e.g., includes `**/*Test.java`, `**/*Tests.java`, `**/*TestCase.java`). If any test throws an exception or fails an assertion, Surefire returns a non‑zero exit code, causing Maven to mark the build as **FAILED**. |
| **4.5 Implicit Plugins** | Maven adds a default `maven-compiler-plugin` (version defined by the Maven core) that reads the `maven.compiler.*` properties. | No explicit XML entry – Maven’s default lifecycle binds the compiler plugin to the **compile** and **test‑compile** phases. | The compiler will use the JDK that Maven is launched with. If the JDK version is lower than 17, compilation fails with “source release 17 requires JDK 17”. |
| **4.6 Encoding** | The property `project.build.sourceEncoding` influences the compiler’s source file encoding and the resources plugin. | `<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>` | Guarantees that source files are read as UTF‑8, preventing “illegal character” errors on non‑ASCII source. |

---

**5. Language Version**  
*Java 17* (both source and target compatibility are set to 17 via the `maven.compiler.*` properties).

---

**6. Dependency Versions**

| Dependency | Version | Scope |
|------------|---------|-------|
| org.mockito:mockito-core | **5.6.0** | test |
| org.assertj:assertj-core | **3.24.2** | test |
| org.junit.jupiter:junit-jupiter-engine | **5.10.0** (via `${junit.jupiter.version}`) | test |
| org.junit.jupiter:junit-jupiter-api | **5.10.0** (via `${junit.jupiter.version}`) | test |
| org.mockito:mockito-junit-jupiter | **5.6.0** | test |
| Maven Surefire Plugin | **3.0.0** | build (plugin) |

---

**7. Pseudo Code (Step‑by‑Step Build Flow)**  

```
START Maven Build (e.g., mvn clean verify)

1. READ pom.xml
   a. Parse XML, validate against Maven 4.0.0 XSD.
   b. Extract <modelVersion>, <groupId>, <artifactId>, <version>.
   c. Load <properties> into a map:
        properties["maven.compiler.source"] = "17"
        properties["maven.compiler.target"] = "17"
        properties["project.build.sourceEncoding"] = "UTF-8"
        properties["junit.jupiter.version"] = "5.10.0"

2. RESOLVE DEPENDENCIES
   FOR each <dependency> element DO
        IF scope == "test" THEN
            add to TEST classpath
        ELSE
            add to COMPILE classpath
        ENDIF
        Resolve version:
            IF version contains ${...} THEN
                substitute from properties map
            ENDIF
        Attempt to download artifact (jar + pom) from repositories.
        IF download fails THEN
            ABORT build with "DependencyResolutionException"
        ENDIF
   ENDFOR

3. SETUP BUILD PLUGINS
   a. Implicitly add maven-compiler-plugin (default version).
   b. Configure compiler plugin:
        source = properties["maven.compiler.source"]   // "17"
        target = properties["maven.compiler.target"]   // "17"
        encoding = properties["project.build.sourceEncoding"] // "UTF-8"
   c. Add explicit maven-surefire-plugin version 3.0.0.

4. EXECUTE LIFECYCLE PHASES (default for "verify")
   Phase: **validate**
        - No custom actions.
   Phase: **initialize**
        - No custom actions.
   Phase: **generate-sources** … **process-resources**
        - No custom actions.
   Phase: **compile**
        - Invoke maven-compiler-plugin:
            * Compile src/main/java with Java 17, UTF‑8.
            * If compilation error → ABORT with "CompilationFailureException".
   Phase: **process-test-resources**
        - Copy test resources (if any).
   Phase: **test-compile**
        - Compile src/test/java with same Java version.
        - Include test‑scope dependencies on classpath.
        - If compilation error → ABORT.
   Phase: **test**
        - Invoke maven-surefire-plugin:
            * Discover test classes matching default includes.
            * Launch a new JVM (or forked process) with test classpath.
            * Run each test; collect results.
            * If any test fails or throws uncaught exception → set exit code != 0.
        - If Surefire exit code != 0 → MARK BUILD as FAILED.
   Phase: **package**
        - Create JAR (default packaging = jar) containing compiled main classes.
        - Test‑scope dependencies are NOT bundled.
   Phase: **verify**
        - No extra actions; success if previous phases succeeded.
   Phase: **install** (if user invoked)
        - Copy built artifact to local Maven repository.
   Phase: **deploy** (if user invoked)
        - Upload artifact to remote repository.

5. FINALIZE
   IF any phase reported failure THEN
        Print error summary, exit with non‑zero status.
   ELSE
        Print "BUILD SUCCESS" and exit with status 0.
   ENDIF

END Maven Build
```

*Edge‑Case Handling Highlighted in Pseudocode*  

* **Missing Dependency** – aborts during *Resolve Dependencies* with a clear error.  
* **Incompatible JDK** – compiler plugin throws a compilation failure if the running JDK < 17.  
* **Test Failures** – Surefire returns a non‑zero code; Maven marks the whole build as FAILED.  
* **Invalid XML / Schema Mismatch** – Maven stops before any lifecycle execution.  

---

**8. Dependencies and Plugins – Equivalent Recommendations**

| Maven Artifact | Purpose | Equivalent in Gradle (Groovy DSL) | Equivalent in Gradle (Kotlin DSL) | Equivalent in npm (if applicable) |
|----------------|---------|-----------------------------------|-----------------------------------|------------------------------------|
| `org.apache.maven.plugins:maven-surefire-plugin:3.0.0` | Executes JUnit/TestNG unit tests. | `testImplementation` + built‑in `test` task (uses JUnit Platform). No extra plugin needed. | Same as Groovy DSL. | `jest` or `mocha` (JS test runners). |
| `org.mockito:mockito-core` / `mockito-junit-jupiter` | Mocking framework for unit tests. | Same coordinates (`testImplementation "org.mockito:mockito-core:5.6.0"`). | `testImplementation("org.mockito:mockito-core:5.6.0")` | `sinon` (JS mocking). |
| `org.assertj:assertj-core` | Fluent assertions library. | `testImplementation "org.assertj:assertj-core:3.24.2"` | `testImplementation("org.assertj:assertj-core:3.24.2")` | `chai` (JS assertions). |
| `org.junit.jupiter:*` | JUnit 5 testing framework. | `testImplementation "org.junit.jupiter:junit-jupiter:5.10.0"` + `test { useJUnitPlatform() }` | Same. | `jest` (includes assertions) or `jasmine`. |
| Implicit `maven-compiler-plugin` (source/target 17) | Compiles Java source. | `java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }` | Same. | Not applicable (JS). |
| `project.build.sourceEncoding` | Sets source file encoding. | `tasks.withType<JavaCompile> { options.encoding = "UTF-8" }` | Same. | Not applicable. |

*If you need a Maven‑like build in another ecosystem (e.g., SBT for Scala, Ant, Bazel), the equivalents are:*

* **Ant** – Use `<javac srcdir="src/main/java" target="17" source="17" encoding="UTF-8"/>` and `<junit>` task.  
* **Bazel** – `java_library` rule with `source_version = "17"` and `java_test` rule that depends on JUnit, Mockito, AssertJ.  

--- 

**End of Documentation**