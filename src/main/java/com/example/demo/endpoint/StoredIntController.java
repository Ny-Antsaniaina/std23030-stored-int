package com.example.demo.endpoint;

import com.example.demo.service.StoredIntService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {

    private final StoredIntService service;

    public StoredIntController(StoredIntService service) {
        this.service = service;
    }

    @GetMapping("/stored-int")
    public int getStoredInt() {
        return service.getStoredInt();
    }
}
