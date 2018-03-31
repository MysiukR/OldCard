package com.epam.lab.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class OldCards {
    private List<OldCard> oldCards;

    @XmlElement
    public List<OldCard> getOldCard() {
        return oldCards;
    }

    public void setOldCard(List<OldCard> oldCards) {
        this.oldCards = oldCards;
    }
}