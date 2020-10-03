package com.joraclista.agileengine.challenge.imagelookup.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Alisa
 * version 1.0.
 */
@Data
@NoArgsConstructor
public class Auth {
    private String token;
    private boolean auth;
}
