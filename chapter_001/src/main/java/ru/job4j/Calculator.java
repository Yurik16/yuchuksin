package job4j.ru;
/**
* Calculator class
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since  14.01.2017
*/

public class Calculator {
		private double result;	
		/**
		* Add method calculate addition of two arguments
		* @params first, second inners parametors of that method
		*/
		public void add(double first, double second) {
			this.result = first + second;
		}
		/**
		* Substruct method calculate substruction of two arguments
		* @params first, second inners parametors of that method
		*/
		public void substruct(double first, double second) {
			this.result = first - second;
		}
		/**
		* Div method calculate division of two arguments
		* @params first, second inners parametors of that method
		*/
		public void div(double first, double second) {
			this.result = first / second;
		}
		/**
		* multiple method calculate multiplication of two arguments
		* @params first, second inners parametors of that method
		*/
		public void multiple(double first, double second) {
			this.result = first * second;
		}
		/**
		* GetResult method calculate division of two arguments
		* @params args
		*/
		public double getResult() {
			return result;
		}
} 