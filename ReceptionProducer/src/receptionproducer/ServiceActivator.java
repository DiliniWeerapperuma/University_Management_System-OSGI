package receptionproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class ServiceActivator implements BundleActivator {

	ServiceRegistration receptionRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Reception Producer  >> Start");
		ReceptionProducer receptionProducer = new ReceptionProducerImpl();
		receptionRegistration = bundleContext.registerService(ReceptionProducer.class.getName(), receptionProducer, null);
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Reception Producer >> Stop");
		receptionRegistration.unregister();
	}

}
