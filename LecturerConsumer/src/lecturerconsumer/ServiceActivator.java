package lecturerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import lecturerproducer.Lecturer;
import lecturerproducer.LecturerProducer;

public class ServiceActivator implements BundleActivator {

	ServiceReference lecturerReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Lecturer Consumer >> Start");
		
		lecturerReference = bundleContext.getServiceReference(LecturerProducer.class.getName());
		
		LecturerProducer lecturerproduce = (LecturerProducer) bundleContext.getService(lecturerReference);
		lecturerproduce.RegisterLecturer();
		lecturerproduce.DisplayLecturerList();
		
		System.out.println("--------------------------------------------------------------------------");
//		String exit = "n";
		System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
		String answer = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.print("Enter Lecturer NIC: "); 
		
		Lecturer lecturer = lecturerproduce.getLecturerById(sc.next()); //get lecturer by the lecturer NIC
		
		System.out.println("--------------------------------------------------------------------------");
		
		if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("E")) {  //edit lecturer details 
			lecturerproduce.UpdateLecturer(lecturer);
			lecturerproduce.DisplayLecturerList(); 
			
//			........................................................................
    		   System.out.println("Do you want delete lecturer details (y/n)?");
			   answer = sc.next();
			   System.out.println("Delete lecturer details (d/D)?");
			   answer = sc.next();
			   System.out.println("--------------------------------------------------------------------------");
        	   System.out.print("Enter Lecturer NIC: "); 
			    String  input = sc.next();
			   
			   if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing lecturer
					lecturerproduce.DeleteLecturer(lecturer.getNic());//delete the lecturer details according to the NIC
					lecturerproduce.DisplayLecturerList();
					System.out.println("Do you want exit (y/n)?");
				     String exit = sc.next();
				   } 
			   
			   
			   
//			
//				System.out.println("Do you want exit (y/n)?");
//				     String exit = sc.next();
//				     System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
//						  exit = sc.next();
//						  System.out.println("--------------------------------------------------------------------------");
//							
//							System.out.print("Enter Lecturer NIC: "); 
//							String input = sc.next();
//							
//
//							
//							
//						
//						  if (exit.equalsIgnoreCase("d") || exit.equalsIgnoreCase("D")) {// delete existing lecturer
//								lecturerproduce.DeleteLecturer(lecturer.getNic());//delete the lecturer details according to the NIC
//								lecturerproduce.UpdateLecturer(lecturer);
//								lecturerproduce.DisplayLecturerList();
//								
//								System.out.println("Do you want exit (y/n)?");
//							       exit = sc.next();
//							   } 

		         }
		
		
	    else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing lecturer
				lecturerproduce.DeleteLecturer(lecturer.getNic());//delete the lecturer details according to the NIC
				lecturerproduce.DisplayLecturerList();
				System.out.println("Do you want exit (y/n)?");
			     String exit = sc.next();
			   } 
		
		 else  {
			
			 System.out.println("Undifine Input!!!") ;
		}	
	}
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Lecturer Consumer stop");
		bundleContext.ungetService(lecturerReference);
	}

}
	

