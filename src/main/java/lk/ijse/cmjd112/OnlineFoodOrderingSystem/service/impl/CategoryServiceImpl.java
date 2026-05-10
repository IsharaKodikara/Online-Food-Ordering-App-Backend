package lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.dto.CategoryDTO;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity.Category;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.repository.CategoryRepository;
import lk.ijse.cmjd112.OnlineFoodOrderingSystem.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        categoryRepository.save(category);

        dto.setId(category.getId());
        return dto;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> {
                    CategoryDTO dto = new CategoryDTO();
                    dto.setId(c.getId());
                    dto.setName(c.getName());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());
        categoryRepository.save(category);
        return dto;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
