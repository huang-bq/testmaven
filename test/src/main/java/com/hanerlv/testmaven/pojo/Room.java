package com.hanerlv.testmaven.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by huangbq on 16/9/27.
 */
public class Room {
    private String roomId;
    private  String roomMaster;
    private List<String> gameMembers;

    private Room(){
    }

    public Room(String roomMaster){
        this.roomId = UUID.randomUUID().toString();
        this.roomMaster = roomMaster;
        this.gameMembers = new ArrayList<String>();
        this.gameMembers.add(roomMaster);
    }

    public void enter(String member){
        if (this.gameMembers != null){
            this.gameMembers.add(member);
        }
    }
    public void out(String  member){
        if (this.gameMembers != null){
            this.gameMembers.remove(member);
        }
    }
}
