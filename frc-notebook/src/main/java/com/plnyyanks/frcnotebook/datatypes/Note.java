package com.plnyyanks.frcnotebook.datatypes;

import com.plnyyanks.frcnotebook.activities.StartActivity;

/**
 * Created by phil on 2/19/14.
 */
public class Note {
    private String  eventKey,
                    matchKey,
                    teamKey,
                    note;
    private short   id;
    private long    timestamp;

    public Note(){
        timestamp = System.currentTimeMillis();
    }

    public Note(String eventKey, String matchKey, String teamKey, String note) {
        this.eventKey = eventKey;
        this.matchKey = matchKey;
        this.teamKey = teamKey;
        this.note = note;
        this.timestamp = System.currentTimeMillis();
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static String buildGeneralNoteTitle(Note note,boolean displayEvent){
        String output = "";

        if(displayEvent){
            //on all notes tab. Include event title
            Event parentEvent = StartActivity.db.getEvent(note.getEventKey());
            if(parentEvent!=null){
                //note is associated with an event
                output += parentEvent.getShortName()+": ";
            }
        }
        output += note.getNote();
        return output;
    }

    public static String buildMatchNoteTitle(Note note, boolean displayEvent, boolean displayMatch){
       return buildMatchNoteTitle(note,displayEvent,displayMatch,false);
    }

    public static String buildMatchNoteTitle(Note note, boolean displayEvent, boolean displayMatch, boolean lineBreak){
        String output = "";
        if(displayEvent && !note.getEventKey().equals("all")){
            //on all notes tab. Include event title
            Event parentEvent = StartActivity.db.getEvent(note.getEventKey());
            output += parentEvent.getShortName()+" ";
        }

        if(displayMatch && !note.getMatchKey().equals("all")){
            Match parentMatch = StartActivity.db.getMatch(note.getMatchKey());
            output += parentMatch.getTitle()+": ";
        }
        if(lineBreak){
            output+="\n";
        }
        output +=note.getNote();
        return output;
    }
}
