/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Payment;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import java.util.HashMap;
import java.util.Map;
import javax.naming.AuthenticationException;
import javax.smartcardio.CardException;
//import jdk.nashorn.internal.parser.Token;
import com.stripe.model.Token;


/**
 *
 * @author Esprit1
 */
public class ServicePayment {
    public boolean payer(String numeroCarte,int moisExp,int anneeExp,String cvc,int montant,String description) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, com.stripe.exception.AuthenticationException, com.stripe.exception.CardException
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> tokenParams = new HashMap<>();
        Map<String, Object> cardParams = new HashMap<>();
        Payment p = new Payment();
        Stripe.apiKey =p.getApiKey();
        cardParams.put("number", numeroCarte);
        cardParams.put("exp_month", moisExp);
        cardParams.put("exp_year", anneeExp);
        cardParams.put("cvc", cvc);
        int nMontant= montant*100;
        tokenParams.put("card", cardParams);
        Token token=Token.create(tokenParams);
        System.out.println(token);
        if (token.getId()!=null){
        params.put("amount", nMontant);
        params.put("currency", "usd");
        params.put("description", description);
        params.put("source", token.getId());
        Charge charge = Charge.create(params);
        }
        else 
            return false;
        return true; 
    }
    }
    

