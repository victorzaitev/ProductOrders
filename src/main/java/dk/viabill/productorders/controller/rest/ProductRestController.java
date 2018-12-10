/**
 * <h1>ProductRestController</h1>
 * The ProductRestController program implements an application that simply
 * acction for product.
 */
package dk.viabill.productorders.controller.rest;

import dk.viabill.productorders.entity.Products;
import dk.viabill.productorders.entity.request.ProductRequestForm;
import dk.viabill.productorders.entity.request.UpdateProductRequestForm;
import dk.viabill.productorders.entity.rest.ProductsFormRest;
import dk.viabill.productorders.repository.ProductsRepository;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductsRepository productsRepository;

    /**
     * This method is used for show all product details storage in database
     *
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<ProductsFormRest>> getListActivityDomains() {
        return new ResponseEntity<>(productsRepository.findAllProducts(), HttpStatus.OK);
    }

    /**
     * This method is used for save the product details
     *
     * @param request This is the first paramater
     * @param bindingResult This is the second parameter
     * @return int status code
     */
    @PostMapping("/save")
    public ResponseEntity<Integer> saveProduct(@Valid @RequestBody ProductRequestForm request, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }

        Products products = productsRepository.findByName(request.getName());
        if (products == null) {
            products = new Products();
        }
        products.setName(request.getName().trim().replaceAll(" +", " "));
        products.setUnitPrice(request.getUnitPrice());
        products.setCreateAt(new Date());
        products.setActive(true);
        productsRepository.save(products);

        return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);

    }

    /**
     *
     * This method is used for update the product details
     *
     * @param request This is the first paramater
     * @param bindingResult This is the second parameter
     * @return int status code
     */
    @PutMapping("/update")
    public ResponseEntity<Integer> updateProduct(@Valid @RequestBody UpdateProductRequestForm request, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }

        Products products = productsRepository.getOne(request.getId());
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }

        products.setName(request.getName());
        products.setUnitPrice(request.getUnitPrice());
        products.setModifiedAt(new Date());
        products.setActive(true);
        productsRepository.save(products);

        return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);

    }

    /**
     *This method is used for delete the product details by id
     * @param productId specific product id
     * @return int http status
     */
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable int productId) {
        Products products = productsRepository.getOne(productId);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
        products.setActive(false);
        productsRepository.save(products);
        return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);
    }

}
