package c;

public abstract class Vehicle implements Navigator{

		protected int number;
		protected int point;
		

		public Vehicle(int number) {
			super();
			this.number = number;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
		
		public abstract void drive() ;
		
		
}
