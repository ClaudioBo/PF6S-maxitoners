package mx.maxitoners.utils;

import java.io.IOException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import mx.maxitoners.interfaces.MaxitonersAPI;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RetrofitUtil {

    public static MaxitonersAPI obtenerApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maxitoners.elclaudio.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MaxitonersAPI.class);
    }
}
