package com.spring.demo.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.demo.demo.ObjectIdSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@JsonSerialize
@Document(collection = "product")
public class Product {
  @Id
  @JsonSerialize(using = ObjectIdSerializer.class)
  private ObjectId id;
  private String name;

  public Product(ObjectId id, String name) {
    this.id = id;
    this.name = name;
  }

  public String toString() {
    return "ProductModel [id = " + id + ",name = " + name + " ]";
  }
}
