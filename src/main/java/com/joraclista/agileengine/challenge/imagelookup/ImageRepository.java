package com.joraclista.agileengine.challenge.imagelookup;

import com.joraclista.agileengine.challenge.imagelookup.model.Image;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Alisa
 * version 1.0.
 */
@Setter
@NoArgsConstructor
@Controller
public class ImageRepository {
    private Map<String, Image> imagesMap = new HashMap<>();
    private Map<String, String> imagesDigestMap = new HashMap<>();

    public List<Image> getImagesBySearchTerm(String term) {
        return imagesDigestMap.keySet().stream()
                .filter(key -> key.toUpperCase().contains(term.toUpperCase()))
                .map(key -> imagesMap.get(key))
                .collect(Collectors.toList());
    }
}
