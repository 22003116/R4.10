package edu.spring.td2.controller

import edu.spring.td2.repositories.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/orgas/")
class OrgaController {

    @Autowired
    lateinit var orgaRepository: OrganizationRepository

    @RequestMapping(path = ["", "index"])
    fun indexAction(model:ModelMap):String{
        model["Orgas"]=orgaRepository.findAll()
        return "/orgas/index"
    }
}