# Introduction
This guide is intended for developers of Services team that are responsible for maintaining this library. 

For instructions on how to create projects using this archetype, please refer [README.md](README.md) instead.

# Generating and Deploying Archetype to Maven
This repository contains a base project that we will use to create archetype by following below steps - 

* Clone this repository, if not done already
* Clean project __target__directory either manually or run following command from project directory

```sh
mvn clean
```

* Create archetype project by executing the following command

```sh
mvn archetype:create-from-project
```

* Go to created archetype home directory by executing following command -

```sh
cd target/generated-sources/archetype/
```

* Build the archetype by executing following command -

```sh
mvn clean install
```

* Go to its target directory by executing command - 

```sh
cd target
```

* If you want to push a SNAPSHOT version of archetype to Maven repository, execute following command (replace __archetype-jar-file-name__ with actual jar file name and __version-no__ with actual version number) -

```sh
mvn deploy:deploy-file -Durl=http://mavenrepo.infoedge.com/artifactory/libs-snapshot-local -DrepositoryId=snapshots -Dfile=<archetype-jar-file-name> -DgroupId=com.ie.naukri.archetypes -DartifactId=archetype-cloud-grizzly-starter-archetype -Dversion=<version-no>
```

* Else, if you want to push a release version of archetype to Maven repository, execute following command (replace __archetype-jar-file-name__ with actual jar file name and __version-no__ with actual version number) -

```sh
mvn deploy:deploy-file -Durl=http://mavenrepo.infoedge.com/artifactory/libs-release-local -DrepositoryId=central -Dfile=<archetype-jar-file-name> -DgroupId=com.ie.naukri.archetypes -DartifactId=archetype-cloud-grizzly-starter-archetype -Dversion=<version-no>
```
