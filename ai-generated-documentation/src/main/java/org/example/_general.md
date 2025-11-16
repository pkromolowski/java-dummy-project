![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
## General Documentation for **example** package  

The **example** package (namespace `org.example`) contains two simple utility classes that demonstrate basic Java programming concepts such as method design, input validation, and control‑flow complexity.  

The **`Service`** class offers two public methods. `isEven(int input)` is a straightforward predicate that returns `true` when the supplied integer is divisible by 2 and `false` otherwise, using the modulus operator. The second method, `highComplexityMethod(int a, int b, int c)`, prints a series of messages describing whether each of the three integer arguments is *positive* (`> 0`) or *non‑positive* (`≤ 0`). Although the underlying decision logic is simple, the method is deliberately written with many nested `if‑else` blocks to illustrate a high cyclomatic‑complexity pattern; it handles edge cases such as zero and negative numbers and produces console output via `System.out.println`. No class‑level state is stored, making the class stateless and thread‑safe.  

The **`Client`** class acts as a thin wrapper around a `Service` dependency. It holds a final reference to a `Service` instance supplied through its constructor. Its sole public operation, `greeting(String name)`, validates the input string (rejecting `null` or blank values with an `IllegalArgumentException`), determines whether the length of the name is even by delegating to `service.isEven(name.length())`, and then builds a greeting `"Hello, <name>"`. If the length is even, the greeting is converted to upper‑case before being returned; otherwise, the original mixed‑case greeting is returned. The method does not perform any I/O beyond returning a string, and it does not handle secrets or credentials, so it is not security‑sensitive. Together, these two classes provide a minimal but complete example of service‑oriented design, input validation, and conditional logic in Java.  

---

## Table of Contents  

- [Service.md](Service.md)  
  - **Description:** This file documents the `Service` class, which includes the `isEven(int)` method for checking integer parity and the `highComplexityMethod(int a, int b, int c)` that prints sign information for three integers using a deeply nested `if‑else` structure. The documentation covers method signatures, parameters, return types, important logic, edge‑case handling, and provides equivalent implementations in several other programming languages, as well as pseudo‑code illustrating the control flow.  

- [Client.md](Client.md)  
  - **Description:** This file describes the `Client` class, a thin wrapper around a `Service` instance. It explains the constructor that injects the service, and the `greeting(String name)` method which validates the input, uses the service to check whether the name length is even, builds a personalized greeting, and conditionally converts it to upper‑case. The documentation details parameters, return values, validation logic, edge‑case handling, security considerations, and includes pseudo‑code that outlines the method’s step‑by‑step execution.