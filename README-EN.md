# Simple Kotlin Clean Architecture Backend

Kotlin backend based on the Clean Architecture principles.

The application is separated into three layers: Domain, UseCases and Adapters


### The domain layer
The center of the ring, the domain layer, houses the overarching business rules, logic and needs that form the foundation for the application's intended role and purpose. This core also contains what are known as "entities," which represent the class and interface types needed by the enterprise business rules. These types encapsulate the most general and high-level rules that the application would take advantage of. These types do not have any knowledge of the other layers nor do they have any dependency on any other types of components residing in the outer layers.

### The application layer or Core Layer
The application layer, which sits outside this core, contains the rules and logic that relate specifically to the application's design and behavior. This layer includes "use cases" which refer to the specific business rules that define the application's responsibilities and expected behavior. It is isolated from external elements, such as the user interface, database and frameworks, to maintain the intended separation of concerns.

### Adapter layer
The next layer holds APIs and gateways, which govern the flow of communication between the application's back end and the external components. This layer is responsible for outward facing elements such as the application presenters, views and controllers. In clean architecture, none of these external components should have any knowledge of or dependence on the data persisted in the database.

### Infrastructure layer
Finally, the outermost infrastructure layer serves up all necessary details pertaining to the particular web frameworks or database models in use. These details should be abstracted from the domain layer, since teams will need to alter the configuration of these frameworks and databases over time. By abstracting these details, teams can update and modify an application's code structure, data models and user interface without impacting the foundational domain layer.


##### Technologies:

Kotlin, Spring, H2 Database, MongoDB

![image](https://cdn.ttgtmedia.com/rms/onlineImages/app_arch-layers_clean_architecture-f.png)


### References
* [ARTICLE: A primer on the clean architecture pattern and its principles](https://www.techtarget.com/searchapparchitecture/tip/A-primer-on-the-clean-architecture-pattern-and-its-principles)
* [ARTICLE: Baeldung Hexagonal Architecture DDD Spring](https://www.baeldung.com/hexagonal-architecture-ddd-spring)
* [VIDEO: Otavio Lemos - Clean Architecture com TypeScript & Node.js](https://www.youtube.com/watch?v=7BNoxRntLYo)
* [ARTICLE: Clean Architecture Example with Java and Spring Boot](https://medium.com/swlh/clean-architecture-java-spring-fea51e26e00)
* [Reference Java Project on Github](https://github.com/soyjuanmalopez/clean-architecture)
* [Principal Kotlin_Project_on_Github](https://github.com/ESchouten/CleanArchitecture)