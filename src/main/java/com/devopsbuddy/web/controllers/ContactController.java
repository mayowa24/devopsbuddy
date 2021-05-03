package com.devopsbuddy.web.controllers;

import com.devopsbuddy.web.domain.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    /** The application logger*/
    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
    public static final String CONTACT_MODEL_KEY = "feedback";

    public static  final String CONTACT_US_VIEW_NAME ="contact/contact";
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap model){
        FeedbackPojo pojo = new FeedbackPojo();
        model.addAttribute(ContactController.CONTACT_MODEL_KEY, pojo);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value="/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(CONTACT_MODEL_KEY) FeedbackPojo feedback ){
        LOG.debug("Feedback POJO Content: {}", feedback);
        return ContactController.CONTACT_US_VIEW_NAME;
    }
}
