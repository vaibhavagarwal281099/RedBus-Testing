# About Project


## How to run

- Clone repo from the github link
- gitHub link :- **https://github.com/vaibhavagarwal281099/RedBus-Testing.git**
- run runProject.bat

## Important Note

- To change browser - change the browser in configuration.properties

## Important Directory

- Drivers : ./Resources/drivers/
- Report File : ./Reports/ExtentReport.html
- Log File : ./logs/
- Configuration File: ./Resources/Configuration.properties
- Screenshots Folder: ./FailedTestsScreenshots/
- Test Data File : ./Resources/testData/TestDataForRedBus.xlsx

> Command to install custom jar : 

'''
java -cp RedBusTesting-0.0.1-SNAPSHOT.jar;RedBusTesting-0.0.1-SNAPSHOT-tests.jar;libs/* org.testng.TestNG ../testng.xml
// mvn install:install-file -Dfile=C:\Users\narayankrishna\eclipse-workspace\TestCreatedJars\ResourcesCreateJar-0.0.1-SNAPSHOT.jar -DgroupId=com.nagarro -DartifactId=CreateJar -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
'''

## How to run through jenkins

- download jenkins.war file
- run in cmd 

```
java -jar jenkins.war --httpPort=8080
```

- setup jenkins

### Screenshots

#### Jenkins Setup 
-:  ./Jenkin Integration With Project Screenshot

## How to run in docker and parallely

- In testNg.xml use 

```
<suite parallel="classes">...</suite>
```

- Run docker-compose up command in the project directory
- To increase number of browser nodes use command 

```
docker-compose scale <service name> = <no of instances>
```
- run RunProject.bat
- after all tests are completed run docker-compose down command

## Main Parameters in Configuration.properties file

- runDocker : true or false -> to run in docker container
- headlessMode : true or false -> to run in head or headless mode

## Implemented features

-	Create atleast 20 automated scenarios across different flows and screens - **done** 
-	Implement POM - **done**
-	Test data should be read from excel. User has the ability to selective run the test cases by marking yes in the Execution Required field in excel - **done**  
-	Global Parameters should be read from config file like browser name, test site URL, global wait value etc. should be read from a properties file - **done** 
-	Use proper waits i.e. implicit wait and explicit wait wherever necessary.- **done**  
-	The test should run on following browsers IE, Chrome, FF - **done** 
-	There should be an option to run the test cases in headless mode - **done** 
-	Implement dockers to run the test cases in parallel - **done** 
-	Put proper assertions and error screenshot in the extent report - **done** 
-	Create reusable libraries and import these as jars in the current project - **done** (in.redbus.pageUtils)
-	Create a ReadMe document which has the steps to install and run the code - **done**
-	Integration with github and Jenkins **done**

