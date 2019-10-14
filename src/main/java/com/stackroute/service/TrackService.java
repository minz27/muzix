package com.stackroute.service;

import com.stackroute.domain.Track;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface TrackService {
    public List<Track> searchTrack(String trackName) throws IOException, ParseException;

    public List<Track> getAllTracks();

    public Track saveTrack(Track track);

    public Track deleteTrack(int trackId);

    public Track updateTrack(Track track);
}
