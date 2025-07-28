# 🧩 Spring Annotations & Component Scanning Overview

Spring uses annotations to manage and wire dependencies at runtime. Here's a quick reference:

---

## 📍 Core Stereotype Annotations

| Annotation       | Role                                         | Spring Component? | Typical Layer       |
|------------------|----------------------------------------------|--------------------|----------------------|
| `@Component`     | Generic component                            | ✅                 | Any layer            |
| `@Service`       | Business/service logic                       | ✅ (specialized)    | Service layer        |
| `@Repository`    | Data access logic, exception translation     | ✅ (specialized)    | Repository/DAO layer |
| `@Controller`    | Handles HTTP requests (Spring MVC)           | ✅ (specialized)    | Web Controller       |
| `@RestController`| `@Controller` + `@ResponseBody`              | ✅                 | API Layer (REST)     |
| `@Configuration` | Declares configuration (usually `@Bean`)     | ❌ (not a component) | Configuration class |

---

## 🧭 `@ComponentScan`

### 🔍 What It Does:
Tells Spring where to look for annotated components (`@Component`, `@Service`, etc.)

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
}
# 🔍 Spring's `@ComponentScan` – Deep Dive

`@ComponentScan` tells Spring **where to look** for components like:

- `@Component`
- `@Service`
- `@Repository`
- `@Controller`

Without it, Spring only scans the package where your main class is located (by default).

---

## ✅ Basic Usage

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
}
