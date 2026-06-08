package com.hglsys.nodues.utility;

import com.hglsys.nodues.Dto.PagedResponse;
import org.springframework.data.domain.Page;

public class PaginationUtil {

    public static <T> PagedResponse<T> toPagedResponse(Page<T> pageData) {
        return new PagedResponse<>(
                pageData.getContent(),
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages(),
                pageData.isFirst(),
                pageData.isLast()
        );
    }
}
