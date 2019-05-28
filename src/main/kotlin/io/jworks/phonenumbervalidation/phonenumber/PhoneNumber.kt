package io.jworks.phonenumbervalidation.phonenumber

import com.google.i18n.phonenumbers.PhoneNumberUtil

data class PhoneNumber(
        @field:PhoneNumberConstraint
        val phoneNumber: String
) {
        fun formatPhoneNumber(): String {
                val instance = PhoneNumberUtil.getInstance()
                val number = instance.parse(phoneNumber, "AU")
                return instance.format(number, PhoneNumberUtil.PhoneNumberFormat.E164)
        }
}
