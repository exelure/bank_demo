package denis.nesterov.demo.microservices.cards.controller

import denis.nesterov.demo.microservices.cards.configuration.properties.CardsServiceConfig
import denis.nesterov.demo.microservices.cards.configuration.properties.HeaderNames
import denis.nesterov.demo.microservices.cards.model.CardDto
import denis.nesterov.demo.microservices.cards.model.CustomerDto
import denis.nesterov.demo.microservices.cards.model.Properties
import denis.nesterov.demo.microservices.cards.repository.CardsRepository
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CardsController {

    private val log = LoggerFactory.getLogger(CardsController::class.java)

    @Autowired
    private lateinit var cardsRepository: CardsRepository

    @Autowired
    private lateinit var config: CardsServiceConfig

    @PostMapping("/cards")
    fun cardsDetails(
        @RequestHeader(HeaderNames.CORR_ID) correlationId: String?,
        @RequestBody customerDto: CustomerDto,
    ): List<CardDto> {
        log.info("Method cardsDetails started")

        val result = cardsRepository.findByCustomerId(customerDto.id)
            .map { CardDto.fromEntity(it) }

        log.info("Method cardsDetails ended")
        return result
    }

    @GetMapping("/cards/properties")
    fun cardsProperties() = Properties(
        buildVersion = config.buildVersion,
        msg = config.msg,
        activeBranches = config.activeBranches,
        mailDetails = config.mailDetails
    )
}
