package com.donContainer.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlideRequestDTO {

    private String imageUrl;
    private String text;
    private int order;
    private Long proyectId;

}
