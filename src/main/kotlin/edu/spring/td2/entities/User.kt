package edu.spring.td2.entities

import jakarta.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int?=null

    @Column(length = 30)
    open var firstname:String?=null

    @Column(length = 30)
    open var lastname:String?=null

    @Column(nullable = false, unique = true)
    open lateinit var email: String

    @Column(nullable = false)
    open lateinit var password:String

    open var suspended:Boolean=false

    @ManyToOne
    @JoinColumn(name = "idOrganisation",nullable = false)
    open lateinit var organization: Organization

    @ManyToMany
    @JoinTable(name = "user_group")
    open var groups = mutableSetOf<Group>()
}