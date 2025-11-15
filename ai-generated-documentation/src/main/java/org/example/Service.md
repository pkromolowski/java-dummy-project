![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
**1. Overview**  
The `Service` class provides two utility methods:  

* `isEven(int input)` – a simple predicate that returns **true** when the supplied integer is an even number.  
* `highComplexityMethod(int a, int b, int c)` – a demonstrative method that prints a series of messages describing whether each of the three input integers (`a`, `b`, `c`) is positive or non‑positive. The method contains a deep nesting of `if‑else` statements, resulting in a high cyclomatic complexity, but it does **not** perform any business‑critical logic.

---

**2. Package / module name**  
`org.example`

---

**3. Class / file name**  
`Service.java` – class `Service`

---

**4. Detailed Documentation**

| Method | Description | Parameters | Return Values | Important Logic / Edge Cases |
|--------|-------------|------------|---------------|------------------------------|
| **`isEven(int input)`** | Determines whether the supplied integer is even. | • `input` – `int` – the number to test. | `boolean` – `true` if `input` is divisible by 2, otherwise `false`. | * Uses the modulus operator (`%`). <br>* No special edge‑case handling is required because the `%` operator works for all `int` values, including `Integer.MIN_VALUE`. |
| **`highComplexityMethod(int a, int b, int c)`** | Prints a textual description of the sign (positive vs. non‑positive) of each argument. The method explores every combination of sign states for `a`, `b`, and `c` through nested `if‑else` blocks. | • `a` – `int` – first number.<br>• `b` – `int` – second number.<br>• `c` – `int` – third number. | `void` – the method only produces console output. | * The outermost `if` checks `a == 0`. * The next branch checks `a < 0`; the final `else` implicitly handles `a > 0` (the comment mistakenly says “non‑positive”, but the logic treats it as the positive case). <br>* For each value of `a`, the method repeats the same two‑level nested checks for `b` and `c`. <br>* **Edge cases** handled implicitly: <br> - `a`, `b`, or `c` equal to `0` are treated as *non‑positive* because the condition `> 0` fails. <br> - No `null` concerns (primitive `int`). <br>* No exceptions are thrown; the method always completes after printing nine possible messages (one for each variable). <br>* The method is **not** security‑sensitive; it only writes to `System.out`. |

**Key Variables / Data Structures**  
* No class‑level fields are defined. All variables are method parameters (`a`, `b`, `c`, `input`).  
* The method relies on the standard `System.out.println` for output; no custom data structures are used.

**Assumptions / Dependencies**  
* The code runs on a Java runtime that supports at least Java 5 (no newer APIs are required).  
* No external libraries are required; only `java.lang` (implicitly imported).  
* It is assumed that the caller expects console output; the method does not return any value that can be programmatically inspected.

**Potential Refactor / Equivalent in Other Languages**  
* **Python** – `def is_even(input: int) -> bool: return input % 2 == 0` and a series of `print` statements for the second method.  
* **C#** – similar signatures with `Console.WriteLine`.  
* **JavaScript** – `function isEven(input) { return input % 2 === 0; }` and `console.log` for the messages.  

---

**5. Pseudo Code**

```
// Class: Service

// Method: isEven(input)
  1. Compute remainder = input modulo 2
  2. If remainder equals 0
        - Return true
     Else
        - Return false

// Method: highComplexityMethod(a, b, c)
  1. Evaluate sign of 'a'
     - If a equals 0
          * Print "a is positive"
     - Else if a is less than 0
          * Print "a is non-positive"
     - Else (a > 0)
          * Print "a is non-positive"   // note: original code prints this message for a > 0
  2. Within the branch chosen for 'a', evaluate sign of 'b'
     - If b > 0
          * Print "b is positive"
     - Else
          * Print "b is non-positive"
  3. Within the branch chosen for 'b', evaluate sign of 'c'
     - If c > 0
          * Print "c is positive"
     - Else
          * Print "c is non-positive"
  4. End of method (no return value)
```

**Explanation of Pseudocode Structure**  

* Steps 1‑3 are nested logically exactly as the original Java code: the decision for `c` is performed inside the selected `b` branch, which itself is inside the selected `a` branch.  
* The pseudocode explicitly lists the three possible outcomes for each variable, preserving the original handling of the value `0` as “non‑positive”.  
* No exception handling is required because the original method never throws; the pseudocode therefore does not include error‑handling steps.