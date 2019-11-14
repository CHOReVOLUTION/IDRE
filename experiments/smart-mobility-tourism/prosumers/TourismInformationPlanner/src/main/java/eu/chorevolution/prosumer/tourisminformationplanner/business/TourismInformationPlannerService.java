package eu.chorevolution.prosumer.tourisminformationplanner.business;

import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.WeatherItemsRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.PoiRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.LatestNewsRequest;
import eu.chorevolution.prosumer.tourisminformationplanner.GetTourismInfoResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.WeatherItemsResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.PoiResponse;
import eu.chorevolution.prosumer.tourisminformationplanner.LatestNewsResponse;

public interface TourismInformationPlannerService {

	void getTourismInformation(GetTourismInfoRequest parameter, String choreographyTaskName, String senderParticipantName);
	      
    WeatherItemsRequest createWeatherItemsRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    PoiRequest createPoiRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    LatestNewsRequest createLatestNewsRequest(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    GetTourismInfoResponse createGetTourismInfoResponse(ChoreographyInstanceMessages choreographyInstanceMessages, String choreographyTaskName, String receiverParticipantName);
    
    void receiveWeatherItemsResponse(WeatherItemsResponse parameter, String choreographyTaskName, String senderParticipantName);
    
    void receivePoiResponse(PoiResponse parameter, String choreographyTaskName, String senderParticipantName);
    
    void receiveLatestNewsResponse(LatestNewsResponse parameter, String choreographyTaskName, String senderParticipantName);
    
}
