
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteredList {

    public static List<Object> filterList(final List<Object> list) {

        List<Object> onlyNumbers = list.stream().filter(new Predicate<Object>() {
            @Override
            public boolean test(Object obj) {
                return obj instanceof Integer;
            }

        }).collect(Collectors.toList());

        System.out.println("Numbers list: " + onlyNumbers);
        return onlyNumbers;

        // with Lambda:

//        List<Object>onlyNumbers = list.stream().filter(obj -> obj instanceof Integer)
//        .collect(Collectors.toList());
//        return onlyNumbers;

    }
}