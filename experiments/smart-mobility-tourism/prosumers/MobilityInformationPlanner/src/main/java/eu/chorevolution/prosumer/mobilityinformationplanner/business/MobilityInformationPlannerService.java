package eu.chorevolution.prosumer.mobilityinformationplanner.business;

import eu.chorevolution.prosumer.mobilityinformationplanner.GetMobilityInfoRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.TripsRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.ParkingRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.TrafficRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.LatestPTRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.GetMobilityInfoResponse;
import eu.chorevolution.prosumer.mobilityinformationplanner.TripsResponse;
import eu.chorevolution.prosumer.mobilityinformationplanner.ParkingResponse;
import eu.chorevolution.prosumer.mobilityinformationplanner.TrafficResponse;
import eu.chorevolution.prosumer.mobilityinformationplanner.LatestPTResponse;

public interface MobilityInformationPlannerService {

	void getMobilityInformation(GetMobilityInfoRequest parameter, String choreographyTaskName, String senderParticipantName);
	      
    TripsRequest createTripsRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    ParkingRequest createParkingRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    TrafficRequest createTrafficRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    LatestPTRequest createLatestPTRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    GetMobilityInfoResponse createGetMobilityInfoResponse(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    void receiveTripsResponse(TripsResponse parameter, String choreographyTaskName, String senderParticipantName);
    
    void receiveParkingResponse(ParkingResponse parameter, String choreographyTaskName, String senderParticipantName);
    
    void receiveTrafficResponse(TrafficResponse parameter, String choreographyTaskName, String senderParticipantName);
    
    void receiveLatestPTResponse(LatestPTResponse parameter, String choreographyTaskName, String senderParticipantName);
    
}
