package com.example.scott.ohemem;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Scott on 2/26/2016.
 */
public class TechniqueManager {
    private static String DEBUG_MESS = "TechniqueManager";

    private static TechniqueManager sTechniqueManager;

    private ArrayList<Technique> mTechList;

    private enum TechniqueCats {COUNTERSTRAIN, HVLA, MUSCLE_ENERGY,
            BLT, FPR, SOFT_TISSUE, CRANIAL_SACRAL, ARTICULATORY};

    /**
     *  Constructor needs a listName, then automatically runs the
     *  loadList method to compile it's TechniqueManager
     * @param
     */
    private TechniqueManager() {
        mTechList = new ArrayList<>();
    }

    public static TechniqueManager getInstance(){
        if(sTechniqueManager == null){
            sTechniqueManager = new TechniqueManager();
        }

        return sTechniqueManager;
    }

    /**
     *
     * @param name  String Name of technique that you want Description for
     * @return  Description of technique you named, otherwise returns null.
     */
    public String getDescription(String name){
        Iterator itr = mTechList.iterator();

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
        Iterator itr = mTechList.iterator();

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
        Iterator itr = mTechList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            if(curr.getName().equals(name)){
                return curr.getVidUrl();
            }
        }
        return "-1";
    }
    /**
     *
     * @param name  String Name of technique that you want the picUrl for
     * @return  URL of the picture for technique you named, otherwise returns "-1".
     */
    public String getPicUrl(String name){
        Iterator itr = mTechList.iterator();

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
     * @param index uses index in TechniqueManager
     * @return  String name of technique at Index, else returns "-1"
     */
    public String getNameAt(int index){
        if(mTechList.get(index) == null)
            return "-1";
        else{
            return mTechList.get(index).getName();
        }
    }
    public Technique getTechniqueById(UUID id){
        for(Technique tech : mTechList){
            if(tech.getTechId().equals(id)){
                return tech;
            }
        }

        return null;
    }

    public List<Technique> getAllTechniques(){
        return mTechList;
    }

    public List<Technique> getTechniquesOfCategory(TechniqueCats cats){
        List<Technique> temp = new ArrayList<>();

        switch (cats){
            case COUNTERSTRAIN :
            {
                for(Technique tech : mTechList){
                    if(tech.getCategory().equalsIgnoreCase("counterstrain")){
                        temp.add(tech);
                    }
                }
                return temp;
            }
            case HVLA :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("hvla")) {
                        temp.add(tech);
                    }
                }
                return temp;
            }
            case MUSCLE_ENERGY :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("muscle_energy")) {
                        temp.add(tech);
                    }
                }return temp;
            }
            case BLT :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("blt")) {
                        temp.add(tech);
                    }
                }return temp;
            }
            case FPR :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("fpr")) {
                        temp.add(tech);
                    }
                }return temp;
            }
            case SOFT_TISSUE :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("soft_tissue")) {
                        temp.add(tech);
                    }
                }return temp;
            }
            case CRANIAL_SACRAL :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("cranial_sacral")) {
                        temp.add(tech);
                    }
                }return temp;
            }
            case ARTICULATORY :
            {
                for(Technique tech : mTechList) {
                    if (tech.getCategory().equalsIgnoreCase("ARTICULATORY")) {
                        temp.add(tech);
                    }
                }return temp;
            }
            default:;
        }
        //Else empty
        return null;
    }

    public List<String> getCategories(){
        List<String> categories = new ArrayList<>();

        categories.add("Counterstrain");
        categories.add("HVLA");
        categories.add("Muscle Energy");
        categories.add("BLT");
        categories.add("FPR");
        categories.add("Soft Tissue");
        categories.add("Cranial Sacral");
        categories.add("Articulatory");

        return categories;
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
            mTechList.add(t);
            return true;
        }
        else{
            Log.e(DEBUG_MESS, "Could not add Technique");
            return false;
        }
    }

    /**
     *  Checks TechniqueManager for the existence of specific technique
     * @param t Technique to check
     * @return  true of false, if technique is in the list.
     */
    protected boolean alreadyExists(Technique t){
        Iterator itr = mTechList.iterator();

        while(itr.hasNext()){
            Technique curr = (Technique) itr.next();
            return (curr.equals(t));
        }
        Log.d(DEBUG_MESS, t.getName() + " already exists");
        return false;
    }
}
