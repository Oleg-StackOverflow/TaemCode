package semester_1.Laba11;

import java.util.*;

class DepartmentComparator implements Comparator<Department> {
    @Override
    public int compare(Department d1, Department d2) {
        return Integer.compare(d1.getEmployees().size(), d2.getEmployees().size());
    }
}

