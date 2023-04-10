package denis.nesterov.demo.microservices.accounts.service.client

import denis.nesterov.demo.microservices.accounts.model.CustomerDto
import denis.nesterov.demo.microservices.accounts.model.LoanDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("loans")
interface LoansFeignClient {

    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/loans"],
        consumes = ["application/json"])
    fun getLoansDetails(@RequestBody customerDto: CustomerDto): List<LoanDto>
}
