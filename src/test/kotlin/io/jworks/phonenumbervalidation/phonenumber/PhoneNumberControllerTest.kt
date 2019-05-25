package io.jworks.phonenumbervalidation.phonenumber

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(SpringExtension::class)
@WebAppConfiguration
@ContextConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhoneNumberControllerTest {

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    internal fun setup() {

        this.mockMvc = MockMvcBuilders
                .standaloneSetup(PhoneNumberController())
                .build()
    }

    @Test
    internal fun validInput() {
        mockMvc.perform(
                post("/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
{
	"name": "Erik",
	"phoneNumber": "+61403123456"
}""")
        ).andExpect(status().isOk)
    }

    @Test
    internal fun invalidInput() {
        mockMvc.perform(
                post("/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
{
	"name": "Erik",
	"phoneNumber": "0000"
}""")
        ).andExpect(status().isBadRequest)
    }

}