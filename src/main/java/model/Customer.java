package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "customer")
public class Customer {
  @Id
  private Integer id;
  private String firstName;
  private String lastName;

  public String toString() {
    return "CustomerModel [id = " + id + ",firstName = " + firstName + ", lastName = " + lastName + " ]";
  }
}
