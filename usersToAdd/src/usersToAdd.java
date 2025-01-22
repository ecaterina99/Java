/*
Toţi utilizatorii din colecţia usersToAdd trebuie adăugaţi la colecţia users.
Dacă utilizatorul adăugat există deja în colecţie, trebuie să îl suprascrieţi peste cel existent.
Trebuie să utilizaţi valori de identificare pentru a compara utilizatorii.
În cele din urmă, trebuie să se afişeze toate elementele colecţiei users.
 */

import java.util.ArrayList;

public class usersToAdd {
    public static void main(String[] args) {

        ArrayList users = new ArrayList();
        users.add(new User(4, "Sem"));
        users.add(new User(2, "Peter"));
        users.add(new User(3, "Ben"));

        ArrayList usersToAdd = new ArrayList();
        usersToAdd.add(new User(3, "Ben2"));
        usersToAdd.add(new User(1, "John"));
        usersToAdd.add(new User(5, "Tom"));


        for (int i = 0; i < usersToAdd.size(); i++) {
            boolean userExists = false;
            for (int u = 0; u < users.size(); u++)
                if (((User) users.get(u)).id == ((User) usersToAdd.get(i)).id) {
                    users.set(u, (User) usersToAdd.get(i));
                    userExists = true;
                }
            if (!userExists)
                users.add(usersToAdd.get(i));
            else
                userExists = false;
        }
        for (Object o : users) {
            User u = (User) o;
            System.out.println(u.id + ":" + u.name);

        }

        System.out.println("Sorted id: ");
        for(int i=0; i<users.size(); i++){
            for(int j=i+1; j<users.size(); j++){
                if(((User)users.get(i)).id > ((User)users.get(j)).id){
                    User temp = (User) users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, temp);
                }

            }
        }

        for (Object o : users) {
            User u = (User) o;
            System.out.println(u.id + ":" + u.name);
        }

    }
}


