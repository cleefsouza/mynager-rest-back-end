# Mynager
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
  

#### Dump Database
> File: [db_mynager.sql](https://github.com/cleefsouza/mynager-rest-back-end/blob/master/db_dump/db_mynager.sql)

#### Application Link
> [mynager-rest-api.herokuapp.com](mynager-rest-api.herokuapp.com)

#### Endpoints
- **Item**
> GET: **/item**
> POST: **/item**
> PUT: **/item/id**
> DELETE: **/item/id**

- **Type**
> GET: **/type**

- **Situation**
> GET: **/situation**

- **User**
> GET: **/user, /user/id**
> POST: **/user**
> PUT: **/user/id**
> DELETE: **/user/id**

- **Auth**
> POST: **/auth/refresh_token**

#### Class Diagram
<img src="https://github.com/cleefsouza/mynager-rest-back-end/blob/master/diagrams/class_diagram.png/"/>
