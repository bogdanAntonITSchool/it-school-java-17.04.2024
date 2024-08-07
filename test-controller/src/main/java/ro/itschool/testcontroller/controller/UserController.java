package ro.itschool.testcontroller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.testcontroller.controller.dto.UserDto;
import ro.itschool.testcontroller.controller.payload.ResponsePayload;
import ro.itschool.testcontroller.service.UserService;

import java.util.List;

// http://localhost:8080/api/v1/users

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePayload<UserDto>> getUserById(@PathVariable long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponsePayload<>(userDto, "User found for id: " + id));
    }

    // http://localhost:8080/api/v1/users/[orice]/[orice]
    @GetMapping("/{id}/{name}")
    public UserDto getUserByIdAndPrintName(@PathVariable long id, @PathVariable String name) {
        System.out.println("id: " + id + ", name: " + name);
        return userService.getUserById(id);
    }

    // http://localhost:8080/api/v1/users/user?name=User1&age=21&email=user1@test.com&address=Test Address
    @GetMapping("/user")
    public List<UserDto> getUsersByFilters(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) Integer age,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String address) {
        return userService.getUsersByFilters(name, age, email, address);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam long id) {
        userService.removeUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestParam int id, @RequestBody UserDto userDto) {
//        UserDto currentUserDto = userService.getUserById(id);
//        if (currentUserDto != null) {
//            userService.updateAndLoadUserData(userDto, id);
//            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
//        } else {
//            userService.addUser(userDto, id);
//            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
//        }

        userService.updateAndLoadUserData(userDto, id);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }
}
