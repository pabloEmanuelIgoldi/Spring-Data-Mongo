package com.mongo.controller.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductoResponseDTO {
	
	private String id;
    private String nombre;    
    private Date fecha;    
    private Double precio;
}
