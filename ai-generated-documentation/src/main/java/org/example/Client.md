![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
**1. Overview**  
The `Client` class is a thin wrapper around a `Service` dependency. It provides a single public operation – `greeting(String name)` – which validates the input name, asks the `Service` whether the length of the name is even, builds a “Hello, \<name\>” message, and returns the message in upper‑case when the length is even.  

**2. Package / module name**  
`org.example`

**3. Class / file name**  
`Client.java` – class `Client`

**4. Detailed Documentation**

| Member | Description |
|--------|-------------|
| **Field** `private final Service service;` | Holds a reference to a `Service` implementation that supplies the `isEven(int)` method. The field is immutable after construction. |
| **Constructor** `public Client(Service service)` | Creates a `Client` instance with the supplied `Service`. <br>**Parameters**:<br>• `service` – an object implementing the `Service` contract; must not be `null` (the code does not explicitly check, so a `NullPointerException` will be thrown later if it is). <br>**Return**: a new `Client` object. <br>**Important Logic**: simply assigns the argument to the final field. |
| **Method** `public String greeting(String name)` | Generates a greeting for the given `name`. <br>**Parameters**:<br>• `name` – the name to greet; must be non‑null and contain at least one non‑whitespace character. <br>**Return Values**:<br>• Returns `"HELLO, <NAME>"` (all upper‑case) when the length of `name` is even.<br>• Returns `"Hello, <Name>"` (original case) when the length is odd. <br>**Important Logic**:<br>1. **Validation** – throws `IllegalArgumentException` if `name` is `null` **or** `name.isBlank()` (i.e., empty or only whitespace). <br>2. Calls `service.isEven(name.length())` to determine parity of the length. <br>3. Builds the base greeting using `String.formatted`. <br>4. Returns the greeting in upper‑case if the length is even; otherwise returns it unchanged. <br>**Edge Cases / Error Handling**:<br>• `null` or blank `name` → `IllegalArgumentException` with message `"'name' must not be null or empty"`.<br>• If `service` is `null`, a `NullPointerException` will be thrown when `isEven` is invoked. |
| **Helper Variables (local)** | `boolean even` – result of `service.isEven(name.length())`. <br>`String greeting` – the formatted base greeting before any case conversion. |

**5. Pseudo Code**

```
// Class: Client
// Dependency: Service (provides isEven(int) -> boolean)

1. Constructor(Client, service)
   a. Store the provided service reference in the instance field.

2. Method: greeting(name)
   a. Validate input
      - If name is null OR name consists only of whitespace
          * Throw IllegalArgumentException with message "'name' must not be null or empty".
   b. Determine parity of the name length
      - Call service.isEven(length of name) and store result in variable even.
   c. Build base greeting string
      - Set greeting = "Hello, %s" where %s is replaced by the original name.
   d. Return result based on parity
      - If even is true
          * Return greeting converted to upper‑case.
      - Else
          * Return greeting unchanged.
```

*Notes on dependencies*  
- The code relies on an external `Service` type. In other languages, an equivalent would be an interface or abstract class exposing a method like `bool isEven(int value)`.  
  - **Java** – keep the same `Service` interface.  
  - **Python** – define a protocol or abstract base class with `def is_even(self, value: int) -> bool`.  
  - **C#** – an interface `IService` with `bool IsEven(int value);`.  
  - **C++** – a class with a virtual method `bool isEven(int) const;`.  

No security‑sensitive operations are performed in this class.