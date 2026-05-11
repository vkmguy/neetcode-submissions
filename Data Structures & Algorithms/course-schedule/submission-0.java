class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // to complete the course, we need to identify if there is a cycle or not
        // go through all courses, add each course to the visited set, if there, there will be a condition
        // we already have a value in the set

        HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new HashSet<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> visited = new HashSet<>();
        for(Integer key: adjList.keySet()){
            if(!dfs(key, adjList, visited))
                return false;
        }
        return true;
    }

    public boolean dfs(int val, HashMap<Integer, Set<Integer>> adjList, Set<Integer> visited){
        if(visited.contains(val)){
            return false;
        }
        if(adjList.get(val).isEmpty()){
            return true;
        }

        visited.add(val);
        for(int node : adjList.get(val)){
            if(!dfs(node, adjList, visited)){
                return false;
            }
        }
        visited.remove(val);
        adjList.put(val, new HashSet<>());
        return true;
    }
}