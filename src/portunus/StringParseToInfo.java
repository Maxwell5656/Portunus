/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 *
 * @author Maxwell
 */
public class StringParseToInfo implements Observer{
    private StringParser parse;
    private Info info;
    private StringPEvent event;
    public StringParseToInfo(Info info, StringParser parse)
    {
        this.info = info;
        this.parse = parse;
    }
    
    @Override
    public void logAndMakeChanges()
    {
        this.event = parse.getEvent();
        storChange change = this.event.getEvent();
        if(change == storChange.LOADING_TO_INFO)
        {
            info.loadFromStorage(parse.getIdent(), parse.getUsername(), parse.getSiteName(), parse.getPassword(), parse.getAllSecQuestions(), parse.getAllSecAnswers());
        }
    }
}
