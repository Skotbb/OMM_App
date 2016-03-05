package com.example.scott.ohemem;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Scott on 2/26/2016.
 */
public class TechniqueList {
    private static String DEBUG_MESS = "TechniqueList";

    private String listName;
    private ArrayList<Technique> techList;

    /**
     *  Constructor needs a listName, then automatically runs the
     *  loadList method to compile it's TechniqueList
     * @param listName  String name for List
     */
    public TechniqueList(String listName) {
        this.listName = listName;
        loadList();
    }

    public String getListName() {
        return listName;
    }

    /**
     *
     * @param name  String Name of technique that you want Description for
     * @return  Description of technique you named, otherwise returns null.
     */
    public String getDescription(String name){
        Iterator itr = techList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            if(curr.getName().equals(name)){
                return curr.getDescription();
            }
        }
        return null;
    }

    /**
     *
     * @param name  String Name of technique that you want Category for
     * @return  Category of technique you named, otherwise returns null.
     */
    public String getCategory(String name){
        Iterator itr = techList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            if(curr.getName().equals(name)){
                return curr.getCategory();
            }
        }
        return null;
    }
    /**
     *
     * @param name  String Name of technique that you want the vidUrl for
     * @return  URL of the video for technique you named, otherwise returns null.
     */
    public String getVidUrl(String name){
        Iterator itr = techList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            if(curr.getName().equals(name)){
                return curr.getVidUrl();
            }
        }
        return null;
    }
    /**
     *
     * @param name  String Name of technique that you want the picUrl for
     * @return  URL of the picture for technique you named, otherwise returns "-1".
     */
    public String getPicUrl(String name){
        Iterator itr = techList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            if(curr.getName().equals(name)){
                return curr.getPicUrl();
            }
        }
        return "-1";
    }

    /**
     *
     * @param index uses index in TechniqueList
     * @return  String name of technique at Index, else returns "-1"
     */
    public String getNameAt(int index){
        if(techList.get(index) == null)
            return "-1";
        else{
            return techList.get(index).getName();
        }
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    protected void loadList(){

    }

    /**
     * Method checks if technique already exists in list,
     * then adds it.
     * @param t Technique to be loaded to list
     * @return true, if item was added, else returns false
     */
    protected boolean addTechnique(Technique t){
        if(!alreadyExists(t)) {
            techList.add(t);
            return true;
        }
        else{
            Log.e(DEBUG_MESS, "Could not add Technique");
            return false;
        }
    }

    /**
     *  Checks TechniqueList for the existence of specific technique
     * @param t Technique to check
     * @return  true of false, if technique is in the list.
     */
    protected boolean alreadyExists(Technique t){
        Iterator itr = techList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            return (curr.equals(t));
        }
        Log.d(DEBUG_MESS, t.getName() + " already exists");
        return false;
    }
}
