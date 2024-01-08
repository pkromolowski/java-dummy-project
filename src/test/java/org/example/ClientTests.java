package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientTests {

    @Mock
    private Service service;

    @InjectMocks
    private Client client;

    @Test
    public void greetingShouldReturnUpperCaseWhenNameLengthIsEven() {
        // Arrange
        String name = "John";
        when(service.isEven(name.length())).thenReturn(true);

        // Act
        String result = client.greeting(name);

        // Assert
        assertThat(result).isEqualTo("HELLO, JOHN");
    }

    @Test
    public void greetingShouldReturnLowerCaseWhenNameLengthIsOdd() {
        // Arrange
        String name = "Jane";
        when(service.isEven(name.length())).thenReturn(false);

        // Act
        String result = client.greeting(name);

        // Assert
        assertThat(result).isEqualTo("Hello, Jane");
    }

    @Test
    public void greetingShouldThrowExceptionWhenNameIsNull() {
        // Arrange
        String name = null;

        // Act & Assert
        assertThatThrownBy(() -> client.greeting(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'name' must not be null or empty");
    }

    @Test
    public void greetingShouldThrowExceptionWhenNameIsEmpty() {
        // Arrange
        String name = "";

        // Act & Assert
        assertThatThrownBy(() -> client.greeting(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'name' must not be null or empty");
    }
}