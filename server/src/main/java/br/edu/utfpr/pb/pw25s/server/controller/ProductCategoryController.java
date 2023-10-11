package br.edu.utfpr.pb.pw25s.server.controller;

import br.edu.utfpr.pb.pw25s.server.dto.CategoryDTO;
import br.edu.utfpr.pb.pw25s.server.model.ProductCategory;
import br.edu.utfpr.pb.pw25s.server.service.ICrudService;
import br.edu.utfpr.pb.pw25s.server.service.IProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class ProductCategoryController extends CrudController<ProductCategory, CategoryDTO, Long> {

    private static IProductCategoryService categoryService;
    private static ModelMapper modelMapper;

    public ProductCategoryController(IProductCategoryService categoryService,
                                     ModelMapper modelMapper) {
        super(ProductCategory.class, CategoryDTO.class);
        ProductCategoryController.categoryService = categoryService;
        ProductCategoryController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<ProductCategory, Long> getService() {
        return ProductCategoryController.categoryService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return ProductCategoryController.modelMapper;
    }
}
