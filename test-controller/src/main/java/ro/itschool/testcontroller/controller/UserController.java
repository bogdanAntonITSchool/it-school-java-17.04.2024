package ro.itschool.testcontroller.controller;

import org.springframework.web.bind.annotation.*;
import ro.itschool.testcontroller.model.User;

import java.util.HashMap;
import java.util.Map;

// http://localhost:8080/api/v1/users

@RestController
@RequestMapping("/users")
public class UserController {

    // private List<String> users = List.of("User1", "User2", "User3", "User4", "User5");
    private static final Map<Integer, User> users = new HashMap<>();

    static {
        users.put(1,
                User.builder()
                        .name("User1")
                        .age(20)
                        .email("user1@test.com")
                        .address("Test Address")
                        .build());
        users.put(2, new User("User2", 21, "user2@test.com", "Test Address 2"));
        users.put(3, new User("User3", 22, "user3@test.com", "Test Address 3"));
        users.put(4, new User("User4", 23, "user4@test.com", "Test Address 4"));
        users.put(5, new User("User5", 24, "user5@test.com", "Test Address 5"));
    }

    @GetMapping
    public Map<Integer, User> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.get(id);
    }

    @GetMapping("/{id}/{name}")
    public User getUserByIdAndPrintName(@PathVariable int id, @PathVariable String name) {
        System.out.println("id: " + id + ", name: " + name);
        return users.get(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        users.put(users.size() + 1, user);
    }
}
