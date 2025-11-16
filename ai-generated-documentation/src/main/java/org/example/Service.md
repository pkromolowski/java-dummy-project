![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
**1. Overview**  
The `Service` class provides two utility methods:  

* `isEven(int input)` – a simple predicate that tells whether a given integer is even.  
* `highComplexityMethod(int a, int b, int c)` – a demonstrative method that prints a series of messages describing the sign (positive / non‑positive) of the three input integers. The method contains many nested `if‑else` branches, which makes its cyclomatic complexity high even though the underlying logic is straightforward.

Both methods are pure (they do not modify external state) except that `highComplexityMethod` writes to `System.out`.

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
| **`isEven(int input)`** | Returns `true` if the supplied integer is evenly divisible by 2, otherwise returns `false`. | • `input` – `int` – the number to test. | `boolean` – `true` when `input % 2 == 0`, `false` otherwise. | * Uses the modulus operator (`%`). <br>* No special edge‑case handling is required because the `%` operator works for all `int` values, including `Integer.MIN_VALUE`. |
| **`highComplexityMethod(int a, int b, int c)`** | Prints a message for each argument indicating whether it is **positive** (`> 0`) or **non‑positive** (`<= 0`). The method first evaluates `a`, then `b`, then `c`, nesting the checks to produce a total of 12 possible output lines (4 branches for each combination of signs). | • `a` – `int` – first number.<br>• `b` – `int` – second number.<br>• `c` – `int` – third number. | `void` – no return value. | * The outermost `if` distinguishes three cases for `a`:<br>  - `a == 0` (treated as “positive” in the original message – a semantic inconsistency).<br>  - `a < 0` (non‑positive).<br>  - `a > 0` (the final `else` branch, also labelled “non‑positive”).<br>* For each `a` branch, the method repeats the same `b`/`c` logic, resulting in duplicated code. <br>* **Edge cases**:<br>  - `a == 0`, `b == 0`, or `c == 0` are considered *non‑positive* because the condition `> 0` is false. <br>  - No exception is thrown; the method always completes after printing the appropriate messages. <br>* **Security‑sensitive note**: The method only writes to standard output; there is no handling of sensitive data. |
| | | | | |

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
  1. Evaluate the sign of 'a'
        - If a equals 0
            * Print "a is positive"
        - Else if a is less than 0
            * Print "a is non-positive"
        - Else (a > 0)
            * Print "a is non-positive"
  2. Within the selected 'a' branch, evaluate the sign of 'b'
        - If b is greater than 0
            * Print "b is positive"
        - Else
            * Print "b is non-positive"
  3. Within the selected 'b' branch, evaluate the sign of 'c'
        - If c is greater than 0
            * Print "c is positive"
        - Else
            * Print "c is non-positive"
  4. End of method (no return value)
```

*Notes on the pseudo‑code:*  

* Steps 1‑3 are nested; the actual implementation repeats the same `b`/`c` logic for each possible `a` branch, but the pseudo‑code abstracts that repetition for clarity.  
* The method treats `0` as “non‑positive” for `b` and `c`, while it mistakenly labels `a == 0` as “positive”. This semantic inconsistency is preserved from the original code.  

---

**6. Dependencies / Libraries**  

* The class uses only core Java (`java.lang`), specifically `System.out.println`. No external libraries are required.  
* Equivalent functionality in other languages:  

| Language | `isEven` equivalent | `highComplexityMethod` equivalent |
|----------|--------------------|-----------------------------------|
| Python   | `def is_even(x): return x % 2 == 0` | Use `print` statements with the same nested `if` logic. |
| C#      | `bool IsEven(int input) => input % 2 == 0;` | Use `Console.WriteLine` with nested `if` blocks. |
| JavaScript | `function isEven(n) { return n % 2 === 0; }` | Use `console.log` with nested `if` statements. |

No security‑critical operations are present, so no special handling is required.