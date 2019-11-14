package eu.chorevolution.prosumer.mobilityinformationplanner.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.chorevolution.prosumer.mobilityinformationplanner.MobilityInformationPlannerPT;
import eu.chorevolution.prosumer.mobilityinformationplanner.GetMobilityInfoRequestType;
import eu.chorevolution.prosumer.mobilityinformationplanner.GetMobilityInfoRequestReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.SendRequestType;
import eu.chorevolution.prosumer.mobilityinformationplanner.TripsRequestReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.TripsRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.SendRequestType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ParkingRequestReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ParkingRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.SendRequestType;
import eu.chorevolution.prosumer.mobilityinformationplanner.TrafficRequestReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.TrafficRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.SendRequestType;
import eu.chorevolution.prosumer.mobilityinformationplanner.LatestPTRequestReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.LatestPTRequest;
import eu.chorevolution.prosumer.mobilityinformationplanner.SendRequestType;
import eu.chorevolution.prosumer.mobilityinformationplanner.GetMobilityInfoResponseReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.GetMobilityInfoResponse;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveTripsResponseType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveTripsResponseReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveParkingResponseType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveParkingResponseReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveTrafficResponseType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveTrafficResponseReturnType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveLatestPTResponseType;
import eu.chorevolution.prosumer.mobilityinformationplanner.ReceiveLatestPTResponseReturnType;

import eu.chorevolution.prosumer.mobilityinformationplanner.business.ChoreographyDataService;
import eu.chorevolution.prosumer.mobilityinformationplanner.business.ChoreographyInstanceMessagesStore;
import eu.chorevolution.prosumer.mobilityinformationplanner.business.MobilityInformationPlannerService;


@Component(value="MobilityInformationPlannerPTImpl")
public class MobilityInformationPlannerPTImpl implements MobilityInformationPlannerPT {
	
	private static Logger logger = LoggerFactory.getLogger(MobilityInformationPlannerPTImpl.class);

	@Autowired
	private MobilityInformationPlannerService service;
	
	@Autowired
	private ChoreographyDataService choreographyDataService;
	
    @Override
    public GetMobilityInfoRequestReturnType getMobilityInformation(GetMobilityInfoRequestType parameters) {
    	logger.info("CALLED getMobilityInformation ON MobilityInformationPlanner");	
    	GetMobilityInfoRequestReturnType result = new GetMobilityInfoRequestReturnType();
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), parameters.getInputMessageData());
  		service.getMobilityInformation(parameters.getInputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		
		return result;
    }
     
    @Override
    public TripsRequestReturnType sendTripsRequest(SendRequestType parameters) {
    	logger.info("CALLED sendTripsRequest ON MobilityInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		TripsRequest businessResult = service.createTripsRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		TripsRequestReturnType result = new TripsRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public ParkingRequestReturnType sendParkingRequest(SendRequestType parameters) {
    	logger.info("CALLED sendParkingRequest ON MobilityInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		ParkingRequest businessResult = service.createParkingRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		ParkingRequestReturnType result = new ParkingRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public TrafficRequestReturnType sendTrafficRequest(SendRequestType parameters) {
    	logger.info("CALLED sendTrafficRequest ON MobilityInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		TrafficRequest businessResult = service.createTrafficRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		TrafficRequestReturnType result = new TrafficRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public LatestPTRequestReturnType sendLatestPTRequest(SendRequestType parameters) {
    	logger.info("CALLED sendLatestPTRequest ON MobilityInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		LatestPTRequest businessResult = service.createLatestPTRequest(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		LatestPTRequestReturnType result = new LatestPTRequestReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
    @Override
    public GetMobilityInfoResponseReturnType sendGetMobilityInfoResponse(SendRequestType parameters) {
    	logger.info("CALLED sendGetMobilityInfoResponse ON MobilityInformationPlanner");	
    	ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		GetMobilityInfoResponse businessResult = service.createGetMobilityInfoResponse(store, parameters.getChoreographyTaskName(), parameters.getReceiverParticipantName());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getInputMessageName(), parameters.getChoreographyTaskName(), businessResult);
		GetMobilityInfoResponseReturnType result = new GetMobilityInfoResponseReturnType();
		result.setInputMessageData(businessResult);
	 
		return result;
    }
     
	@Override
	public ReceiveTripsResponseReturnType receiveTripsResponse(ReceiveTripsResponseType parameters) {
		logger.info("CALLED receiveTripsResponse ON MobilityInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receiveTripsResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceiveTripsResponseReturnType();
	}
     
	@Override
	public ReceiveParkingResponseReturnType receiveParkingResponse(ReceiveParkingResponseType parameters) {
		logger.info("CALLED receiveParkingResponse ON MobilityInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receiveParkingResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceiveParkingResponseReturnType();
	}
     
	@Override
	public ReceiveTrafficResponseReturnType receiveTrafficResponse(ReceiveTrafficResponseType parameters) {
		logger.info("CALLED receiveTrafficResponse ON MobilityInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receiveTrafficResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceiveTrafficResponseReturnType();
	}
     
	@Override
	public ReceiveLatestPTResponseReturnType receiveLatestPTResponse(ReceiveLatestPTResponseType parameters) {
		logger.info("CALLED receiveLatestPTResponse ON MobilityInformationPlanner");			
		ChoreographyInstanceMessagesStore store = choreographyDataService.getChoreographyInstanceMessages(parameters.getChoreographyId().getChoreographyId());
		store.storeMessage(parameters.getSenderParticipantName(), parameters.getReceiverParticipantName(), parameters.getOutputMessageName(), parameters.getChoreographyTaskName(), parameters.getOutputMessageData());
		service.receiveLatestPTResponse(parameters.getOutputMessageData(), parameters.getChoreographyTaskName(), parameters.getSenderParticipantName());
		return new ReceiveLatestPTResponseReturnType();
	}
     

	
}
