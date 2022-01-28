package kz.sunlab.demo.entity

import kz.sunlab.demo.model.User
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name ="USERS")
class UserEntity (
    @Column
    var name: String? = null,
    @Column
    var age: Int? = null,
    @Column
    var email: String? = null,
) : BaseEntity() {
    fun toUser() = User(
        id = id,
        name = name,
        age = age,
        email = email
    )
}