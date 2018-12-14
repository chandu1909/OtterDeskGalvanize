package com.galvanize.assessment.rabbit.model;

import java.math.BigInteger;
import java.util.UUID;

public class BluePrint {

    private UUID blueprintId;
    private String currentProcessingPhase;
    private String fileLocation;
    private String time;

    public UUID getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(UUID blueprintId) {
        this.blueprintId = blueprintId;
    }

    public String getCurrentProcessingPhase() {
        return currentProcessingPhase;
    }

    public void setCurrentProcessingPhase(String currentProcessingPhase) {
        this.currentProcessingPhase = currentProcessingPhase;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    //constructor


    public BluePrint(UUID blueprintId, String currentProcessingPhase, String fileLocation, String time) {
        this.blueprintId = blueprintId;
        this.currentProcessingPhase = currentProcessingPhase;
        this.fileLocation = fileLocation;
        this.time = time;
    }
}
