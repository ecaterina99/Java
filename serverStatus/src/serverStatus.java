/*
Trebuie să creaţi o clasă Server cu câmpurile: id, name şi status.

serverId=25&serverName=my name&serverStatus=Running

Datele care ajung în aplicaţia web trebuie utilizate pentru crearea obiectelor de tip Server.
Textul de intrare trebuie parsat şi din acesta trebuie extrase informaţii individuale,
adică ID-ul, numele şi starea serverului. Câmpul id trebuie să fie reprezentat de tipul int,
câmpul name de tipul String, în timp ce pentru câmpul status trebuie creată enumerarea cu stările serverului
(Stopped, Running, Unknown). După crearea unui obiect de tip Server şi setarea valorilor proprietăţilor
acestuia, la ieşire trebuie să listaţi datele sale, adică trebuie să listaţi valorile proprietăţilor sale.
 */


public class serverStatus {
    public static void main(String[] args) {

        Server server = new Server("serverId=25&serverName=my name&serverStatus=Running");
        server.showInfo();
        System.out.println(server.showInfo());
    }
}




