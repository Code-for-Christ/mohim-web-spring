package com.mohim.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ChurchesResponse {
    private List<ChurchDTO> churches;
}
