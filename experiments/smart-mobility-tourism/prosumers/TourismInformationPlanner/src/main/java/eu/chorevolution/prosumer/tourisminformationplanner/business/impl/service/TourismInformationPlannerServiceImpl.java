package eu.chorevolution.prosumer.tourisminformationplanner.business.impl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.WeatherItemsRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.PoiRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.LatestNewsRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.WeatherItemsResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.PoiResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.LatestNewsResponse;

import eu.chorevolution.prosumer.tourisminformationplanner.business.ChoreographyInstanceMessages;
import eu.chorevolution.prosumer.tourisminformationplanner.business.TourismInformationPlannerService;

@Service
public class TourismInformationPlannerServiceImpl implements TourismInformationPlannerService {
	
	private static Logger logger = LoggerFactory.getLogger(TourismInformationPlannerServiceImpl.class);

	@Override
	public void getTourismInformation(GetTourismInfoRequest parameter, String choreographyTaskName, String senderParticipantName) {
		/**
		*	TODO Add your business logic upon the reception of GetTourismInfoRequest message from senderParticipantName
		*/
	}     

    @Override
    public WeatherItemsRequest createWeatherItemsRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createWeatherItemsRequest ON TOURISMPROSUMER");
    	
    	GetTourismInfoRequest request = (GetTourismInfoRequest) choreographyInstanceMessages.getMessage("getTourismInfoRequest");
    	WeatherItemsRequest result = new WeatherItemsRequest();
    	
    	if(request != null){
    		result.setLowerLeftLat(request.getLowerLeftLat());
    		result.setLowerLeftLon(request.getLowerLeftLon());
    		result.setUpperRightLat(request.getUpperRightLat());
    		result.setUpperRightLon(request.getUpperRightLon());
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates WeatherItemsRequest message 
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
    public PoiRequest createPoiRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createPoiRequest ON TOURISMPROSUMER");
    	
    	GetTourismInfoRequest request = (GetTourismInfoRequest) choreographyInstanceMessages.getMessage("getTourismInfoRequest");
    	PoiRequest result = new PoiRequest();
    			
		if(request != null){
			result.setLowerLeftLat(request.getLowerLeftLat());
			result.setLowerLeftLon(request.getLowerLeftLon());
			result.setUpperRightLat(request.getUpperRightLat());
			result.setUpperRightLon(request.getUpperRightLon());
			//result.setType(value);
		}
		
		return result;
    	/**
		 *	TODO write the code that generates PoiRequest message 
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
    public LatestNewsRequest createLatestNewsRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createLatestNewsRequest ON TOURISMPROSUMER");
    	
    	GetTourismInfoRequest request = (GetTourismInfoRequest) choreographyInstanceMessages.getMessage("getTourismInfoRequest");
    	LatestNewsRequest result = new LatestNewsRequest();
    	
    	if(request != null){
    		result.setLat(request.getUpperRightLat());
    		result.setLon(request.getUpperRightLon());
    		//result.setType(value);
    	}
    	
    	return result;
    	/**
		 *	TODO write the code that generates LatestNewsRequest message 
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
    public GetTourismInfoResponse createGetTourismInfoResponse(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName) {
    	
    	logger.info("CALLED createGetTourismInfoResponse ON TOURISMPROSUMER");
    	
    	WeatherItemsResponse weatherResponse = (WeatherItemsResponse) choreographyInstanceMessages.getMessage("weatherItemsResponse");
    	PoiResponse poiResponse = (PoiResponse) choreographyInstanceMessages.getMessage("poiResponse");
    	LatestNewsResponse newsResponse = (LatestNewsResponse) choreographyInstanceMessages.getMessage("latestNewsResponse");
    	
    	GetTourismInfoResponse result = new GetTourismInfoResponse();
    	if(weatherResponse != null)
    		result.getWeatherStations().addAll(weatherResponse.getWeatherStations());
    	if(poiResponse != null)
    		result.getPois().addAll(poiResponse.getPois());
    	if(newsResponse != null)
    		result.getEvents().addAll(newsResponse.getEvents());
    	
    	return result;
    	/**
		 *	TODO write the code that generates GetTourismInfoResponse message 
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
    public void receiveWeatherItemsResponse(WeatherItemsResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (WeatherItemsResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
    
	@Override    
    public void receivePoiResponse(PoiResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (PoiResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
    
	@Override    
    public void receiveLatestNewsResponse(LatestNewsResponse parameter, String choreographyTaskName, String senderParticipantName) {
    	/**
		*	TODO Add your business logic upon the reception of (LatestNewsResponse message from senderParticipantName 
		*		 within the interaction belonging to choreographyTaskName
		*/
    }
}
