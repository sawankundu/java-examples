package JavaTheory;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ul_p = findParent(parent.get(node));
        parent.set(node, ul_p);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            int sizeU = size.get(ulp_u);
            size.set(ulp_v, size.get(ulp_v) + sizeU);
        }else{
            parent.set(ulp_v, ulp_u);
            int sizeV = size.get(ulp_v);
            size.set(ulp_u, size.get(ulp_u) + sizeV);
        }
    }
}

class Main{
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionBySize(1,2);
        disjointSet.unionBySize(2,3);
        disjointSet.unionBySize(4,5);
        disjointSet.unionBySize(6,7);
        disjointSet.unionBySize(5,6);

        if (disjointSet.findParent(3) == disjointSet.findParent(7)){
            System.out.println("Same");
        }else System.out.println("Not same");

        disjointSet.unionBySize(3, 7);

        if (disjointSet.findParent(3) == disjointSet.findParent(7)){
            System.out.println("Same");
        }else System.out.println("Not same");
    }
}
