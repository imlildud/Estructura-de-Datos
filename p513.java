import java.util.*;

public class p513 {
    private static final double radioTierra = 6371.0;
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        String entrada = tec.nextLine();
        String[] datos = entrada.split(" ");

        List<Ciudad> ciudades = new ArrayList<>();

        for (int i=0; i<datos.length; i+= 3) {
            String nombreCiudad = datos[i];

            double latitud = Double.parseDouble(datos[i + 1]);
            double longitud = Double.parseDouble(datos[i + 2]);

            ciudades.add(new Ciudad(nombreCiudad, latitud, longitud));
        }

        for (int i = 0; i < ciudades.size(); i++) {
            for (int j = i + 1; j < ciudades.size(); j+=2) {
                Ciudad ciudad1 = ciudades.get(i);
                Ciudad ciudad2 = ciudades.get(j);

                double distancia = haversine(ciudad1.latitud, ciudad1.longitud, ciudad2.latitud, ciudad2.longitud);

                System.out.printf("%s %s %.10f\n", ciudad1.nombre, ciudad2.nombre, distancia);
            }
        }
    }
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (radioTierra * c);
    }

    static class Ciudad {
        String nombre;
        double latitud;
        double longitud;

        Ciudad(String nombre, double latitud, double longitud) {
            this.nombre = nombre;
            this.latitud = latitud;
            this.longitud = longitud;
        }
    }
}
