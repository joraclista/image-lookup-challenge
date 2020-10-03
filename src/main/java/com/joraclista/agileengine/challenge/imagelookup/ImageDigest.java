package com.joraclista.agileengine.challenge.imagelookup;

import com.joraclista.agileengine.challenge.imagelookup.model.Image;

/**
 * Created by Alisa
 * version 1.0.
 */
public interface ImageDigest {
    static String getImageDigest(Image image) {
        return new StringBuilder()
                .append(image.getTags())
                .append(image.getAuthor())
                .append((image.getCamera()))
                .append(image.getId())
                .toString();
    }
}
