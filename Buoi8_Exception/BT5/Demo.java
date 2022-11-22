package Buoi8_Exception.BT5;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        String[] arrayStudent = {
                "id: 1; name: Mrz Jonh; birthDay: 21/01/1999",
                "id: 2; name: Jack1; birthDay: 21/13/1994",
                "id: 3; name: Tie; birthDay: 00/01/1993",
                "id: 4; name: Dipe; birthDay: 02/01/2001"};

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> elementError = new ArrayList<>();
        for(int i = 0; i < arrayStudent.length; i++){
            String[] subStudent = arrayStudent[i].split("; ");
            ArrayList<String> arrayList = new ArrayList<>();
            int id;
            String name;
            LocalDate localDate;
            for(int j = 0; j < subStudent.length; j++){
                String[] subElement = subStudent[j].split(": ");
                arrayList.add(subElement[1]);
            }
            try {
                id = checkId(arrayList.get(0));
                name = checkName(arrayList.get(1));
                localDate = localDate(arrayList.get(2));
                students.add(new Student(id, name, localDate));
            }catch (StudentConvertException e){
                elementError.add("[id: " + arrayList.get(0) + e.getMessage());
            }
        }
        for (int j = 0; j < students.size(); j++) {
            System.out.println(students.get(j));
        }
        for (int j = 0; j < elementError.size(); j++){
            System.out.println(elementError.get(j));
        }
    }

    public static int checkId(String id) throws StudentConvertException{
        try {
            int temp = Integer.parseInt(id);
            if( temp < 0){
                String str = String.format(": id : %s : Can't < 0]", id);
                throw new StudentConvertException(str);
            }
            return temp;
        }catch (NumberFormatException e){
            String str = String.format(": id : %s : Can't parse %s to int < 0]", id, id);
            throw new StudentConvertException(str);
        }
    }

    public static String checkName(String name) throws StudentConvertException{
        char[] arr = name.toCharArray();
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            if(!(temp > 64 && temp < 91) && !(temp > 96 && temp < 123) && temp != 32){
                String str = String.format(": name : '%s' : not alphabe or space]", arr[i]);
                throw new StudentConvertException(str);
            }
        }
        return String.valueOf(arr);
    }

    public static LocalDate localDate(String locadate) throws StudentConvertException{
        String[] day = locadate.split("/");
        int d = 0;
        int m = 0;
        int y = 0;
        try {
            d = Integer.parseInt(day[0]);
            m = Integer.parseInt(day[1]);
            y = Integer.parseInt(day[2]);
            if(d < 1 || d > 31 || m < 1 || m > 12 || y < 1990 || y > 2022){
                String str = String.format(": birthday %s : is not valid]", locadate);
                throw new StudentConvertException(str);
            }
        }catch (NumberFormatException e){
            String str = String.format(": birthday %s : is not valid]", locadate);
            throw new StudentConvertException(str);
        }
        return LocalDate.of(y, m, d);
    }

}
