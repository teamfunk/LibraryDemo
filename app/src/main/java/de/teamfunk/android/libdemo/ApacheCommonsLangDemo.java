package de.teamfunk.android.libdemo;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.apache.commons.lang3.text.StrTokenizer;
import org.apache.commons.lang3.time.StopWatch;

/**
 * Demo of so useful Apache Commons Lang Library features
 */
public class ApacheCommonsLangDemo {

    private static final String TAG = "ApacheCommonsLangDemo";

    public ApacheCommonsLangDemo(){

        // more
        // org.apache.commons.lang3.*
        // BooleanUtils
        // org.apache.commons.lang3.Conversion.hexToInt()
        // org.apache.commons.lang3.ClassUtils
        // org.apache.commons.lang3.LocaleUtils.languagesByCountry()
        // org.apache.commons.lang3.RandomUtils.nextInt(0, 100);
        // org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4()
        //  org.apache.commons.lang3.SerializationUtils.serialize()
    }

    /**
     *
     */
    protected void demoStringUtils() {

        Log.d(TAG, "************************ Demo StringUtils ************************");

        // abreviate to max chars
        Log.e(TAG, StringUtils.abbreviateMiddle("Willhelmsburger Reichsstrasse 118", "..", 24));

        // e.g. add file extension if missing
        Log.d(TAG, StringUtils.appendIfMissing("image", ".jpg"));

        // delete whitespaces e.g. in text from webservice
        Log.d(TAG, StringUtils.deleteWhitespace(" White space    is gone."));

        // get common start e.g. for package identifier
        Log.d(TAG, StringUtils.getCommonPrefix("de.teamfunk.android.libdemo.ApacheCommonsLangDemo", "de.teamfunk.android.libdemo.OtherClass"));

        // e.g. add http if missing
        Log.d(TAG, StringUtils.prependIfMissingIgnoreCase("www.gogle.com", "https://"));

        // remove unwanted things
        Log.d(TAG, StringUtils.remove("https://www.google.com", "https://"));

        // saving time to be shocked
        Log.d(TAG, StringUtils.repeat("Lorem ispsum ", " ", 20));

        // ungermify
        String[] german = {"Ü","ü","Ä","ä","Ö","ö","ß"};
        String[] nogerman = {"Ue","ue","Ae","ae","Oe","oe","ss"};
        Log.d(TAG, StringUtils.replaceEach("Die süße Hündin läuft in die Höhle des Bären", german, nogerman));

        // advanced substring
        Log.d(TAG, StringUtils.substringAfterLast("Auto und Boot und Flugzeug", "und"));

    }

    protected void demoNumbers() {

        Log.d(TAG, "************************ Demo Numbers ************************");

        // checks
        Log.d(TAG, "is 167.88 a number? " + NumberUtils.isNumber("167.88"));

        // max of an array
        int[] values = {35, 75, 98, 10, 24};
        Log.d(TAG, "what is the max? " + NumberUtils.max(values));

        Log.d(TAG, "parse int from string with default " + NumberUtils.toInt("Text", 5));


    }

    protected void demoArrayUtils() {

        Log.d(TAG, "************************ Demo ArrayUtils ************************");

        // define int array
        int[] data = new int[5];
        // fill array
        for (int i=0; i<data.length; i++) {
            data[i] = i*10;
        }

        // easy to add element to fixed length array
        data = ArrayUtils.add(data, 1000);

        // multiadd via varargs
        data = ArrayUtils.addAll(data, 2000, 3000, 4000, 5000);

        // existance in array
        Log.d(TAG, "contains the array 3000? " + ArrayUtils.contains(data, 3000));

        // search in array
        Log.d(TAG, "where in the array is 3000? " + ArrayUtils.indexOf(data, 3000));

        // remove in array
        data = ArrayUtils.removeElement(data, 3000);
        Log.d(TAG, "remove 3000 " + ArrayUtils.toString(data));

        // reverse
        ArrayUtils.reverse(data);
        Log.d(TAG, "reverse " + ArrayUtils.toString(data));

        // primitive to Objects
        Integer[] objects = ArrayUtils.toObject(data);
        Log.d(TAG, "objects " + ArrayUtils.toString(objects));

    }

    protected void demoMisc() {

        Log.d(TAG, "************************ Demo Misc ************************");

        // inheritance distance
        Log.d(TAG, "inheritance distance: " + InheritanceUtils.distance(TableLayout.class, View.class));

        // Wertebereich
        Range<Integer> range = Range.between(100, 2000);
        Log.d(TAG, "1000 in range? " + range.contains(1000));

        // Stopuhr
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String text = "";
        for (int i=0; i<10000; i++) {
            text += "Hallo";
            if ( (i%1000) == 0 )
                text = "";
        }
        stopWatch.stop();
        Log.d(TAG, "stopwatch loop time " + stopWatch.getTime());


        // use String as list
        StrTokenizer strTokenizer = new StrTokenizer("a,b,c,d", ",");
        while (strTokenizer.hasNext()) {
            Log.d(TAG, "String Token: " + strTokenizer.next());
        }

        Log.d(TAG, "languages in CH: " + LocaleUtils.languagesByCountry("CH").toString());


    }
}
