package com.example.macbookpro.practiceapp.Model;

/**
 * Created by MacbookPro on 3/26/18.
 */

public class MusicType {
    private String id;
    private String typeName;
    private int imageID;

    public MusicType() {
    }

    public MusicType(String id, String typeName, int imageID) {
        this.id = id;
        this.typeName = typeName;
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
