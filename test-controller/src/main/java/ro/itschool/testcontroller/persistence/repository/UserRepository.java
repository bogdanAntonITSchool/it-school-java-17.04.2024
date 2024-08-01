package ro.itschool.testcontroller.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.itschool.testcontroller.persistence.dao.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByName(String name);

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    List<User> findUsersByNameJPQL(String name);

    @Query(value = "SELECT * FROM users WHERE name = ?1", nativeQuery = true)
    List<User> findUsersByNameNative(String name);
}
