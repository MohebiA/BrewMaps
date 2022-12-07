package com.techelevator.services;

import com.techelevator.model.ZipLongLat;

public interface LocationConverter {

    ZipLongLat getCoordinates(int zip);

}
