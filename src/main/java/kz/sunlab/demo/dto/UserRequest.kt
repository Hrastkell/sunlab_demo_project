package kz.sunlab.demo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kz.sunlab.demo.model.User

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserRequest (
    @JsonProperty("user_name")
    var name: String? = null,
    @JsonProperty("user_age")
    var age: Int = 0,
    @JsonProperty("user_email")
    var email: String? = null
) {
    fun toUser() = User(
        name = name,
        age = age,
        email = email
    )
}