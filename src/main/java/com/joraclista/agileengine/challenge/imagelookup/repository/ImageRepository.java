package com.joraclista.agileengine.challenge.imagelookup.repository;

import com.joraclista.agileengine.challenge.imagelookup.model.Image;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by Alisa
 * version 1.0.
 */

@NoArgsConstructor
@Setter
@Controller
public class ImageRepository {
    private Map<String, Image> imagesMap = new HashMap<>();
    private Map<String, String> imagesDigestMap = new HashMap<>();

    public List<Image> getImagesBySearchTerm(String term) {
        return imagesDigestMap.entrySet().stream()
                .filter(entry -> entry.getKey().toUpperCase().contains(term.toUpperCase()))
                .map(entry -> imagesMap.get(entry.getValue()))
                .collect(toList());
    }
}
