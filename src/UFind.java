//public class UFind {
//    // Finds the representative of the set that i
//// is an element of.
//    int find(int i)
//    {
//        // If i is the parent of itself
//        if (Parent[i] == i)
//        {
//            // Then i is the representative
//            return i;
//        }
//        else
//        {
//            // Recursively find the representative.
//            int result = find(Parent[i]);
//// We cache the result by moving i’s node
//            // directly under the representative of this
//            // set
//            Parent[i] = result;
//
//            // And then we return the result
//            return result;
//        }
//    }
//
//}
