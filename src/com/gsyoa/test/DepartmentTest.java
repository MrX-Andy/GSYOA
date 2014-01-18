package com.gsyoa.test;


import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gsyoa.entity.Department;
import com.gsyoa.service.DepartmentService;
/**
 * ������Ϣ
 * @author yang_С��
 * @date 2013��12��13��
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
		 * ���沿����Ϣ-���Գɹ�
		 */
	@Test
	public void testSaveDepartment() {
		
		Department department=new Department();
		department.setName("������");
		
		departmentService.saveDepartment(department);
		System.out.println("-------------"+department.getName());
	}

	@Test
	public void testDeleteDepartment() {
	boolean b=	departmentService.deleteDepartment(1);
		if(b==true){
			System.out.println("ɾ���ɹ�------");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}

	/**
	 * ����id��ѯ������Ϣ-���Գɹ�
	 */
	@Test
	public void testSelectDepartmentById() {
		Department department=  departmentService.SelectDepartmentById(1);
		System.out.println("ְλ���ƣ�"+department.getName()+" ----");	

	}

	/**
	 * ��ѯȫ��������Ϣ-���Գɹ�
	 */
	@Test
	public void testSelectAllDepartment() {
		  List<Department> list=  (List<Department>) departmentService.SelectAllDepartment();
		  for(Department department:list){
			  System.out.println("ְλ���ƣ�"+department.getName()+"");	
			  
		  }
	}
/**
 * �޸Ĳ�����Ϣ-���Գɹ�
 */
	@Test
	public void testUpdateDepartment() {
		Department department=  departmentService.SelectDepartmentById(1);
		 System.out.println("�޸�ǰ��"+department.getName());
		 department.setName(department.getName()+"��һ���޸�");
		 		 
		 departmentService.updateDepartment(department);
		 Department department2=  departmentService.SelectDepartmentById(1);
		 System.out.println("�޸ĺ�"+department2.getName()+"   ");
	}

}
