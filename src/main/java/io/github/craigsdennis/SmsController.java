package io.github.craigsdennis;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class SmsController {

    @PostMapping(value = "/sms", produces = "application/xml")
    public String sms(WebRequest request) {
        String country = request.getParameter("FromCountry");
        String txt = String.format("Hi! It looks like your phone number was born in %s", country);
        MessagingResponse twiml = new MessagingResponse.Builder()
                .message(new Message.Builder()
                        .body(new Body.Builder(txt).build())
                        .build())
                .build();
        return twiml.toXml();

    }
}
