package com.spring.demo.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class SaleRequest {
  private ObjectId userId;
  private ObjectId productId;
}
