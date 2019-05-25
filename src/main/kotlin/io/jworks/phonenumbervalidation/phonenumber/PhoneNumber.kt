package io.jworks.phonenumbervalidation.phonenumber

import com.google.i18n.phonenumbers.PhoneNumberUtil
import javax.validation.constraints.Size

data class PhoneNumber(
        @field:PhoneNumberConstraint
        val phoneNumber: String,

        @field:Size(min = 2, max = 40)
        val name: String
) {
        fun formatPhoneNumber(): String {
                val instance = PhoneNumberUtil.getInstance()
                val number = instance.parse(phoneNumber, "AU")
                return instance.format(number, PhoneNumberUtil.PhoneNumberFormat.E164)
        }
}
