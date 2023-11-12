package tn.esprit.devops_project.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    Long idProduct;
    String title;
    float price;
    int quantity;
    ProductCategory category;
    Stock stock;
}
