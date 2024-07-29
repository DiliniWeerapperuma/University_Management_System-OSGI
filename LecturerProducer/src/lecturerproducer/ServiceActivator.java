package lecturerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class ServiceActivator implements BundleActivator {

	ServiceRegistration lecturerRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Lecturer Producer  >> Start");
		LecturerProducer lecturerProducer = new LecturerProducerImpl();
		lecturerRegistration = bundleContext.registerService(LecturerProducer.class.getName(), lecturerProducer, null);
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Lecturer Producer >> Stop");
		lecturerRegistration.unregister();
	}

}
