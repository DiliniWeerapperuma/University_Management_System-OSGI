package receptionproducer;

import receptionproducer.Reception;


public interface ReceptionProducer {
	
	public void RegisterReception();

	public void UpdateReception(Reception reception);

	public void DeleteReception(String receptionId);

	public void DisplayReceptionList();
	
	public Reception getReceptionById(String receptionId);

}
