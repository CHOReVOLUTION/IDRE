package eu.chorevolution.prosumer.touristagent.business.impl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import eu.chorevolution.prosumer.touristagent.GetTouristicGuideRequest;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoResponse;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoResponse;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoRequest;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoRequest;
import eu.chorevolution.prosumer.touristagent.GetTouristicGuideResponse;

import eu.chorevolution.prosumer.touristagent.business.ChoreographyInstanceMessages;
import eu.chorevolution.prosumer.touristagent.business.TouristAgentService;

@Service
public class TouristAgentServiceImpl implements TouristAgentService {
	
	private static Logger logger = LoggerFactory.getLogger(TouristAgentServiceImpl.class);


	@Override
	public void getTouristGuide(GetTouristicGuideRequest parameter, String choreographyTaskName, String senderParticipantName) {
		/**
		*	TODO Add your business logic upon the reception of GetTouristicGuideRequest message from senderParticipantName
		*/
	}     

	@Override
	public void setMobilityInformation(GetMobilityInfoResponse parameter, String choreographyTaskName, String senderParticipantName) {
		/**
		*	TODO Add your business logic upon the reception of GetMobilityInfoResponse message from senderParticipantName
		*/
	}     

	@Override
	public void setTourismInformation(GetTourismInfoResponse parameter, String choreographyTaskName, String senderParticipantName) {
		/**
		*	TODO Add your business logic upon the reception of GetTourismInfoResponse message from senderParticipantName
		*/
	}     

    @Override
    public GetMobilityInfoRequest createGetMobilityInfoRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createGetMobilityInfoRequest ON TAPROSUMER");
    	
    	GetTouristicGuideRequest request = (GetTouristicGuideRequest) choreographyInstanceMessages.getMessage("getTouristicGuideRequest");
    	GetMobilityInfoRequest result = new GetMobilityInfoRequest();
    	
    	if(request != null){
        	result.setFromLat(request.getFromLat());
        	result.setFromLon(request.getFromLon());
        	result.setLowerLeftLat(request.getLowerLeftLat());
        	result.setLowerLeftLon(request.getLowerLeftLon());
        	result.setToLat(request.getToLat());
        	result.setToLon(request.getToLon());
        	result.setTransportMode(request.getTransportMode());
        	result.setUpperRightLat(request.getUpperRightLat());
        	result.setUpperRightLon(request.getUpperRightLon());
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates GetMobilityInfoRequest message 
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
    public GetTourismInfoRequest createGetTourismInfoRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createGetTourismInfoRequest ON TAPROSUMER");
    	
    	GetTouristicGuideRequest request = (GetTouristicGuideRequest) choreographyInstanceMessages.getMessage("getTouristicGuideRequest");
    	GetTourismInfoRequest result = new GetTourismInfoRequest();
    	
    	if(request != null){
    		result.setLowerLeftLat(request.getLowerLeftLat());
    		result.setLowerLeftLon(request.getLowerLeftLon());
    		result.setUpperRightLat(request.getUpperRightLat());
    		result.setUpperRightLon(request.getUpperRightLon());
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates GetTourismInfoRequest message 
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
    public GetTouristicGuideResponse createGetTouristicGuideResponse(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createGetTouristicGuideResponse ON TAPROSUMER");
    	
    	GetMobilityInfoResponse mobilityResponse = (GetMobilityInfoResponse) choreographyInstanceMessages.getMessage("getMobilityInfoResponse");
    	GetTourismInfoResponse tourismResponse = (GetTourismInfoResponse) choreographyInstanceMessages.getMessage("getTourismInfoResponse");
    	
    	GetTouristicGuideResponse result = new GetTouristicGuideResponse();
    	
    	if(mobilityResponse != null){
    		result.setTrip(mobilityResponse.getTrip());
    		result.getParkings().addAll(mobilityResponse.getParkings());
    		result.getTrafficInfos().addAll(mobilityResponse.getTrafficInfos());
    		result.getPublicTransportInfo().addAll(mobilityResponse.getPublicTransportInfo());
    	}
    	
    	if(tourismResponse != null){
    		result.getWeatherStations().addAll(tourismResponse.getWeatherStations());
    		result.getPois().addAll(tourismResponse.getPois());
    		result.getEvents().addAll(tourismResponse.getEvents());
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates GetTouristicGuideResponse message 
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
}
