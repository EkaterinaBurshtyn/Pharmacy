package org.burshtyn.pharmacy.dto;


import java.util.ArrayList;
import java.util.List;

public class GroupDto extends BaseDto {

    private String name;

    private List<PreparationDto> preparations = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PreparationDto> getPreparations() {
        return preparations;
    }

    public void setPreparations(List<PreparationDto> preparations) {
        this.preparations = preparations;
    }
}
