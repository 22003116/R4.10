package edu.spring.td2.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

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
    var aliases:String?=null
}