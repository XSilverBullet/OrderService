package com.siemens.scic.controller;

import com.siemens.scic.model.Car;
import com.siemens.scic.model.CarOrder;
import com.siemens.scic.model.basis.OrderState;
import com.siemens.scic.services.CarOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
@RestController
@RequestMapping("car")
public class CarOrderController {

    @Autowired
    private CarOrderService carOrderService;

    @RequestMapping(path = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CarOrder addOrder (@RequestBody Car customizedCar) {
        CarOrder carOrder = new CarOrder();
        carOrder.setId(UUID.randomUUID().toString());
        carOrder.setState(OrderState.CREATED.getValue());
        carOrder.setCar(customizedCar);
        return carOrderService.addOrder(carOrder);
    }

    @RequestMapping(path = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CarOrder getOrder (@PathVariable String id) {
        return carOrderService.findOrderById(id);
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CarOrder> getOrders () {
        return carOrderService.findAllOrders();
    }
}
