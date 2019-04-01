package com.sag.routes.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sag.routes.model.Organization;
import com.sag.routes.model.ProductData;
import com.sag.routes.model.ProductDataList;
import com.sag.routes.service.ServiceI;

@RestController
@RequestMapping("/product") 
public class ProductController 
{
	
	@Autowired
	private ServiceI serviceI;

	@GetMapping(value = "/productdata")
	/*public ResponseEntity<Organization> getOrganizationById(@PathVariable("oId") Integer oId) {
		Organization organization = serviceI.getOrganizationById(oId);
		return new ResponseEntity<Organization>(organization , HttpStatus.OK);
	}*/
	public ResponseEntity<ProductDataList> getProductData(@PathVariable("productId") int[] productId) 
	{        
	    ArrayList<ProductData> products = serviceI.getProductData(productId);

	    ProductData[] pdArray = new ProductData[products.size()];
	    products.toArray(pdArray);
	    ProductDataList productDataList = new ProductDataList();
	    productDataList.setProductData(pdArray);

	    return new ResponseEntity<ProductDataList>(productDataList , HttpStatus.OK);
	   // return productDataList;
	}
	
	
	
	@RequestMapping(path = "/all", produces=MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ProductData> getAll() {
        // This returns a JSON or XML with the users

        Iterable<ProductData> assureurs = new ArrayList<>();
        assureurs = serviceI.getProductData();
        return assureurs;
    }
}
