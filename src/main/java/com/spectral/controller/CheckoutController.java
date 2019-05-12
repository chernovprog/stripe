package com.spectral.controller;

import com.spectral.service.StripeService;
import com.spectral.model.stripe.JSONStripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class CheckoutController {

    @Autowired
    private StripeService stripeService;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("/")
    public String checkout(Model model) {
        Map<String, Object> params = stripeService.getParams();

        try {
            Session session = Session.create(params);
            model.addAttribute("stripePublicKey", stripePublicKey);
            model.addAttribute("CHECKOUT_SESSION_ID", session.getId());
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return "index";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @RequestMapping(value = "/webhook", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object handle(@RequestBody String json, HttpServletResponse response) {
        /*Event eventJson = ApiResource.GSON.fromJson(json, Event.class);
        eventJson.getType();*/
        Boolean transaction = stripeService.saveTransaction(json);

        if (transaction == true) response.setStatus(200);

        return "";
    }

    @GetMapping("/canceled")
    public String canceled() {
        return "canceled";
    }

}
