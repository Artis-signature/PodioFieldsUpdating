package com.podio.integration.freshdesk.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.podio.APIFactory;
import com.podio.ResourceFactory;
import com.podio.contact.Profile;
import com.podio.integration.freshdesk.bean.Contact;
import com.podio.integration.freshdesk.bean.Fields;
import com.podio.integration.freshdesk.bean.Ticket;
import com.podio.item.FieldValuesUpdate;
import com.podio.item.Item;
import com.podio.item.ItemAPI;
import com.podio.item.ItemBadge;
import com.podio.item.ItemCreate;
import com.podio.item.ItemCreateResponse;
import com.podio.item.ItemUpdate;
import com.podio.item.ItemsResponse;
import com.podio.oauth.OAuthClientCredentials;
import com.podio.oauth.OAuthUsernameCredentials;
import com.podio.user.UserAPI;

@Configuration
public class PodioService {
	
	ResourceFactory resourceFactory;
	@EventListener(ApplicationReadyEvent.class)
	public void podioConnection() {
	
	ResourceFactory resourceFactory = new ResourceFactory(
	        new OAuthClientCredentials("demofresh", "KK41lbEp11pAa3dRuIKqoUttGRZR7qNTjOmS9IjkOK4Nvym7WBHnvVrgtuKIuAND"),
	        new OAuthUsernameCredentials("aminj@artissol.com", "Artissol@123"));
	
	APIFactory apiFactory = new APIFactory(resourceFactory);
	
	UserAPI userAPI = apiFactory.getUserAPI();
	Profile profile = userAPI.getProfile();
	System.out.println(profile.getName());
	
	ItemAPI itemAPI = apiFactory.getItemAPI();
	System.out.println(itemAPI.getItem(896221322));
	
	itemAPI.getItemFieldValues(896221322, 174538595);
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println(itemAPI.getItemFieldValues(896221322, 174538608));
	System.out.println(itemAPI.getItemFieldValues(896221322, 174538595));
	System.out.println(itemAPI.getItemFieldValues(896221322, 174538609));
	System.out.println(itemAPI.getItemFieldValues(896221322, 174538610));
	
//	List<Integer> fileIds = new ArrayList<Integer>();
//	fileIds.add(174538608);
//	fileIds.add(174538595);
//	fileIds.add(174538609);
//	fileIds.add(174538610);
//	
//	ItemCreate create = new ItemCreate();
//	create.setFileIds(fileIds);
//	int newId = itemAPI.addItem(896221322, create, true);
//	System.out.println("^^^^^^^^^^^^" + newId);
	
	 


//	getPodioTicket();
	
	}
	private final static int REQUESTER_NAME = 174538610;
	private final static int REQUESTER_APP_ID = 21262000;
	public List<FieldValuesUpdate> getRequesterFields(Contact freshdeskContact){
		System.out.println("Inside getRequesterFields");
		System.out.println(freshdeskContact);
	       List<FieldValuesUpdate> fields = new ArrayList<FieldValuesUpdate>();
//	       fields.add(new FieldValuesUpdate(REQUESTER_NAME, "value", StringUtils
//	               .abbreviate(freshdeskContact.getName(), 128)));
	       if (freshdeskContact.getName() != null) {
	           fields.add(new FieldValuesUpdate(REQUESTER_NAME, "value",
	        		   freshdeskContact.getName()));
	           System.out.println("@@@@" + freshdeskContact.getName());
	           
	       }
	       System.out.println(fields);
	       return fields;
	   }
	
	private ItemBadge getPodioRequester(long freshdeskRequesterId) {
		ItemsResponse response = new ItemAPI(resourceFactory).getItemsByExternalId(
				REQUESTER_APP_ID, Long.toString(freshdeskRequesterId));
		if (response.getFiltered() < 1) {
			return null;
		}

		return response.getItems().get(0);
	}
	
	public Integer updateRequester(Contact con){
        Contact requesterFreshdesk = con;
//        ItemBadge requesterPodio = getPodioRequester(con.getRequester_id());
////        if (requesterPodio != null) {
////			if (requesterPodio.getCurrentRevision().getCreatedOn()
////					.isBefore(requesterFreshdesk.getUpdatedAt())) {
//				List<FieldValuesUpdate> fields = getRequesterFields(requesterFreshdesk);
//
//				new ItemAPI(resourceFactory).updateItem(requesterPodio.getId(),
//						new ItemUpdate(Long.toString(con.getId()),
//								fields), true);
////			}
//
//			return requesterPodio.getId();
////		}
        
        
        
        
            List<FieldValuesUpdate> fields = getRequesterFields(requesterFreshdesk);
            System.out.println("**********************");
            System.out.println(fields);
            
            
            return new ItemAPI(resourceFactory).addItem(REQUESTER_APP_ID,
                    new ItemCreate(Long.toString(con.getId()),
                            fields, Collections.<Integer> emptyList(),
                            Collections.<String> emptyList()), true);

    }
	
	
	public List<FieldValuesUpdate> getTicketFields(Ticket freshdeskTicket){
		System.out.println("Inside getTicketFields");
		System.out.println(freshdeskTicket);
	       List<FieldValuesUpdate> fields = new ArrayList<FieldValuesUpdate>();
	       //if (freshdeskTicket.getId() != null) {
	           fields.add(new FieldValuesUpdate(REQUESTER_NAME, "value",
	        		   freshdeskTicket.getSubject()));
	           System.out.println("@@@@" + freshdeskTicket.getSubject());
	           
	      // }
	       System.out.println(fields);
	       return fields;
	   }
		
	
	public ItemBadge getPodioTicket() {
		String item = new Item().getExternalId();
		System.out.println(item);
		ItemsResponse response = new ItemAPI(resourceFactory).getItemsByExternalId(21262000, item);
		System.out.println("#########");
		System.out.println(response);
		
		return response.getItems().get(0);
	}
	
	
}
