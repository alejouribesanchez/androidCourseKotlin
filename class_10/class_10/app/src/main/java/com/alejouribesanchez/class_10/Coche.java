package com.alejouribesanchez.class_10;

/**
 * Created by alejo on 2/28/17.
 */

public class Coche {
    private String nombre;
    private int idDrawable;

    public Coche(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Coche[] ITEMS = {
            new Coche("Jaguar F-Type 2015", R.drawable.jaguar_f_type_2015),
            new Coche("Mercedes AMG-GT", R.drawable.mercedes_benz_amg_gt),
            new Coche("Mazda MX-5", R.drawable.mazda_mx5_2015),
            new Coche("Porsche 911 GTS", R.drawable.porsche_911_gts),
            new Coche("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015),
            new Coche("Ford Mondeo", R.drawable.ford_mondeo),
            new Coche("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry),
            new Coche("Jaguar XE", R.drawable.jaguar_xe),
            new Coche("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015),
            new Coche("Seat León ST Cupra", R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Coche getItem(int id) {
        for (Coche item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}