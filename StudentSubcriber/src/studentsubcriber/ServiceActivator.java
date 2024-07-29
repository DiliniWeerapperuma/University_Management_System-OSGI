package studentsubcriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import studentpublisher.Student;
import studentpublisher.StudentPublisher;

public class ServiceActivator implements BundleActivator {

	ServiceReference studentReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		
		

		System.out.println("Student subscriber start");
		studentReference = context.getServiceReference(StudentPublisher.class.getName());
		StudentPublisher stdPublish = (StudentPublisher) context.getService(studentReference);
		stdPublish.RegisterStudent();	
		stdPublish.ViewStudentList();
		
		
		
		
		
		System.out.println("--------------------------------------------------------------------------");
//		String exit = "n";
		System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
		String answer = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.print("Enter Student ID: "); 
		
		Student std = stdPublish.getStudentById(sc.next());  //get student by the student id
		
		System.out.println("--------------------------------------------------------------------------");
		
		if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("E")) {  //edit student details 
			stdPublish.StudentEdit(std);
			stdPublish.ViewStudentList();
			
//			........................................................................
    		   System.out.println("Do you want delete student details (y/n)?");
			   answer = sc.next();
			   System.out.println("Delete Student Details (d/D)?");
			   answer = sc.next();
			   System.out.println("--------------------------------------------------------------------------");
        	   System.out.print("Enter Student ID: "); 
			    String  input = sc.next();
			   
			   if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing lecturer
				   stdPublish.StudentDelete(std.getID()); //delete the student details according to the id
				   stdPublish.ViewStudentList();
					System.out.println("Do you want exit (y/n)?");
				     String exit = sc.next();
				   } 
			   
			   

		         }
		
		
	    else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing module
	    	stdPublish.StudentDelete(std.getID()); //delete the student details according to the id
	    	stdPublish.ViewStudentList();
				System.out.println("Do you want exit (y/n)?");
			     String exit = sc.next();
			   } 
		
		 else  {
			
			 System.out.println("Undifine Input!!!") ;
		}	
	}
	
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Student subscriber stop");
		context.ungetService(studentReference);
	}


}
	

