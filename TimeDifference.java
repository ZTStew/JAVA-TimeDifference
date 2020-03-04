/*
 * Author: Zachary Stewart
 * File Name: TimeDifference.java
 * Description: Program takes two strings of times based on HH:MM:SS format with
 * AM and PM as well. These strings then are compared and the difference between
 * the two given times is returned.
 */

public class TimeDifference {
    public static void main(String[] args){

        /* Test Times 1: */
        // String time1 = "11:58:10 PM";
        // String time2 = "12:02:15 AM";
        /* Test Times 2: */
        String time1 = "00:15:02 PM";
        String time2 = "12:02:15 AM";
        /* Test Times 3: */
        // String time1 = "11:58:10 PM";
        // String time2 = "00:15:02 PM";

        /* Splits 'time1' based on ':' and ' ' */
        String[] parts1 = time1.split(":|\\s+");
        /* Assigns each index to an Integer value */
        Integer hour1 = Integer.parseInt(parts1[0]);
        Integer minute1 = Integer.parseInt(parts1[1]);
        Integer second1 = Integer.parseInt(parts1[2]);
        /*
         * If the last index says 'PM' then 12 hours need to be added to 'hourX'
         * in order to make the times based on a 24 hour clock.
         */
        if(parts1[parts1.length-1].equals("PM")){
            hour1 += 12;
        }

        /* ****************************************************************** */

        /* Splits 'time2' based on ':' and ' ' */
        String[] parts2 = time2.split(":|\\s+");
        /* Assigns each index to an Integer value */
        Integer hour2 = Integer.parseInt(parts2[0]);
        Integer minute2 = Integer.parseInt(parts2[1]);
        Integer second2 = Integer.parseInt(parts2[2]);
        /*
         * If the last index says 'PM' then 12 hours need to be added to 'hourX'
         * in order to make the times based on a 24 hour clock.
         */
        if(parts2[parts2.length-1].equals("PM")){
            hour2 += 12;
        }

        /* Gets the difference between each time */
        /* Largest hour needs to be calculated last */
        if(hour1 > hour2){
            hour1 = hour2 - hour1;
            minute1 = minute2 - minute1;
            second1 = second2 - second1;
        } else {
            hour1 = hour1 - hour2;
            minute1 = minute1 - minute2;
            second1 = second1 - second2;
        }

        /*
         * If either 'second1' or 'minute1' are negative, remove a value from the
         * above value and add 60 (time is base 60) to the current negative value.
         */
        if(second1 < 0){
            minute1--;
            second1 += 60;
        }
        if(minute1 < 0){
            hour1--;
            minute1 += 60;
        }
        /* If the hour is negative, multiply it by -1 */
        if(hour1 == -12){
            hour1 = 0;
        } else if(hour1 < 0){
            hour1 *= -1;
        }
        /* If the user wants the returned time to have 'AM' or 'PM' */
        // String midnightCount = "AM";
        // if(hour1 > 12){
        //     hour1 -= 12;
        //     midnightCount = "PM";
        // }

        System.out.printf("Total Time Elapsed: %2d Hour(s), %2d Minute(s) %2d Second(s)\n", hour1, minute1, second1);
    }
}