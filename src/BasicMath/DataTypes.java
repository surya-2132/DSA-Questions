package BasicMath;

public class DataTypes {
    public static void main(String[] args) {
        DataTypes dt = new DataTypes();
        dt.primitiveDataTypes();

    }

    public void primitiveDataTypes(){

        //Below are the primitive data type with their hierarchical order
        //if we do operation of combining things below, by hierarchical order after default type casting, larger only will get replaced.
        //eg : int * float * byte = float
        //float * char * double = double

        byte byteNumRange = 127;     //byte: -128 to 127
        short shortNumRange = 32767;    //short: -32,768 to 32,768
        char character = 'a';   //character from a to z || A to z inside 'character'
        int usualNumRange = 2147483647;     //int: -2,147,483,648 to 2,147,483,647
        long longNumRange = 9223372036854775807L;    //long: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float decimalShortRange = 9.99F;      //float: Approximately ±3.40282347E+38F (6-7 significant decimal digits)
        double decimalLongRange = 9.99999;   //double: Approximately ±1.7976931348623157E+308 (15 significant decimal digits)
        boolean trueOrFalse = true;

        System.out.println("byteNumRange: " + byteNumRange);
        System.out.println("shortNumRange: " + shortNumRange);
        System.out.println("character " + character);
        System.out.println("usualNumRange: " + usualNumRange);
        System.out.println("longNumRange: " + longNumRange);
        System.out.println("decimalShortRange: " + decimalShortRange);
        System.out.println("decimalLongRange: " + decimalLongRange);
        System.out.println("Boolean: " + trueOrFalse);
    }
}
