package com.mongo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "productos")
public class Producto {
	
    @Id
    private String id;
    
    private String nombre;
    
    private Date fecha;
    
    private Double precio;

}
