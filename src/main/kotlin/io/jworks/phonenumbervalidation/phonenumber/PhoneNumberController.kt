package io.jworks.phonenumbervalidation.phonenumber

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PhoneNumberController {

    @PostMapping("/validate")
    fun validate(@RequestBody @Valid input: PhoneNumber): ResponseEntity<String> {
        println(input)

        return ResponseEntity.ok("Number is valid")
    }

}



