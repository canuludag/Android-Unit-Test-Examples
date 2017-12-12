package com.uludag.can.plantplacespacktfortdd.dto;

public class PlantDTO {

    private int guid;
    private String genus;
    private String species;
    private String cultivar;
    private String common;
    private String type;

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return genus + " " + species + " " + cultivar + " " + common;
    }

    @Override
    public boolean equals(Object obj) {

        PlantDTO otherPlant = (PlantDTO) obj;

        if (genus.equals(otherPlant.getGenus())) {

            return true;
        }

        return false;
    }
}
