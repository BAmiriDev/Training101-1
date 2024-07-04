//Seq
val seq1: Seq[Int] = Seq(1, 2, 3)
//List
val list1: List[Int] = List(1, 2, 3)
//Map
//key value pairs : key -> value
val map1: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

val getSeqData: Int = seq1(1)
val getSeqData: Int = seq1.head
// tail will give everything but the first element
val getSeqTail = seq1.tail

val getListData: Int = list1(1)
val getListhead: Int = list1.head
val getListtail: List[Int] = list1.tail

val getMapData = map1("one")

val tripleSeq: Seq[Int] = seq1.map {
  number => number * 3
}

val tripleList: List[Int] = list1.map {
  con => con * 3
}

val tripleMap: Map[String, Int] = map1.map {
  case (key, value) => (key, value * 3)
}

val changeKey: Map[String, Int] = map1.map {
  case (key, value) => (key + "s", value)
}

val changeKeyAndValue: Map[String, Int] = map1.map {
  case (key, value) => (key + "s", value * 3)
}

//filter
val filteredseq: Seq[Int] = seq1.filter {
  num1 => num1 > 1
}

val filteredseq1: List[Int] = list1.filter {
  num1 => num1 > 1
}


//tuple = [String, Int]
filteredseq1 == filteredseq
val filteredMap: Map[String, Int] = {
  map1.filter(number => number._2 > 1)
}
// works like logical not
val filterNotList: List[Int] = {
  list1.filterNot(number => number >= 2)
}

//Exists
// Boolean
val listexists: Boolean = list1.exists {
  number => number > 9
}
val seqtexists: Boolean = seq1.exists {
  number => number > 9
}
val mapexists: Boolean = map1.exists {
  number => number._2 > 2
}

//Contains
//Check for 1 param
val containSeq: Boolean = seq1.contains(100)
val containList: Boolean = list1.contains(1)
val containMap: Boolean = map1.contains("two")

val seqNames: Seq[String] = Seq("bilal", "anthony", "jamie", "joe", "rosh", "mo", "spenc", "arei", "tom", "tay")
val map2: Map[Int, String] = Map(1 -> "red", 2 -> "yellow", 3 -> "blue", 4 -> "green")
val getMap = map2(4)


val addOne: Map[Int, String] = map2.map {
  case (key, value) => (key + 1, value)
}

val filteredMap: Map[Int, String] = map2.filter {
  case (key, _) => key % 2 != 0
}

val filteredSequ: Seq[String] = seqNames.filterNot{
  name => name.contains("r")
}

val testSet: Set[Int] = Set(1,2,3,4,5,5)



//Arrays
val array1: Array[Int] = Array(1,2,3)
val plusTwo: Array[Int] = array1.map{
  _ + 2
}

var x = Seq[Int]()
x :+= 1

val y = Seq(3,4,5)
// 6 -> Seq(3,4,5,6)

val y = Seq(3, 4, 5)
val y1 = y :+ 6
val y1 = y :+ Seq(6,7)
val y2 =  2 +: y
val y1 = y ++ Seq(6,7)
val w = Seq(1,2) ++ y
val o = 2 +: y

