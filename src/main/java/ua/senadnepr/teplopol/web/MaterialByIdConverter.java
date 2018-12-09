package ua.senadnepr.teplopol.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ua.senadnepr.teplopol.Material;
import ua.senadnepr.teplopol.data.MaterialRepository;

import java.util.Optional;

public class MaterialByIdConverter implements Converter<String, Material> {

    private MaterialRepository materialRepo;

    @Autowired

    public MaterialByIdConverter(MaterialRepository materialRepo) {
        this.materialRepo = materialRepo;
    }

    @Override
    public Material convert(String id) {
        Optional<Material> optionalMaterial = materialRepo.findById(id);
        return optionalMaterial.isPresent() ?
                optionalMaterial.get() : null;
    }

}
