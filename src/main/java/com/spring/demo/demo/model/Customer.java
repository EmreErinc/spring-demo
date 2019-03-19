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
@Document(collection = "customer")
public class Customer {
  @Id
  @JsonSerialize(using = ObjectIdSerializer.class)
  private ObjectId id;
  private String firstName;
  private String lastName;

  public Customer(ObjectId id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String toString() {
    return "CustomerModel [id = " + id + ",firstName = " + firstName + ", lastName = " + lastName + " ]";
  }
}
