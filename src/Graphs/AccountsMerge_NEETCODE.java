//Accounts Merge
//Medium
//Topics
//Company Tags
//Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
//
//Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
//
//After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
//
//Example 1:
//
//Input: accounts = [
//    ["neet","neet@gmail.com","neet_dsa@gmail.com"],
//    ["alice","alice@gmail.com"],
//    ["neet","bob@gmail.com","neet@gmail.com"],
//    ["neet","neetcode@gmail.com"]
//]
//
//Output: [["neet","bob@gmail.com","neet@gmail.com","neet_dsa@gmail.com"],["alice","alice@gmail.com"],["neet","neetcode@gmail.com"]]
//Example 2:
//
//Input: accounts = [
//    ["James","james@mail.com"],
//    ["James","james@mail.co"]
//]
//
//Output: [["James","james@mail.com"],["James","james@mail.co"]]
//Constraints:
//
//1 <= accounts.length <= 1000
//2 <= accounts[i].length <= 10
//1 <= accounts[i][j].length <= 30
//accounts[i][0] consists of English letters.
//accounts[i][j] (for j > 0) is a valid email.
package Graphs;

import java.util.*;

public class AccountsMerge_NEETCODE {
    // Each account is represented as a node in DSU.
    // Accounts sharing an email will be merged into the same component.
    // Map each email to an account that contains it.
    // If an email is already present, both accounts belong to the same person,
    // so we union their DSU components.
    // After all accounts are connected, group emails by their DSU root.
    // Every group represents one merged account.
    // Sort emails as required and prepend the account owner's name.
    //    DSU operations: O(E * α(N))
    //    Grouping emails: O(E * α(N))
    //    Sorting emails: O(E log E) worst case
    //
    //    Overall: O(E log E)
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int [] dsu= new int[n];
        int [] rank= new int[n];
        for(int i=0;i<n;i++){
            dsu[i]=i;
        }
        HashMap<String,Integer> emailMap= new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> emails= accounts.get(i);
            for(int j=1;j<emails.size();j++){
                String email= emails.get(j);
                if(emailMap.containsKey(email)){
                    int x= emailMap.get(email);
                    int y= i;
                    union(dsu,rank,x,y);
                }
                emailMap.put(email,i);
            }
        }
        List<List<String>> res= new ArrayList<>();
        List<String> [] lists= new ArrayList[n];
        for(String key : emailMap.keySet()){
            int parent= findParent(dsu,emailMap.get(key));
            if(lists[parent]==null){
                lists[parent]= new ArrayList<>();
            }
            lists[parent].add(key);
        }
        for(int i =0;i<n;i++){
            List<String> list= lists[i];
            if(list==null){
                continue;
            }
            Collections.sort(list);
            List<String> newList= new ArrayList<>();
            newList.add(accounts.get(i).get(0));
            newList.addAll(list);
            res.add(newList);
        }
        return res;
    }

    public static int findParent(int [] dsu , int x){
        if(x!=dsu[x]){
            dsu[x]=findParent(dsu,dsu[x]);
        }
        return dsu[x];
    }

    public  static void union(int [] dsu,int [] rank , int  x, int y){
        int parentX= findParent(dsu,x);
        int parentY= findParent(dsu,y);
        if(parentX==parentY){
            return ;
        }
        if(rank[parentX]<rank[parentY]){
            dsu[parentX]=parentY;
        }else if(rank[parentX]>rank[parentY]){
            dsu[parentY]=parentX;
        }else{
            dsu[parentY]=parentX;
            rank[parentX]++;
        }
    }


    public static void main(String[] args) {

        //Example 1:

        List<List<String>>  accounts1 = Arrays.asList(
                Arrays.asList("neet","neet@gmail.com","neet_dsa@gmail.com"),
                Arrays.asList("alice","alice@gmail.com"),
                Arrays.asList("neet","bob@gmail.com","neet@gmail.com"),
                Arrays.asList("neet","neetcode@gmail.com")
        );

        List<List<String>> output1= Arrays.asList(
                Arrays.asList("neet","bob@gmail.com","neet@gmail.com","neet_dsa@gmail.com"),
                Arrays.asList("alice","alice@gmail.com"),
                Arrays.asList("neet","neetcode@gmail.com"));

        //Example 2:
        List<List<String>>  accounts2 = Arrays.asList(
                Arrays.asList("James","james@mail.com"),
                Arrays.asList("James","james@mail.co")
        );
        List<List<String>>  output2 = Arrays.asList(
                Arrays.asList("James","james@mail.com"),
                Arrays.asList("James","james@mail.co")
        );

        List<List<String>> ans1= accountsMerge(accounts1);
        List<List<String>> ans2= accountsMerge(accounts2);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
