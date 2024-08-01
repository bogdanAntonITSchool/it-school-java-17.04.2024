package ro.itschool.testcontroller.service;

import org.springframework.stereotype.Service;
import ro.itschool.testcontroller.controller.dto.IdentityCardDto;
import ro.itschool.testcontroller.persistence.dao.IdentityCard;
import ro.itschool.testcontroller.persistence.dao.User;
import ro.itschool.testcontroller.persistence.repository.IdentityCardRepository;
import ro.itschool.testcontroller.persistence.repository.UserRepository;

import java.util.Optional;

@Service
public class IdentityCardService {

    private final IdentityCardRepository identityCardRepository;
    private final UserRepository userRepository;

    public IdentityCardService(IdentityCardRepository identityCardRepository, UserRepository userRepository) {
        this.identityCardRepository = identityCardRepository;
        this.userRepository = userRepository;
    }

    public void createIdentityCardForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        IdentityCard identityCard = new IdentityCard();
        identityCard.setCnp("1234567890123");
        identityCard.setUser(user);
        identityCard.setSeries("AB");

        identityCardRepository.save(identityCard);
    }

    public IdentityCardDto getIdentityCardForUser(Long userId) {
//        User user = userRepository.findById(userId).orElseThrow();
//        IdentityCard identityCardByUserId = identityCardRepository.findIdentityCardByUserId(user.getId());

        IdentityCard identityCard = identityCardRepository.findById(1L).orElseThrow();
        User user = identityCard.getUser();
        IdentityCardDto identityCardDto = new IdentityCardDto();
        identityCardDto.setCnp(identityCard.getCnp());
        identityCardDto.setSeries(identityCard.getSeries());

        return identityCardDto;
    }
}
