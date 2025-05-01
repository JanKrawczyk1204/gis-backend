package com.template.productservice.mediator;

import com.template.productservice.entity.*;
import com.template.productservice.exceptions.CategoryDoesntExistException;
import com.template.productservice.service.CategoryService;
import com.template.productservice.service.ProductService;
import com.template.productservice.translator.ProductEntityToProductDTO;
import com.template.productservice.translator.ProductEntityToSimpleProduct;
import com.template.productservice.translator.ProductFormToProductEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMediator {
    private static final Logger logger = LoggerFactory.getLogger(ProductMediator.class);
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductEntityToSimpleProduct productEntityToSimpleProduct;
    private final ProductEntityToProductDTO productEntityToProductDTO;
    private final ProductFormToProductEntity formToProductEntity;
    @Value("${file-service.url}")
    private String FILE_SERVICE;

    public ResponseEntity<?> getProduct(int page, int limit, String name, String category, Float price_min, Float price_max, String data, String sort, String order) {
        if (name != null && !name.isEmpty())
            name = URLDecoder.decode(name, StandardCharsets.UTF_8);

        List<ProductEntity> product = productService.getProduct(name, category, price_min, price_max, data,page, limit, sort, order);

        product.forEach(value-> {
            for (int i = 0; i < value.getImageUrls().length; i++)
                value.getImageUrls()[i] = FILE_SERVICE + "?uuid=" + value.getImageUrls()[i];
        });

        if (name == null || name.isEmpty() || data == null || data.isEmpty()) {
            List<SimpleProductDTO> simpleProductDTOS = new ArrayList<>();
            long totalCount  = productService.countActiveProducts(name, category, price_min, price_max);
            product.forEach(value -> {
                simpleProductDTOS.add(productEntityToSimpleProduct.toSimpleProduct(value));
            });
            return ResponseEntity.ok().header("X-Total-Count", String.valueOf(totalCount)).body(simpleProductDTOS);
        }
        ProductDTO productDTO = productEntityToProductDTO.toProductDTO(product.get(0));
        return ResponseEntity.ok().body(productDTO);
    }

    public ResponseEntity<Response> saveProduct(ProductFormDTO productFormDTO) {
        try{
            ProductEntity product = formToProductEntity.toProductEntity(productFormDTO);
            categoryService.findCategoryByShortID(product.getCategory().getShortId()).ifPresentOrElse(product::setCategory,()-> {
                throw new CategoryDoesntExistException();
            });
            productService.createProduct(product);
            return ResponseEntity.ok(new Response("Successful created a product"));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(new Response("Can't create product category don't exist"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<Response> deleteProduct(String uuid) {
        try {
            productService.delete(uuid);
            return ResponseEntity.ok(new Response("Successful delete product"));
        } catch (RuntimeException e){
            return ResponseEntity.status(400).body(new Response("Product doesn't exist"));
        }
    }

    public ResponseEntity<?> getProductExtend(String uuid) {
        System.out.println("Requested UUID: " + uuid);
        System.out.println(org.hibernate.Version.getVersionString());
        ProductEntity product = productService.getProductByUuid(uuid).orElse(null);
        if (product != null) {
            System.out.println("Product found: " + product);
            for (int i = 0; i < product.getImageUrls().length; i++) {
                product.getImageUrls()[i] = FILE_SERVICE + "?uuid=" + product.getImageUrls()[i];
            }
            return ResponseEntity.ok(product);
        }
        System.out.println("Product not found for UUID: " + uuid);
        return ResponseEntity.status(400).body(new Response("Product doesn't exist"));
    }
}
