![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
**1. Overview**  
The `Client` class is a thin wrapper around a `Service` dependency. It provides a single public operation – `greeting(String name)` – which validates the supplied name, asks the `Service` whether the length of the name is even, builds a “Hello, \<name\>” message and returns it either in normal case or fully upper‑cased depending on the parity result.

---

**2. Package / module name**  
`org.example`

---

**3. Class / file name**  
`Client.java` – class `Client`

---

**4. Detailed Documentation**

| Member | Description |
|--------|-------------|
| **Field** `private final Service service;` | Holds a reference to a `Service` implementation that supplies the `isEven(int)` method. The field is immutable after construction. |
| **Constructor** `public Client(Service service)` | Creates a `Client` instance with the supplied `Service` implementation. |
| **Method** `public String greeting(String name)` | Generates a greeting for the supplied `name`. The greeting is converted to upper‑case when the length of `name` is even, otherwise it is returned unchanged. |

---

### Constructor: `Client(Service service)`

- **Description**  
  Instantiates a `Client` object and stores the provided `Service` instance for later use.

- **Parameters**  
  - `service` (`Service`) – a non‑null implementation that provides the `isEven(int)` method. (The code does not explicitly check for `null`; passing `null` will cause a `NullPointerException` later when `service.isEven(...)` is invoked.)

- **Return Values**  
  None (constructors do not return a value).

- **Important Logic**  
  - The constructor simply assigns the argument to the final field `this.service`.  
  - No validation is performed; callers must ensure a valid `Service` object is supplied.

---

### Method: `greeting(String name)`

- **Description**  
  Returns a personalized greeting string for the given `name`. The greeting is transformed to upper‑case if the length of `name` is an even number, otherwise it is left as‑is.

- **Parameters**  
  - `name` (`String`) – the name to be greeted. Must be non‑null and contain at least one non‑whitespace character.

- **Return Values**  
  - `String` – the formatted greeting (`"Hello, <name>"`) possibly converted to upper‑case.

- **Important Logic**  

  1. **Input validation**  
     - Checks `name == null` **or** `name.isBlank()`.  
     - If either condition is true, throws `IllegalArgumentException` with the message `"'name' must not be null or empty"`.

  2. **Parity check**  
     - Calls `service.isEven(name.length())` to determine whether the length of `name` is even.  
     - The result is stored in the local variable `even` (`boolean`).

  3. **Greeting construction**  
     - Uses `String.formatted` to build `"Hello, %s"` with the supplied `name`.  
     - Stores the result in the local variable `greeting`.

  4. **Conditional transformation**  
     - If `even` is `true`, returns `greeting.toUpperCase()`.  
     - Otherwise, returns `greeting` unchanged.

- **Edge‑case handling**  
  - `null` or blank `name` → `IllegalArgumentException`.  
  - No explicit handling for a `null` `service`; a `NullPointerException` will be thrown when `service.isEven(...)` is invoked if the constructor was given a `null` service.

- **Security considerations**  
  - The method does not process secrets, credentials, or perform I/O; therefore it is **not security‑sensitive**.

---

**5. Pseudo Code**

```
// Class: Client
// Dependency: Service (provides isEven(int) -> boolean)

1. Constructor(Client, service)
   a. Assign the provided service to the internal field.
   b. (No validation performed.)

2. Method: greeting(name)
   a. Validate input
      i. If name is null OR name consists only of whitespace
         - Throw IllegalArgumentException with message "'name' must not be null or empty".
   b. Determine parity
      i. Compute length = number of characters in name.
      ii. Call service.isEven(length) and store result in variable even.
   c. Build base greeting
      i. Set greeting = "Hello, " concatenated with name.
   d. Conditional transformation
      i. If even is true
         - Convert greeting to upper‑case.
         - Return the upper‑cased greeting.
      ii. Else
         - Return greeting unchanged.
   e. End of method.
```

*All edge cases (null/blank name) and the conditional upper‑casing based on the evenness of the name length are captured in the pseudo code.*