package de.tosken.proc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HueServiceTest {

    @Autowired
    private HueService hueService;

    @Test
    void getLights() {
        hueService.getLights();
    }
}
