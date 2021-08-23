package b;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.sun.jdi.connect.spi.Connection;

public class Person {

		private int id;
		private String name;
		private int age;
		private static int currId = 10001;
		private static String[] names = {"avi" , "moshe", "eli" , "dalit", "dana"};
		
		public static Person getRandomPerson() {
			Person p = new Person();
			p.id = currId++;
			p.name =names[(int) (Math.random()*names.length)];
			p.age = (int) (Math.random()*121);
			return p;
			
			
			

		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
		}
		
		public static List<Person> getRandomPerson(int amount) {
			List<Person> list = new ArrayList<Person>();
			for (int i = 0; i < amount; i++) {
				list.add(getRandomPerson());
				
			}
			return list;
		}
		public static void main(String[] args) {
			List<Person> persons = getRandomPerson(200);
			String url = "jdbc:mysql://127.0.0.1:3306/db1";
			String user = "root";
			String password = "1234";
			try (Connection con = DriverManager.getConnection(url, user, password)){
				Statement stmt = con.createStatement();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}