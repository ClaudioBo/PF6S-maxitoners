package mx.itson.maxitoners.utils;

import mx.itson.maxitoners.interfaces.MaxitonersAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    public static MaxitonersAPI obtenerApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maxitoners.elclaudio.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MaxitonersAPI.class);
    }
}
