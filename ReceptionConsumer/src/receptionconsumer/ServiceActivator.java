package receptionconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import receptionproducer.Reception;
import receptionproducer.ReceptionProducer;

public class ServiceActivator implements BundleActivator {

	ServiceReference receptionReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Reception Consumer >> Start");
		
		receptionReference = bundleContext.getServiceReference(ReceptionProducer.class.getName());
		
		ReceptionProducer receptionproduce = (ReceptionProducer) bundleContext.getService(receptionReference);
		receptionproduce.RegisterReception();
		receptionproduce.DisplayReceptionList();
		
		System.out.println("--------------------------------------------------------------------------");
//		String exit = "n";
		System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
		String answer = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.print("Enter Receptiion ID: "); 
		
		Reception reception = receptionproduce.getReceptionById(sc.next()); //get reception by the reception NIC
		
		System.out.println("--------------------------------------------------------------------------");
		
		if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("E")) {  //edit reception details 
			receptionproduce.UpdateReception(reception);
			receptionproduce.DisplayReceptionList(); 
			
//			........................................................................
    		   System.out.println("Do you want delete reception details (y/n)?");
			   answer = sc.next();
			   System.out.println("Delete reception details (d/D)?");
			   answer = sc.next();
			   System.out.println("--------------------------------------------------------------------------");
        	   System.out.print("Enter Reception ID: "); 
			    String  input = sc.next();
			   
			   if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing reception
				   receptionproduce.DeleteReception(reception.getReceptionId());//delete the reception details according to the ID
				   receptionproduce.DisplayReceptionList();
				   System.out.println("Do you want exit (y/n)?");
				     String exit = sc.next();
				   } 
			   
			   

		         }
		
		
	    else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing module
	    	receptionproduce.DeleteReception(reception.getReceptionId());//delete the reception details according to the ID
	    	receptionproduce.DisplayReceptionList();
				System.out.println("Do you want exit (y/n)?");
			     String exit = sc.next();
			   } 
		
		 else  {
			
			 System.out.println("Undifine Input!!!") ;
		}	
	}
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Reception Consumer stop");
		bundleContext.ungetService(receptionReference);
	}

}
	

