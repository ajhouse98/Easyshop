package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController
{
    private CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    @PreAuthorize("permitAll()")
    public List<Category> search(@RequestParam(name="cat", required = false) Integer categoryId,
                                @RequestParam(name="minPrice", required = false) BigDecimal minPrice,
                                @RequestParam(name="maxPrice", required = false) BigDecimal maxPrice,
                                @RequestParam(name="color", required = false) String color
    )
    {
        try
        {
            return categoryDao.getAllCategories();
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public Category getById(@PathVariable int id )
    {
        try
        {
            var category = categoryDao.getById(id);

            if(category == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            return category;
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Category addCategory(@RequestBody Category category)
    {
        try
        {
            return categoryDao.create(category);
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        try
        {
            categoryDao.create(category);
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCategory(@PathVariable int id)
    {
        try
        {
            var category = categoryDao.getById(id);

            if(category == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            categoryDao.delete(id);
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }
}



















//@RestController
//@RequestMapping("categories")
//@CrossOrigin
//public class CategoriesController
//{
//    private CategoryDao CategoryDao;
//
//    @Autowired
//    public CategoriesController(CategoryDao categoryDao)
//    {
//        this.CategoryDao = categoryDao;
//    }
//
//// add the annotations to make this a REST controller
//// add the annotation to make this controller the endpoint for the following url
//    // http://localhost:8080/categories
//// add annotation to allow cross site origin requests
//
//    private CategoryDao categoryDao;
//
//
//    // create an Autowired controller to inject the categoryDao and Categories
//    Dao
//
//    // add the appropriate annotation for a get action
//    public List<Category> getAll()
//    {
//        // find and return all categories
//        return null;
//    }
//
//    // add the appropriate annotation for a get action
//    public Category getById(@PathVariable int id)
//    {
//        // get the category by id
//        return null;
//    }
//
//    // the url to return all Categories
//    s in category 1 would look like this
//    // https://localhost:8080/categories/1/Categories
//    s
//    @GetMapping("{categoryId}/Categories
//    s")
//    public List<Categories
//    > getCategories
//    sById(@PathVariable int categoryId)
//    {
//        // get a list of Categories
//        by categoryId
//        return null;
//    }
//
//    // add annotation to call this method for a POST action
//    // add annotation to ensure that only an ADMIN can call this function
//    public Category addCategory(@RequestBody Category category)
//    {
//        // insert the category
//        return null;
//    }
//
//    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
//    // add annotation to ensure that only an ADMIN can call this function
//    public void updateCategory(@PathVariable int id, @RequestBody Category category)
//    {
//        // update the category by id
//    }
//
//
//    // add annotation to call this method for a DELETE action - the url path must include the categoryId
//    // add annotation to ensure that only an ADMIN can call this function
//    public void deleteCategory(@PathVariable int id)
//    {
//        // delete the category by id
//    }
//}
