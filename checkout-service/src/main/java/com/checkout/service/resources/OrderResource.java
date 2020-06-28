package com.checkout.service.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkout.service.model.Order;
import com.checkout.service.resources.vo.OrderVO;
import com.checkout.service.services.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class webservices Order
 * 
 * @author nelson-penagos
 *
 */
@RestController
@RequestMapping("/api/checkout")
@Api(tags = "order")
public class OrderResource {
	
	private final OrderService orderService;
	
	public OrderResource(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	@ApiOperation(value = "Create Order", notes = "service to create an order")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Order created successfully"),
			@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<Order> createOrder(@RequestBody OrderVO orderVo){
		Order order = new Order();
		order.setDate(orderVo.getDate());
		order.setDirection(orderVo.getDirection());
		order.setProducts(order.getProducts());
		return new ResponseEntity<Order>(this.orderService.create(order), HttpStatus.CREATED);
	}
}
