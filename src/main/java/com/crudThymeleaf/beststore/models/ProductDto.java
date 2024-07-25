package com.crudThymeleaf.beststore.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotEmpty(message = "This name is required")
    private String name;

    @NotEmpty(message = "This brand is required")
    private String brand;;

    @NotEmpty(message = "This category is required")
    private String category;

    @Min(0)
    private double price;

    @Size(min = 10, message = "The description should be at least 10 characters")
    @Size(max = 2000, message = "The description can't exceed 2000 characters")
    private String description;

    private MultipartFile imageFile;
}
