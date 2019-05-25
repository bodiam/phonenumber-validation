package io.jworks.phonenumbervalidation.phonenumber

import com.google.i18n.phonenumbers.PhoneNumberUtil
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


class PhoneNumberValidator : ConstraintValidator<PhoneNumberConstraint, String> {

    private var phoneUtil = PhoneNumberUtil.getInstance()

    override fun initialize(phoneNumber: PhoneNumberConstraint?) {}

    override fun isValid(phoneNumber: String?,
                         cxt: ConstraintValidatorContext): Boolean {

        val auPhoneNumber = phoneUtil.parse(phoneNumber, "AU")

        return phoneUtil.isPossibleNumber(auPhoneNumber)
    }

}