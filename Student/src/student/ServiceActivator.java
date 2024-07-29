package student;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
	ServiceRegistration stdRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Student Publisher Start");
		StudentPublisher stdPublisher = (StudentPublisher) new StudentPublisherImpl();
		stdRegistration = context.registerService(StudentPublisher.class.getName(), stdPublisher, null);
		
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Student Publisher Stop");
		stdRegistration.unregister();
		
		
	}

}
