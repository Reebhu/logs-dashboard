package com.dash;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dash.Reports;
import com.dash.logParent;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class dashControl {

	@GetMapping
	public static void m(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            logParent logParentObj = objectMapper.readValue(new File("/Users/jasir/Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/dash-1/src/main/java/com/dash/logs.json"), logParent.class);
            //Print info directly
            System.out.println("totalPages    : " + logParentObj.getTotalPages());
           
            System.out.println("totalItems : " + logParentObj.getTotalItems());
            System.out.println("currentPage   : " + logParentObj.getCurrentPage());
             
            //parsing nested list
            System.out.println("###### REPORTS ###########");
            for(Reports report : logParentObj.getReports()) {
            	
            	
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
                
                //System.out.println("Values            : " + report.getValues());
                
                System.out.println("Sid               : " + report.getSid());
                
                
                 }}
               
         catch (IOException e) {
            e.printStackTrace();
        }}
	
}

