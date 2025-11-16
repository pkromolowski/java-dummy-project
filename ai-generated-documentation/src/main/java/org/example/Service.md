![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
**1. Overview**  
The `Service` class provides two utility methods:  

* `isEven(int input)` – a simple predicate that tells whether a given integer is even.  
* `highComplexityMethod(int a, int b, int c)` – a demonstrative method that prints a series of messages describing the sign (positive / non‑positive) of the three input integers. The method contains many nested `if‑else` branches, which makes its control‑flow appear complex even though the underlying logic is straightforward.

---

**2. Package / Module Name**  
`org.example`

---

**3. Class / File Name**  
`Service.java` – class `Service`

---

**4. Detailed Documentation**

| Method | Description | Parameters | Return Values | Important Logic / Edge Cases |
|--------|-------------|------------|---------------|------------------------------|
| **`isEven(int input)`** | Returns `true` if the supplied integer is evenly divisible by 2, otherwise returns `false`. | • `input` – `int` – the number to test. | `boolean` – `true` when `input` is even, `false` otherwise. | * Uses the modulus operator (`%`). <br>* No special edge‑case handling is required because the `%` operator works for all `int` values, including `Integer.MIN_VALUE`. |
| **`highComplexityMethod(int a, int b, int c)`** | Prints a message for each argument indicating whether it is **positive** (`> 0`) or **non‑positive** (`<= 0`). The method first evaluates `a`, then `b`, then `c`, nesting the checks to illustrate a high cyclomatic‑complexity pattern. | • `a` – `int` – first number.<br>• `b` – `int` – second number.<br>• `c` – `int` – third number. | `void` – the method only produces console output via `System.out.println`. | * The outermost `if` distinguishes three cases for `a`:<br> - `a == 0` (treated as “positive” in the original message – likely a mistake, but kept as‑is).<br> - `a < 0` (non‑positive).<br> - `a > 0` (falls into the final `else` block, also labelled “non‑positive”).<br>* For each `a` branch, the same nested structure is repeated for `b` and `c`.<br>* No exception handling is required because the method only performs comparisons and prints. <br>* Edge cases handled implicitly:<br> - Zero is considered “positive” only in the `a == 0` branch; for `b` and `c` zero falls into the “non‑positive” branch (`> 0` test fails). <br> - Negative numbers are correctly identified as “non‑positive”. <br>* The method’s complexity is purely structural; the actual decision logic is identical across the three outer branches. |

**Key Variables / Data Structures**  
* No class‑level fields are used. All variables are method parameters (`a`, `b`, `c`, `input`).  
* The method relies on primitive `int` and `boolean` types and the standard output stream (`System.out`).

**Assumptions / Dependencies**  
* The code assumes a standard Java runtime (no external libraries).  
* It uses `System.out.println` for side‑effects; callers must have a console or log capture if they need the output.  
* No thread‑safety concerns because the class holds no mutable state.

**Suggested Equivalent Libraries (if porting)**  
| Target Language | Equivalent Functionality |
|-----------------|--------------------------|
| Python | `def is_even(input): return input % 2 == 0` and `print` statements for the second method. |
| C# | `bool IsEven(int input) => input % 2 == 0;` and `Console.WriteLine` for output. |
| JavaScript | `function isEven(input) { return input % 2 === 0; }` and `console.log`. |
| C++ | `bool isEven(int input) { return input % 2 == 0; }` and `std::cout`. |

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
          * Proceed to step 2 (evaluate b)
     - Else if a is less than 0
          * Print "a is non-positive"
          * Proceed to step 2
     - Else (a > 0)
          * Print "a is non-positive"
          * Proceed to step 2

  2. Evaluate the sign of 'b' (same logic for all three outer branches)
     - If b is greater than 0
          * Print "b is positive"
          * Proceed to step 3 (evaluate c)
     - Else
          * Print "b is non-positive"
          * Proceed to step 3

  3. Evaluate the sign of 'c' (same logic for all branches)
     - If c is greater than 0
          * Print "c is positive"
     - Else
          * Print "c is non-positive"

  // Note: Steps 2 and 3 are repeated verbatim for each possible outcome of step 1,
  // resulting in a total of 3 (a) × 2 (b) × 2 (c) = 12 possible printed messages.
```

*All edge cases (zero values, negative numbers) are covered by the explicit comparisons shown above.*