package ru.job4j;
/**
* Calculator class.
* @author Yury Chuksin (chuksin.yury@gmail.com)
* @since  14.01.2017
*/
public class Calculator {
		/**
		* result stores the result of the methods.
		*/
		private double result;
		/**
		* Add method calculate addition of two arguments.
		* @param first inner parametor of this method
		* @param second inner parametor of this method
		*/
		public void add(double first, double second) {
			this.result = first + second;
		}
		/**
		* Substruct method calculate substruction of two arguments.
		* @param first inner parametor of this method
		* @param second inner parametor of this method
		*/
		public void substruct(double first, double second) {
			this.result = first - second;
		}
		/**
		* Div method calculate division of two arguments.
		* @param first inner parametor of this method
		* @param second inner parametor of this method
		*/
		public void div(double first, double second) {
			this.result = first / second;
		}
		/**
		* multiple method calculate multiplication of two arguments.
		* @param first inner parametor of this method
		* @param second inner parametor of this method
		*/
		public void multiple(double first, double second) {
			this.result = first * second;
		}
		/**
		* Getter method.
		* @return result returns value of private parametor "result"
		*/
		public double getResult() {
			return result;
		}
}