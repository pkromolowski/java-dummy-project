![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
## General Documentation for example package  

The **example** package ( `org.example` ) contains two simple Java classes that illustrate basic utility and composition patterns.  

The **`Service`** class offers two public methods. `isEven(int input)` is a straightforward predicate that returns **true** when the supplied integer is divisible by 2, using the modulus operator. The second method, `highComplexityMethod(int a, int b, int c)`, demonstrates a highly nested series of `if‑else` statements that print a textual description of each argument’s sign (positive vs. non‑positive). Although the method’s cyclomatic complexity is intentionally high, it performs no business‑critical work and only writes to `System.out`. No class‑level fields are defined; all data are passed as method parameters. The class has no external dependencies beyond the core Java language.  

The **`Client`** class is a thin wrapper around a `Service` instance. It holds a final reference to a `Service` object supplied via its constructor. Its sole public operation, `greeting(String name)`, validates the input (rejecting `null` or blank strings with an `IllegalArgumentException`), determines whether the length of the provided name is even by delegating to `service.isEven(name.length())`, and then builds a greeting string `"Hello, <name>"`. If the length is even, the greeting is returned in upper‑case; otherwise it is returned unchanged. The method relies on `String.formatted` for interpolation and performs no I/O or security‑sensitive actions.  

Together, these files provide a minimal example of utility methods, conditional logic, input validation, and dependency injection in Java. They can be readily translated to other languages (Python, C#, JavaScript, etc.) while preserving the same logical behavior. The package is self‑contained, requires only the standard Java runtime, and serves as a teaching aid for basic coding concepts such as method design, control flow, and simple service composition.  

---  

## Table of Contents  

- [Service.md](Service.md)  
  - **Description:** This file documents the `Service` class located in `org.example`. It explains the two utility methods provided: `isEven(int)`, a simple even‑number check using the modulus operator, and `highComplexityMethod(int a, int b, int c)`, which contains deeply nested `if‑else` statements to print sign information for each argument. The documentation includes method signatures, parameter and return details, important logic notes, edge‑case handling, and a full pseudo‑code representation of the class’s behavior.  

- [Client.md](Client.md)  
  - **Description:** This file describes the `Client` class, also in `org.example`, which depends on a `Service` instance. It outlines the immutable `service` field, the constructor that injects the dependency, and the `greeting(String name)` method that validates its input, uses `Service.isEven` to decide on case conversion, and returns a formatted greeting. The documentation covers parameter validation, error handling, return values, and provides pseudo‑code illustrating the method’s step‑by‑step logic.  