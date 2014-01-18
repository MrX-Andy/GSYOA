package com.gsyoa.test;


import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gsyoa.entity.Department;
import com.gsyoa.service.DepartmentService;
/**
 * 部门信息
 * @author yang_小新
 * @date 2013年12月13日
 */
public class DepartmentTest {
	  private static DepartmentService departmentService;			
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				departmentService = (DepartmentService)applicationContext.getBean("departmentService");					
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 保存部门信息-测试成功
		 */
	@Test
	public void testSaveDepartment() {
		
		Department department=new Department();
		department.setName("技术部");
		
		departmentService.saveDepartment(department);
		System.out.println("-------------"+department.getName());
	}

	@Test
	public void testDeleteDepartment() {
	boolean b=	departmentService.deleteDepartment(1);
		if(b==true){
			System.out.println("删除成功------");
		}else{
			System.out.println("删除失败");
		}
	}

	/**
	 * 根据id查询部门信息-测试成功
	 */
	@Test
	public void testSelectDepartmentById() {
		Department department=  departmentService.SelectDepartmentById(1);
		System.out.println("职位名称："+department.getName()+" ----");	

	}

	/**
	 * 查询全部部门信息-测试成功
	 */
	@Test
	public void testSelectAllDepartment() {
		  List<Department> list=  (List<Department>) departmentService.SelectAllDepartment();
		  for(Department department:list){
			  System.out.println("职位名称："+department.getName()+"");	
			  
		  }
	}
/**
 * 修改部门信息-测试成功
 */
	@Test
	public void testUpdateDepartment() {
		Department department=  departmentService.SelectDepartmentById(1);
		 System.out.println("修改前："+department.getName());
		 department.setName(department.getName()+"第一次修改");
		 		 
		 departmentService.updateDepartment(department);
		 Department department2=  departmentService.SelectDepartmentById(1);
		 System.out.println("修改后："+department2.getName()+"   ");
	}

}
