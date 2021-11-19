package com.samjain.OrderService.api.Service;

import com.samjain.OrderService.api.Common.Payment;
import com.samjain.OrderService.api.Common.TransactionRequest;
import com.samjain.OrderService.api.Common.TransactionResponse;
import com.samjain.OrderService.api.Entity.Order;
import com.samjain.OrderService.api.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    @Lazy
    private RestTemplate template;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response="";
        Order order=request.getOrder();
        Payment payment= request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //Logic for calling Rest API
        Payment paymentResponse = template.postForObject(ENDPOINT_URL, payment,Payment.class);

        response= paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api, order added to cart";

        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
