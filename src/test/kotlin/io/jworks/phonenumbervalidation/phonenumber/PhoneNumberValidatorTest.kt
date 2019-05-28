package io.jworks.phonenumbervalidation.phonenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import javax.validation.Validation

internal class PhoneNumberValidatorTest {

    @ParameterizedTest(name = "{0} should be valid")
    @ValueSource(strings = [
        "0403123456",
        "+61403123456",
        "04 03 123456",
        "+61-403-123456",
        "+61403123aaa",
        "(+61)403123456"
    ])
    @DisplayName("Phone Number Validation")
    fun isValid(input: String) {
        val factory = Validation.buildDefaultValidatorFactory()
        val validator = factory.validator

        validator.validate(PhoneNumber(input))
    }

    @ParameterizedTest(name = "{0} should be valid")
    @CsvSource(value = [
        "0403123456,      +61403123456",
        "+61403123456,    +61403123456",
        "04 03 123456,    +61403123456",
        "+61-403-123456,  +61403123456",
        "(+61)403123456,  +61403123456"
    ])
    @DisplayName("Phone Number Formatting")
    fun format(input: String, expected: String) {
        val formatted = PhoneNumber(input).formatPhoneNumber()

        assertEquals(expected, formatted)
    }
}