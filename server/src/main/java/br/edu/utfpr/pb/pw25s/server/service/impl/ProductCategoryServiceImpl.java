package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.ProductCategory;
import br.edu.utfpr.pb.pw25s.server.repository.ProductCategoryRepository;
import br.edu.utfpr.pb.pw25s.server.service.IProductCategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl extends CrudServiceImpl<ProductCategory, Long>
        implements IProductCategoryService {

    private final ProductCategoryRepository categoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<ProductCategory, Long> getRepository() {
        return categoryRepository;
    }
}
