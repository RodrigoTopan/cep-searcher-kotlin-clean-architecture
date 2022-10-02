# Simple Kotlin Clean Architecture Backend

Kotlin backend based on the Clean Architecture principles.
https://www.techtarget.com/searchapparchitecture/tip/A-primer-on-the-clean-architecture-pattern-and-its-principles


The application is separated into three layers: Domain, UseCases and Adapters

<p>
1. <b>The domain layer</b><br>
   The center of the ring, the domain layer, houses the overarching business rules, logic and needs that form the foundation for the application's intended role and purpose. This core also contains what are known as "entities," which represent the class and interface types needed by the enterprise business rules. These types encapsulate the most general and high-level rules that the application would take advantage of. These types do not have any knowledge of the other layers nor do they have any dependency on any other types of components residing in the outer layers.
</p>
<p>
2. <b> The application layer or Core Layer</b><br>
   The application layer, which sits outside of this core, contains the rules and logic that relate specifically to the application's design and behavior. This layer includes "use cases" which refer to the specific business rules that define the application's responsibilities and expected behavior. It is isolated from external elements, such as the user interface, database and frameworks, to maintain the intended separation of concerns.
</p>
<p>
3. <b> Adapter layer</b><br>
   The next layer holds APIs and gateways, which govern the flow of communication between the application's back end and the external components. This layer is responsible for outward facing elements such as the application presenters, views and controllers. In clean architecture, none of these external components should have any knowledge of or dependence on the data persisted in the database.
</p>
<p>
4. <b> Infrastructure layer</b><br>
   Finally, the outermost infrastructure layer serves up all necessary details pertaining to the particular web frameworks or database models in use. These details should be abstracted from the domain layer, since teams will need to alter the configuration of these frameworks and databases over time. By abstracting these details, teams can update and modify an application's code structure, data models and user interface without impacting the foundational domain layer.
</p>

##### Technologies:

Kotlin, Spring, Hibernate, MongoDB, Docker, Docker-Compose

![image](https://cdn.ttgtmedia.com/rms/onlineImages/app_arch-layers_clean_architecture-f.png)