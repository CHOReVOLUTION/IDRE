package eu.chorevolution.prosumer.mobilityinformationplanner.business.impl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

import eu.chorevolution.prosumer.mobilityinformationplanner.business.ChoreographyInstanceMessages;
import eu.chorevolution.prosumer.mobilityinformationplanner.business.MobilityInformationPlannerService;

@Service
public class MobilityInformationPlannerServiceImpl implements MobilityInformationPlannerService {
	
	private static Logger logger = LoggerFactory.getLogger(MobilityInformationPlannerServiceImpl.class);

	@Override
	public void getMobilityInformation(GetMobilityInfoRequest parameter, String choreographyTaskName, String senderParticipantName) {
		/**
		*	TODO Add your business logic upon the reception of GetMobilityInfoRequest message from senderParticipantName
		*/
	}     

    @Override
    public TripsRequest createTripsRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createTripsRequest ON MOBILITYPROSUMER");
    	
    	GetMobilityInfoRequest request = (GetMobilityInfoRequest) choreographyInstanceMessages.getMessage("getMobilityInfoRequest");
    	TripsRequest result = new TripsRequest();
    	
    	if(request != null){
    		result.setFromLat(request.getFromLat());
    		result.setFromLon(request.getFromLon());
    		result.setToLat(request.getToLat());
    		result.setToLon(request.getToLon());
    		result.setTransportMode(request.getTransportMode());
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates TripsRequest message 
		 *	that has to be sent to receiverParticipantName within the interaction belonging to choreographyTaskName
		 *	You can exploit the following API from choreographyInstanceMessages
		 *	1. Get a Message using its name 
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessage("EcoRoutesRequest");
		 *		A null value is returned if no message has been found.
		 *	2. Get a list of messages using a message name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessages("EcoRoutesRequest");
		 *		A null value is returned if no message has been found. 
		 *	3. Get a message using its name and the name of the sender participant
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND");
		 *		A null value is returned if no message has been found. 
		 *	4. Get a list of messages using a message name and a sender participant name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND"); 
		 *		A null value is returned if no message has been found.
		 *	5. Get a message using its name, the name of the sender participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");	
		 *		A null value is returned if no message has been found.
		 *	6. Get a list of messages using a message name, the name of the sender participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");
		 *		A null value is returned if no message has been found.
		 *	7. Get a message using its name and the name of the receiver participant
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedParticipant("RoutesRequest", "DTS-GOOGLE");
		 *		A null value is returned if no message has been found. 
		 *	8. Get a message using its name, the name of the receiver participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");;	
		 *		A null value is returned if no message has been found.
		 *	9. Get a list of messages using a message name and a receiver participant name
		 *		- example: 
         *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE");
		 *	10. Get a list of messages using a message name, the name of the receiver participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");
		 *		A null value is returned if no message has been found.
		 */	
    }
    
    @Override
    public ParkingRequest createParkingRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createParkingRequest ON MOBILITYPROSUMER");
    	
    	GetMobilityInfoRequest request = (GetMobilityInfoRequest) choreographyInstanceMessages.getMessage("getMobilityInfoRequest");
    	ParkingRequest result = new ParkingRequest();
    	
    	if(request != null){
    		result.setLowerLeftLat(request.getLowerLeftLat());
    		result.setLowerLeftLon(request.getLowerLeftLon());
    		result.setUpperRightLat(request.getUpperRightLat());
    		result.setUpperRightLon(request.getUpperRightLon());
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates ParkingRequest message 
		 *	that has to be sent to receiverParticipantName within the interaction belonging to choreographyTaskName
		 *	You can exploit the following API from choreographyInstanceMessages
		 *	1. Get a Message using its name 
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessage("EcoRoutesRequest");
		 *		A null value is returned if no message has been found.
		 *	2. Get a list of messages using a message name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessages("EcoRoutesRequest");
		 *		A null value is returned if no message has been found. 
		 *	3. Get a message using its name and the name of the sender participant
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND");
		 *		A null value is returned if no message has been found. 
		 *	4. Get a list of messages using a message name and a sender participant name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND"); 
		 *		A null value is returned if no message has been found.
		 *	5. Get a message using its name, the name of the sender participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");	
		 *		A null value is returned if no message has been found.
		 *	6. Get a list of messages using a message name, the name of the sender participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");
		 *		A null value is returned if no message has been found.
		 *	7. Get a message using its name and the name of the receiver participant
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedParticipant("RoutesRequest", "DTS-GOOGLE");
		 *		A null value is returned if no message has been found. 
		 *	8. Get a message using its name, the name of the receiver participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");;	
		 *		A null value is returned if no message has been found.
		 *	9. Get a list of messages using a message name and a receiver participant name
		 *		- example: 
         *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE");
		 *	10. Get a list of messages using a message name, the name of the receiver participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");
		 *		A null value is returned if no message has been found.
		 */	
    }
    
