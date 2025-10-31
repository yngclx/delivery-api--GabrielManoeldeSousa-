# Delivery Tech API 

Sistema de delivery desenvolvido com Spring Boot e Java 21 

## Tecnologias
- **Java 21 LTS** (versão mais recente)
- Spring Boot 3.2.x
- Spring Web
- Spring Data JPA
- H2 Database
- Maven 

## Recursos Modernos Utilizados no projeto
- Records (Java 14+)
- Text Blocks (Java 15+)
- Pattern Matching (Java 17+)
- Virtual Threads (java 21)

## Como executar localmente
1. **Pré-requisitos:** JDK 21 instalado
2. Clone o repositório
3. Execute: './mvnw spring-boot:run'
4. Acesse: http://localhost:8080/health

## Endpoits do projeto
- GET /health - Status da aplicação (inclui versão Java)
- GET /info - Informações da aplicação
- GET /h2-console - Console do banco H2

## Configuração
- Porta: 8080
- Banco: H2 em memória
- Profile - development

## Desenvolvedor
Gabriel Manoel de Sousa
Turma de API Rest SpringBoot Sexta á noite
Desenvolvido com JDK 21 e Spring Boot 3.2.x