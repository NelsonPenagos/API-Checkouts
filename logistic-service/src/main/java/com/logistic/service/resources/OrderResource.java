package com.logistic.service.resources;

import java.util.Collections;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.logistic.service.model.Order;
import com.logistic.service.resources.vo.BillVO;
import com.logistic.service.resources.vo.OrderVO;
import com.logistic.service.services.OrderService;

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
@RequestMapping("/api/logistic")
@Api(tags = "order")
@Component
public class OrderResource {

	private final String STATE_ORDER = "SENT_ORDER";
	private final OrderService orderService;

	@Autowired
	RestTemplate restTemplate;

	public OrderResource(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 
	 * Method to call createOrder
	 * 
	 * @param orderVo
	 * @return
	 */
	@PostMapping
	@ApiOperation(value = "Create Order", notes = "service to create an order")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Order created successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Order> createOrder(@RequestBody OrderVO orderVo) {
		Order order = new Order();
		order.setDate(orderVo.getDate());
		order.setDirection(orderVo.getDirection());
		order.setState_order(STATE_ORDER);
		order.setProducts(orderVo.getProducts());
		this.orderService.create(order);
		createBill(orderVo);
		return new ResponseEntity<Order>(HttpStatus.CREATED);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Listener for create order MQ
	 * 
	 * @param orderVo
	 */
	@RabbitListener(queues = "queue_name")
	public void createOrderMQ(OrderVO orderVo) {
		Order order = new Order();
		order.setDate(orderVo.getDate());
		order.setDirection(orderVo.getDirection());
		order.setState_order(STATE_ORDER);
		order.setProducts(orderVo.getProducts());
		this.orderService.create(order);
		//createBill(orderVo);
		
	}
	
	public void createBill(OrderVO orderVo) {
		BillVO bill = new BillVO();
		bill.setDate(orderVo.getDate());
		//bill.setProduct(orderVo.getProducts());
//		// bill.setOrderId(orderVo.get);		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	
		HttpEntity<BillVO> request = new HttpEntity<>(bill,headers);
	   
		restTemplate.postForEntity("http://bill-service/api/bill", request, BillVO.class);
		System.out.println("Response Received as " );
	}

}
