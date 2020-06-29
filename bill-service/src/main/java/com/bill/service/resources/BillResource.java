package com.bill.service.resources;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.service.model.Bill;
import com.bill.service.resources.vo.BillVO;
import com.bill.service.resources.vo.ProductVO;
import com.bill.service.services.BillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class webservices Bill
 * 
 * @author nelson-penagos
 *
 */
@RestController
@RequestMapping("/api/bill")
@Api(tags = "bill")
public class BillResource {
	private final BillService billService;

	public BillResource(BillService billService) {
		this.billService = billService;
	}

	@PostMapping
	@ApiOperation(value = "Create Bill", notes = "service to create an bill")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Bill created successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Bill> createBill(@RequestBody BillVO billVo) {
		Bill bill = new Bill();
		bill.setDate(billVo.getDate());
		bill.setOrderId(billVo.getOrderId());
		bill.setTotal(getTotal(billVo.getProduct()));
		return new ResponseEntity<Bill>(this.billService.create(bill), HttpStatus.CREATED);
	}
	
	/**
	 * Sum all products cost  
	 *  
	 * @param productVo
	 * @return Double
	 */
	public Double getTotal(List<ProductVO> productVo) {
		Double total = 0.0;
		for (ProductVO product : productVo) {
			total += product.getCost().doubleValue();
		}
		return total;
	}
}
