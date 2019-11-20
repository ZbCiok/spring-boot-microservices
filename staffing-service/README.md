# staffing-service
## *(Config Server Client with CRUD H2 Example)*
### Launching
##### 1. Run Config Server
* mvn clean install
* mvn spring-boot:run
* see: *[https://zbciok.eu/java/index.php/2019/11/14/microservices-spring-config-server/](https://zbciok.eu/java/index.php/2019/11/14/microservices-spring-config-server/)*<br>
##### 2. Run *staffing-service*<br>
* mvn clean install
* mvn spring-boot:run
##### 3. Configuring config-server
* *[ config-server-configuration/configuration/staffing-service.properties ](https://github.com/ZbCiok/config-server-configuration/blob/master/configuration/staffing-service.properties)*
* *http://localhost:8081/job-categories/showConfig*:<br><br>
![](src/main/resources/img/showConfig-01.png?raw=true?style=centerme)
