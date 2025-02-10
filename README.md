# tangle
A lightweight, annotation-driven, compile-time and Jarkarta EE compliant dependency injection framework for Java.

### State

Work in progress, initial interest was spark by colleagues complaints on boiler-plate code with using dagger. I have worked a lot with Spring's DI hence looking at making something similar and learning in the process more about the challenges, constraints associated with the topic at hand.

### Features

Initial layout of what needs to be done for some sort of MVP:

#### 1. Core Dependency Injection System
- [ ] **Annotation-Based Injection** (`@Inject`, `@Qualifier`, `@Named`, `@Produces`)  
- [ ] **Compile-Time Processing** (Java Annotation Processing or Compiler Plugin)  
- [ ] **Bean Scoping** (`@ApplicationScoped`, `@RequestScoped`, `@SessionScoped`, `@Dependent`, etc.)  
- [ ] **Provider Support** (`javax.inject.Provider<T>` for lazy injection)  
- [ ] **Dependency Graph Resolution** (Static DI container generation)  

#### 2. Context Management & Lifecycle Handling
- [ ] **Contextual Lifecycle Management** (Managed bean lifecycle support)  
- [ ] **Context Propagation** (Passing context across threads)  
- [ ] **Destruction Callbacks** (`@PreDestroy`, `@PostConstruct` lifecycle hooks)  
- [ ] **Proxy Support for Contextual Scopes** (Scoped dependency management)  

#### 3. Qualifiers & Alternatives
- [ ] **Custom Qualifiers** (`@Qualifier` support for multiple beans of the same type)  
- [ ] **Alternatives for Bean Selection** (`@Alternative` to override implementations)  
- [ ] **Default & Named Beans** (`@Named` for explicit bean selection in EL)  

#### 4. Producers & Disposers
- [ ] **Bean Producers** (`@Produces` for factory-based dependency creation)  
- [ ] **Bean Disposers** (`@Disposes` to handle resource cleanup)  

#### 5. Interceptors & Decorators
- [ ] **Interceptor Support** (`@Interceptor`, `@InterceptorBinding` for method interception)  
- [ ] **Decorator Support** (`@Decorator` for modifying injected objects dynamically)  
- [ ] **Interceptor Invocation Context** (`InvocationContext` for advanced handling)

#### 6. Events & Observers
- [ ] **Event Bus System** (`@Observes`, `@ObservesAsync` for event-driven programming)  
- [ ] **Event Qualifiers** (`@WithAnnotations` for event filtering)  
- [ ] **Asynchronous Event Processing** (Non-blocking event handling)  

#### 7. Extensions & Meta-Programming
- [ ] **Build-Time Extensions (Portable Extensions)** (`jakarta.enterprise.inject.spi.Extension`)  
- [ ] **Annotation Processing for Static Analysis** (Compile-time dependency scanning)  
- [ ] **Reflection-Free DI Metamodel** (No `java.lang.reflect` for better performance)  

#### 8. CDI-Compatible Dependency Resolution
- [ ] **CDI Bean Discovery** (`META-INF/beans.xml` automatic discovery)  
- [ ] **Explicit and Implicit Bean Discovery Modes** (`bean-discovery-mode="annotated"` and `"all"`)  
- [ ] **Portable Bean Injection** (Jakarta CDI `BeanManager` compatibility)  

#### 9. Thread Safety & Performance Optimizations  
- [ ] **Thread-Safe Dependency Resolution** (Proper singleton/request-scoped handling)  
- [ ] **Optimized Injection Strategy** (Minimize instantiations & improve reuse)  
- [ ] **Minimal Startup Overhead** (Efficient code generation)  

### 10. Jakarta EE Integration
- [ ] **Seamless Jakarta EE Compatibility** (Integration with **Jakarta REST, Servlet, JPA, JTA**)  
- [ ] **EL Support for Web Applications** (`@Named` beans in **Jakarta Faces & JSP**)  
- [ ] **CDI API Compliance** (Follow **Jakarta CDI 4.1+** specifications)  

#### 11. Testing & Validation 
- [ ] **Unit Testing with Mocking Support** (Mock dependencies easily)  
- [ ] **Validation of Injection Points** (Compile-time validation of dependency graphs)  
- [ ] **Integration Testing Support** (Compatible with Jakarta EE servers like **Payara, WildFly, OpenLiberty**)  

#### 🎯 Some Interesting Future Enhancements
- [ ] **Kotlin Support**  
- [ ] **Ahead-of-Time Compilation (AOT) Support for GraalVM**  
- [ ] **Native Image Support** (For Quarkus-like performance)  
- [ ] **Configuration-Based Injection** (Support for YAML, JSON, Properties)  

### 🛠 Contribution Guide 
If you want to contribute, feel free to **pick a feature**, fork the repo, and submit a PR!  
