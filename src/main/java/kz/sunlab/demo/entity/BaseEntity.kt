package kz.sunlab.demo.entity

import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    var id: Long? = null
}