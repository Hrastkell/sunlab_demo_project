package kz.sunlab.demo.model

import kz.sunlab.demo.entity.UserEntity

data class User (
    var id: Long? = null,
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null
) {
    fun toUserEntity() = UserEntity(
        name = name,
        age = age,
        email = email
    )
}