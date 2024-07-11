import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Weather> weatherList = new LinkedList<>();

        Weather firstRainyWeather = null;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            Weather wea = new Weather(tmp[0], tmp[1], tmp[2]);
            if (wea.weather.equals("Rain")) {
                if (firstRainyWeather == null || wea.date.compareTo(firstRainyWeather.date) < 0) {
                    firstRainyWeather = wea;
                }
            }
            weatherList.add(wea);
        }

        if (firstRainyWeather != null) {
            System.out.println(firstRainyWeather.dateString + " " + firstRainyWeather.dateEn + " " + firstRainyWeather.weather);
        } else {
            Collections.sort(weatherList, (w1, w2) -> w1.date.compareTo(w2.date));
            for (Weather wea : weatherList) {
                if (wea.weather.equals("Rain")) {
                    System.out.println(wea.dateString + " " + wea.dateEn + " " + wea.weather);
                    break;
                }
            }
        }
    }
}

class Weather {
    Date date;
    String dateString;
    String dateEn;
    String weather;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Weather(String dates, String dateEn, String weather) throws Exception {
        this.date = sdf.parse(dates);
        this.dateString = dates;
        this.dateEn = dateEn;
        this.weather = weather;
    }
}