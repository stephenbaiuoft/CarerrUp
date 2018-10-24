package ByMonth.august.June;

public class L681_NextClosestTime_M {
    public L681_NextClosestTime_M() {
        String input = "20:56";
        String rez = nextClosestTime(input);
    }

    public String nextClosestTime(String time) {
        if (time == null || time.length() < 5) return time;
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        String buffer = null;

        // increment by 1
        while(true) {
            if (++minute == 60) {
                minute = 0;
                hour ++;
                hour %= 24;
            }

            buffer = String.format("%02d:%02d", hour, minute);
            Boolean valid = true;
            for(int i = 0; i < buffer.length(); i++) {
                // toggle
                if (time.indexOf(buffer.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) return buffer;

        }

    }
}
