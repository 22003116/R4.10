package edu.spring.td2.entities

import jakarta.persistence.*

@Entity
class Organization {
    @Id
    @GeneratedValue
    var id:Int?=null

    @Column(nullable = false,unique = true, length = 45)
    lateinit var name:String

    @Column(length = 45)
    var domain:String?=null

    @Column(length = 30)
    open var aliases:String?=null

    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    open val Users = mutableSetOf<User>()

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    open val Groups = mutableSetOf<Group>()
}