package com.joraclista.agileengine.challenge.imagelookup.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
@Data
@NoArgsConstructor
public class PageOfImages {
    private List<Image> pictures;
    private int page;
    private int pageCount;
    private boolean hasMore;
}
