package ejercicio1;

public class Temperatura {

    
    private float celsius;

    private float farenheit = 0;

    private int kelvin = 0;
    public Temperatura(float celsius) {

        this.celsius = celsius;
        this.farenheit = (celsius * 9 / 5) + 32;
        this.kelvin = (int) (celsius + 273.15);

    }

    public static void showCelsius(){

    try {
        System.out.println("La temperatura en grados celsius es : " + celsius);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    }

    public float toCelsius() {

        return this.celsius;

    }

}
