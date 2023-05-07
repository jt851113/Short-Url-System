# <center>Short URL System</center>

![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)
*** 

![image.png](https://raw.githubusercontent.com/jt851113/my-image-host/main/202305070012141.png)

*** 
## Background

使用 SpringBoot 與 MySql 實現的簡易短網址系統<br>

This is a simple implementation of a short URL system using Spring Boot and MySQL. <br>
It provides a convenient way to shorten long URLs and includes a basic front-end presentation using HTML, CSS, and JavaScript.<br>

Short Url System is a web application that allows you to create shortened URLs for long URLs. It helps to make your URLs more concise and easier to share.
The Short URL System is designed to create shortened versions of long URLs, making them easier to share and manage. It utilizes the Spring Boot framework for the backend logic and MySQL as the database for storing URL mappings.<br>
### Whole System Design
    
### Unique Id Implement

***
## Install
To install and run the ShortUrl System, follow these steps:
1. Clone the repository:
    ```
    git clone https://github.com/jt851113/Short-Url-System.git
    ```
2. Change to the project directory:
    cd Short-Url-System
3. Install the dependencies using Maven:
   ```
   mvn install
   ```
4. Configure the application properties:
   Open the `application.properties` file located in `src/main/resources` and update the necessary configuration settings such as database connection details.
5. Create the database:
   Use the provided SQL script `shorturl.sql` to create the required database structure. Execute the script on your preferred database management tool.
6. Modifying the Domain name in HTML file:
    Modified the `index.html` file located in `src/main/resources/static` and find the domain variable<br> Domain name setting should look like this:<br>
    ```
    var domain = "https://your-domain-name/"
    ```
7. Build the project:
   ```
   mvn package -D maven.test.skip
   ```
8. Run the application:
   ```
   java -jar target/short-url-system.jar
   ```
9. Access the application:
   Open a web browser and go to `http://localhost:8080` to access the ShortUrl System

    
***

## Usage
Once the ShortUrl System is running, follow these steps to create shortened URLs:
  
1. Enter the long URL in the input field provided.
2. Click the "Shorten URL" button. 
3. The shortened URL will be generated and displayed on the page. 
4. Copy the shortened URL and use it as desired.

## Configure The SSL certificate:
By default, the Short-Url-System runs on HTTP. If you want to enable SSL for secure communication, follow these steps:

1. Obtain an SSL certificate:
- You can obtain an SSL certificate from a trusted certificate authority (CA).
- Alternatively, you can generate a self-signed certificate for testing purposes.

2. Configure the SSL properties:
   Open the `application.properties` file located in `src/main/resources` and add the following configuration settings:
```
server.port=8443
server.ssl.enabled=true
server.ssl.key-store=/path/to/your/keystore.p12
server.ssl.key-store-password=your-keystore-password
server.ssl.key-store-type=PKCS12
```
Replace /path/to/your/keystore.p12 with the actual path to your SSL keystore file, and your-keystore-password with the password for your keystore.
3. Restart the application:
   Stop the running Short-Url-System application and start it again.
4. Access the application over HTTPS:
   Open a web browser and go to https://localhost:8443 to access the Short-Url-System using SSL.

Make sure to update the SSL configuration based on your specific certificate and keystore information.<br> It's recommended to use a valid SSL certificate issued by a trusted CA in a production environment.

Please note that the instructions provided assume a basic understanding of Git, Maven, and running Java applications. Make sure to provide any additional instructions or prerequisites specific to your application if needed.

## Future Work
- [ ] Adding a RandomNumber DataBase to avoid conflict of random numbers.
- [ ] Input checking system.
- [ ] Better front-end (Maybe ?)
- [ ] Adding Users service
- [ ] Adding Nginx for load balancer.
- [ ] Adding Redis for improve read capabilities.