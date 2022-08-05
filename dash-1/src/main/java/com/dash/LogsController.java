package com.dash;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class LogsController {

	
	
	// BestDoc API url
	
	private static final String BESTDOC_API_URL = "https://messaging.bestdocapp.com/communication/WHATSAPP/getAllReports?startDate=2022-01-01&endDate=2022-02-01&size=10&page=100";
	
	@GetMapping("/logs")
	public void httpMethod() throws IOException, InterruptedException {
		
		HttpClient  client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept","json")
				.uri(URI.create(BESTDOC_API_URL))
				.build();
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		
    
		
	// parse the response(String) to java object
		
	ObjectMapper mapper =new ObjectMapper();
	LogParent logs = mapper.readValue(response.body(), LogParent.class );
		
	    
	    
	// printing to console
	    
	    System.out.println("totalPages    : " + logs.getTotalPages()); 
        System.out.println("totalItems : " + logs.getTotalItems());
        System.out.println("currentPage   : " + logs.getCurrentPage());
         
    //parsing nested list
        
        System.out.println("###### REPORTS ###########");
        for(Reports report : logs.getReports()) {
        	
        	
            System.out.println("createdBy         : " + report.getCreatedBy());
            System.out.println("CreationDate      : " + report.getCreationDate());
            System.out.println("LastModifiedBy    : " + report.getLastModifiedBy());
            System.out.println("LastModifiedDate  : " + report.getLastModifiedDate());
            System.out.println("Source            : " + report.getSource());
            System.out.println("Hospital          : " + report.getHospital());
            System.out.println("RequestId         : " + report.getRequestId());
            
            System.out.println("Purpose           : " + report.getMetadata().getPurpose());
            System.out.println("Uhid              : " + report.getMetadata().getUhid());
            System.out.println("FeedbackId        : " + report.getMetadata().getFeedbackId());
            
            System.out.println("Id                : " + report.getId());
            System.out.println("Sender            : " + report.getSender());
            System.out.println("Receiver          : " + report.getReceiver());
            System.out.println("SendDate          : " + report.getSendDate());
            System.out.println("SendTime          : " + report.getSendTime());
            System.out.println("MessageType       : " + report.getMessageType());
            System.out.println("MessageText       : " + report.getMessageText());
            System.out.println("MediaBucket       : " + report.getMediaBucket());
            System.out.println("MediaKey          : " + report.getMediaKey());
            System.out.println("Status            : " + report.getStatus());
            System.out.println("ErrorMessage      : " + report.getErrorMessage());
            
            System.out.println("Values            : " + report.getValues());
            
            System.out.println("Sid               : " + report.getSid());
            
            
             }}
		
	}
	