    @Override
    public TrafficRequest createTrafficRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createTrafficRequest ON MOBILITYPROSUMER");
    	
    	GetMobilityInfoRequest request = (GetMobilityInfoRequest) choreographyInstanceMessages.getMessage("getMobilityInfoRequest");
    	TrafficRequest result = new TrafficRequest();
    	
    	if(request != null){
    		result.setLowerLeftLat(request.getLowerLeftLat());
    		result.setLowerLeftLon(request.getLowerLeftLon());
    		result.setUpperRightLat(request.getUpperRightLat());
    		result.setUpperRightLon(request.getUpperRightLon());
    		//result.setType(value);
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates TrafficRequest message 
		 *	that has to be sent to receiverParticipantName within the interaction belonging to choreographyTaskName
		 *	You can exploit the following API from choreographyInstanceMessages
		 *	1. Get a Message using its name 
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessage("EcoRoutesRequest");
		 *		A null value is returned if no message has been found.
		 *	2. Get a list of messages using a message name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessages("EcoRoutesRequest");
		 *		A null value is returned if no message has been found. 
		 *	3. Get a message using its name and the name of the sender participant
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND");
		 *		A null value is returned if no message has been found. 
		 *	4. Get a list of messages using a message name and a sender participant name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND"); 
		 *		A null value is returned if no message has been found.
		 *	5. Get a message using its name, the name of the sender participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");	
		 *		A null value is returned if no message has been found.
		 *	6. Get a list of messages using a message name, the name of the sender participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");
		 *		A null value is returned if no message has been found.
		 *	7. Get a message using its name and the name of the receiver participant
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedParticipant("RoutesRequest", "DTS-GOOGLE");
		 *		A null value is returned if no message has been found. 
		 *	8. Get a message using its name, the name of the receiver participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");;	
		 *		A null value is returned if no message has been found.
		 *	9. Get a list of messages using a message name and a receiver participant name
		 *		- example: 
         *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE");
		 *	10. Get a list of messages using a message name, the name of the receiver participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");
		 *		A null value is returned if no message has been found.
		 */	
    }
    
    @Override
    public LatestPTRequest createLatestPTRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createLatestPTRequest ON MOBILITYPROSUMER");
    	
    	GetMobilityInfoRequest request = (GetMobilityInfoRequest) choreographyInstanceMessages.getMessage("getMobilityInfoRequest");
    	LatestPTRequest result = new LatestPTRequest();
    	
