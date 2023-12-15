open class Line(var width:Double ){
init { println("Line was created")}
fun printwidth(){ println("The width of this line is $width")   }
}
open class Square(var swidth:Double):Line(swidth){
    init { println("Square was created")}
open fun area(){println("the area of this square is ${width*width}")}
}
class Circle(var redius:Double):Square(redius){
    init { println("Circle was created")}
 override fun area(){println("the area of this square is ${width*width*Math.PI}")}
}
open class Rectangle(var w:Double,var height:Double):Square(w){
    init { println("rectangle was created")}
 fun printheight(){println("The height of this rectangle is $height")}
 override fun area(){println("the area of this rectangle is ${width*height}")}
}
class Any(var aw:Double,var ah:Double):Rectangle(aw,ah){
 fun findanyarea(area:findareaforAny){ area.findarea(width,height)}
}
interface findareaforAny{
    fun findarea(w:Double,h:Double){}
}
class AnyLamda(var aw:Double,var ah:Double):Rectangle(aw,ah) {
   fun findanyarea(area:(w:Double,h:Double)->Unit){
       area(width,height)
   }
}
fun main(args: Array<String>) {
val A2=AnyLamda(2.0,4.0);A2.printwidth();A2.printheight()
 A2.findanyarea { w, h -> println("The area of this diamond is ${w*h*0.5}")  }
    /*
val A1=Any(2.0,4.0);A1.printwidth();A1.printheight()
A1.findanyarea(object:findareaforAny{
    override fun findarea(w: Double, h: Double) {
        super.findarea(w, h)
      println("the area for this diamond is ${w*h*0.5}")
    }
})*/
//   var R1=Rectangle(10.0,20.0);R1.printwidth();R1.printheight();R1.area()
//val Line1=Line(10.0);Line1.printwidth()
//val Sq1=Square(20.0);Sq1.printwidth();Sq1.area()
 //   val C1=Circle(3.0);C1.printwidth();C1.area()
}
