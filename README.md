# Evening with testers workshop support code

### Prerequisites

* [Git](https://git-scm.com/downloads) - Version Control System
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) - Automation Framework Language

## Getting started
Create folder of your choice to use as a workspace and git repo  
In the created folder open a terminal with git support and do
```
git init
```
followed by
```
git clone https://github.com/rariciuc/RTC-evening-with-testers-workshop.git
```
### Prerequisites test
To test your pre-requisites setup you can execute the following command in your cloned git repo (where the pom.xml file is located)
```
mvn clean test
```
If you see a chrome browser opening then your pre-requisites are correctly set
