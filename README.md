# Course Notes Section 3
- Maven is a build tool
- Relies on Plugins that provide default and additional functionality
- Maven automatically detects the following folder structures:
  - src/main/java, src/main/java/resources, src/test/java, src/test/java/resources
  - src/main/webapp
- Goals are like tasks. Lifecycle is a collection of phases. compile, test, package etc. are phases.
- Maven defines a default super pom that all projects have
- Maven automatically handles all dependencies in your pom.xml, including transitive dependencies
- Maven requires little or no configuration - you may override default configuration
- 

## Running your java class through a JAR generate by Maven
### mvn package
- You can run your java file through the generated jar
- To generate a jar, run "mvn package" in your maven-quick-start dir
- Then, navigate to the generated target folder ( cd target )
- then run the command, `java -cp <jarname.jar> <packagename>.<javaclassname>`
- so in our case: `java -cp example-1.0.jar clinic.programming.training.Application`

## Cleaning up the build
### mvn clean
- is a phase part of the clean lifecycle from the jar lifecycle
- this will remove the target folder
- you need to cd out of the target folder first

## Multiple goals and phases in a lifecycle
### mvn clean package
- allows you to clean and recompile at once!

## Local Maven Repo
### mvn clean install
### mvn install
- copies the jar file out of the target into mavens local repo
- the repo is a local cache of builds and artifacts
- the repo is found under the .m2 folder (known as 'repository')
- repository contains other folders that contain dependencies we have executed for maven
- remember maven needs plugins to execute phases, plugins themselves have dependencies

# Course Notes Section 4: Maven Plugins
- They provide default functionality and behvaiours and add more features and funcationality
- They are also dependencies that are downloaded
- E.g. publish to server, compile, run unit test
- Maven contains defaults also, some other mentioned in the pom
- Think of maven as a "plugin runner"
- You can visit maven.apache.org plugins section

## Testing out the 'compiler' plugin with incompatible java
- Here we will test before adding the updates pom details for using the compiler
- The compiler should fail due to incomp version of java ( java -version ), 
- The default for the 'compiler' plugin is 1.8 ( as at the time we checked )
- So we added the following code
`
var list = List.of(1,2,3); // this was introduced from java 9+ onwards
- ### Run mvn clean install
- compiler would complain about the source for the compiler 1.8, which does not
know of this
`
- [ERROR] COMPILATION ERROR :
  [INFO] -------------------------------------------------------------
  [ERROR] /C:/Users/muham/OneDrive/Documents/Udemy Courses/mavenquickstart/maven-quick-start/src/main/java/clinic/programming/training/Application.java:[14,9] cannot find symbol
  symbol:   class var
  location: class clinic.programming.training.Application
  [INFO] 1 error
  [INFO] -------------------------------------------------------------
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD FAILURE
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  0.614 s
  [INFO] Finished at: 2026-01-01T17:07:39+02:00
  [INFO] ------------------------------------------------------------------------
  [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.13.0:compile (default-compile) on project example: Compilation failure
  [ERROR] /C:/Users/muham/OneDrive/Documents/Udemy Courses/mavenquickstart/maven-quick-start/src/main/java/clinic/programming/training/Application.java:[14,9] cannot find symbol
  [ERROR]   symbol:   class var
  [ERROR]   location: class clinic.programming.training.Application
  [ERROR]
  [ERROR] -> [Help 1]
`
- To resolve this we had to add a compiler plugin for the correct java version (23)
- See example of adding a compiler plugin in the pom.xml
`
    <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.14.1</version>
        <configuration>
          <release>23</release>
        </configuration>
      </plugin>
    </plugins>
    </build>
`
- When you run again, it will download some extra stuff before passing:
### Run mvn clean install and it will pass!  ;> 
### Can also go back to your target folder and rerun the java to see that your program runs fine!


# Course Work Notes Section 5: Maven Dependencies
- Dependencies are a core thing 
- They are resolved by the Maven Repo and the online Maven Central repo
- There are 6 scopes ( compile, test, runtime, test, import, System)
- Compile is a default scope
- Runtime scope - for dependencies needed during running
- Test scope - ... you can guess , not needed for compilation or deployment only testing

# Testing out adding dependencies to POM file
- in java add `import org.apache.commons.lang3.StringUtils;`
- see the countWords method for its usage in Application.java
- try to compile and it will fail if we didnt add the pom `mvn clean compile`
`
  [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.14.1:compile (default-compile) on project example: Compilation failure: Compilation failure:
  [ERROR] /C:/Users/muham/OneDrive/Documents/Udemy Courses/mavenquickstart/maven-quick-start/src/main/java/clinic/programming/training/Application.java:[4,32] package org.apache.commons.lang3 does not exist
  [ERROR] /C:/Users/muham/OneDrive/Documents/Udemy Courses/mavenquickstart/maven-quick-start/src/main/java/clinic/programming/training/Application.java:[14,29] cannot find symbol
  [ERROR]   symbol:   variable StringUtils
  [ERROR]   location: class clinic.programming.training.Application
  [ERROR] -> [Help 1]
`
- Add the dependency to the pom.xml - visit Maven Central online to find the correct pom
- search for commons-lang3
`
  <dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.20.0</version>
  </dependency>
`
- Rerun `mvn clean compile` and it will download the dependency and then pass !


