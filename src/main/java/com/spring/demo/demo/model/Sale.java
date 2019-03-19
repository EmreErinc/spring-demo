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
@Document(collection = "sale")
public class Sale {
  @Id
  @JsonSerialize(using = ObjectIdSerializer.class)
  private ObjectId id;
  @JsonSerialize(using = ObjectIdSerializer.class)
  private ObjectId userId;
  @JsonSerialize(using = ObjectIdSerializer.class)
  private ObjectId productId;

  public Sale(ObjectId id, ObjectId userId, ObjectId productId) {
    this.id = id;
    this.userId = userId;
    this.productId = productId;
  }
}
