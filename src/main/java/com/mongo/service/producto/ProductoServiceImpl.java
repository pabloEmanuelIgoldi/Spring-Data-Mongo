package com.mongo.service.producto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mongo.controller.dto.ProductoRequestDTO;
import com.mongo.controller.dto.ProductoResponseDTO;
import com.mongo.entity.Producto;
import com.mongo.service.repository.ProductoRepository;

import lombok.extern.slf4j.Slf4j;

import com.mongo.exception.EntityNotFoundException;

@Slf4j
@Service
public class ProductoServiceImpl implements IProductoService{

	private final ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public List<ProductoResponseDTO> findAll() {
		log.info("INGRESA A  ProductoServiceImpl.findAll()");
		return this.mapperList(productoRepository.findAll());
	}

	private List<ProductoResponseDTO> mapperList(List<Producto> list) {
		return list.stream()
				   .map(p -> new ProductoResponseDTO(p.getId(), p.getNombre(), p.getFecha(), p.getPrecio()))
				   .collect(Collectors.toList());
	}

	public ProductoResponseDTO findById(String id) {
		log.info("INGRESA A  ProductoServiceImpl.findById(). ID: " + id);
		return productoRepository.findById(id)
		        .map(p -> new ProductoResponseDTO(p.getId(), p.getNombre(), p.getFecha(), p.getPrecio()))
		        .orElseThrow(() -> {
		            log.error("ERROR EN ProductoServiceImpl.findById(). Producto no encontrado con id: " + id);
		            return new EntityNotFoundException("Producto no encontrado con id: " + id);
		        });
	}

	private ProductoResponseDTO mapperProductoDTO(Producto p) {
		return new ProductoResponseDTO(p.getId(), p.getNombre(), p.getFecha(), p.getPrecio());
		       
	}

	public ProductoResponseDTO save(ProductoRequestDTO request) {
		log.info("INGRESA A  ProductoServiceImpl.save().");
		Producto newProducto = Producto.builder()
									   .fecha(request.getFecha())
									   .nombre(request.getNombre())
									   .precio(request.getPrecio())
									   .build();
		Producto savedProducto = productoRepository.save(newProducto);
		return this.mapperProductoDTO(savedProducto);
	}

	public void deleteById(String id) {
		log.info("INGRESA A  ProductoServiceImpl.deleteById(). ID: " +id);
		Optional<Producto> optionalProducto = productoRepository.findById(id);
		if (optionalProducto.isPresent()) {
			productoRepository.deleteById(id);
		}else {
			log.error("ERROR EN ProductoServiceImpl.deleteById(). Producto no encontrado con id: " + id);
			throw new EntityNotFoundException("Producto no encontrado con id: " + id);
		}
	}

	public ProductoResponseDTO update(String id, ProductoRequestDTO productoDetails) {
		log.info("INGRESA A  ProductoServiceImpl.update(). ID: " +id);
		Optional<Producto> optionalProducto = productoRepository.findById(id);
		if (optionalProducto.isPresent()) {
			Producto existingProducto = optionalProducto.get();
			existingProducto.setNombre(productoDetails.getNombre());
			existingProducto.setFecha(productoDetails.getFecha());
			existingProducto.setPrecio(productoDetails.getPrecio());
			Producto savedProducto = productoRepository.save(existingProducto);
			return this.mapperProductoDTO(savedProducto);			
		} else {
			log.error("ERROR EN ProductoServiceImpl.update(). Producto no encontrado con id: " + id);
			throw new EntityNotFoundException("Producto no encontrado con id: " + id);
		}
	}

}
