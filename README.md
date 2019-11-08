# Turntabl Client Management System (TCSM)
##### TCM is a management system for managing turntabl clients.
the system stores the following information about clients:
1. name 
2. address
3. telephone number 
4. email address


## System Funcitonalities
The system enables the manager to :
- enter new client details
- view and access all the details stored previously 
- search for clients by their names
- delete clients 
- restore deleted clients

## System Operation
The system operates on the following processes:
- displays a welcome message and a menu on start-up
- requests user input
- processes selected option
- generates result

## Software Implementation Tools
- Intellij 
- Travis CI
- Mockito
- Java Core
- JUnit

## Requirements
Make sure your terminal is working properly.<br>
And you have java installed. <br> 
If you don't, type this in your terminal to install the latest version: 
#### sudo apt-get install openjdk-8-jre <br>

## Usage

Get the tcms folder unto your machine: <br>
put it in a recognised location, that you can easily navigate to, for instance, Desktop.<br>

Open your terminal<br>

Navigate to the 'tcms' location from your current location. If it's on your desktop, use the command
```
   cd Desktop/tcms/ <br>
```
Check to see if you have the a zipped file called versions in it using this command:
```
   ls
```
Unzip it using the command:
```
   unzip versions.zip
```
Navigate into the "versions" directory using:
```
   cd versions/
```
You can now run the latest version of the application using this command:
```
   java -jar tcms.1.0.0.jar 
```


## Running with Docker
- git clone https://github.com/idawud/TCMS.git
- install gradle,docker and java
- run 
```
   ./gradlew fatJar
   docker build -t tcms:v1.0 .
   docker run -a stdin -a stdout -i -t tcms:v1.0 /bin/bash
```

## Contributors
- Ismail Dawud [send mail](dawud.ismail@turntabl.io) 
- Patricia Agyekum [send mail](patricia.agyekum@turntabl.io) 
- Alexander Owusu [send mail](alex.owusu@turntabl.io) 
- John K. Erbynn [send mail](john.erbynn@turntabl.io) 


## Acknoledgement
   - Project Manager, Sam Moorhouse, [email](sam@turntabl.io)
   
## License
https://github.com/idawud/TCMS/blob/master/LINSENSE.txt

## Contributing...
Pull requests are welcome.

## Deployment 
This extension is a project to improve our software development skills. Any suggestions or tips are welcome.
Thank you.

