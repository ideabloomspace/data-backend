package com.data.entry.kendra.services;

import com.data.entry.kendra.model.DataEntryDetails;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendSms implements ISendSms{

    @Override
    public void sendSms(DataEntryDetails dataEntryDetails) {
        log.info("sending sms to {}", dataEntryDetails.getOfficerPhoneNumbers());
        VonageClient client = VonageClient.builder().apiKey("72c8ff7b").apiSecret("9exsq7m9BwaxKz84").build();
        TextMessage message = new TextMessage("550077", "91"+dataEntryDetails.getOfficerPhoneNumbers(),
                dataEntryDetails.getName()+"\n"+dataEntryDetails.getComplaintDetails());
        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            log.info("Message sent successfully.");
        } else {
            log.info("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }

    }
}
