package com.callum.model.items;

/**
 * Created by callummarriage on 26/04/2018.
 */
public interface Item {

    public boolean isActive();

    public void setInactive(boolean inActive);

    public String giveDescription();

    public String getName();
}
