package com.spectral.controller;

import com.spectral.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class CheckoutController {

    @Autowired
    private StripeService stripeService;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    /**
     * Creating a Checkout Session on server
     * When creating a Session, we can tell Checkout to create one-time payments
     *
     * @param model
     * @return
     */
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

    /**
     * This JSON is needed to save a user and a transaction to the database.
     *
     * @param json
     * @param response
     * @return
     */
    @RequestMapping(value = "/webhook", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object handle(@RequestBody String json, HttpServletResponse response) {

        Boolean transaction = stripeService.saveTransaction(json);

        if (transaction == true) response.setStatus(200);

        return "";
    }

    @GetMapping("/canceled")
    public String canceled() {
        return "canceled";
    }

}
