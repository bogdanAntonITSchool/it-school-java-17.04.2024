package ro.itschool.testcontroller.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.itschool.testcontroller.persistence.dao.IdentityCard;

@Repository
public interface IdentityCardRepository extends JpaRepository<IdentityCard, Long> {

    @Query("SELECT i FROM IdentityCard i WHERE i.user.id = ?1")
    IdentityCard findIdentityCardByUserId(Long userId);
}
