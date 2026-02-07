package com.example;

import com.example.app.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void greetReturnsExpectedMessage() {
        App app = new App();
        assertEquals("Hello, Codex!", app.greet("Codex"));
    }
}
