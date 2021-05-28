package com.qsspy.TAIbackend.dtos.product;

import com.qsspy.TAIbackend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private float price;

    private float vat;

    private float discountPercent;

    private String shortDescription;

    private String longDescription;

    private Byte[] image;

    private Category category;
}
