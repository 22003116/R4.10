package edu.spring.td1.models

data class Categorie(var label: String) {
    private var items:ArrayList<Item> = ArrayList<Item>()

    fun getItems(): ArrayList<Item> {
        return items
    }
    fun add(value: String) {
        items.add(Item(value))
    }
    fun remove(value: String) {
        items.remove(Item(value))
    }
    fun clear() {
        items.clear()
    }
    fun modify(value:String) {
        label = value
    }
}