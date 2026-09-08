/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        for (Employee employee : employees){
            if(employee.id == id){

                int total = employee.importance;

                for(int subordinate : employee.subordinates){
                    total+=getImportance(employees,subordinate);
                }

                return total;
            }
        }

        return 0;


        
    }
}
