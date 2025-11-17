# Test Company

Test Slogan!

---
## Client.java Documentation

**1. Overview:**

This Java code defines a `Client` class that interacts with a `Service` object to generate greetings. The client validates input names, determines if the name length is even, and formats a greeting accordingly. 

**2. Package/Module Name:**

org.example

**3. Class/File Name:**

Client.java

**4. Detailed Documentation:**

   - **Class `Client`**:
     - **Description:**  This class encapsulates the logic for generating greetings based on a provided name and interaction with a `Service` object. 
     - **Constructor `Client(Service service)`**:
       - **Description:** Initializes a new `Client` instance, associating it with a given `Service` object.
       - **Parameters:**
         - `service`: A `Service` object responsible for providing functionality like checking if a number is even.
     - **Method `greeting(String name)`**:
       - **Description:** Generates a greeting string based on the provided name. 
       - **Parameters:**
         - `name`: The name to be used in the greeting (cannot be null or empty).
       - **Return Values:** A formatted greeting string, either in uppercase if the name length is even or lowercase otherwise.
       - **Important Logic:**
         - Validates that the input `name` is not null or empty, throwing an `IllegalArgumentException` if it is.
         - Calls the `isEven()` method of the associated `Service` object to determine if the length of the name is even.
         - Formats a greeting string using string interpolation (`%s`).
         - Returns the formatted greeting in uppercase if the name length is even, otherwise returns it in lowercase.

**5. Dependencies and Libraries:**

- **Service Interface:** This code assumes the existence of an interface named `Service` with at least one method called `isEven()`.  This interface defines the contract for interacting with a service that provides functionality like checking if a number is even. 
   - **Equivalent Libraries in Other Languages:**
     - Java: No specific library dependency, as the `Service` interface is custom.
     - Python: You could define a similar interface using abstract classes or protocols.
     - C++: Use an abstract base class to represent the `Service` interface.

**6. Pseudo Code:**


```
// Class: Client

// Method: greeting(name)
  1. Check if name is null or empty:
    - If true, throw an "IllegalArgumentException" with message "'name' must not be null or empty".
  2. Get the length of the name.
  3. Call the 'isEven()' method on the associated Service object, passing the name length as input.
  4. Store the result (true if even, false otherwise) in a variable called 'isNameLengthEven'.
  5. Format a greeting string using string interpolation: "Hello, %s" with the provided name.
  6. If 'isNameLengthEven' is true:
    - Convert the greeting string to uppercase.
  7. Return the formatted greeting string (uppercase if even length, lowercase otherwise). 
```



