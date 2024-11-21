package com.sinfolix.Sai_Samartha.Controller;

import com.sinfolix.Sai_Samartha.DTO.ApiResponse;
import com.sinfolix.Sai_Samartha.DTO.ProductCatalogueDTO;
import com.sinfolix.Sai_Samartha.Entities.ProductCatalogue;
import com.sinfolix.Sai_Samartha.Service.ProductCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCatalogueController {


    @Autowired
    ProductCatalogueService productCatalogueService;

    //post -create product catlogue
    @PostMapping("/")
    public ResponseEntity<ProductCatalogueDTO> createProductCatalogue(@RequestBody ProductCatalogueDTO productCatalogueDTO){
        System.out.println("Hello Ashok");
        ProductCatalogueDTO createproductCatalogueDTO = this.productCatalogueService.createProductCatalogue(productCatalogueDTO);
        return new ResponseEntity<>(createproductCatalogueDTO, HttpStatus.CREATED);
    }


//    Put update product catalogue

    @PutMapping("/{id}")
    public ResponseEntity<ProductCatalogueDTO> updateProductCatlogue(@PathVariable int id, @RequestBody ProductCatalogueDTO productCatlogueDTO){
        ProductCatalogueDTO updatedProductCatlogueDTO = this.productCatalogueService.updateProductCatalogue(productCatlogueDTO, id);
        return new ResponseEntity<>(updatedProductCatlogueDTO, HttpStatus.OK);
//        or return ResponseEntity.ok(updatedProductCatlogueDTO);
    }
    //    DELETE delete catlogue
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProductCatalogue(@PathVariable int id){
        this.productCatalogueService.deleteProductCatalogue(id);
        return ResponseEntity.ok(new ApiResponse("Product Deleted Successfully",true));
    }

    //    DISABLE disable the product
//    @PatchMapping("/{id}/disable")
//    public void disableProduct(@PathVariable int id){
//        productCatalogueService.disableProduct(id);
//    }


//    Get - user catlogue
    @GetMapping("/")
    public ResponseEntity<List<ProductCatalogueDTO>> getAllProducts(){
        return ResponseEntity.ok(this.productCatalogueService.getAllProductCatalogue());
    }
    @GetMapping("product/{id}")
    public ResponseEntity<ProductCatalogueDTO> getProductById(@PathVariable int id){
        return ResponseEntity.ok(this.productCatalogueService.getProductCatalogueById(id));
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<ProductCatalogueDTO>> getProductsByCategory(@PathVariable String category ){
        return ResponseEntity.ok(this.productCatalogueService.getProductByCategory(category.toLowerCase()));
    }
}
