package com.spring.demo.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Stats {
  private Integer customerCount;
  private Integer productCount;
  private Integer saleCount;
}
