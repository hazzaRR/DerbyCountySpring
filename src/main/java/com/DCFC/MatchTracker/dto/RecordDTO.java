package com.DCFC.MatchTracker.dto;

public class RecordDTO {
    private String result;

    private Long count;

    public RecordDTO() {
    }

    public RecordDTO(String result, Long count) {
        this.result = result;
        this.count = count;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
