# Kotlin Backend Simples com Arquitetura Limpa

Backend Kotlin baseado nos princípios da Arquitetura Limpa.

A aplicação é separada em três camadas: Domínio, Casos de Uso e Adaptadores


### Camada de Domínios
A camada de domínio é a camada central, ela abriga as regras de negócio, a lógica e as necessidades abrangentes que formam a base para a função e a finalidade pretendida do aplicativo. 
Esse núcleo também contém o que é conhecido como "entidades", que representam a classe e os tipos de interface necessários às regras de negócio da empresa. 
Esses tipos encapsulam as regras mais gerais e de alto nível das quais o aplicativo se beneficiaria. 
Esses tipos não têm nenhum conhecimento das outras camadas nem dependem de nenhum outro tipo de componente que reside nas camadas externas.


### Camada de Casos de Uso
A camada do aplicativo, que fica fora do núcleo/domínio, contém as regras e a lógica que se relacionam específicamente ao design e ao comportamento do aplicativo. 
Essa camada inclui "casos de uso" que se referem às regras de negócios específicas que definem as responsabilidades do aplicativo e o comportamento esperado. 
Ele é isolado de elementos externos (infraestrutura), como interface do usuário, banco de dados e frameworks, para manter a separação de interesses pretendida. Contudo, a camada de casos de uso enxerga a camada de domínio e entidades.

### Camada de Adaptadores
A próxima camada contém APIs e gateways, que controlam o fluxo de comunicação entre o back-end do aplicativo e os componentes externos. 
Essa camada é responsável por elementos voltados para o exterior, como apresentadores de aplicativos, visualizações e controladores. 
Na arquitetura limpa, nenhum desses componentes externos deve ter conhecimento ou dependência dos dados persistidos no banco de dados. Contudo, a camada de adaptadores enxerga os casos de uso e a camada de domínio.
Nesse exemplo, coloquei os adaptadores dentro da camada de infraestrutura para deixar a aplicação mais simples, porém a regra de negócio e casos de uso estão realmente encapsulados.

### Camada de infraestrutura
Por fim, a camada mais externa, a camada de infraestrutura fornece todos os detalhes de implementação e configuração necessários sobre as estruturas específicas da web ou os modelos de banco de dados em uso. 
Esses detalhes devem ser abstraídos da camada de domínio, pois as equipes precisarão alterar a configuração dessas estruturas e bancos de dados ao longo do tempo. Ao abstrair esses detalhes, as equipes podem atualizar e modificar a estrutura de código, os modelos de dados e a interface do usuário de um aplicativo sem afetar a camada de domínio fundamental.

##### Tecnologias:

Kotlin, Spring, H2 Database, MongoDB

![image](https://cdn.ttgtmedia.com/rms/onlineImages/app_arch-layers_clean_architecture-f.png)


### Referências
* [Artigo: A primer on the clean architecture pattern and its principles](https://www.techtarget.com/searchapparchitecture/tip/A-primer-on-the-clean-architecture-pattern-and-its-principles)
* [Artigo: Baeldung Hexagonal Architecture DDD Spring](https://www.baeldung.com/hexagonal-architecture-ddd-spring)
* [Video: Otavio Lemos - Clean Architecture com TypeScript & Node.js](https://www.youtube.com/watch?v=7BNoxRntLYo)
* [Artigo: Clean Architecture Example with Java and Spring Boot](https://medium.com/swlh/clean-architecture-java-spring-fea51e26e00)
* [Principal projeto Java Spring usado de referência no Github](https://github.com/soyjuanmalopez/clean-architecture)
* [Principal projeto Kotlin Spring usado de referência no Github](https://github.com/ESchouten/CleanArchitecture)
