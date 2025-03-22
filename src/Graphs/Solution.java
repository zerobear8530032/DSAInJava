package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {
    public static int isADish(String dish,String [] recipes){
        for(int i=0;i<recipes.length;i++){
            if(dish.equals(recipes[i])){
                return i;
            }
        }
        return -1;
    }
   

    public static List<String> findAllRecipesBruteForce(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,HashSet<String>> recipiesMap = new HashMap();
        HashSet<String>supply= new HashSet();
        for(String x: supplies) {
        	supply.add(x);
        }
        for(int i =0;i<recipes.length;i++){
            HashSet<String> mat= new HashSet();
            for(int j=0;j<ingredients.get(i).size();j++){
                int idx= isADish(ingredients.get(i).get(j),recipes);
                if(idx!=-1){
                    for(int k=0;k<ingredients.get(idx).size();k++){
                    mat.add(ingredients.get(idx).get(k));
                    }
                }else{
                    mat.add(ingredients.get(i).get(j));
                }
            }
            
            
            recipiesMap.put(recipes[i],mat);
        }     
        List<String> ans = new ArrayList<String>();
        for(Map.Entry<String, HashSet<String>> entry: recipiesMap.entrySet()) {
        	String key = entry.getKey();
        	HashSet<String> matset= entry.getValue();
        	if(isAllMatAvaible(matset, supply)) {
        		ans.add(key);
        	}
        }
        
        return ans;
    }
    
    public static boolean isAllMatAvaible(HashSet<String> mats,HashSet<String> supplies) {
    	for(String m:mats) {
    		if(!supplies.contains(m)) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	String [] recipes1= {"bread"};
    	List<List<String>> ingredients1 = new ArrayList(Arrays.asList("yeast","flour"));
    	String [] supply1= {"yeast","flour","corn"};
    	
    	String [] recipes2= {"bread","sandwich"};
        List<List<String>> ingredients2 = new ArrayList<>(Arrays.asList(Arrays.asList("yeast", "flour"),Arrays.asList("bread", "meat")));
        String [] supply2= {"yeast","flour","meat"};

    	
    	System.out.println(findAllRecipes(recipes2, ingredients2, supply2));
    	
	}
}