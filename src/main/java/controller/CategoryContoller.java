package controller;

import entities.Category;
import metier.CategoryDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryContoller {

    @Autowired
    private CategoryDaoImpl categoryDao;

    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories: ", categoryDao.getAll());
        return "categories";
        
    }

    @PostMapping("/categories/add")
    public String addCategory(Category category) {
        categoryDao.create(category);
        return "redirect:/categories";
    }




}

