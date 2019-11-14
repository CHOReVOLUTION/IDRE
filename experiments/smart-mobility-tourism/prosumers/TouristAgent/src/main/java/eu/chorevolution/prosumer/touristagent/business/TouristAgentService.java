package eu.chorevolution.prosumer.touristagent.business;

import eu.chorevolution.prosumer.touristagent.GetTouristicGuideRequest;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoResponse;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoResponse;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoRequest;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoRequest;
import eu.chorevolution.prosumer.touristagent.GetTouristicGuideResponse;

public interface TouristAgentService {

	void getTouristGuide(GetTouristicGuideRequest parameter, String choreographyTaskName, String senderParticipantName);
	      
	void setMobilityInformation(GetMobilityInfoResponse parameter, String choreographyTaskName, String senderParticipantName);
	      
	void setTourismInformation(GetTourismInfoResponse parameter, String choreographyTaskName, String senderParticipantName);
	      
    GetMobilityInfoRequest createGetMobilityInfoRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    GetTourismInfoRequest createGetTourismInfoRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    GetTouristicGuideResponse createGetTouristicGuideResponse(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
}
