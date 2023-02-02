package com.spring.td1.controllers

import com.spring.td1.models.Item
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ItemController {
    @get:ModelAttribute("Items")
    val items: Set<Item>
        get() {
            val elements = HashSet<Item>()
            elements.add(Item("foo"))
            return elements
        }

    @RequestMapping("/")
    fun indexAction():String{
        return "index"
    }
}