package io.jworks.phonenumbervalidation.phonenumber

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PhoneNumberController {

    @PostMapping("/phonenumber")
    fun validate(@RequestBody @Valid input: PhoneNumber): ResponseEntity<Message> {
        return ResponseEntity.ok(Message("Number is valid: ${input.formatPhoneNumber()}"))
    }

    data class Message(val message: String)
}