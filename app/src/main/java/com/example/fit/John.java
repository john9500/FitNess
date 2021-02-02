package com.example.fit;

import javax.sql.StatementEvent;

public class John {
    private String artistID;
    private String name;
    private String artistbloodlevel;
    private String artistheartrate;
    private String artistRespiration;
    private String artistoxylevel;
    private String astma;

    public John(String artistID, String artistbloodlevel, String artistheartrate, String artistRespiration, String artistoxylevel, String astma, String name) {
        this.artistID = artistID;
        this.artistbloodlevel = artistbloodlevel;
        this.artistheartrate = artistheartrate;
        this.artistRespiration = artistRespiration;
        this.artistoxylevel = artistoxylevel;
        this.astma = astma;
        this.name = name;
    }

    public String getArtistID() {
        return artistID;
    }

    public String getArtistbloodlevel() {
        return artistbloodlevel;
    }

    public String getArtistheartrate() {
        return artistheartrate;
    }

    public String getArtistRespiration() {
        return artistRespiration;
    }

    public String getArtistoxylevel() {
        return artistoxylevel;
    }
    public String getAstma() {
        return astma;
    }

    public String getName() {
        return name;
    }
}

