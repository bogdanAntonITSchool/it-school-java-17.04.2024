package ro.itschool.testcontroller.controller;

import org.springframework.web.bind.annotation.*;
import ro.itschool.testcontroller.controller.dto.IdentityCardDto;
import ro.itschool.testcontroller.persistence.dao.IdentityCard;
import ro.itschool.testcontroller.service.IdentityCardService;

@RestController
@RequestMapping("/identity-cards")
public class IdentityCardController {

    private final IdentityCardService identityCardService;

    public IdentityCardController(IdentityCardService identityCardService) {
        this.identityCardService = identityCardService;
    }

    @PostMapping
    public String addIdentityCard(@RequestParam Long userId) {
        identityCardService.createIdentityCardForUser(userId);
        return "Identity card added successfully";
    }

    @GetMapping
    public IdentityCardDto getIdentityCard(@RequestParam Long userId) {
        return identityCardService.getIdentityCardForUser(userId);
    }
}
