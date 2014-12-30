package it.unisa.dottorato.phdProfile.collaborations;

import java.io.Serializable;
import java.util.Date;

public class Collaboration implements Serializable {
    
    private int idCollaboration;
    private String istitution;
    private String description;
    private Date startDate;
    private Date endDate;
    private String FK_Strudent;

    public int getIdCollaboration() {
        return idCollaboration;
    }

    public void setIdCollaboration(int idCollaboration) {
        this.idCollaboration = idCollaboration;
    }

    public String getIstitution() {
        return istitution;
    }

    public void setIstitution(String istitution) {
        this.istitution = istitution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFK_Strudent() {
        return FK_Strudent;
    }

    public void setFK_Strudent(String FK_Strudent) {
        this.FK_Strudent = FK_Strudent;
    }  
    
}
