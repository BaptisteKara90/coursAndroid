package fr.eni.ecole.mod1demo1

//fun main() {
//    println("Hello World !")
//
//    //Déclaration de variable
//
//    var name: String? = null; // ? : représente la possibilité d'être null
//    // name = 10 pas possible
//    name = "Michel"
//
//    //Constante
//    val COFFEE: String
//    COFFEE = "Café ?"
//    //COFFEE = "Thé ?" pas possible car constante
//
//};

/*
fun main(){

    var null1 : String? = null
    var null2 = null

    println(null1?.length ?: "PAS DE TAILLE") // Operateur Elvis, si c'est null alors on passe le string, sinon on met le length de la variable
    println(null2)


}*/

/*fun main(){

    var world = "world"

    val message by lazy { "Hello $world"}

    println(message) // instancie la constante via le premier println donc le deuxième plus bas va prendre "world" aussi.

    world = "man !"

    println(message)
}*/


//CONDITION
/*fun main(){

    val AGE = 18

    val message = if(AGE >= 18) "MAJEUR" else "MINEUR"

    println(message)

    when(AGE){
        0,1,2 -> println("c'est un bébé !")
        in 3..17 -> println("c'est un mineur !")
        is Int -> println("MAJEUR !")
        else -> println ("Chef?")
    }

}*/

//BOUCLE
/*fun main(){
    val powers = listOf("fly", "invisible", "strength", "Pyrokinesy")

    for (power in powers){
        println(power)
    }

    for(i in 0..< powers.size){
        println(powers[i]) //powers.get(i)
    }

    for(j in 10 downTo 0 step 2){
        println(j)
    }
}*/


//Function
fun main() {

    val articles = List(30){id ->
        /*"Article $it"*/
        "Article $id"
    }

    val colors = mutableListOf<String>()
    colors.add("cornFlowerBlue")
    colors += "yellow"
    colors += "red"
    colors += "yellow"

    var nbColor = colors.filter { it == "yellow" }.count()
    println(nbColor)

    fun String.sayHello(){
        println("Hello $this")
    }

    "Michel".sayHello()

}



