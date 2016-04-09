import math._
import collection.mutable.ArrayBuffer
import io.StdIn._
object HelloWorld {
	def main(args: Array[String]) : Unit = {
		//a.func(b) can be written as "a func b"
		println(1 to 10)

		//Assignment based on evaluation of block
		//If assignment towards the end of block then Unit type is returned
		val experiment = {val x = 10; val y = 20; y * x + x}
		println(experiment)

		//Use C type printf
		//User array argument
		if (args.length > 0) 
			printf("Hello %s!\n", args(0))
		else
			println("Hello unkown user!")
		
		//Take user input
		val name = readLine("Your name: ")
		print("Age: ")
		val age = readInt()
		printf("%s is %d years old\n", name, age)

		funWithArrays
	}

	def funWithArrays : Unit = {
		var myArray = new ArrayBuffer[Int]()
		myArray += 1
		myArray ++= ArrayBuffer(2, 3, 4, 5, 6)
		myArray ++= ArrayBuffer(11, 15, 18)

		for(i <- 0 until myArray.length) {
			println("Element: " + myArray(i))
		}
	}
}