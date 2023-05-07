#  <center>Short URL System</center>

![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)
*** 

![image.png](https://raw.githubusercontent.com/jt851113/my-image-host/main/202305070012141.png)

*** 
## Background

使用 SpringBoot 與 MySql 實現的簡易短網址系統

ShortUrl System is a web application that allows you to create shortened URLs for long URLs. It helps to make your URLs more concise and easier to share.
***
## Install
To install and run the ShortUrl System, follow these steps:
1. Clone the repository:
	git clone https://github.com/jt851113/Short-Url-System.git
2. Change to the project directory:
	cd Short-Url-System
3. Install the dependencies using Maven:
   mvn install
4. Configure the application properties:
   Open the `application.properties` file located in `src/main/resources` and update the necessary configuration settings such as database connection details.
5. Create the database:
   Use the provided SQL script `shorturl.sql` to create the required database structure. Execute the script on your preferred database management tool.
6. Build the project:
   mvn package -Dmaven.test.skip
7. Run the application:
   java -jar target/short-url-system.jar
8. Access the application:
   Open a web browser and go to `http://localhost:8080` to access the ShortUrl System

***

## Usage
Once the ShortUrl System is running, follow these steps to create shortened URLs:
  
1. Enter the long URL in the input field provided.
2. Click the "Shorten URL" button. 
3. The shortened URL will be generated and displayed on the page. 
4. Copy the shortened URL and use it as desired.
