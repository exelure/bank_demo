package denis.nesterov.demo.microservices.cards.controller

import denis.nesterov.demo.microservices.cards.model.CardDto
import denis.nesterov.demo.microservices.cards.model.CustomerDto
import denis.nesterov.demo.microservices.cards.repository.CardsRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CardsController {

    @Autowired
    private lateinit var cardsRepository: CardsRepository

    @PostMapping("/cards")
    fun cardsDetails(@RequestBody customerDto: CustomerDto): List<CardDto> {
        return cardsRepository.findByCustomerId(customerDto.id)
            .map { CardDto.fromEntity(it) }
    }
}