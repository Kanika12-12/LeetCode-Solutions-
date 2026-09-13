class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        return dfs(id, map);
    }

    private int dfs(int currentId, Map<Integer, Employee> map) {
        Employee emp = map.get(currentId);
        int totalImportance = emp.importance;

        for (int subId : emp.subordinates) {
            totalImportance += dfs(subId, map);
        }

        return totalImportance;
    }
}