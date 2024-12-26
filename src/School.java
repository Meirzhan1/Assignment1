import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class School {
    public List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person member) {
        members.add(member);
    }

    public List<Person> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}