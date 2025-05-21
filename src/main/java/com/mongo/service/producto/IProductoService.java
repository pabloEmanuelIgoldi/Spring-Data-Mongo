package com.mongo.service.producto;

import java.util.List;
import com.mongo.controller.dto.ProductoRequestDTO;
import com.mongo.controller.dto.ProductoResponseDTO;

public interface IProductoService {

	List<ProductoResponseDTO> findAll();

	ProductoResponseDTO findById(String id);

	ProductoResponseDTO save(ProductoRequestDTO producto);

	void deleteById(String id);

	ProductoResponseDTO update(String id, ProductoRequestDTO productoDetails);
	
}
