
package com.example.mybrewery.models;

import java.io.Serializable;
import java.util.List;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BreweryResponse implements Serializable {

    @SerializedName("drinks")
    @Expose
    private List<Brewery> drinks = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BreweryResponse() {
    }

    /**
     * 
     * @param drinks
     */
    public BreweryResponse(List<Brewery> drinks) {
        super();
        this.drinks = drinks;
    }

    public List<Brewery> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Brewery> drinks) {
        this.drinks = drinks;
    }

}
