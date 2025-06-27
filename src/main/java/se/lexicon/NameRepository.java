package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] newNames) {
        names = newNames;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        String[] newArray = new String[names.length];
        System.arraycopy(names, 0, newArray, 0, names.length);
        return newArray;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        String[] newArray = Arrays.copyOf(names, names.length);
        Arrays.sort(newArray, String.CASE_INSENSITIVE_ORDER);
        int indexFound = Arrays.binarySearch(newArray, fullName);

        if(indexFound < 0){
            System.out.println("There is no such person here: " + fullName);
            return null;
        }else{
            System.out.println("A person was found");
            return fullName;
        }
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        String findingResult = find(fullName);
        if(findingResult != null){
            System.out.println("This name already exists");
            return false;
        }else{
            String[] newArray = new String[names.length + 1];
            System.arraycopy(names, 0, newArray, 0, names.length);
            newArray[newArray.length -1] = fullName;
            names = newArray;
            return true;
        }
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        int count = 0;
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("There is no such person with that name here: " + firstName);
            return new String[0];
        } else{
            String[] result = new String[count];
            int index = 0;
            for (String name : names) {
                if (name.startsWith(firstName + " ")) {
                    result[index++] = name;
                }
            }
            return result;
        }
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        int count = 0;
        for (String name : names) {
            if (name.endsWith(" " + lastName)) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("There is no such person with that lastname here: " + lastName);
            return new String[0];
        } else{
            String[] result = new String[count];
            int index = 0;
            for (String name : names) {
                if (name.endsWith(" " + lastName)) {
                    result[index++] = name;
                }
            }
            return result;
        }
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        String[] newArray = Arrays.copyOf(names, names.length);
        Arrays.sort(newArray, String.CASE_INSENSITIVE_ORDER);
        int originalFound = Arrays.binarySearch(newArray, original);
        int updatedFound = Arrays.binarySearch(newArray, updatedName);
        if(updatedFound >= 0 ){
            System.out.println("The updated name already exists");
            return false;
        } else if (originalFound < 0) {
            System.out.println("There is no such person here: " + original);
            return false;
        }else {
            names[originalFound] = updatedName;
            return true;
        }
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
         int indexToRemove = -1;
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(fullName)) {
                    indexToRemove = i;
                    break;
                }
            }

            if (indexToRemove < 0) {
                System.out.println("There is no such person here: " + fullName);
                return false;
            }

            String[] newArray = new String[names.length - 1];

            for (int i = 0, j = 0; i < names.length; i++) {
                if (i != indexToRemove) {
                    newArray[j++] = names[i];
                }
            }
            names = newArray;
            return true;
    }
}