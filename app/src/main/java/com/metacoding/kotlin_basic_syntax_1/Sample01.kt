package com.metacoding.kotlin_basic_syntax_1

//엔트리 함수, 처음 시작하는 포인트가 main함수이다.
fun main(){
    //1. 함수
    helloWorld()
    println(add(1,28))

    //2. val과 var

    //3. String Template
    val name = "Ha Eun"
    val lastName = "Jo"
    println("my name is ${name + lastName}. I'm 22")

    //+ 주석 단축키 : ctrl (cmd) + /

    //4. 조건식
    var result = whatIsMax(4,8)
    println("whatIsMax : max is ${result}")

    result = whatIsMax2(15,63)
    println("whatIsMax2 : max is ${result}")

    checkNum(70)

    //6.for, while
    forAndWhile()

    //7. null
    nullCheck()


}
//1. 함수를 만드는 방법

// 1)리턴값 x, 파라미터 x
fun helloWorld() : Unit{// Unit은 void와 똑같다

    println("Hello World!")
}

// 2) 리턴값 o, 파라미터 o
fun add(num1 : Int,num2 : Int) : Int {

    return ( num1 + num2 )
}

//2. val과 var의 차이


//4. 조건식 - if

//1)번 방법
fun whatIsMax(a : Int, b : Int) : Int{
    if(a > b){

        return a
    }else{

        return b
    }
}

//2)번 방법
fun whatIsMax2(a : Int, b : Int) = if( a > b) a else b

//5. 조건식 when
// 1)번 방법
fun checkNum(score : Int){
    when(score) {

        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't know")//else안써줘도 됨

    }
    // 2)번 방법
    var data2 = when(score){

        1->1//score가 1이면 data2에 1 리턴
        2->2//score가 2이면 data2에 2 리턴
        else -> 3 //이 때는 else 꼭 써줘야 함

    }

    var grade = when(score){
        in 90..100 -> "A"
        in 80 until 90 ->"B"
        in 70 until 80 ->"C"
        else -> "재수강"
    }
    println("당신은 ${grade}입니다.")

}

//5. Array and List
//Array : 기본적으로 크기가 정해져 있다.
//List ->(List와 mutableList로 분류) -> List: 수정이 불가능, mutableList :수정가능

// 1) Array
fun array(){
    val array = arrayOf(1,2,3)


    //array는 mutable이다 -> 값 변경이 가능하다
    array[0] = 3
    // 2 - 1) List
//listOf : 리스트를 초기화 해주는 것
    val list = listOf(1,"a",3.14f)//이 때 list는 any타입으로 지정된다.

//값을 변경 못하는 '읽기 전용'이다.
//list[0] = 2 -> 안됨

//가져오는 건 가능하다
    var result = list.get(0)//list는 interface이다.

// 2 - 2) mmutableList -> arrayList/
//   a) arrayList

//arrayList의 초기화
    var arrayList = arrayListOf<Int>()
    arrayList.add(10) // arrayList에 10 추가하기
    arrayList.add(32)
}

//6. 반복문 - for/while

fun forAndWhile(){
    val students = arrayListOf("jehhy", "lisa", "taylor")

    for(name in students){//students 배열이 끝날 때까지 name에 담아가며 for문을 돌음
        println("${name}")
    }

    var sum = 0
    for(i in 1..10){//1부터 10까지 돌려봐라
        sum += i
    }
    println("${sum}")

    for(i in 1..10 step 2){//1부터 10까지 2씩 증가하며 돌려봐라
        println("${i}")
    }

    for(i in 10 downTo 1 step 2){//10부터 1까지 2씩 감소하며 돌려봐라
        println("${i}")
    }

    for(i in 1 until 10){//1부터 10까지 2씩 증가하며 돌려봐라
        println("${i}")
    }

    //while문은 그냥 똑같음
    var index =0;
    while(index < 10){
        println("${index}")
        index++
    }

    //for문을 사용해 인덱스와 배열요소를 같이 출력하고 싶은 경우
    for((index,name) in students.withIndex()){
        println("${index+1}번째 학생은 ${name}입니다.")
    }
}

fun nullCheck(){
    var name = "Ha eun"
    var nullName : String? = null

    var nameInUpperCase = name.toUpperCase()
    var nullNameInUpperCase = nullName?.toUpperCase()

    println("${nameInUpperCase}")
    println("${nullNameInUpperCase}")

    //?:
    var lastName : String ? = null
    var fullName = name + " " + (lastName?:"잘못된 lastName입니다. null값이 존재합니다.")
    println("${fullName}")

    //!! :컴파일러에게 null이 아니라고 말해줄 때 사용하는 것이다.
}

fun ignoreNulls(str : String?){//확실하게 null이 아닌게 아니라면 !!는 쓰는걸 지양하자
    val mNotNull : String = str!!//null이 들어올 수도 있어서 원래 이렇게 쓰면 안되지만 !!를 붙여주면 사용할 수 있다.
    val upper = mNotNull.toUpperCase()

    val email :String? = "hani921@naver.com"

    //email이 null이 아니라면 email을 출력한다. -> safe하다!
    email?.let{
        println("my email is ${it}")
    }

}




