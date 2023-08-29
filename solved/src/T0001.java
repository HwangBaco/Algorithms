//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class T0001 {
//    public static class Weather {
//        private String date;
//        private String day;
//        private String weather;
//
//        public Weather(String date, String day, String weather) {
//            this.date = date;
//            this.day = day;
//            this.weather = weather;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        public String getDay() {
//            return day;
//        }
//
//        public String getWeather() {
//            return weather;
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        List<Weather> li = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            Weather weather = new Weather(st.nextToken(), st.nextToken(), st.nextToken());
//            li.add(weather);
//        }
//        List<Weather> ansList = li.stream()
//                .filter(o -> o.weather.equals("Rain"))
//                .sorted(Comparator.comparing(Weather::getDate)
//                        .thenComparing(Weather::getDay))
//                .toList();
//        Weather ans = ansList.get(0);
//        System.out.println(ans.date + " " + ans.day + " " + ans.weather);
//    }
//}
