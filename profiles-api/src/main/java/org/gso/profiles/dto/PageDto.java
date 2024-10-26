package org.gso.profiles.dto;

import lombok.Data;

import java.net.URI;
import java.util.List;

@Data
/**
 * DTO to expose paginable results
 */
public class PageDto<T> {

    private int pageSize;
    private long totalElements;
    private URI next;
    private URI first;
    private URI last;
    private List<T> data;
}
