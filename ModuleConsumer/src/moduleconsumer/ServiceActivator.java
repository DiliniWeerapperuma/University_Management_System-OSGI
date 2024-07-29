package moduleconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import moduleproducer.Module;
import moduleproducer.ModuleProducer;

public class ServiceActivator implements BundleActivator {

	ServiceReference moduleReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Module Consumer >> Start");
		
		moduleReference = bundleContext.getServiceReference(ModuleProducer.class.getName());
		
		ModuleProducer moduleproduce = (ModuleProducer) bundleContext.getService(moduleReference);
		moduleproduce.ModuleRegister();
		moduleproduce.displayModuleList();
		
		System.out.println("--------------------------------------------------------------------------");
//		String exit = "n";
		System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
		String answer = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.print("Enter Module ID: "); 
		
		Module module = moduleproduce.getModuleById(sc.next()); //get lecturer by the lecturer NIC
		
		System.out.println("--------------------------------------------------------------------------");
		
		if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("E")) {  //edit lecturer details 
			moduleproduce.UpdateModule(module);
			moduleproduce.displayModuleList(); 
			
//			........................................................................
    		   System.out.println("Do you want delete module details (y/n)?");
			   answer = sc.next();
			   System.out.println("Delete module details (d/D)?");
			   answer = sc.next();
			   System.out.println("--------------------------------------------------------------------------");
        	   System.out.print("Enter Module ID: "); 
			    String  input = sc.next();
			   
			   if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing lecturer
				   moduleproduce.ModuleDelete(module.getModuleId());//delete the lecturer details according to the NIC
				   moduleproduce.displayModuleList();
					System.out.println("Do you want exit (y/n)?");
				     String exit = sc.next();
				   } 
			   
		         }
		
		
	    else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing module
	    	moduleproduce.ModuleDelete(module.getModuleId());//delete the module details according to the ID
	    	moduleproduce.displayModuleList();
				System.out.println("Do you want exit (y/n)?");
			     String exit = sc.next();
			   } 
		
		 else  {
			
			 System.out.println("Undifine Input!!!") ;
		}	
	}
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Lecturer Consumer stop");
		bundleContext.ungetService(moduleReference);
	}

}
	

