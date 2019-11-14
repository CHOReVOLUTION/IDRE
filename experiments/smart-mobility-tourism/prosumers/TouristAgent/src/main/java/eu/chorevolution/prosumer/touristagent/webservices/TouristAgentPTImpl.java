package eu.chorevolution.prosumer.touristagent.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.chorevolution.prosumer.touristagent.TouristAgentPT;
import eu.chorevolution.prosumer.touristagent.GetTouristicGuideRequestType;
import eu.chorevolution.prosumer.touristagent.GetTouristicGuideRequestReturnType;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoResponseType;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoResponseReturnType;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoResponseType;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoResponseReturnType;
import eu.chorevolution.prosumer.touristagent.SendRequestType;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoRequestReturnType;
import eu.chorevolution.prosumer.touristagent.GetMobilityInfoRequest;
import eu.chorevolution.prosumer.touristagent.SendRequestType;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoRequestReturnType;
import eu.chorevolution.prosumer.touristagent.GetTourismInfoRequest;
import eu.chorevolution.prosumer.touristagent.SendRequestType;
import eu.chorevolution.prosumer.touristagent.GetTouristicGuideResponseReturnType;
import eu.chorevolution.prosumer.touristagent.GetTouristicGuideResponse;

import eu.chorevolution.prosumer.touristagent.business.ChoreographyDataService;
import eu.chorevolution.prosumer.touristagent.business.ChoreographyInstanceMessagesStore;
import eu.chorevolution.prosumer.touristagent.business.TouristAgentService;


@Component(value="TouristAgentPTImpl")
public class TouristAgentPTImpl implements TouristAgentPT {
	
	private static Logger logger = LoggerFactory.getLogger(TouristAgentPTImpl.class);

	@Autowired
	private TouristAgentService service;
	
	@Autowired
	private ChoreographyDataService choreographyDataService;
	
    @Override
    public GetTouristicGuideRequestReturnType getTouristGuide(GetTouristicGuideRequestType parameters) {
    	logger.info("CALLED getTouristGuide ON TouristAgent");	
    	GetTouristicGuideRequestReturnType result = new GetTouristicGuideRequestReturnType();
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), parameters.getInputMessageData());
  		service.getTouristGuide(parameters.getInputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		
		return result;
    }
     
    @Override
    public GetMobilityInfoResponseReturnType setMobilityInformation(GetMobilityInfoResponseType parameters) {
    	logger.info("CALLED setMobilityInformation ON TouristAgent");	
    	GetMobilityInfoResponseReturnType result = new GetMobilityInfoResponseReturnType();
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), parameters.getInputMessageData());
  		service.setMobilityInformation(parameters.getInputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		
		return result;
    }
     
    @Override
    public GetTourismInfoResponseReturnType setTourismInformation(GetTourismInfoResponseType parameters) {
    	logger.info("CALLED setTourismInformation ON TouristAgent");	
    	GetTourismInfoResponseReturnType result = new GetTourismInfoResponseReturnType();
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), parameters.getInputMessageData());
  		service.setTourismInformation(parameters.getInputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		
		return result;
    }
     
    @Override
    public GetMobilityInfoRequestReturnType sendGetMobilityInfoRequest(SendRequestType parameters) {
    	logger.info("CALLED sendGetMobilityInfoRequest ON TouristAgent");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		GetMobilityInfoRequest businessResult = service.createGetMobilityInfoRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		GetMobilityInfoRequestReturnType result = new GetMobilityInfoRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public GetTourismInfoRequestReturnType sendGetTourismInfoRequest(SendRequestType parameters) {
    	logger.info("CALLED sendGetTourismInfoRequest ON TouristAgent");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		GetTourismInfoRequest businessResult = service.createGetTourismInfoRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		GetTourismInfoRequestReturnType result = new GetTourismInfoRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public GetTouristicGuideResponseReturnType sendGetTouristicGuideResponse(SendRequestType parameters) {
    	logger.info("CALLED sendGetTouristicGuideResponse ON TouristAgent");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		GetTouristicGuideResponse businessResult = service.createGetTouristicGuideResponse(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		GetTouristicGuideResponseReturnType result = new GetTouristicGuideResponseReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     

	
}
