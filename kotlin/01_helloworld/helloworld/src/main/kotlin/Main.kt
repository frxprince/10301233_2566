fun main(args: Array<String>){
/*
println("Hello")
print(" World")

val a="hello world"
val b= 1234.0
println(a)
println(b)
println(b::class.simpleName)


var c=1234
var d:Double
c=c+1
d=123456.0
println("c="+c.toString()+
        " d="+d.toString()+" a+b = "+
        (c+d).toString())
println("c=$c d=$d c+d=${c+d} ${d::class.simpleName}")
println("This \"\\n\" is for newline")
println(""" This "\n" is for newline """)
var e="""
    We’re committed to giving back to our wonderful community, which is why IntelliJ IDEA Community Edition is completely free to use

    IntelliJ IDEA Community "Edition"
    The IDE for Java and Kotlin enthusiasts
""".trimIndent()
println(e)

 val A= arrayOf("CS","MJU","Maejo")
 A[1]="XXX"
 println("${A[0]} ${A[1]} ${A[2]}  ${A.size}  ")
 var B= arrayOfNulls<String>(5)
 B[0]="a"; B[1]="b"; B[2]="c"; B[3]="d"; B[4]="e"
println("${B[0]} ${B[1]} ${B[2]} ${B[3]} ${B[4]}")
 var C= Array(20,init={ i->"CSMJU(${i+1})"})
 println("${C[0]} ${C[1]} ${C[2]} ${C[18]} ${C[19]}")
 for( (index,c) in C.withIndex()) {
  println("$index  ->  $c")
 }
 */
 var D= listOf("item1","item2","item3")
 println(D)
 var E= mutableListOf("item1","item2","item3","item3")
 E.add(2,"XXX")
 println(E)
 var F= setOf("t","n","c","d","c")
 println(F.sortedDescending())
 var G= mapOf(Pair("th",1),Pair("en",2),Pair("jp",3))
 println(G["jp"])
 var txt="""asdysdfodfogyfsdgrgioghgfgsdfuivuiscfuisdfuisdfuisduiofsdifsdyiofsdifuilsdtfysduilfuilsdf"""
var CH= mutableMapOf<Char,Int>()
 for(c in txt.toCharArray()) {
  CH.set(c,(CH?.get(c)?:0)+1)
 }
 println(CH)
}