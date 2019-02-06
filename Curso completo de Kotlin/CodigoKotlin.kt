
//Interface
interface Presidente{
    fun ganharEleicao()
}
interface Pai{
    fun temFilho()
}
open class Cidadao{
    fun direitosDeveres()
    {
        println("Todo cidadao tem direitos e deveres!")
    }
}
class Obama:Cidadao(), Presidente, Pai{
    override fun ganharEleicao(){
        println("Ganhar Eleicao nos EUA")
    }
    override fun temFilho(){
        println("Tem filho")
    }
}
class Isaque:Cidadao(), Presidente{
	override fun ganharEleicao(){
        println("Ganhar Eleicao no Brasil")
    }
}
////NullSafe
class naruto{
    var texto:String = "jorge"
    //println(texto)
}
////Controles de fluxo
/*valclass Fluxo{
    var num1 = 2
    var num2 = 3
    if(num1 == num2)
    {
       println(true) 
    }
}*/
open class Bicho{
    //private - protected, public
    protected var nome = "Marley"
    fun dormir(){
        println("Dormir")
    } 
}
class Cachorro:Bicho(){
    fun exibirNome(){
        println("Método exite nome: $nome")
    }
}
//Herança
open class Animal{
    open fun dormir(){
        println("Dormir")
    } 
}
class Cao:Animal(){
 	 override fun dormir(){
        super.dormir()
        println("como um cão")
     }	
     fun latir(){
        println("latir")
     }
}
class Passaro:Animal(){
     override fun dormir(){
        println("como um passáro")
     }	
}
//Construtores
class CasaConstrutor/*( var cor: String, va:Animal()r vagasGaragem: Int )*/ {
    
    //Propriedades
    
    var cor: String
    var vagasGaragem: Int
    
    constructor( cor: String, vagasGaragem: Int  ){
        this.cor = cor
        this.vagasGaragem = vagasGaragem
    }
    
    /*
    init{
       this.cor = cor
        this.vagasGaragem = vagasGaragem
    }
    */
    
    //Métodos
    fun detalhesCasa(){
        println("A casa tem a cor: $cor, vagas: $vagasGaragem ")
    }
    
    fun abrirJanela(qtdJanelas: Int){
        println("Abrir janela total: $qtdJanelas ")
    }
    
    fun abrirPorta(){
        println("Abrir porta")
    }
    
    fun abrirCasa(){
        //this.abrirJanela()
        this.abrirPorta()
    }
    
}
//Classes
class Casa
{
    //Propriedades
    var cor:String = ""
    var vagasGaragem: Int = 0
    //Metodos
    fun detalhesCasa(){
    	//println()
    }
    fun abrirJanela(quant: Int){
        println("Abrir Janela: " + quant.toString())
    }
    fun abrirPorta()
    {
        println("Abrir porta")
    }
    fun abrirCasa(){
        this.abrirJanela(2)
        this.abrirPorta()
    }
}
fun main() {
    //number(10)
    //var num = somar(1,2)
    //println(num)
    //val casa = Casa()
    //casa.cor = "azul"
    //casa.abrirJanela(2)
    //val casaContruida = CasaConstutor("azul", 3)
    //casaContruida.Imprimir()
    //val casaConstrutor = CasaConstrutor("azul", 3);
    //casaConstrutor.detalhesCasa()
    //val cao = Cao()
    //cao.dormir()
    //val bicho = Bicho()
    //println(bicho.nome)
    //val cachorro = Cachorro()
    //cachorro.exibirNome()
    /*var num1 = 3
    when(num1)
    {
       1 -> println("1")
       2 -> println("2")
       3,4 -> println("3 ou 4")
       else -> println("Nd")
    }
    //Nullsafe
    var texto:String? = null
    //texto = "jj"
    println(texto?.length)*/
    /*val postagens = arrayOf("um um", "dois dois", "tres tres")
    for(numero in 1..5)
    {
        println(numero)
    }
    for(postagem in postagens){
        println(postagem)
    }
    for((indice, postagem) in postagens.withIndex()){
        println("$indice - $postagem")
    }*/
    /*val isaque = Isaque()
    isaque.direitosDeveres()
    isaque.ganharEleicao()*/
    /*var listaItens = listOf("RJ", "SP", "MG") //Imutavel
    println(listaItens)
    var arrayListItens = arrayListOf("RJ", "SP", "MG")//Mutavel
    arrayListItens.add("PE")
    arrayListItens.remove("RJ")
    println(arrayListItens)*/
    //Set
    //var itens = hashSetOf("a", "b", "c", "c", "d")
    /*var itens = hashSetOf(10,20,30,50,70)
    for(item in itens)
    {
        println(item)
    }
    println(itens)
    var map = hashMapOf("urso" to "Animal que hiberna", "cao" to "Animal que late")
    map.put("passaro", "Animal que voa")
    map.remove("passaro")
    for(itemmap in map.values){
        println(itemmap)
    }*/
    val pedido = Pedido()
    pedido.status = StatusPedido.APROVADO
    if(pedido.status == StatusPedido.PROCESSANDO){
        println("Pedido está sendo processado")
    }else if(pedido.status == StatusPedido.APROVADO){
        println("Pedido foi aprovado!")
    }
}
//Enum
enum class StatusPedido
{
    PROCESSANDO, APROVADO, REPROVADO
}
class Pedido{
    var status: StatusPedido = StatusPedido.PROCESSANDO
}
//array
fun number(num: Int)
{
    var array = arrayOf(1,2,3,4,5,6,7,8,9,10)
    var i = 1
	while(i <= num){
        var j = 0
        while(j < array.size)
        {
            println(i*array[j])
            j++
        }
        i++
    }
}
//Funcao que retorna valor
fun somar(numero1: Int, numero2: Int): Int
{
    var total = numero1+numero2
    return total
}
