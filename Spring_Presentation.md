![Lexicon Logo](https://lexicongruppen.se/media/wi5hphtd/lexicon-logo.svg)

# 🌱 Spring Core (IoC & DI)

---

# 📑 Table of Contents

1. **Spring Core**
2. **Inversion of Control (IoC)**
3. **Dependency Injection (DI)**
4. **IoC Container** (ApplicationContext)
5. **Beans**
6. **Configuration Approaches**

---

## 1. Introduction to Spring Framework

**Spring** is a **lightweight**, **flexible**, and **powerful** open-source framework for building **Java applications**, especially large and enterprise-level systems.  

Its main goal is to make Java development **simpler, cleaner, and easier to maintain** by handling common technical tasks automatically, so developers can focus on **business logic** instead of infrastructure code.

Spring is known for being:
- **Lightweight**
- **Flexible**
- **Powerful**

### How Spring simplifies application development:

- **Inversion of Control (IoC)**  
- **Dependency Injection (DI)**  
- **Modular Architecture**  
- **Rich Spring Ecosystem**  

---

### Spring Ecosystem

The **Spring Ecosystem** is a collection of projects built **on top of Spring Core**.  
Each project focuses on solving a specific type of problem while sharing the same core concepts like **IoC**, **DI**, and **beans**.

Think of it this way:

- **Spring Core** is the foundation
- The **Spring Ecosystem** is everything built on that foundation

All Spring projects work together smoothly because they rely on the same core principles.

- **Spring Boot** – Fast and easy Spring setup
- **Spring MVC / Web** – Web apps and REST APIs
- **Spring Data** – Easy database access
- **Spring Security** – Authentication and authorization
- **Spring Cloud** – Microservices and distributed systems
- **Spring AI** – AI and LLM integrations

---


## 1. Spring Core

Spring Core is the **foundation** of the entire Spring Framework.

It is responsible for:

- Creating objects
- Managing their lifecycle
- Connecting them together

Main concepts:

- **Inversion of Control (IoC)**
- **Dependency Injection (DI)**
- **Beans**
- **ApplicationContext**
---

## 2. Inversion of Control (IoC)

**Inversion of Control** means that the *control* of object creation is moved away from your code and handed to the Spring framework.

Traditionally, your code is responsible for creating and wiring objects.  
With IoC, this responsibility is **inverted**:

- Spring, not you, creates the objects.
- Spring decides when to create them and how long they live.
- Spring connects the objects together based on configuration.

---

## 3. Dependency Injection (DI)

**Dependency Injection** is the technique Spring uses to provide an object’s required dependencies *from the outside*, instead of the object creating them itself.

- Spring creates the required dependencies.
- Spring injects them into your class through the constructor, setters, or fields.
- Your class depends on **abstractions (interfaces)** rather than concrete implementations.

### Types of Dependency Injection

1. Constructor Injection (Recommended)
   - Dependencies are provided at object creation
   - Object is always valid
   - Easy to test
   - Best design choice

2. Setter Injection
   - Dependencies are set later
   - Used for optional dependencies
   - Less safe

3. Field Injection (Not Recommended)
   - Dependencies are hidden
   - Harder to test
   - Poor design

---

## 4. IoC Container (ApplicationContext)

The **IoC Container** is Spring’s core engine.

In Spring, it is called **ApplicationContext**.

It:

- Reads configuration
- Creates beans
- Injects dependencies
- Manages and Provides beans when needed


![multilayered-app.png](multilayered-app.png)

---

## 5. Beans

A **bean** is any object managed by Spring.

In Spring, a **bean** is simply an object that is created, managed, and controlled by the Spring IoC container.

A bean can be:
- A service class
- A repository or DAO
- A configuration class
- Any object managed by Spring


---

## 6. Configuration Approaches

Spring provides multiple ways to configure how beans are created, discovered, and managed inside the IoC Container.  
These configuration methods tell Spring **what beans exist** and **how to wire them together**.

There are three main configuration approaches:

---

### 1. Java Configuration (Recommended)

Java-based configuration uses classes annotated with `@Configuration` and methods annotated with `@Bean`.

This approach is:

- Type-safe
- Easy to refactor
- Modern and widely recommended

When to use:

- When you need **full control** over bean creation and initialization logic
- When you want to integrate **third-party libraries** as Spring beans
- When you prefer a **type-safe**, **refactor-friendly** approach using pure Java code
- When you need to create beans with **complex instantiation logic** or **conditional creation**

### 2. Annotation-based Configuration

Spring automatically detects and registers classes annotated with stereotype annotations as beans in the IoC container:

- **`@Component`** – Generic stereotype for any Spring-managed component
- **`@Service`** – Indicates a service layer component (business logic)
- **`@Repository`** – Marks a DAO/repository class (data access layer)
- **`@Controller`** – Designates a web controller (presentation layer)

**How it works:**

- Spring scans the classpath for annotated classes
- Automatically creates bean instances for detected classes
- Injects dependencies where needed

**Configuration:**

Enabled by adding `@ComponentScan` to your configuration class or by using `@SpringBootApplication` (which includes
`@ComponentScan` by default).

### 3. XML Configuration (Legacy)

Beans defined in XML files.  
Used only in older projects.


Reference to the [Spring Framework](https://docs.spring.io/spring-framework/reference/overview.html) for more details.