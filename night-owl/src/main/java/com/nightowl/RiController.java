package com.nightowl;

import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientService;
import com.nightowl.recipes.Recipe;
import com.nightowl.user.User;
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
    public List<RiTwo> listRiTwo(@RequestParam (required = false) String allergen, @RequestParam (required = false) Integer cookingTime) {
        User user = new User();
        if (allergen != null) {
            user.setAllergy(allergen);
        } else {
            user.setAllergy("null");
        }

        if (cookingTime != null) {
            user.setCookingTime(cookingTime);
        } else {
            user.setCookingTime(300);
        }

        return riService.getRiTwo(user);
    }



    @GetMapping("{id}")
    public Ri getRiId(@PathVariable("id") Integer id) {
        return riService.getRi(id);
    }

    @PostMapping
    public void addRi(@RequestBody Ri ri) {
        riService.addNewRi(ri);
    }

    @DeleteMapping("{id}")
    public void deleteRi(@PathVariable("id") Integer id) {
        riService.deleteRi(id);
    }

    @PutMapping("{id}")
    public void updateRi(@RequestBody Ri ri, @PathVariable("id") Integer id) { riService.updateRi(ri,id);}



}
