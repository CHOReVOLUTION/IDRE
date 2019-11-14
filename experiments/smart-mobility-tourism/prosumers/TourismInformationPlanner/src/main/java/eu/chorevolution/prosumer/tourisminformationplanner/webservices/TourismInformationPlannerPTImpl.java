package eu.chorevolution.prosumer.tourisminformationplanner.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.chorevolution.prosumer.tourisminformationplanner.TourismInformationPlannerPT;
import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoRequestType;
import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoRequestReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.SendRequestType;
import eu.chorevolution.prosumer.tourisminformationplanner.WeatherItemsRequestReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.WeatherItemsRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.SendRequestType;
import eu.chorevolution.prosumer.tourisminformationplanner.PoiRequestReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.PoiRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.SendRequestType;
import eu.chorevolution.prosumer.tourisminformationplanner.LatestNewsRequestReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.LatestNewsRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.SendRequestType;
import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoResponseReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.ReceiveWeatherItemsResponseType;
import eu.chorevolution.prosumer.tourisminformationplanner.ReceiveWeatherItemsResponseReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.ReceivePoiResponseType;
import eu.chorevolution.prosumer.tourisminformationplanner.ReceivePoiResponseReturnType;
import eu.chorevolution.prosumer.tourisminformationplanner.ReceiveLatestNewsResponseType;
import eu.chorevolution.prosumer.tourisminformationplanner.ReceiveLatestNewsResponseReturnType;

import eu.chorevolution.prosumer.tourisminformationplanner.business.ChoreographyDataService;
import eu.chorevolution.prosumer.tourisminformationplanner.business.ChoreographyInstanceMessagesStore;
import eu.chorevolution.prosumer.tourisminformationplanner.business.TourismInformationPlannerService;


@Component(value="TourismInformationPlannerPTImpl")
public class TourismInformationPlannerPTImpl implements TourismInformationPlannerPT {
	
	private static Logger logger = LoggerFactory.getLogger(TourismInformationPlannerPTImpl.class);

	@Autowired
	private TourismInformationPlannerService service;
	
	@Autowired
	private ChoreographyDataService choreographyDataService;
	
    @Override
    public GetTourismInfoRequestReturnType getTourismInformation(GetTourismInfoRequestType parameters) {
    	logger.info("CALLED getTourismInformation ON TourismInformationPlanner");	
    	GetTourismInfoRequestReturnType result = new GetTourismInfoRequestReturnType();
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), parameters.getInputMessageData());
  		service.getTourismInformation(parameters.getInputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		
		return result;
    }
     
    @Override
    public WeatherItemsRequestReturnType sendWeatherItemsRequest(SendRequestType parameters) {
    	logger.info("CALLED sendWeatherItemsRequest ON TourismInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		WeatherItemsRequest businessResult = service.createWeatherItemsRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		WeatherItemsRequestReturnType result = new WeatherItemsRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public PoiRequestReturnType sendPoiRequest(SendRequestType parameters) {
    	logger.info("CALLED sendPoiRequest ON TourismInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		PoiRequest businessResult = service.createPoiRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		PoiRequestReturnType result = new PoiRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public LatestNewsRequestReturnType sendLatestNewsRequest(SendRequestType parameters) {
    	logger.info("CALLED sendLatestNewsRequest ON TourismInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		LatestNewsRequest businessResult = service.createLatestNewsRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		LatestNewsRequestReturnType result = new LatestNewsRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public GetTourismInfoResponseReturnType sendGetTourismInfoResponse(SendRequestType parameters) {
    	logger.info("CALLED sendGetTourismInfoResponse ON TourismInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		GetTourismInfoResponse businessResult = service.createGetTourismInfoResponse(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		GetTourismInfoResponseReturnType result = new GetTourismInfoResponseReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
	@Override
	public ReceiveWeatherItemsResponseReturnType receiveWeatherItemsResponse(ReceiveWeatherItemsResponseType parameters) {
		logger.info("CALLED receiveWeatherItemsResponse ON TourismInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receiveWeatherItemsResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceiveWeatherItemsResponseReturnType();
	}
     
	@Override
	public ReceivePoiResponseReturnType receivePoiResponse(ReceivePoiResponseType parameters) {
		logger.info("CALLED receivePoiResponse ON TourismInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receivePoiResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceivePoiResponseReturnType();
	}
     
	@Override
	public ReceiveLatestNewsResponseReturnType receiveLatestNewsResponse(ReceiveLatestNewsResponseType parameters) {
		logger.info("CALLED receiveLatestNewsResponse ON TourismInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receiveLatestNewsResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceiveLatestNewsResponseReturnType();
	}
     

	
}
