# Test Company

Test Slogan!

---
## Client.java Documentation

**1. Overview:**

The `Client` class demonstrates a simple client application that interacts with a `Service` object. It provides a `greeting` method which takes a name as input, checks if it's valid, and then generates a greeting message based on the length of the name. The greeting is either returned in lowercase or uppercase depending on whether the name's length is even or odd.

**2. Package/module name:**

org.example

**3. Class/file name:**

Client.java

**4. Detailed Documentation:**

   - **Constructor `Client(Service service)`:**
     - **Description:** Initializes a new instance of the `Client` class, associating it with a given `Service` object.
     - **Parameters:**
       - `service`: A `Service` object responsible for providing services like checking if a number is even.
     - **Return Values:** None

   - **Method `greeting(String name)`:**
     - **Description:** Generates a greeting message based on the provided name. 
     - **Parameters:**
       - `name`: A string representing the recipient's name.
     - **Return Values:**
       - A string containing the formatted greeting message, either in lowercase or uppercase depending on the length of the name.
     - **Important Logic:**
       - It first validates the input `name` to ensure it's not null or empty. If invalid, it throws an `IllegalArgumentException`.
       - Calls the `isEven()` method of the associated `Service` object to determine if the length of the name is even.
       - Formats a greeting message using string interpolation (`"Hello, %s".formatted(name)`).
       - Returns the formatted greeting in uppercase if the name's length is even, otherwise returns it in lowercase.

**5. Pseudo Code:**


```
// Class: Client

// Method: greeting(name)
  1. Check if 'name' is null or empty:
    - If true, throw an "IllegalArgumentException" with message "'name' must not be null or empty".
  2. Call the 'isEven()' method of the associated 'Service' object, passing the length of 'name' as input. 
     - Store the result (true if even, false otherwise) in a variable called 'even'.
  3. Format a greeting message using string interpolation: "Hello, %s".formatted(name).
  4. If 'even' is true:
    - Convert the formatted greeting to uppercase and return it.
  5. Otherwise:
    - Return the formatted greeting as is (lowercase). 



```

**Dependencies and Libraries:**

* **Service Interface:** The `Client` class relies on a `Service` interface, which likely defines methods like `isEven()`. This interface could be implemented using various libraries or custom classes depending on the specific requirements.


Let me know if you have any other questions or need further clarification!