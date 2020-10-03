package com.joraclista.agileengine.challenge.imagelookup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Alisa
 * version 1.0.
 */
@Data
@NoArgsConstructor
public class Image {
    private String id;

    private String author;
    private String camera;
    private String tags;
    @JsonProperty(value = "cropped_picture")
    private String croppedPicture;
    @JsonProperty(value = "full_picture")
    private String fullPicture;
}
