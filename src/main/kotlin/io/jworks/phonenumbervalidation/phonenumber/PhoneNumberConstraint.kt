package io.jworks.phonenumbervalidation.phonenumber

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Constraint(validatedBy = [PhoneNumberValidator::class])
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class PhoneNumberConstraint(
        val message: String = "Invalid phone number",

        val groups: Array<KClass<*>> = [],

        val payload: Array<KClass<out Payload>> = []
)