    	return result;
    	/**
		 *	TODO write the code that generates LatestPTRequest message 
		 *	that has to be sent to receiverParticipantName within the interaction belonging to choreographyTaskName
		 *	You can exploit the following API from choreographyInstanceMessages
		 *	1. Get a Message using its name 
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessage("EcoRoutesRequest");
		 *		A null value is returned if no message has been found.
		 *	2. Get a list of messages using a message name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessages("EcoRoutesRequest");
		 *		A null value is returned if no message has been found. 
		 *	3. Get a message using its name and the name of the sender participant
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND");
		 *		A null value is returned if no message has been found. 
		 *	4. Get a list of messages using a message name and a sender participant name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND"); 
		 *		A null value is returned if no message has been found.
		 *	5. Get a message using its name, the name of the sender participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");	
		 *		A null value is returned if no message has been found.
		 *	6. Get a list of messages using a message name, the name of the sender participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");
		 *		A null value is returned if no message has been found.
		 *	7. Get a message using its name and the name of the receiver participant
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedParticipant("RoutesRequest", "DTS-GOOGLE");
		 *		A null value is returned if no message has been found. 
		 *	8. Get a message using its name, the name of the receiver participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");;	
		 *		A null value is returned if no message has been found.
		 *	9. Get a list of messages using a message name and a receiver participant name
		 *		- example: 
         *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE");
		 *	10. Get a list of messages using a message name, the name of the receiver participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");
		 *		A null value is returned if no message has been found.
		 */	
    }
    
    @Override
    public GetMobilityInfoResponse createGetMobilityInfoResponse(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createGetMobilityInfoResponse ON MOBILITYPROSUMER");
    	
    	TripsResponse tripsResponse = (TripsResponse) choreographyInstanceMessages.getMessage("tripsResponse");
    	ParkingResponse parkingResponse = (ParkingResponse) choreographyInstanceMessages.getMessage("parkingResponse");
    	TrafficResponse trafficResponse = (TrafficResponse) choreographyInstanceMessages.getMessage("trafficResponse");
    	LatestPTResponse latestResponse = (LatestPTResponse) choreographyInstanceMessages.getMessage("latestPTResponse");
    	
    	GetMobilityInfoResponse result = new GetMobilityInfoResponse();
    	
    	if(tripsResponse != null)
    		result.setTrip(tripsResponse);
    	if(parkingResponse != null)
    		result.getParkings().addAll(parkingResponse.getParkings());
    	if(trafficResponse != null)
    		result.getTrafficInfos().addAll(trafficResponse.getTrafficInfos());
    	if(latestResponse != null)
    		result.getPublicTransportInfo().addAll(latestResponse.getPublicTransportNews());
    	
    	
    	return result;
    	/**
		 *	TODO write the code that generates GetMobilityInfoResponse message 
		 *	that has to be sent to receiverParticipantName within the interaction belonging to choreographyTaskName
		 *	You can exploit the following API from choreographyInstanceMessages
		 *	1. Get a Message using its name 
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessage("EcoRoutesRequest");
		 *		A null value is returned if no message has been found.
		 *	2. Get a list of messages using a message name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessages("EcoRoutesRequest");
		 *		A null value is returned if no message has been found. 
		 *	3. Get a message using its name and the name of the sender participant
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND");
		 *		A null value is returned if no message has been found. 
		 *	4. Get a list of messages using a message name and a sender participant name
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND"); 
		 *		A null value is returned if no message has been found.
		 *	5. Get a message using its name, the name of the sender participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			EcoRoutesRequest message = (EcoRoutesRequest) choreographyInstanceMessages.getMessageSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");	
		 *		A null value is returned if no message has been found.
		 *	6. Get a list of messages using a message name, the name of the sender participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<EcoRoutesRequest> messages = choreographyInstanceMessages.getMessagesSentFromParticipant("EcoRoutesRequest","ND","Get Eco Routes");
		 *		A null value is returned if no message has been found.
		 *	7. Get a message using its name and the name of the receiver participant
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedParticipant("RoutesRequest", "DTS-GOOGLE");
		 *		A null value is returned if no message has been found. 
		 *	8. Get a message using its name, the name of the receiver participant and the name of the task in which 
		 *		the message has been exchanged
		 *		- example: 
		 *			RoutesRequest message = (RoutesRequest) choreographyInstanceMessages.getMessageReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");;	
		 *		A null value is returned if no message has been found.
		 *	9. Get a list of messages using a message name and a receiver participant name
		 *		- example: 
         *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE");
		 *	10. Get a list of messages using a message name, the name of the receiver participant and the name of the task in which 
		 *		the messages has been exchanged
		 *		- example: 
		 *			List<RoutesRequest> messages = choreographyInstanceMessages.getMessagesReceivedFromParticipant("RoutesRequest", "DTS-GOOGLE", "Routes Request");
		 *		A null value is returned if no message has been found.
		 */	
    }
    
	@Override    
    public void receiveTripsResponse(TripsResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (TripsResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
    
	@Override    
    public void receiveParkingResponse(ParkingResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (ParkingResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
    
	@Override    
    public void receiveTrafficResponse(TrafficResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (TrafficResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
    
	@Override    
    public void receiveLatestPTResponse(LatestPTResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (LatestPTResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
}
