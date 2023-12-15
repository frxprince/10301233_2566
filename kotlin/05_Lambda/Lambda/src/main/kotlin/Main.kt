fun Sum1(a:Int ,b:Int):Int{
  return a+b
}

fun EachItem(x:List<Int>,actionX:(Int)->Unit){
  for(i in x){
    actionX(i)
  }
}


fun main(args: Array<String>) {
val H= listOf<Int>(1,2,3,4,5,6,11,23,15)
EachItem(H,{k->println("Hello $k")})
//println(Sum1(5,6))
//val Sum2:(Int,Int)->Int={i:Int,j:Int->i+j}
//println(Sum2(5,6))
}