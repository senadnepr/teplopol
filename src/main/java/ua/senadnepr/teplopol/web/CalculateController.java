package ua.senadnepr.teplopol.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.senadnepr.teplopol.Building;
import ua.senadnepr.teplopol.Material;
import ua.senadnepr.teplopol.Material.Type;
import ua.senadnepr.teplopol.Order;
import ua.senadnepr.teplopol.data.BuildingRepository;
import ua.senadnepr.teplopol.data.MaterialRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/calculate")
@SessionAttributes("order")
public class CalculateController {

    private final MaterialRepository materialRepo;

    private BuildingRepository buildingRepo;

    @Autowired
    public CalculateController(
            MaterialRepository ingredientRepo,
            BuildingRepository buildingRepo) {
        this.materialRepo = ingredientRepo;
        this.buildingRepo = buildingRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "building")
    public Building building() {
        return new Building();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Material> materials = new ArrayList<>();
        materialRepo.findAll().forEach(i -> materials.add(i));

        Type[] types = Material.Type.values();
        for (Type type : types
             ) {
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(materials, type));
        }
        return "calculate";
    }



    @PostMapping
    public String processCalculate(@Valid @ModelAttribute("calculate") Building building, Errors errors,
                                    Model model) {
        if (errors.hasErrors()) {
            return "calculate";
        }

        Building saved = buildingRepo.save(building);
        order().addBuilding(saved);
        return "redirect:/orders/current";
    }

    private List<Material> filterByType(
            List<Material> materials, Type type) {
        return materials
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
