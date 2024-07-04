package com.nompat.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Product {

    private Integer id;

    private String name;

    private Date createdDate;

    private Boolean active;

}
