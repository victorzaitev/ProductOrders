/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.controller.rest;

import dk.viabill.productorders.entity.Cutomers;
import dk.viabill.productorders.entity.OrderDetails;
import dk.viabill.productorders.entity.Orders;
import dk.viabill.productorders.entity.Products;
import dk.viabill.productorders.entity.request.OrdersRequestForm;
import dk.viabill.productorders.entity.rest.OrdersDetailsFormRest;
import dk.viabill.productorders.entity.rest.OrdersFormRest;
import dk.viabill.productorders.repository.CutomersRepository;
import dk.viabill.productorders.repository.OrdersRepository;
import dk.viabill.productorders.repository.ProductsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
@RestController
@RequestMapping("/orders")
public class OrdersRestController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CutomersRepository cutomersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    /**
     *
     * @param request
     * @param bindingResult
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Integer> saveOrders(@Valid @RequestBody OrdersRequestForm request, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }

        Cutomers cutomers = cutomersRepository.findByEmail(request.getEmail().trim());
        if (cutomers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
        Orders orders = new Orders();
        orders.setOrderDate(new Date());
        orders.setCutomers(cutomers);

        Set<OrderDetails> orderDetailses = new HashSet<>();
        request.getOrderDetails().stream().map((orderDetail) -> {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrders(orders);
            orderDetails.setUnitPrice(orderDetail.getUnitPrice());
            orderDetails.setQuantity(orderDetail.getQuantity());
            Products products = productsRepository.findByName(orderDetail.getProductsName().trim());
            orderDetails.setProducts(products);
            return orderDetails;
        }).forEachOrdered((orderDetails) -> {
            orderDetailses.add(orderDetails);
        });

        orders.setOrderDetailses(orderDetailses);
        ordersRepository.save(orders);

        return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);

    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/order/between/date/{startDate}/{endDate}")
    public ResponseEntity<List<OrdersFormRest>> allOrdersdateBetween(@PathVariable("startDate") @DateTimeFormat(pattern = "ddMMyyyy") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "ddMMyyyy") Date endDate) {
        Set<Orders> orderses = ordersRepository.findByOrderDateBetween(startDate, endDate);

        List<OrdersFormRest> ordersFormRests = new ArrayList<>();

        orderses.stream().map((orderse) -> {
            OrdersFormRest ordersFormRest = new OrdersFormRest(orderse.getCutomers().getEmail(), orderse.getOrderDate());
            Set<OrdersDetailsFormRest> ordersDetailsFormRests = new HashSet<>();
            BigDecimal totalCost = BigDecimal.ZERO;
            orderse.getOrderDetailses().forEach((orderDetailse) -> {
                BigDecimal itemCost = BigDecimal.ZERO;
                OrdersDetailsFormRest formRest = new OrdersDetailsFormRest();
                formRest.setProductName(orderDetailse.getProducts().getName());
                formRest.setUnitPrice(orderDetailse.getUnitPrice());
                formRest.setQuantity(orderDetailse.getQuantity());
                itemCost = orderDetailse.getUnitPrice().multiply(new BigDecimal(orderDetailse.getQuantity()));
                totalCost.add(itemCost);

                ordersDetailsFormRests.add(formRest);
            });
            ordersFormRest.setOrdersDetailsFormRests(ordersDetailsFormRests);
            ordersFormRest.setTotalAmount(totalCost);
            return ordersFormRest;
        }).forEachOrdered((ordersFormRest) -> {
            ordersFormRests.add(ordersFormRest);
        });
        return new ResponseEntity<>(ordersFormRests, HttpStatus.OK);
    }
}
