import java.io.*;
import java.util.*;

public class SerializationExample {

	// deserialize to Object from given file
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}

	public static void main(String[] args) {
		String fileName = "employee.txt";
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Kishan");
		//emp.setSalary(5000);
		
//		// serialize to file
//		try {
//			SerializationExample.serialize(emp, fileName);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return;
//		}
		
		//deserialize to file
		Employee empNew = null;
		try {
			empNew = (Employee) SerializationExample.deserialize(fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("emp Object:: "+emp);
//		System.out.println(list);
		//System.out.println(result);
		System.out.println("empNew Object:: "+empNew);

	}

}
class Employee implements Serializable {
	
	private static final long serialVersionUID = 5604395347890253261L;
	private String name;
	private int id;
	//transient private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getSalary() {
//		return salary;
//	}
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" +  "]";
	}

}