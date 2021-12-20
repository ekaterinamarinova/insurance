package com.online.insurance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Insurance(@Id Long id, String name, String type, Double price) {
}
