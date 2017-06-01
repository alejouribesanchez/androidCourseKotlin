package com.alejouribesanchez.class_10

/**
 * Created by alejo on 2/28/17.
 */

class Coche(val nombre: String, val idDrawable: Int) {

    val id: Int
        get() = nombre.hashCode()

    companion object {

        var ITEMS = arrayOf(Coche("Jaguar F-Type 2015", R.drawable.jaguar_f_type_2015), Coche("Mercedes AMG-GT", R.drawable.mercedes_benz_amg_gt), Coche("Mazda MX-5", R.drawable.mazda_mx5_2015), Coche("Porsche 911 GTS", R.drawable.porsche_911_gts), Coche("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015), Coche("Ford Mondeo", R.drawable.ford_mondeo), Coche("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry), Coche("Jaguar XE", R.drawable.jaguar_xe), Coche("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015), Coche("Seat León ST Cupra", R.drawable.seat_leon_st_cupra))

        /**
         * Obtiene item basado en su identificador

         * @param id identificador
         * *
         * @return Coche
         */
        fun getItem(id: Int): Coche? {
            for (item in ITEMS) {
                if (item.id == id) {
                    return item
                }
            }
            return null
        }
    }
}