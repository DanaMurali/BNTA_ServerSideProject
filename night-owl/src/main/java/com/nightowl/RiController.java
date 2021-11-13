package com.nightowl;

import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ri")
public class RiController {

    private RiService riService;


    public RiController(RiService riService) {
        this.riService = riService;
    }

    @GetMapping
    public List<Ri> listRi() {
        return riService.getRi();
    }

    @GetMapping("{id}")
    public Ri getRiId(@PathVariable("id") Integer id) {
        return riService.getRi(id);
    }
    
    
}
