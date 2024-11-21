package com.sinfolix.Sai_Samartha.Service;


import com.sinfolix.Sai_Samartha.DTO.ProductCatalogueDTO;
import com.sinfolix.Sai_Samartha.Entities.ProductCatalogue;
import com.sinfolix.Sai_Samartha.Exceptions.ResourceNotFoundException;
import com.sinfolix.Sai_Samartha.Repository.ProductCatalogueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCatalogueService {

    @Autowired
    private ProductCatalogueRepo productCatalogueRepo;  // Assuming ProductCatlogueRepo is defined in the same package


    public ProductCatalogueDTO createProductCatalogue(ProductCatalogueDTO product) {
        ProductCatalogue productCatalogue = DTOtoProductCatalogue(product);
        this.productCatalogueRepo.save(productCatalogue);
        return productCatalogueToDTO(productCatalogue);

    }


    public ProductCatalogueDTO updateProductCatalogue(ProductCatalogueDTO product, Integer productId) {
    // Implement logic to update product in the database and return updated DTO
        ProductCatalogue productCatalogue = this.productCatalogueRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product Catalogue","ID ",productId));
        productCatalogue.setQuantity(product.getQuantity());
        productCatalogue.setPrice(product.getPrice());
        productCatalogue.setDiscount(product.getRealMrp()-product.getDiscountMrp());
        productCatalogue.setCompanyName(product.getCompanyName());
        productCatalogue.setMedicineName(product.getMedicineName());
        productCatalogue.setMinAge(product.getMinAge());
        productCatalogue.setMaxAge(product.getMaxAge());
        productCatalogue.setRealMrp(product.getRealMrp());
        productCatalogue.setDiscountMrp(product.getDiscountMrp());
        productCatalogue.setCategories(product.getCategories());
        return productCatalogueToDTO(this.productCatalogueRepo.save(productCatalogue));
    }


    public ProductCatalogueDTO getProductCatalogueById(Integer productId) {
        ProductCatalogue productCatalogue = this.productCatalogueRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product Catlogue","ID ",productId));

        return productCatalogueToDTO(productCatalogue);
    }


    public List<ProductCatalogueDTO> getAllProductCatalogue() {
        List<ProductCatalogue> productCatalogue = this.productCatalogueRepo.findAll();
        List<ProductCatalogueDTO> productCatalogueDTO =productCatalogue.stream().map(e -> this.productCatalogueToDTO(e)).collect(Collectors.toList());


        return productCatalogueDTO;
    }


    public void deleteProductCatalogue(Integer productId) {
        ProductCatalogue productCatalogue = this.productCatalogueRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product Catlogue","ID ",productId));
        this.productCatalogueRepo.delete(productCatalogue);
    }


    public List<ProductCatalogueDTO> getProductByCategory(String category) {
        List<ProductCatalogue> productCatalogue = this.productCatalogueRepo.findByCategory(category);
        List<ProductCatalogueDTO> productCatalogueDTO = productCatalogue.stream().map(e-> this.productCatalogueToDTO(e)).collect(Collectors.toList());
        return productCatalogueDTO;
    }



    private ProductCatalogue DTOtoProductCatalogue(ProductCatalogueDTO productCatalogueDTO) {
        ProductCatalogue productCatalogue = new ProductCatalogue();
        // Mapping fields from DTO to Entity

        productCatalogue.setId(productCatalogueDTO.getId());
        productCatalogue.setImage(productCatalogueDTO.getImage());
        productCatalogue.setQuantity(productCatalogueDTO.getQuantity());
        productCatalogue.setPrice(productCatalogueDTO.getPrice());
        productCatalogue.setDiscount(productCatalogueDTO.getDiscount());
        productCatalogue.setCompanyName(productCatalogueDTO.getCompanyName());
        productCatalogue.setMedicineName(productCatalogueDTO.getMedicineName());
        productCatalogue.setMinAge(productCatalogueDTO.getMinAge());
        productCatalogue.setMaxAge(productCatalogueDTO.getMaxAge());
        productCatalogue.setRealMrp(productCatalogueDTO.getRealMrp());
        productCatalogue.setDiscountMrp(productCatalogueDTO.getDiscountMrp());
        productCatalogue.setProdDescription(productCatalogueDTO.getProdDescription());
        productCatalogue.setComments(productCatalogueDTO.getComments());
        productCatalogue.setCategories(productCatalogueDTO.getCategories());

        return productCatalogue;

    }

    private ProductCatalogueDTO productCatalogueToDTO(ProductCatalogue productCatlogue) {
        ProductCatalogueDTO productCatalogueDTO = new ProductCatalogueDTO();
        // Mapping fields from Entity to DTO

        productCatalogueDTO.setId(productCatlogue.getId());
        productCatalogueDTO.setQuantity(productCatlogue.getQuantity());
        productCatalogueDTO.setImage(productCatlogue.getImage());
        productCatalogueDTO.setPrice(productCatlogue.getPrice());
        productCatalogueDTO.setDiscount(productCatlogue.getDiscount());
        productCatalogueDTO.setCompanyName(productCatlogue.getCompanyName());
        productCatalogueDTO.setMedicineName(productCatlogue.getMedicineName());
        productCatalogueDTO.setMinAge(productCatlogue.getMinAge());
        productCatalogueDTO.setMaxAge(productCatlogue.getMaxAge());
        productCatalogueDTO.setRealMrp(productCatlogue.getRealMrp());
        productCatalogueDTO.setDiscountMrp(productCatlogue.getDiscountMrp());
        productCatalogueDTO.setProdDescription(productCatlogue.getProdDescription());
        productCatalogueDTO.setComments(productCatlogue.getComments());
        productCatalogueDTO.setCategories(productCatlogue.getCategories());
        return productCatalogueDTO;
    }



}
