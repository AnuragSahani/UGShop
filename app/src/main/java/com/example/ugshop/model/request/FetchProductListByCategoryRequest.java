package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
/*@GetMapping(value = "/products")
//	@RequestMapping(value = "/products", method=RequestMethod.GET)
public ResponseEntity<List<ProductModel>> fetchProductList() {
        List<ProductModel> productList = productBS.fetchProductList();
        return new ResponseEntity<List<ProductModel>>(productList, HttpStatus.OK);
        }

@GetMapping(value = "/productbycategory")
//	@RequestMapping(value ="/productbycategory", method = RequestMethod.GET)
public ResponseEntity<List<ProductModel>> fetchProductListByCategory(@RequestParam int catId)  {
        List<ProductModel> productListByCategory = productBS.fetchProductListByCategory(catId);
        return new ResponseEntity<List<ProductModel>>(productListByCategory, HttpStatus.ACCEPTED);
        }

@GetMapping(value = "/productbysubcategory")
public ResponseEntity<List<ProductModel>> fetchProductBySubCategory(@RequestParam int catId, @RequestParam int subCatId){
        List<ProductModel> productBySubCat = productBS.fetchProductBySubCategory(catId, subCatId);
        return new ResponseEntity<List<ProductModel>>(productBySubCat,HttpStatus.OK);
        }*/
public class FetchProductListByCategoryRequest extends RequestEntity {
    private int catId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
