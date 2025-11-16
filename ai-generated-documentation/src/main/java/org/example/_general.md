![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
## General Documentation for example package  

The **example** package (namespace `org.example`) contains two closely related classes that together illustrate basic service‑oriented design and simple control‑flow logic in Java. The core component is the `Service` class, which offers two utility methods: `isEven(int)` – a straightforward predicate that determines whether a supplied integer is divisible by 2 using the modulus operator, and `highComplexityMethod(int a, int b, int c)` – a demonstrative routine that prints a series of messages describing the sign (positive or non‑positive) of three integer arguments. Although the underlying logic of the latter method is simple, its implementation is intentionally verbose, featuring many nested `if‑else` branches that result in a high cyclomatic complexity; this serves as an example of how code duplication and deep nesting can inflate complexity without adding functional value.  

Complementing the service layer, the `Client` class acts as a thin wrapper that depends on a `Service` instance. It exposes a single public operation, `greeting(String name)`, which validates the input name (rejecting `null` or blank strings with an `IllegalArgumentException`), determines whether the length of the name is even by delegating to `Service.isEven`, and then constructs a greeting message. If the length is even, the greeting is returned in all upper‑case letters; otherwise, it is returned in title case. The class stores its `Service` dependency in an immutable final field, emphasizing a simple form of dependency injection. Together, these classes demonstrate basic principles of input validation, delegation, and the impact of code structure on readability and maintainability, while remaining free of external library dependencies and security‑sensitive operations.  

---

## Table of Contents  

- [Service.md](Service.md)  
  - **Description:** This file documents the `Service` class, which provides two utility methods: `isEven(int)` for checking integer parity using the modulus operator, and `highComplexityMethod(int a, int b, int c)` that prints messages describing the sign of three integers. The latter method contains many nested `if‑else` branches, illustrating high cyclomatic complexity despite simple underlying logic. The documentation includes method tables, pseudo‑code, and cross‑language equivalents, and notes that the class relies only on core Java (`System.out`).  

- [Client.md](Client.md)  
  - **Description:** This file describes the `Client` class, a thin wrapper around a `Service` dependency. It offers a single public method `greeting(String name)` that validates the input, uses `Service.isEven` to check the name’s length parity, and returns a greeting either in upper‑case (if length is even) or title case (if odd). The documentation details the class fields, constructor, method behavior, error handling for null or blank names, pseudo‑code, and equivalent implementations in other languages, emphasizing its simple dependency injection pattern and lack of external libraries.