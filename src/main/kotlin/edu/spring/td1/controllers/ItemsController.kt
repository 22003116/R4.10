package edu.spring.td1.controllers

import edu.spring.td1.models.Categorie
import edu.spring.td1.services.UIMessage
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

@Controller
@SessionAttributes("categories")
class categoriesController {
    @get:ModelAttribute("categories")
    val categories : Set<Categorie>
        get(){
            var elements = HashSet<Categorie>()
            elements.add(Categorie("Amis"))
            elements.add(Categorie("Famille"))
            elements.add(Categorie("Professionnels"))
            return elements
        }

    @RequestMapping("/")
    fun indexAction(
            @RequestAttribute("msg") msg:UIMessage.Message?
    ): String{
        return "index"
    }

    @GetMapping("/new")
    fun newAction(): String{
        return "newForm"
    }

    @PostMapping("/addNew")
    fun addNewAction(
            @ModelAttribute Categorie:Categorie,
            @SessionAttribute("categories") categories:HashSet<Categorie>,
            attrs:RedirectAttributes
    ): RedirectView {
        var msg:UIMessage.Message
        if(categories.add(Categorie)) {
            msg = UIMessage.success("Ajout", "${Categorie.label} ajouté aux categories.")
        }else{
            msg = UIMessage.error("Ajout", "L'Categorie ${Categorie.label} existe déjà !")
        }
        attrs.addFlashAttribute("msg",msg)
        return RedirectView("/")
    }

    @GetMapping("/delete/{nom}")
    fun deleteAction(
            @PathVariable("nom") nom:String,
            @SessionAttribute("categories") categories:HashSet<Categorie>,
            attrs: RedirectAttributes
    ):RedirectView{
        if(categories.remove(Categorie(nom))){
            attrs.addFlashAttribute("msg",
            UIMessage.success("Suppression","$nom supprime."))
        }
        return RedirectView("/")
    }
}