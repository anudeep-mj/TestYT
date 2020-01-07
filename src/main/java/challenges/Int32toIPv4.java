package challenges;

public class Int32toIPv4 {
    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        String ipStr =
                String.format("%d.%d.%d.%d",
                        (ip & 0xff),
                        (ip >> 8 & 0xff),
                        (ip >> 16 & 0xff),
                        (ip >> 24 & 0xff));


        return ipStr;
    }

    public static Long ipToLong(String ipAddress) {
        String[] ipAddressArray = ipAddress.split("\\.");
        Long result = 0L;
        int i = 0;
        for (String string : ipAddressArray) {
            Integer ip = Integer.valueOf(string);
            if (ip > 255) {
                throw new RuntimeException("Wrong IP address");
            } else {
                result = result + (ip << (24 - (8 * i)));
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        longToIP(2154959208L); //104.17.114.128
        //ipToLong("0.0.1.255");
    }
}
