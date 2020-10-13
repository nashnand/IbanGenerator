package Iban;

public class BICandCountryMapping extends MapImplementation{

    public static StringBuffer Mapping(String Map) {
        StringBuffer output = new StringBuffer(110);
        StringBuffer MappedValue = new StringBuffer(110);

        String BCOD = Map.toUpperCase();
        for (int i = 0; i < BCOD.length(); i++) {
            int BicInt = 0;
            Character ParseBic = BCOD.charAt(i);
            /*Checking if the value is character or integer , if integer directly append else get the corresponding value*/
            if(Character.isDigit(BCOD.charAt(i))){
                BicInt =Integer.parseInt(String.valueOf(ParseBic));
                MappedValue = output.append(BicInt);
            }
            else {
            String New = ParseBic.toString();
            BicInt = HashMapMethod(New);
            MappedValue = output.append(BicInt);
            }
        }
        return MappedValue;
    }
}

