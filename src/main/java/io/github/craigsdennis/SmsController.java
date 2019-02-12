package io.github.craigsdennis;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SmsController {

    @PostMapping("/sms")
    public String sms(WebRequest request, Model model) {
        String country = request.getParameter("FromCountry");
        model.addAttribute("txt", String.format("Hi! It looks like your phone number was born in %s", country));
        return "sms";

    }
}
