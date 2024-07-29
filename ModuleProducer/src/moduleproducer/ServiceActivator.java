package moduleproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration moduleRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Module Producer Start ");
		ModuleProducer moduleProducer = new ModuleProducerImpl();
		moduleRegistration = bundleContext.registerService(ModuleProducer.class.getName(), moduleProducer, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Module Producer Stop");
		moduleRegistration.unregister();
	}

}









 