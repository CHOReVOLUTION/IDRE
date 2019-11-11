/*
  * Copyright 2015 The CHOReVOLUTION project
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *      http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package eu.chorevolution.syncope.utility.publishservice.serviceinventory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.cxf.helpers.IOUtils;
import org.apache.syncope.common.lib.to.AnyObjectTO;
import org.apache.syncope.common.lib.to.AttrTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.syncope.utility.publishservice.serviceinventory.model.InterfaceDescriptionType;
import eu.chorevolution.syncope.utility.publishservice.serviceinventory.model.Service;
import eu.chorevolution.syncope.utility.publishservice.serviceinventory.model.ServiceRole;

public class PublishServiceIntoServiceInventoryGidl {
	private static final Logger LOG = LoggerFactory.getLogger(PublishServiceIntoServiceInventoryGidl.class);

	public static String URL = "http://localhost:9080/syncope/rest/";
	public static String USERNAME = "admin";
	public static String PASSWORD = "password";
	public static String DOMAIN = "Master";

	private static final String INPUT_RESOURCES = "." + File.separatorChar + "src" + File.separatorChar + "main"
			+ File.separatorChar + "resources" + File.separatorChar;

	private static final String INTERFACE_INPUT_RESOURCES = INPUT_RESOURCES + "interface" + File.separatorChar;

	private static ApacheSyncopeUtilities syncopeUtilities;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		syncopeUtilities = new ApacheSyncopeUtilities(URL, USERNAME, PASSWORD, DOMAIN);

		addProviderServices();
		/*
		 * syncopeUtilities.createChoreography("wp5", new
		 * FileInputStream(CHOREOGRAPHY_DEPLOYMENT_INPUT_RESOURCES + "wp5.xml"),
		 * new EnactmentEngine("ef028fc9-23bb-491b-828f-c923bb791bf5",
		 * "Default"));
		 */
		
	}

	private static void addProviderServices() {
		try {
			Service service = new Service("JourneyPlanner", "http://ge-srv.e-mixer.com/Rest/JourneyPlanningService.svc/trips",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "journeyplanner.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("JourneyPlanner_role", ""));
			syncopeUtilities.createService(service);

			service = new Service("News", "http://srvwebri.softeco.it/t-cube/Rest/NewsService.svc/paged",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "news.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("News_role", ""));
			syncopeUtilities.createService(service);

			service = new Service("Parking", "http://srvwebri.softeco.it/t-cube/Rest/park.svc/pagedparking",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "parking.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("Parking_role", ""));
			syncopeUtilities.createService(service);

			service = new Service("Poi", "http://srvwebri.softeco.it/t-cube/Rest/pws.svc/pageditems",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "poi.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("Poi_role", ""));
			syncopeUtilities.createService(service);

			service = new Service("PublicTransportation", "http://cho-noauth-srv.e-mixer.com/services/Rest/newsService.svc/latest",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "publictransportation.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("PublicTransportation_role", ""));
			syncopeUtilities.createService(service);

			service = new Service("Personal Weather Stations", "http://cho-srv.e-mixer.com/services/Rest/ItemService.svc/items",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "personalweatherstations.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("PersonalWeatherStations_role", ""));
			syncopeUtilities.createService(service);

			service = new Service("Traffic", "http://cho-noauth-srv.e-mixer.com/services/Rest/trafficService.svc/scheduled",
					IOUtils.readBytesFromStream(new FileInputStream(INTERFACE_INPUT_RESOURCES + "traffic.gidl")),
					InterfaceDescriptionType.GIDL);
			service.addServiceRole(createRole("Traffic_role", ""));
			syncopeUtilities.createService(service);

		} catch (IOException e) {
			LOG.error("While loading provider services", e);
		}
	}

	private static ServiceRole createRole(String roleName, String description) {
		AnyObjectTO role = syncopeUtilities.createRole(roleName, description);

		ServiceRole serviceRole = new ServiceRole();

		serviceRole.setKey(role.getKey());
		serviceRole.setName(role.getName());

		Iterator<AttrTO> iterator = role.getPlainAttrs().iterator();
		while (iterator.hasNext()) {

			AttrTO attr = iterator.next();
			if (attr.getSchema().equalsIgnoreCase(ApacheSyncopeUtilities.SERVICE_ROLE_DESCRIPTION)) {
				serviceRole.setDescription(attr.getValues().get(0));
			}

		}

		return serviceRole;

	}


}
