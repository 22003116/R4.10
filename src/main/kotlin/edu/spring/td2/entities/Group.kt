package edu.spring.td2.entities

import jakarta.persistence.*

@Entity
class Group {@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int?=null

    @Column(length = 30)
    open var name:String?=null

    @Column(length = 30)
    open var email:String?=null

    @Column(nullable = false, unique = true)
    open lateinit var aliases:String

    @ManyToOne
    @JoinColumn(name = "idOrganisation",nullable = false)
    open lateinit var organization: Organization

    @ManyToMany(mappedBy = "groups")
    open val users = mutableSetOf<User>()
}