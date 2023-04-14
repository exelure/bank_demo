package denis.nesterov.demo.microservices.accounts.service.client

import denis.nesterov.demo.microservices.accounts.configuration.properties.HeaderNames
import denis.nesterov.demo.microservices.accounts.model.CardDto
import denis.nesterov.demo.microservices.accounts.model.CustomerDto

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("cards")
interface CardsFeignClient {

    @RequestMapping(method = [RequestMethod.POST], value = ["/cards"], consumes = ["application/json"])
    fun getCardsDetails(
        @RequestHeader(HeaderNames.CORR_ID) correlationId: String?,
        @RequestBody customerDto: CustomerDto,
    ): List<CardDto>
}
