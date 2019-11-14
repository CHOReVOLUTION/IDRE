package eu.chorevolution.prosumer.tourisminformationplanner.business;

public interface ChoreographyInstanceMessagesStore<T> extends ChoreographyInstanceMessages<T> {

	public void storeMessage(String senderParticipantName, String receivingParticipantName, String messageName, String taskName, T message) ;
	
}
