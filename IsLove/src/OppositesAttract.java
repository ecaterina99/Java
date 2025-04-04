/*
Timmy & Sarah think they are in love, but around where they live,
they will only know once they pick a flower each.
If one of the flowers has an even number of petals and the other has an odd number of petals
it means they are in love.

Write a function that will take the number of petals of each flower and return true
if they are in love and false if they aren't.
*/

public class OppositesAttract {

    public static boolean isLove(final int flower1, final int flower2) {
//solution 1:

//         if (flower1 % 2 == 0 && flower2 % 2 != 0) {
//             return true;
//         } else if (flower2 % 2 == 0 && flower1 % 2 != 0) {
//             return true;
//         } else {
//             return false;
//         }

//solution 2:
//         if (flower1 % 2 != flower2 % 2) {
//              return true;
//          }
//        else{
//           return false;
//        }

//solution 3:
        return flower1 % 2 != flower2 % 2;
    }

}

