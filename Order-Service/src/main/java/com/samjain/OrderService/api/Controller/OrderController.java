package com.samjain.OrderService.api.Controller;

import com.samjain.OrderService.api.Common.Payment;
import com.samjain.OrderService.api.Common.TransactionRequest;
import com.samjain.OrderService.api.Common.TransactionResponse;
import com.samjain.OrderService.api.Entity.Order;
import com.samjain.OrderService.api.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return service.saveOrder(request);
    }
}
