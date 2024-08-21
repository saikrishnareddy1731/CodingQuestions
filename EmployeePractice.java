package com.test;

import java.awt.print.Printable;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeePractice {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<Employee>();
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		emp.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		emp.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		emp.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		emp.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		emp.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		emp.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		emp.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		emp.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		emp.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		emp.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		emp.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		emp.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		emp.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		emp.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		emp.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		emp.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		emp.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// 1..entrySet(): The result of the collect operation is a Map where the keys
		// are the genders and the values are the counts. The entrySet method returns a
		// set of Map.Entry objects, each of which represents a key-value pair in the
		// map.
		// here count of each element happened right so , we used collect
		// collect(): This is a collector that performs a grouping and a counting
		// operation.
		// Collectors.counting() For each group (each gender), this counts the number of
		// elements in that group.
		// Method Reference: System.out::println is a method reference. It refers to the
		// println method of the PrintStream class (which System.out is an instance of).
		System.out.println(">> genders and print the count  :.");
		emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet()
				.forEach(System.out::println);

		// 2. Transforms each employee into their department, removes duplicates, and
		// prints each unique department.
		System.out.println(">> print all the department names in the organization sai: ");
		emp.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// 3.
		System.out.println(">> getAge the average of males and females sai");
		emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)))
				.entrySet().forEach(System.out::println);

		// 4.ifPresent: This is a method of the Optional class. The max method returns
		// an Optional<Employee> because there might be no employees in the stream.
		System.out.println(">> Get the details of highest paid employee in the organization?");
		emp.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

		// 5.
		System.out.println(">> Get the names of all employees who have joined after 2015?");
		emp.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

		// 6.
		System.out.println(">> Count the number of employees in each department?");
		emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet()
				.forEach(System.out::println);
		// 7
		System.out.println(">> What is the average salary of each department?");
		emp.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().forEach(System.out::println);

		// 8
		System.out.println(">> Get the details of youngest male employee in the product development department?");
		emp.stream().filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparing(Employee::getName)).ifPresent(System.out::println);

		// 9.
		System.out.println(">> Who has the most working experience in the organization?");
		emp.stream().min(Comparator.comparing(Employee::getYearOfJoining)).ifPresent(System.out::println);

		// 10.
		System.out.println(">> How many male and female employees are there in the sales and marketing team?");
		emp.stream().filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet()
				.forEach(System.out::println);

		// 11
		System.out.println(">> What is the average salary of male and female employees?");
		emp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().forEach(System.out::println);

		// 12
		System.out.println(">> List down the names of all employees in each department?");
		emp.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((k, v) -> {
			System.out.println("Department:" + k);
			for (Employee e : v) {
				System.out.println(e.getName());
			}
		});

		// 13
		System.out.println(
				">> Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
		Map<Boolean, List<Employee>> partition = emp.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

		partition.forEach((k, v) -> {
			if (k) {
				System.out.println("Greater than 25");
			} else {
				System.out.println("Lesser than 25");
			}

			for (Employee ep : v) {
				System.out.println(ep.getName());
			}
		});

		// 14
		System.out.println(
				">> Who is the oldest employee in the organization? What is his age and which department he belongs to?");
		emp.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(m -> {
			System.out.println("Name : " + m.getName());
			System.out.println("Age : " + m.getAge());
			System.out.println("Department : " + m.getDepartment());
		});

		// 15
		System.out.println(">> Find the third heighest Salary");
		emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(2).findFirst()
				.ifPresent(System.out::println);

		// 16
		System.out.println(">> Find the employee having more than 30000 salary");
		emp.stream().filter(e -> e.getSalary() > 30000).map(Employee::getName).forEach(System.out::println);

		// 17
		System.out.println(">> Having the heighest salary");
		emp.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

		// 18
		System.out.println(">> list of integers, separate odd and even numbers");
		Map<Boolean, List<Integer>> evenOrOdd = listOfIntegers.stream()
				.collect(Collectors.partitioningBy(p -> p % 2 == 0));
		evenOrOdd.forEach((k, v) -> {
			if (k) {
				System.out.println("Even Numbers");
			} else {
				System.out.println("Odd Number:");
			}
			for (Integer num : v) {
				System.out.println(num);
			}

		});

		// 19
		System.out.println("Remove duplicate elements from a list using Java 8 streams");
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		List<String> listOfUnique = listOfStrings.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique Elements :" + listOfUnique);

		// 20.How do you find frequency of each character in a string using Java 8
		// streams?
		System.out.println("frequency of each character in a string using Java 8 streams");
		String inputString = "Java Concept Of The Day";
		inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.forEach(System.out::println);

	}

//	public void exmaple() {
//		List<Employee> employeeList = new ArrayList<Employee>();
//
//		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
//		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
//		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
//		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
//		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
//		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
//		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
//		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
//		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
//		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
//		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
//		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
//		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
//		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
//		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
//		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
//		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
//
//		}
}
