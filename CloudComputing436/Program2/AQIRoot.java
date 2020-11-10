import java.util.List;

/**
 * RootQ
 *
 * this is a class used to deserialize the json response from the air quality api
 */
public class AQIRoot {
    public String status;
    public Data data;

    public class Attribution{
        public String url;
        public String name;
        public String logo;
    }

    public class City{
        public List<Double> geo;
        public String name;
        public String url;
    }

    public class H{
        public double v;
    }

    public class No2{
        public double v;
    }

    public class P{
        public double v;
    }

    public class Pm25{
        public double v;
    }

    public class T{
        public double v;
    }

    public class W{
        public double v;
    }

    public class Wg{
        public double v;
    }

    public class Iaqi{
        public H h;
        public No2 no2;
        public P p;
        public Pm25 pm25;
        public T t;
        public W w;
        public Wg wg;
    }

    public class Time{
        public String s;
        public String tz;
        public int v;
    }

    public class O3{
        public int avg;
        public String day;
        public int max;
        public int min;
    }

    public class Pm10{
        public int avg;
        public String day;
        public int max;
        public int min;
    }

    public class Pm252{
        public int avg;
        public String day;
        public int max;
        public int min;
    }

    public class Uvi{
        public int avg;
        public String day;
        public int max;
        public int min;
    }

    public class Daily{
        public List<O3> o3;
        public List<Pm10> pm10;
        public List<Pm252> pm25;
        public List<Uvi> uvi;
    }

    public class Forecast{
        public Daily daily;
    }

    /**
     * Data
     *
     * this is a class that holds data from json response from air quality API
     */
    public class Data{
        public double aqi;
        public int idx;
        public List<Attribution> attributions;
        public City city;
        public String dominentpol;
        public Iaqi iaqi;
        public Time time;
        public Forecast forecast;
    }
}

