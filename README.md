# Mynager API
**API RESTful** with Java and Spring Boot for managing _series_ and _animations_ that i follow.

#### Requirements
- **Java 8+**
- PostgreSQL
- Maven

#### Integrated Development Environment
- [x] Eclipse **(Used)**
- [ ] Spring Tools 3+
- [ ] Visual Studio Code
  - Extensions
    - Language Support for Java(TM) by Red Hat
    - Install the Java Extension Pack
    - Maven for Java
    - Spring Initializr Java Support
  
#### Implemented
- [x] Endpoints
- [x] Services
- [x] Connecting to PostgreSQL
- [x] Spring Security
- [x] JWT Authentication

#### Dump Database
> [db_mynager.sql](https://github.com/cleefsouza/mynager-rest-back-end/blob/master/db_dump/db_mynager.sql)

#### Application Link
> https://mynager-rest-api.herokuapp.com <br/>

#### Endpoints
- **Item**
> GET: **/item, /item/id** <br/>
> POST: **/item** <br/>
> PUT: **/item/id** <br/>
> DELETE: **/item/id** <br/>

- **Type**
> GET: **/type**

- **Situation**
> GET: **/situation**

- **User**
> GET: **/user, /user/id, /user/email?value=email** <br/>
> POST: **/user** <br/>
> PUT: **/user/id, /user/block_user/id**<br/>
> DELETE: **/user/id**

- **Auth**
> POST: **/auth/refresh_token**
