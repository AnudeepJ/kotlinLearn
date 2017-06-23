package assignment.com.kotlinlearn;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Praveen Pandey on 17-04-2017.
 */

public class BaseServiceGenerater {

    public static final String S_CACHE_CONTROL = "Cache-Control";
    private static String CACHE_NAME = "republic-cache";

    public static void setIsCachingEnabled(boolean isCachingEnabled) {
        BaseServiceGenerater.isCachingEnabled = isCachingEnabled;
    }

    private static boolean isCachingEnabled = true;

    /**
     * Create the service request
     *
     * @param context context of the app
     */
    public static Retrofit createService(Context context, String baseUrl) {
        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (isCachingEnabled) {
            httpClient.cache(getCache(context));
        }
//
//        httpClient.addNetworkInterceptor(new NetworkInterceptor());
//        httpClient.addInterceptor(new RequestInterceptor());
        httpClient.addInterceptor(provideLogginInterceptor());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit;
    }

    /**
     * @return
     */
    private static HttpLoggingInterceptor provideLogginInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    private static Cache getCache(Context context) {
        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(context.getCacheDir(), CACHE_NAME), SIZE_OF_CACHE);
        return cache;
    }

    /**
     * Handle network not available
     *
     * @param context app context
     * @return interceptor
     */
//    private static Interceptor getConnectivityInterceptor(final Context context) {
//        Interceptor networkInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                if (RepublicApplication.isInternetConnected()) {
//                    throw new ConnectivityException();
//                }
//                return chain.proceed(chain.request());
//            }
//        };
//        return networkInterceptor;
//    }

//    /**
//     *
//     */
//    public static class RequestInterceptor implements Interceptor {
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            if (!RepublicApplication.isInternetConnected()) {
//                CacheControl cacheControl = new CacheControl.Builder().maxStale(AppConstants.INT_7,
//                        TimeUnit.DAYS).build();
//                request = request.newBuilder().cacheControl(cacheControl).build();
//            }
//            return chain.proceed(request);
//        }
//    }
//
//    /**
//     *
//     */
//    public static class NetworkInterceptor implements Interceptor {
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Response response = chain.proceed(chain.request());
//            // re-write response header to force use of cache
//            CacheControl cacheControl = new CacheControl.Builder()
//                    .maxAge(AppConstants.INT_1, TimeUnit.HOURS).build();
//
//            return response.newBuilder()
//                    .header(S_CACHE_CONTROL, cacheControl.toString()).build();
//        }
//    }

    //use if header needs to be sent to server
//    private static class HeaderInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//
//            Request original = chain.request();
//            Request.Builder builder = original.newBuilder();
//            Request request;
//            //builder.header(AppConstants.HEADER_AUTHORIZATION, "Bearer " + OLOApplication.getsUserDetailsData().token);
//            request = builder.method(original.method(), original.body())
//                    .build();
//            return chain.proceed(request);
//        }
//    }
}
