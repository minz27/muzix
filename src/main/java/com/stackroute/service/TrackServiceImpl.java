package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> searchTrack(String trackName) throws ParseException {
        final String uri = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" + trackName + "&api_key=f720237c5a996fe681f78ec412b19e97&format=json&limit=5";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        //Process JSON
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
        JSONObject results = (JSONObject)jsonParser.parse(jsonObject.get("results").toString());
        JSONObject trackMatches = (JSONObject)results.get("trackmatches");
        JSONArray tracks = (JSONArray) trackMatches.get("track");

        List<Track> trackList = new ArrayList<Track>();
        for(int i = 0; i < tracks.size(); i++){
            JSONObject currentTrack = (JSONObject)tracks.get(i);
            trackList.add(new Track(i, (String)currentTrack.get("name"), (String)currentTrack.get("artist"), ""));
        }
        return trackList;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track saveTrack(Track track) {
        return null;
    }

    @Override
    public Track deleteTrack(int trackId) {
        return null;
    }

    @Override
    public Track updateTrack(Track track) {
        return null;
    }
}
