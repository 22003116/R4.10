package edu.spring.td1.controllers

import edu.spring.td1.models.Item
import edu.spring.td1.services.UIMessage
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

@Controller
@SessionAttributes("items")
class ItemsController {
    @get:ModelAttribute("items")
    val items : Set<Item>
        get(){
            var elements = HashSet<Item>()
            elements.add(Item("Foo"))
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
            @ModelAttribute item:Item,
            @SessionAttribute("items") items:HashSet<Item>,
            attrs:RedirectAttributes
    ): RedirectView {
        var msg:UIMessage.Message
        if(items.add(item)) {
            msg = UIMessage.success("Ajout", "${item.nom} ajouté aux items.")
        }else{
            msg = UIMessage.error("Ajout", "L'item ${item.nom} existe déjà !")
        }
        attrs.addFlashAttribute("msg",msg)
        return RedirectView("/")
    }

    @GetMapping("/delete/{nom}")
    fun deleteAction(
            @PathVariable("nom") nom:String,
            @SessionAttribute("items") items:HashSet<Item>,
            attrs: RedirectAttributes
    ):RedirectView{
        if(items.remove(Item(nom))){
            attrs.addFlashAttribute("msg",
            UIMessage.success("Suppression","$nom supprime."))
        }
        return RedirectView("/")
    }
}