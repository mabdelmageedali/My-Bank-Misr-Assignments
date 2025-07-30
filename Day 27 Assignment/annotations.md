# Spring Annotations Notes

## Core Annotations

### `@Component`
- Marks a class as a Spring bean
- Automatically detected during component scanning
- Used in: `Printer.java`, `UserService.java`

### `@Autowired`
- Enables automatic dependency injection
- Can be used on constructors, setters, or fields
- Example:
  ```java
  @Autowired
  public UserService(Printer printer) {
      this.printer = printer;
  }
  ## Spring Boot Annotations Deep Dive

### `@Configuration`
- Marks a class as a configuration class (contains `@Bean` definitions)
- Spring's equivalent of XML configuration files but in Java
- Example use: Database configurations, third-party service setups

### `@ConfigurationProperties`
- Binds external configuration (properties/YAML) to type-safe Java objects
- Perfect for grouping related properties (e.g., `app.security.jwt.*`)
- Requires `@EnableConfigurationProperties` or component scanning
- Example:
  ```java
  @ConfigurationProperties(prefix = "mail")
  public class MailProperties {
      private String host;
      private int port;
      // getters/setters
  }
  @RestController
Convenient stereotype annotation for REST controllers

Combines:

@Controller (marks as Spring MVC controller)

@ResponseBody (serializes return values to HTTP response body)

Default response format: JSON
@GetMapping
Specialized version of @RequestMapping(method = RequestMethod.GET)

Maps HTTP GET requests to handler methods

Can define:

Path (value or path)

Produces/consumes media types

Request parameters
@EventListener
Enables methods to listen for application events

Can listen for:

Standard Spring events (e.g., ContextRefreshedEvent)

Custom application events

Method signature must match event type
@Service
Specialized @Component for service layer classes

Doesn't provide additional functionality (just semantic labeling)

Makes code more readable by indicating the class's role

Example use: Business logic, transaction boundaries

@Primary
Indicates preferred bean when multiple candidates exist

Solves "No qualifying bean" ambiguity errors

Typically used on the main/default implementation

Contrast with @Qualifier for explicit selection

@SpringBootApplication
The "mother of all annotations" in Spring Boot

Meta-annotation combining:

@Configuration - Enables Java-based config

@EnableAutoConfiguration - Enables auto-config magic

@ComponentScan - Enables component discovery

##Secreen shots
<img width="380" height="117" alt="image" src="https://github.com/user-attachments/assets/9b33fc9d-43ae-462c-9f33-adf0063073eb" />
<img width="494" height="117" alt="image" src="https://github.com/user-attachments/assets/96cf6c86-aa18-4ef3-a9fe-f95228d14cab" />
<img width="496" height="121" alt="image" src="https://github.com/user-attachments/assets/4456575e-7003-4be8-a5f5-e486106dd864" />
<img width="511" height="168" alt="image" src="https://github.com/user-attachments/assets/f5cf67ad-cfc2-4fe3-a036-68c735855f27" />



