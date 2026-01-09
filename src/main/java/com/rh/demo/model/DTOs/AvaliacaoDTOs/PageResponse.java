package com.rh.demo.model.DTOs.AvaliacaoDTOs;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        int totalPages,
        long totalElements,
        boolean first,
        boolean last
) {
}
