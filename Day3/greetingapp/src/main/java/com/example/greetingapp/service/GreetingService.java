// GreetingService.java
package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository repo;

    public Greeting getDefaultGreeting() {
        return new Greeting("Hello World");
    }

    public Greeting getGreeting(String firstName, String lastName) {
        String name = (firstName != null ? firstName : "") +
                (lastName != null ? " " + lastName : "");
        name = name.trim();
        return new Greeting("Hello " + (name.isEmpty() ? "World" : name));
    }

    public Greeting saveGreeting(String message) {
        return repo.save(new Greeting(message));
    }

    public Greeting findGreeting(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Greeting> listGreetings() {
        return repo.findAll();
    }

    public Greeting updateGreeting(Long id, String newMsg) {
        Greeting g = findGreeting(id);
        g.setMessage(newMsg);
        return repo.save(g);
    }

    public void deleteGreeting(Long id) {
        repo.deleteById(id);
    }
}
