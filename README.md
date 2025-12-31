## Course Notes
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
# mvn package
- You can run your java file through the generated jar
- To generate a jar, run "mvn package" in your maven-quick-start dir
- Then, navigate to the generated target folder ( cd target )
- then run the command, "java -cp <jarname.jar> <packagename>.<javaclassname>"
- so in our case: """java -cp example-1.0.jar clinic.programming.training.Application"""

## Cleaning up the build
# mvn clean
- is a phase part of the clean lifecycle from the jar lifecycle
- this will remove the target folder
- you need to cd out of the target folder first

## Multiple goals and phases in a lifecycle
# mvn clean package
- allows you to clean and recompile at once!

## Local Maven Repo
# mvn clean install
# mvn install
- copies the jar file out of the target into mavens local repo
- the repo is a local cache of builds and artifacts
- the repo is found under the .m2 folder (known as 'repository')
- repository contains other folders that contain dependencies we have executed for maven
- remember maven needs plugins to execute phases, plugins themselves have dependencies

