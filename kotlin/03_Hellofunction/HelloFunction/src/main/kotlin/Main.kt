fun main(args: Array<String>) {
  // printtext("Paween")
 //  println("the area is "+circlearea(1.0).toString())
//println("the area is ${circlearea(1.0)}")
var T:String?=null
  // T="hello"
    /*
    if(T!=null) {
        println(T.length)
    }else{
        println("no data")
    }
     */
  println( T?.length?:"no data")
  println(T!!.length)
}
/*
fun circlearea(r:Double):Double{
    var area=Math.PI*r*r
    return area
}*/

fun circlearea(r:Double)=Math.PI*r*r
fun printtext(name:String){
    println("The name is $name")
}