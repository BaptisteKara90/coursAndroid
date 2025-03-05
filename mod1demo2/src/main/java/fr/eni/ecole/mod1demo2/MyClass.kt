package fr.eni.ecole.mod1demo2

class Base


open class Apero(private var _name: String, var degree : Int){

    var name : String
        get() = this._name
        set(value){
            this._name = value
        }

   open fun getCheers(cheers : String): String{
        return cheers
    }

    override fun toString(): String {
        return "Apero(name='$name', degree=$degree)"
    }
}

interface Samu{
    fun call911() : Int
    fun getSiren(): String{
        return "Pin Pon !";
    }
}

class HangOver(var headAcheLvl : Int): Apero("Happy Hour", 35), Samu{

    companion object{
        var glass = "une pinte !"
    }

    override fun getCheers(cheers: String): String {
        return cheers + " a consommer avec modération";
    }

    override fun call911(): Int {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return super.toString() + ", maux de tête potentiel de niveau = ${this.headAcheLvl}"
    }

}

fun main() {

    var mojito = Apero("Mojito", 20)
    println(mojito.getCheers("Mo mo jito"))
    println(mojito.name)

    var hangover = HangOver(8)
    println(hangover)
    println(hangover.getCheers("C'est l'happy hour !!!!"))
    println(HangOver.glass)

}