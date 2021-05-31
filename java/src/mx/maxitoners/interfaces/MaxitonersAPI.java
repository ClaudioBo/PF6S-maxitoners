package mx.maxitoners.interfaces;

import mx.maxitoners.negocio.Producto;
import mx.maxitoners.negocio.Respuesta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MaxitonersAPI {

    @Headers({"token: maxitoners2021-cJ0wK8uC7kK2aC8p"})
    @GET("producto")
    Call<Respuesta> verProductos();

    @FormUrlEncoded
    @Headers({"token: maxitoners2021-cJ0wK8uC7kK2aC8p"})
    @POST("producto")
    Call<Respuesta> agregarProducto(
            @Field("nombre") String nombre,
            @Field("cantidad") int cantidad,
            @Field("precio") double precio,
            @Field("categoria") int categoria
    );

    @FormUrlEncoded
    @Headers({"token: maxitoners2021-cJ0wK8uC7kK2aC8p"})
    @POST("producto/{id}")
    Call<Respuesta> editarProducto(
            @Path("id") int id,
            @Field("nombre") String nombre,
            @Field("cantidad") int cantidad,
            @Field("precio") double precio,
            @Field("categoria") int categoria
    );

    @Headers({"token: maxitoners2021-cJ0wK8uC7kK2aC8p"})
    @DELETE("producto/{id}")
    Call<Respuesta> borrarProducto(@Path("id") int id);
}
