package com.mdorici.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdorici.dscommerce.dto.OrderDTO;
import com.mdorici.dscommerce.entities.Order;
import com.mdorici.dscommerce.repositories.OrderRepository;
import com.mdorici.dscommerce.services.exceptions.ResourceNotFindException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFindException("Recurso não encontrado!"));

		return new OrderDTO(order);
	}
}
