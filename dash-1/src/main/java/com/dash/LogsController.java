package com.dash;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class LogsController {

	
	
	// BestDoc API url
	
	private static final String BESTDOC_API_URL = "https://messaging.bestdocapp.com/communication/";
	

	@GetMapping("/logs/{channel}/getAllReports")
	public LogParent httpMethod(
			@PathVariable("channel") String channel ,
			@RequestParam("startDate") String startDate ,
			@RequestParam("endDate") String endDate ,
			@RequestParam("size") String size ,
			@RequestParam("page") String page
		    ) 
			throws IOException, InterruptedException {
		
		    String requestUrl = BESTDOC_API_URL+channel+"/getAllReports?"
				+ "startDate="+startDate
				+"&endDate="+endDate
				+ "&size="+size
				+ "&page="+page  ;
				   
		
		   HttpClient  client = HttpClient.newHttpClient();
		   HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept","json")
				.uri(URI.create(requestUrl))
				.build();
		   HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
			
		
		
	// parse the response(String) to java object
		
	ObjectMapper mapper =new ObjectMapper();
	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	LogParent logs = mapper.readValue(response.body(), LogParent.class );
	   
	     
	return logs;
	
        };
	}
	




