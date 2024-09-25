package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
//		
		System.out.println("====== TEST 1: department findById ========");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n===== TEST 2: department findAll ========");
		List<Department> list = departmentDao.findAll();
		
		for (Department d: list) {
			System.out.println(d);
		}
		
		System.out.println("\n======= TEST 3: department insert ==========");
		Department newdepartment = new Department(null , "music");
		departmentDao.insert(newdepartment);
		System.out.println("Inserted! new id = " + newdepartment.getId());
		
		System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: seller DELETE ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complete!");
		
		sc.close();
		
	}

}
