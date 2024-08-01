package ro.itschool.testcontroller.service;

import org.springframework.stereotype.Service;
import ro.itschool.testcontroller.controller.dto.UserDto;
import ro.itschool.testcontroller.persistence.dao.User;
import ro.itschool.testcontroller.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//    private static final Map<Integer, UserDto> users = new HashMap<>();
//
//    static {
//        users.put(1,
//                UserDto.builder()
//                        .name("User1")
//                        .age(20)
//                        .email("user1@test.com")
//                        .address("Test Address")
//                        .build());
//        users.put(2, new UserDto("User2", 21, "user2@test.com", "Test Address 2"));
//        users.put(3, new UserDto("User3", 22, "user3@test.com", "Test Address 3"));
//        users.put(4, new UserDto("User4", 23, "user4@test.com", "Test Address 4"));
//        users.put(5, new UserDto("User5", 24, "user5@test.com", "Test Address 5"));
//        users.put(6, new UserDto("User6", 20, "user6@test.com", "Test Address 6"));
//    }

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> UserDto.builder()
                        .address(user.getAddress())
                        .age(user.getAge())
                        .email(user.getEmail())
                        .name(user.getName())
                        .build())
                .toList();
    }

    public UserDto getUserById(long id) {
//        return users.get(id);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();
        return UserDto.builder()
                .address(user.getAddress())
                .age(user.getAge())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

    public List<UserDto> getUsersByFilters(String name, Integer age, String email, String address) {
//        return users.values().stream()
//                .filter(userDto -> (name == null || userDto.getName().equals(name))
//                        && (age == null || userDto.getAge() == age)
//                        && (email == null || userDto.getEmail().equals(email))
//                        && (address == null || userDto.getAddress().equals(address)))
//                .toList();
        List<User> usersByName = userRepository.findUsersByNameNative(name);
        return usersByName.stream()
                .map(user -> UserDto.builder()
                        .address(user.getAddress())
                        .age(user.getAge())
                        .email(user.getEmail())
                        .name(user.getName())
                        .build())
                .toList();
    }

    public void addUser(UserDto userDto) {
//        users.put(users.size() + 1, userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());

        userRepository.save(user);
    }

//    public void addUser(UserDto userDto, int id) {
////        users.put(id, userDto);
//        User user = new User();
//        user.setId((long) id);
//        user.setName(userDto.getName());
//        user.setAge(userDto.getAge());
//        user.setEmail(userDto.getEmail());
//        user.setAddress(userDto.getAddress());
//
//        userRepository.save(user);
//    }

    public void removeUserById(long id) {
//        users.remove(id);
        userRepository.deleteById(id);
    }

    public void updateAndLoadUserData(UserDto newUserDto, long id) {
//        currentUserDto.setName(newUserDto.getName() != null
//                ? newUserDto.getName() : currentUserDto.getName());
//        currentUserDto.setAge(newUserDto.getAge() != 0
//                ? newUserDto.getAge() : currentUserDto.getAge());
//        currentUserDto.setEmail(newUserDto.getEmail() != null
//                ? newUserDto.getEmail() : currentUserDto.getEmail());
//        currentUserDto.setAddress(newUserDto.getAddress() != null
//                ? newUserDto.getAddress() : currentUserDto.getAddress());
//
//        users.put(id, currentUserDto);

        User user = userRepository.findById(id).orElseThrow();
        user.setName(newUserDto.getName() != null ? newUserDto.getName() : user.getName());
        user.setAge(newUserDto.getAge() != 0 ? newUserDto.getAge() : user.getAge());
        user.setEmail(newUserDto.getEmail() != null ? newUserDto.getEmail() : user.getEmail());
        user.setAddress(newUserDto.getAddress() != null ? newUserDto.getAddress() : user.getAddress());

        userRepository.save(user);
    }
}


//
