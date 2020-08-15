 

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String i : array) {
            if(i == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] arr = new String[array.length];
        int j = 0;
        for(int i = array.length - 1; i >= 0; i--) {
            arr[j] = array[i];
            j++;
        }
        return arr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for(int i = 0; i < array.length/2; i++) {
            if(array[i] != array[array.length-i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
       String[] arr = new String[26];

        for(String i : array) {
            i = i.replaceAll(" ","");
            for(int j = 0; j < i.length(); j++) {
                arr[((int)i.toLowerCase().charAt(j)) - 97] = String.valueOf(i.toLowerCase().charAt(j));
            }
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int ans = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i].contains(value)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int count = 0;
        for(String i : array) {
            if(i.equals(valueToRemove)) {
                count++;
            }
        }
        String[] arr = new String[array.length - count];
        int index = 0;
        
        for(String i : array) {
            if (!i.equals(valueToRemove)) {
                arr[index] = i;
                index++;
            }
        }
        return arr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        int index = 0;
        int count = 0;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i + 1]) {
                count++;
            }
        }
        String[] arr = new String[array.length - count];
        for(int i = 0; i < array.length - 1; i++) {
            System.out.println(i);
            if(array[i] == array[i+1]) {
                arr[index] = array[i];
                index++;
                for(int j = i + 1; j < array.length; j++) {
                    if(array[i] != array[j]) {
                        i = j-1;
                        break;
                    }
                }
            }else{
                arr[index] = array[i];
                index++;
            }
            if(i == array.length - 2 && array[i] != array[i+1]){
                arr[index] = array[i+1];
            }
        }
        for(String i : arr) {
            System.out.println(i);
        }
        return arr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence 
     * concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        int index = 0;
        int count = 0;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i + 1]) {
                count++;
            }
        }
        String[] arr = new String[array.length - count];
        String str = "";
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i+1]) {
                str = array[i];
                for(int j = i + 1; j < array.length; j++) {
                    if(array[i] == array[j]){
                        str = str.concat(array[j]);
                    }else{
                        arr[index] = str;
                        str = "";
                        index++;
                        i = j - 1;
                        break;
                    }
                }
            }else{
                arr[index] = array[i];
                index++;
            }
            if(i == array.length - 2 && array[i] != array[i+1]){
                arr[index] = array[i+1];
            }
        }
        return arr;
    }


}
